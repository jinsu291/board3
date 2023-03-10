package com.ll.exam.board3.article.controller;

import com.ll.exam.board3.article.entity.Article;
import com.ll.exam.board3.article.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/articles")
@RequiredArgsConstructor
public class ArticleController {
    private final ArticleService articleService;

    @GetMapping("/hello")
    public String test(Model model){
        model.addAttribute("cnt", articleService.articleCount());
        model.addAttribute("test", articleService.articleList());
        return "/article/hello";
    }

    @GetMapping("")
    public String main(Model model){
        model.addAttribute("articles", articleService.articleList());
        return "/article/articles";
    }

    @GetMapping("/{id}")
    public String article(@PathVariable long id, Model model){
        model.addAttribute("article", articleService.findById(id));
        return "/article/article";
    }

    @GetMapping("/add")
    public String add(){
        return "/article/addForm";
    }

    @PostMapping("/add")
    public String add(@RequestParam String subject, @RequestParam String content,
                      RedirectAttributes redirectAttributes){
        Article newArticle = new Article(subject, content);
        Long id = articleService.add(newArticle);
        System.out.println("id = " + id);

        redirectAttributes.addAttribute("id", id);
        redirectAttributes.addAttribute("status", true);
        return "redirect:/articles/{id}";
    }

    @GetMapping("/{id}/edit")
    public String editForm(@PathVariable Long id, Model model){
        Article findArticle = articleService.findById(id);
        model.addAttribute("article", findArticle);
        return "article/editForm";
    }

    @PostMapping("/{id}/edit")
    public String editForm(@PathVariable Long id, @RequestParam String subject,
                           @RequestParam String content)
    {
        Article findArticle = articleService.findById(id);
        findArticle.setSubject(subject);
        findArticle.setContent(content);

        articleService.update(findArticle);

        return "redirect:/articles/{id}";
    }

    @GetMapping("/{id}/delete")
    public String deleteArticle(@PathVariable Long id){
        articleService.deleteById(id);
        return "redirect:/articles";
    }
}