package org.momo.Recent.Dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Builder
@Data
public class RecentSearchResponseDto {
    private int statusCode;
    private String isSuccess;
    private String title;
    private double price;
    private double rating;
    private int count;
    private String image;
    private LocalDateTime createdAt;
}
