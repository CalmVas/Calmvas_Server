package org.momo.Recent.Converter;

import org.momo.Member.Entity.User;
import org.momo.Posts.Dto.PostDTO;
import org.momo.Posts.Entity.Category;
import org.momo.Posts.Entity.Post;
import org.momo.Recent.Dto.RecentDTO;
import org.momo.Recent.Entity.Recent;

import java.time.LocalDateTime;

public class RecentConverter {
    public static Recent toRecent(RecentDTO.RecentCreateRQ recentCreateRQ) {
        return Recent.builder()
                .title(recentCreateRQ.getTitle())
                .imageUrl(recentCreateRQ.getImage())
                .count(recentCreateRQ.getCount())
                .rating(recentCreateRQ.getRating())
                .price(recentCreateRQ.getPrice())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static RecentDTO.RecentCreateRP toRecentCreate(Recent save) {
        return RecentDTO.RecentCreateRP.builder()
                .recentId(save.getId())
                .count(save.getCount())
                .image(save.getImageUrl())
                .rating(save.getRating())
                .price(save.getPrice())
                .createdAt(save.getCreatedAt())
                .title(save.getTitle())
                .build();
    }
}
