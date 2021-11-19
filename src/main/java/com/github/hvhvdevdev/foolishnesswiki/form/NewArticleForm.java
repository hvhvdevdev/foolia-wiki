package com.github.hvhvdevdev.foolishnesswiki.form;

import lombok.Data;
import lombok.NonNull;

import java.util.Set;

@Data
public class NewArticleForm {
    @NonNull
    private final String title;

    @NonNull
    private final String content;

    @NonNull
    private final Set<String> tags;
}
