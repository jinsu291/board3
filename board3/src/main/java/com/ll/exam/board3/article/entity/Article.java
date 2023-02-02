package com.ll.exam.board3.article.entity;

import lombok.*;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Article {
    private long id;
    private String subject;
    private String content;
    private long memberId;

    public Article(String subject, String content) {
        this.subject = subject;
        this.content = content;
    }
}
