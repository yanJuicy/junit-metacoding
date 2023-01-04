package com.metacoding.junitproject.web.dto;

import com.metacoding.junitproject.domain.Book;
import lombok.Setter;

@Setter
public class BookSaveReqDto {
    private String title;
    private String author;

    public Book toEntity() {
        return Book.builder().title(title).author(author).build();
    }
}
