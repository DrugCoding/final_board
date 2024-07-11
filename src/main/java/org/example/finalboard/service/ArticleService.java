package org.example.finalboard.service;

import ch.qos.logback.core.model.Model;
import lombok.RequiredArgsConstructor;
import org.example.finalboard.entity.ArticleEntity;
import org.example.finalboard.repository.ArticleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ArticleService {

    private final ArticleRepository articleRepository;

    public String createArticle(String title, String content) {
        ArticleEntity article = new ArticleEntity();
        article.setTitle(title);
        article.setContent(content);
        articleRepository.save(article);
        return "redirect:/";
    }

    public String updateArticle(Long articlePk, String title, String content) {
        ArticleEntity article = articleRepository.findByArticlePk(articlePk);
        article.setTitle(title);
        article.setContent(content);
        articleRepository.save(article);
        return "redirect:/";
    }

    public void deleteArticle(Long articlePk) {

        articleRepository.deleteById(articlePk);
    }
}
