package com.ll.exam.board3.article.mapper;

import com.ll.exam.board3.article.entity.Article;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface ArticleMapper{

    int articleCount();

    List<Article> findAll();
}
