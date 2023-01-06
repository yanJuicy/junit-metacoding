package com.metacoding.junitproject.web.dto.reqquest;

import com.metacoding.junitproject.domain.Book;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookSaveReqDto {
    private String title;
    private String author;

    public Book toEntity() {
        return Book.builder().title(title).author(author).build();
    }
}
