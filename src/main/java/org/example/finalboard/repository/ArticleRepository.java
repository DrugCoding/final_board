package org.example.finalboard.repository;

import org.example.finalboard.entity.ArticleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<ArticleEntity, Long> {
    ArticleEntity findByArticlePk(Long articlePk);

}
