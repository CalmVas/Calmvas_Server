package org.momo.Posts.Service;

import org.momo.Posts.Dto.PostDTO;
import org.momo.Posts.Dto.PostSearchAllListResponseDto;
import org.momo.Posts.Dto.PostSearchAllResponseDto;
import org.momo.Posts.Dto.PostSearchResponseDto;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface PostService {
  PostDTO.PostCreateRP create(PostDTO.PostCreateRQ postCreateRQ) throws IOException;

//  PostDTO.PostUpdateRP update(Long postId, PostDTO.PostUpdateRQ postUpdateRQ, MultipartFile image, String email) throws IOException;

  PostSearchResponseDto search(Long id);

  PostSearchAllListResponseDto searchByCategory(String category);

  PostSearchAllListResponseDto searchAll();
}
