package com.metacoding.junitproject.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

@DataJpaTest
public class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;

    @BeforeEach
    void 데이터준비() {
        String title = "junit5";
        String author = "메타코딩";
        Book book = Book.builder()
                .title(title)
                .author(author)
                .build();
        bookRepository.save(book);
    }

    @Test
    void 책등록_test() {
        String title = "junit5";
        String author = "메타코딩";

        Book book = Book.builder()
                .title(title)
                .author(author)
                .build();

        Book bookPS = bookRepository.save(book);

        assertEquals(title, bookPS.getTitle());
        assertEquals(author, bookPS.getAuthor());
    }

    @Test
    void 책목록보기_test() {
        List<Book> books = bookRepository.findAll();

        assertEquals("junit5", books.get(0).getTitle());
        assertEquals("메타코딩", books.get(0).getAuthor());
    }

    @Sql("classpath:db/tableInit.sql")
    @Test
    void 책한건보기_test() {
        String title = "junit5";
        String author = "메타코딩";

        Book bookPS = bookRepository.findById(1L).get();

        assertEquals(title, bookPS.getTitle());
        assertEquals(author, bookPS.getAuthor());
    }

    @Sql("classpath:db/tableInit.sql")
    @Test
    void 책삭제_test() {
        Long id = 1L;

        bookRepository.deleteById(id);

        assertFalse(bookRepository.findById(id).isPresent());
    }

}
