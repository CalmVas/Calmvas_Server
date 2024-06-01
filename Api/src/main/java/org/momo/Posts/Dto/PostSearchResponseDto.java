package org.momo.Posts.Dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Builder
@Data
public class PostSearchResponseDto {
    private int statusCode;
    private String isSuccess;
    private String title;
    private String content;
    private LocalDateTime createdAt;
    private String image;
    private String category;
    private String url;
}
