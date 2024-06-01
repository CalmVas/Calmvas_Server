package org.momo.Recent.Dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class RecentSearchAllResponseDto {
    private Long id;
    private String createdAt;
    private String title;
    private double price;
    private double rating;
    private int count;
    private String image;
}
