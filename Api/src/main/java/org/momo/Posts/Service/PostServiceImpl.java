package org.momo.Posts.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.momo.Member.Entity.User;
import org.momo.Member.Repository.UserRepository;
import org.momo.Posts.Converter.PostConverter;
import org.momo.Posts.Dto.PostDTO;
import org.momo.Posts.Dto.PostSearchAllListResponseDto;
import org.momo.Posts.Dto.PostSearchAllResponseDto;
import org.momo.Posts.Dto.PostSearchResponseDto;
import org.momo.Posts.Entity.Category;
import org.momo.Posts.Entity.Post;
import org.momo.Posts.Repository.PostRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Transactional(readOnly = true)
@Service
@RequiredArgsConstructor
@Slf4j
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;
    private final UserRepository memberRepository;


    @Transactional
    @Override
    public PostDTO.PostCreateRP create(PostDTO.PostCreateRQ postCreateRQ) throws IOException {
        //String date -> LocalDate로 변경
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        Optional<User> memberByName = memberRepository.findByUsername(postCreateRQ.getMembername());
        // image url 로 수정하자
        User member;
        if (memberByName.isPresent()) {
            member = memberByName.get();
            Post post = PostConverter.toPost(postCreateRQ, member);
            Post save = postRepository.save(post);
            return PostConverter.toPostCreate(save);
        }
        return PostDTO.PostCreateRP.builder().build();
    }

    public PostSearchResponseDto search(Long id) {
        Optional<Post> postRepositoryById = postRepository.findById(id);
        return postRepositoryById
                .map(post -> PostSearchResponseDto.builder()
                        .statusCode(200)
                        .isSuccess("true")
                        .title(post.getTitle())
                        .image(post.getImageUrl())
                        .createdAt(post.getCreatedAt())
                        .category(post.getCategory().toString())
                        .content(post.getContent())
                        .url(post.getUrl())
                        .build())
                .orElse(PostSearchResponseDto.builder()
                        .statusCode(400)
                        .isSuccess("false")
                        .build());

    }

    @Override
    public PostSearchAllListResponseDto searchByCategory(String category) {
        List<Post> byCategory = postRepository.findByCategory(Category.valueOf(category));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        System.out.println(category);
        return PostSearchAllListResponseDto.builder()
                .statusCode(200)
                .isSuccess("true")
                .posts(byCategory.stream().map(post -> PostSearchAllResponseDto.builder()
                                .id(post.getId())
                                .title(post.getTitle())
                                .image(post.getImageUrl())
                                .content(post.getContent())
                                .createdAt(post.getCreatedAt().format(formatter))
                                .category(post.getCategory())
                                .url(post.getUrl())
                                .build())
                        .collect(Collectors.toList())).build();
    }

    @Override
    public PostSearchAllListResponseDto searchAll() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        List<Post> posts = postRepository.findAll();
        return PostSearchAllListResponseDto.builder()
                .statusCode(200)
                .isSuccess("true")
                .posts(posts.stream().map(post -> PostSearchAllResponseDto.builder()
                                .id(post.getId())
                                .title(post.getTitle())
                                .image(post.getImageUrl())
                                .createdAt(post.getCreatedAt().format(formatter))
                                .category(post.getCategory())
                                .url(post.getUrl())
                                .build())
                        .collect(Collectors.toList()))
                .build();
    }
}
