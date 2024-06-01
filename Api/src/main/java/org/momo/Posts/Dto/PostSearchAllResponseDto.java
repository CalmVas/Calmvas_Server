package org.momo.Posts.Dto;

import lombok.Builder;
import lombok.Data;
import org.momo.Posts.Entity.Category;

@Builder
@Data
public class PostSearchAllResponseDto {
    private Long id;
    private String title;
    private String createdAt;
    private String content;
    private String image;
    private Category category;
    private String url;
}
