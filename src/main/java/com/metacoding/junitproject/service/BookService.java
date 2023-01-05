package com.metacoding.junitproject.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.metacoding.junitproject.domain.Book;
import com.metacoding.junitproject.domain.BookRepository;
import com.metacoding.junitproject.web.dto.BookRespDto;
import com.metacoding.junitproject.web.dto.BookSaveReqDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class BookService {

    private final BookRepository bookRepository;

    @Transactional(rollbackFor = RuntimeException.class)
    public BookRespDto 책등록하기(BookSaveReqDto dto) {
        Book bookPS = bookRepository.save(dto.toEntity());
        return new BookRespDto().toDto(bookPS);
    }

}
