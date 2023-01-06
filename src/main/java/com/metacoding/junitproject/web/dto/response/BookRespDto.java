package com.metacoding.junitproject.web.dto;

import com.metacoding.junitproject.domain.Book;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class BookRespDto {

    private Long id;
    private String title;
    private String author;

    @Builder
    public BookRespDto(Long id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }

    public BookRespDto toDto(Book bookPS) {
        return BookRespDto.builder()
                .id(bookPS.getId())
                .title(bookPS.getTitle())
                .author(bookPS.getAuthor())
                .build();
    }
}
