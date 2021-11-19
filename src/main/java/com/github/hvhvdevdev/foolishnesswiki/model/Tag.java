package com.github.hvhvdevdev.foolishnesswiki.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
public class Tag {
    @Id
    @NonNull
    private String name;

    @ManyToMany(mappedBy = "tags")
    private List<Article> articles;
}
