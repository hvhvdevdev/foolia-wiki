package com.github.hvhvdevdev.foolishnesswiki.service;

import com.github.hvhvdevdev.foolishnesswiki.form.NewArticleEditionForm;
import com.github.hvhvdevdev.foolishnesswiki.form.NewArticleForm;
import com.github.hvhvdevdev.foolishnesswiki.model.Article;
import com.github.hvhvdevdev.foolishnesswiki.model.ArticleEdition;
import com.github.hvhvdevdev.foolishnesswiki.model.Tag;
import com.github.hvhvdevdev.foolishnesswiki.repository.ArticleEditionRepository;
import com.github.hvhvdevdev.foolishnesswiki.repository.ArticleRepository;
import com.github.hvhvdevdev.foolishnesswiki.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ManageArticleService {
    private final ArticleRepository articleRepository;
    private final ArticleEditionRepository articleEditionRepository;
    private final TagRepository tagRepository;

    @Autowired
    public ManageArticleService(ArticleRepository articleRepository, ArticleEditionRepository articleEditionRepository, TagRepository tagRepository) {
        this.articleRepository = articleRepository;
        this.articleEditionRepository = articleEditionRepository;
        this.tagRepository = tagRepository;
    }

    public void createArticle(NewArticleForm newArticleForm) {
        Article articleToInsert = new Article(new ArrayList<>(), newArticleForm.getTitle(), true);
        ArticleEdition articleEditionToInsert = new ArticleEdition(newArticleForm.getContent());
        for (String tag : newArticleForm.getTags()) {
            Tag tagToInsert = new Tag(tag);
            try {
                tagRepository.save(tagToInsert);
            } catch (Exception ignore) {
            }
            articleToInsert.getTags().add(tagToInsert);
        }
        articleEditionToInsert.setArticle(articleToInsert);
        articleRepository.save(articleToInsert);
        articleEditionRepository.save(articleEditionToInsert);
    }

    public void editArticle(Long articleId, NewArticleEditionForm newArticleEditionForm) {
        Article articleToEdit = articleRepository.findById(articleId).orElseThrow();
        ArticleEdition articleEditionToInsert = new ArticleEdition(newArticleEditionForm.getContent());
        articleEditionToInsert.setArticle(articleToEdit);
        articleEditionRepository.save(articleEditionToInsert);
    }
}
