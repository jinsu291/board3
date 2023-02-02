package com.ll.exam.board3.article.mapper;

import com.ll.exam.board3.article.entity.Article;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleMapper{

    int articleCount();

    List<Article> findAll();
}
