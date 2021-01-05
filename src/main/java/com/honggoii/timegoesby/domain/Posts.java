package com.honggoii.timegoesby.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Posts {
    //게시글

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; //PK

    @Column(length = 500, nullable = false)
    private String title; //제목

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content; //내용

    private String author; //작성자

    @Builder
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

}
