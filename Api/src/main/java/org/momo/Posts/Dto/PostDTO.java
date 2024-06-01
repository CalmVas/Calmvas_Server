package org.momo.Posts.Dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class PostDTO {
  @Data
  public static class PostCreateRQ {
    private String title;
    private String content;
    private String category;
    private String membername;
    private String imageUrl;
    private String url;
  }

  @Data
  @Builder
  public static class PostCreateRP {
    private Long memberId;
    private Long postId;
    private String title;
    private String content;
    private LocalDateTime createdAt;
    private String image;
    private String category;
    private String url;
  }

  @Builder
  @Data
  public static class PostSearchRP {
    private String title;
    private String content;
    private LocalDateTime createdAt;
    private String image;
    private String category;
    private String url;
  }

  @Data
  public static class PostUpdateRQ {
    private String title;
    private String content;
    private String category;
  }
  @Data
  @Builder
  public static class PostUpdateRP {
    private Long memberId;
    private Long postId;
    private String title;
    private String content;
    private LocalDateTime createdAt;
    private String image;
    private String category;
  }
}
