package com.honggoii.timegoesby.service;

import com.honggoii.timegoesby.controller.dto.PostsResponseDto;
import com.honggoii.timegoesby.controller.dto.PostsSaveRequestDto;
import com.honggoii.timegoesby.controller.dto.PostsUpdateRequestDto;
import com.honggoii.timegoesby.domain.Posts;
import com.honggoii.timegoesby.repository.PostsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class PostsService {

    private final PostsRepository postsRepository;

    /**
     * 게시글 등록(C)
     */
    @Transactional
    public Long save(PostsSaveRequestDto requestDto) {
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    /**
     * 게시글 조회 (R)
     */
    public PostsResponseDto findById(Long id) {
        Posts entity = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id = " + id));

        return new PostsResponseDto(entity);
    }


    /**
     * 게시글 수정 (U)
     */
    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto) {
        Posts posts = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id = " + id));

        posts.update(requestDto.getTitle(), requestDto.getContent());

        return id;
    }

    /**
     * 게시글 삭제 (D)
     */



}
