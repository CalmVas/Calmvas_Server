package org.momo.Recent.Dto;

import lombok.Builder;
import lombok.Data;
import org.momo.Posts.Dto.PostSearchAllResponseDto;

import java.util.List;

@Builder
@Data
public class RecentSearchAllListResponseDto {
    private int statusCode;
    private String isSuccess;
    private List<RecentSearchAllResponseDto> recents;
}
