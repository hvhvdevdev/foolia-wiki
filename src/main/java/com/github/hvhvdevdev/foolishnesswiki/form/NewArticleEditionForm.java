package com.github.hvhvdevdev.foolishnesswiki.form;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
public class NewArticleEditionForm {
    @NonNull
    private String content;
}
