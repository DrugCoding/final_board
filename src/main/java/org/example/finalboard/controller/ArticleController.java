package org.example.finalboard.controller;


import lombok.RequiredArgsConstructor;
import org.example.finalboard.entity.ArticleEntity;
import org.example.finalboard.repository.ArticleRepository;
import org.example.finalboard.service.ArticleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ArticleController {

    private final ArticleService articleService;
    private final ArticleRepository articleRepository;

    @GetMapping("")
    public String homePage(Model model) {
        List<ArticleEntity> articleList = articleRepository.findAll();
        model.addAttribute("pickme", articleList);
        return "index";
    }

    @GetMapping("/create")
    public String getCreateArticle() {
        return "/create";
    }

    @PostMapping("/create")
    public String createArticle(@RequestParam String title, @RequestParam String content) {
        return articleService.createArticle(title, content);
    }

    @PostMapping("/update/{articlePk}")
    public String updateArticle(@PathVariable Long articlePk, @RequestParam String title, @RequestParam String content) {
        return articleService.updateArticle(articlePk, title, content);
    }

    @GetMapping("/{articlePk}")
    public String getArticle(@PathVariable Long articlePk, Model model) {
        ArticleEntity article = articleRepository.findByArticlePk(articlePk);
        model.addAttribute("pickme2", article);
        return "detail.html";
    }

    @PostMapping("/delete/{articlePk}")
    public String deleteArticle(@PathVariable Long articlePk) {
        articleService.deleteArticle(articlePk);
        return "redirect:/";
    }
}
