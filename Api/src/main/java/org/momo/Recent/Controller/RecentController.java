package org.momo.Recent.Controller;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.momo.Posts.Dto.PostDTO;
import org.momo.Posts.Dto.PostSearchAllListResponseDto;
import org.momo.Posts.Dto.PostSearchResponseDto;
import org.momo.Posts.Service.PostService;
import org.momo.Recent.Dto.RecentDTO;
import org.momo.Recent.Dto.RecentSearchAllListResponseDto;
import org.momo.Recent.Dto.RecentSearchResponseDto;
import org.momo.Recent.Service.RecentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
@Slf4j
public class RecentController {
    private final RecentService recentService;
    @PutMapping(value = "/recent/register")
    public ResponseEntity<?> createRecent(
            @RequestBody RecentDTO.RecentCreateRQ recentCreateRQ
    ) throws IOException {
        try{
            RecentDTO.RecentCreateRP recentCreateRP = recentService.create(recentCreateRQ);
            return new ResponseEntity<>(recentCreateRP,HttpStatus.OK);
        }catch (IllegalStateException e){
            return new ResponseEntity<>("에러가 발생했습니다", HttpStatus.CONFLICT);
        }
    }

    @GetMapping("/recent/search/id")
    public ResponseEntity<?> searchRecent(@RequestParam("id") long id){
        try{
            RecentSearchResponseDto search = recentService.search(id);
            return new ResponseEntity<>(search,HttpStatus.OK);
        }catch (IllegalStateException e){
            return new ResponseEntity<>("에러가 발생했습니다",HttpStatus.CONFLICT);
        }
    }

    @GetMapping("/recent/search/all")
    public ResponseEntity<?> searchAllRecent(){
        try{
            RecentSearchAllListResponseDto recentSearchAllListResponseDto = recentService.searchAll();
            return new ResponseEntity<>(recentSearchAllListResponseDto,HttpStatus.OK);
        }catch (IllegalStateException e){
            return new ResponseEntity<>("에러가 발생했습니다",HttpStatus.CONFLICT);
        }
    }
}