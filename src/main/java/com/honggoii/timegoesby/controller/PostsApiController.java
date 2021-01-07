package com.honggoii.timegoesby.controller;

import com.honggoii.timegoesby.controller.dto.PostsResponseDto;
import com.honggoii.timegoesby.controller.dto.PostsSaveRequestDto;
import com.honggoii.timegoesby.controller.dto.PostsUpdateRequestDto;
import com.honggoii.timegoesby.service.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class PostsApiController {

    private final PostsService postsService;


    /**
     * 게시글 등록(C)
     */
    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto) {
        return postsService.save(requestDto);
    }

    /**
     * 게시글 조회(R)
     */
    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto findById(@PathVariable Long id) {
        return postsService.findById(id);
    }

    /**
     * 게시글 수정(U)
     */
    @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto) {
        return postsService.update(id, requestDto);
    }

    /**
     * 게시글 삭제(D)
     */


}
