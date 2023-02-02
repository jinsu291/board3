package com.ll.exam.board3.article.controller;

import com.ll.exam.board3.article.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/article")
@RequiredArgsConstructor
public class ArticleController {
    private final ArticleService articleService;

    @GetMapping("/hello")
    public String test(Model model){
        model.addAttribute("cnt", articleService.articleCount());
        model.addAttribute("test", articleService.articleList());
        return "/article/hello";
    }
}