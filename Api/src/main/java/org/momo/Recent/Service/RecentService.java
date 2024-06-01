package org.momo.Recent.Service;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.momo.Member.Entity.User;
import org.momo.Posts.Converter.PostConverter;
import org.momo.Posts.Dto.PostDTO;
import org.momo.Posts.Dto.PostSearchAllListResponseDto;
import org.momo.Posts.Dto.PostSearchAllResponseDto;
import org.momo.Posts.Dto.PostSearchResponseDto;
import org.momo.Posts.Entity.Category;
import org.momo.Posts.Entity.Post;
import org.momo.Recent.Converter.RecentConverter;
import org.momo.Recent.Dto.RecentDTO;
import org.momo.Recent.Dto.RecentSearchAllListResponseDto;
import org.momo.Recent.Dto.RecentSearchAllResponseDto;
import org.momo.Recent.Dto.RecentSearchResponseDto;
import org.momo.Recent.Entity.Recent;
import org.momo.Recent.Repository.RecentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RecentService {

    private final RecentRepository recentRepository;

    @Transactional
    public RecentDTO.RecentCreateRP create(RecentDTO.RecentCreateRQ recentCreateRQ) throws IOException {
        //String date -> LocalDate로 변경
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        // image url 로 수정하자
        Recent recent = RecentConverter.toRecent(recentCreateRQ);
        Recent save = recentRepository.save(recent);

        return RecentConverter.toRecentCreate(save);
    }

    @Transactional
    public RecentSearchResponseDto search(Long id) {
        Optional<Recent> recentRepositorybyId = recentRepository.findById(id);
        return recentRepositorybyId
                .map(recent -> RecentSearchResponseDto.builder()
                        .statusCode(200)
                        .isSuccess("true")
                        .title(recent.getTitle())
                        .count(recent.getCount())
                        .price(recent.getPrice())
                        .rating(recent.getRating())
                        .createdAt(recent.getCreatedAt())
                        .image(recent.getImageUrl())
                        .build())
                .orElse(RecentSearchResponseDto.builder()
                        .statusCode(400)
                        .isSuccess("false")
                        .build());

    }

    @Transactional
    public RecentSearchAllListResponseDto searchAll() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        List<Recent> recents = recentRepository.findAll();
        return RecentSearchAllListResponseDto.builder()
                .statusCode(200)
                .isSuccess("true")
                .recents(recents.stream().map(recent -> RecentSearchAllResponseDto.builder()
                                .id(recent.getId())
                                .title(recent.getTitle())
                                .image(recent.getImageUrl())
                                .createdAt(recent.getCreatedAt().format(formatter))
                                .price(recent.getPrice())
                                .count(recent.getCount())
                                .rating(recent.getRating())
                                .build())
                        .collect(Collectors.toList()))
                .build();
    }

}
