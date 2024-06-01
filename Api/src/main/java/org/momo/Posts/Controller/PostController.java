package org.momo.Posts.Controller;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.momo.Posts.Dto.PostDTO;
import org.momo.Posts.Dto.PostSearchAllListResponseDto;
import org.momo.Posts.Dto.PostSearchResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.momo.Posts.Service.PostService;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
@Slf4j
public class PostController {
    private final PostService postService;
    @PutMapping(value = "/post/register")
    public ResponseEntity<?> create(
            @RequestBody PostDTO.PostCreateRQ postCreateDto
    ) throws IOException {
        try{
            PostDTO.PostCreateRP postCreateRP = postService.create(postCreateDto);
            return new ResponseEntity<>(postCreateRP,HttpStatus.OK);
        }catch (IllegalStateException e){
            return new ResponseEntity<>("에러가 발생했습니다", HttpStatus.CONFLICT);
        }
    }

    @GetMapping("/post/search/id")
    public ResponseEntity<?> search(@RequestParam("id") long id){
        try{
            PostSearchResponseDto search = postService.search(id);
            return new ResponseEntity<>(search,HttpStatus.OK);
        }catch (IllegalStateException e){
            return new ResponseEntity<>("에러가 발생했습니다",HttpStatus.CONFLICT);
        }
    }

    @GetMapping("/post/search/category/{cat}")
    public ResponseEntity<?> searchByCategory(@PathVariable("cat") String category){
        try{
            PostSearchAllListResponseDto search = postService.searchByCategory(category);
            return new ResponseEntity<>(search,HttpStatus.OK);
        }catch (IllegalStateException e){
            return new ResponseEntity<>("에러가 발생했습니다",HttpStatus.CONFLICT);
        }
    }

    @GetMapping("/post/search/all")
    public ResponseEntity<?> searchAll(){
        try{
            PostSearchAllListResponseDto postSearchAllListResponseDto = postService.searchAll();
            return new ResponseEntity<>(postSearchAllListResponseDto,HttpStatus.OK);
        }catch (IllegalStateException e){
            return new ResponseEntity<>("에러가 발생했습니다",HttpStatus.CONFLICT);
        }
    }
}