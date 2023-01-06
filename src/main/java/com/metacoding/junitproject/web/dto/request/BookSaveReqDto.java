package com.metacoding.junitproject.web.dto.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.metacoding.junitproject.domain.Book;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookSaveReqDto {

    @Size(min = 1, max = 50)
    @NotBlank
    private String title;

    @Size(min = 2, max = 20)
    @NotBlank
    private String author;

    public Book toEntity() {
        return Book.builder().title(title).author(author).build();
    }
}
