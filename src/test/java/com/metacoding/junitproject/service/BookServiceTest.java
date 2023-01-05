package com.metacoding.junitproject.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.metacoding.junitproject.domain.BookRepository;
import com.metacoding.junitproject.util.MailSenderStub;
import com.metacoding.junitproject.web.dto.BookRespDto;
import com.metacoding.junitproject.web.dto.BookSaveReqDto;

@DataJpaTest
public class BookServiceTest {

    @Autowired
    private BookRepository bookRepository;

    @Test
    public void 책등록하기_테스트() {
        BookSaveReqDto dto = new BookSaveReqDto();
        dto.setTitle("junit강의");
        dto.setAuthor("메타코딩");

        MailSenderStub mailSenderStub = new MailSenderStub();

        BookService bookService = new BookService(bookRepository, mailSenderStub);
        BookRespDto bookRespDto = bookService.책등록하기(dto);

        assertThat(bookRespDto.getTitle()).isEqualTo(dto.getTitle());
        assertThat(bookRespDto.getAuthor()).isEqualTo(dto.getAuthor());
    }

}
