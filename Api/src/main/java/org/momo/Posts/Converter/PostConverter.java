package org.momo.Posts.Converter;

import org.momo.Member.Entity.User;
import org.momo.Posts.Dto.PostDTO;
import org.momo.Posts.Entity.Category;
import org.momo.Posts.Entity.Post;

import java.time.LocalDateTime;

public class PostConverter {
    public static Post toPost(PostDTO.PostCreateRQ postCreateRQ, User member) {
        return Post.builder()
                .member(member)
                .category(Category.valueOf(postCreateRQ.getCategory()))
                .title(postCreateRQ.getTitle())
                .imageUrl(postCreateRQ.getImageUrl())
                .content(postCreateRQ.getContent())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static PostDTO.PostCreateRP toPostCreate(Post save) {
        return PostDTO.PostCreateRP.builder()
                .postId(save.getId())
                .image(save.getImageUrl())
                .memberId(save.getMember().getUserId())
                .category(save.getCategory().toString())
                .content(save.getContent())
                .createdAt(save.getCreatedAt())
                .title(save.getTitle())
                .build();
    }
}
