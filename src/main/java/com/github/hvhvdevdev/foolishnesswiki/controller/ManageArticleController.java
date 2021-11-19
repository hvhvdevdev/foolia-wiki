package com.github.hvhvdevdev.foolishnesswiki.controller;

import com.github.hvhvdevdev.foolishnesswiki.form.NewArticleEditionForm;
import com.github.hvhvdevdev.foolishnesswiki.form.NewArticleForm;
import com.github.hvhvdevdev.foolishnesswiki.service.ManageArticleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/manage-article")
public class ManageArticleController {
    private final ManageArticleService manageArticleService;

    @Autowired
    public ManageArticleController(ManageArticleService manageArticleService) {
        this.manageArticleService = manageArticleService;
    }


    @PostMapping
    @PreAuthorize("hasAnyRole('WRITER','ADMIN')")
    public void createNewArticle(@RequestBody NewArticleForm newArticleForm) throws Exception {
        log.info(newArticleForm.toString());
        manageArticleService.createArticle(newArticleForm);
    }

    @PutMapping("{id}")
    @PreAuthorize("hasAnyRole('ADMIN','WRITER')")
    public void editArticle(@RequestBody NewArticleEditionForm newArticleEditionForm, @PathVariable("id") Long id) {
        manageArticleService.editArticle(id, newArticleEditionForm);
    }
}