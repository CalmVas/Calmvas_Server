package org.momo.Recent.Dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

public class RecentDTO {
  @Data
  public static class RecentCreateRQ {
    private String title;
    private double price;
    private double rating;
    private int count;
    private String image;
  }

  @Data
  @Builder
  public static class RecentCreateRP {
    private Long recentId;
    private LocalDateTime createdAt;
    private String title;
    private double price;
    private double rating;
    private int count;
    private String image;
  }

  @Builder
  @Data
  public static class RecentSearchRP {
    private String title;
    private double price;
    private double rating;
    private int count;
    private String image;
    private LocalDateTime createdAt;
  }
}
