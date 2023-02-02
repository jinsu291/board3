package com.ll.exam.board3.article.service;

import com.ll.exam.board3.article.entity.Article;
import com.ll.exam.board3.article.mapper.ArticleMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ArticleService {
    @Autowired
    private final ArticleMapper articleMapper;

    public int articleCount(){
        return articleMapper.articleCount();
    }
    public List<Article> articleList(){
        return articleMapper.findAll();
    }
}
