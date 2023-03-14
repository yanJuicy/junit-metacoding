package com.metacoding.junitproject.web;

import com.metacoding.junitproject.web.dto.response.BookListRespDto;
import com.metacoding.junitproject.web.dto.response.CMRespDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.metacoding.junitproject.service.BookService;
import com.metacoding.junitproject.web.dto.request.BookSaveReqDto;
import com.metacoding.junitproject.web.dto.response.BookRespDto;

import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
@RestController
public class BookApiController {

    private final BookService bookService;

    @PostMapping("/api/v1/book")
    public ResponseEntity<?> saveBook(@RequestBody BookSaveReqDto bookSaveReqDto, BindingResult bindingResult) {
        // AOP 처리하는 게 좋음!!
        if (bindingResult.hasErrors()) {
            Map<String, String> errorMap = new HashMap<>();
            for (FieldError fe : bindingResult.getFieldErrors()) {
                errorMap.put(fe.getField(), fe.getDefaultMessage());
            }
            System.out.println("=================================");
            System.out.println(errorMap.toString());
            System.out.println("=================================");

            throw new RuntimeException(errorMap.toString());
        }

        BookRespDto bookRespDto = bookService.책등록하기(bookSaveReqDto);
        return new ResponseEntity<>(CMRespDto.builder().code(1).msg("글 저장 성공").body(bookRespDto).build(),
                HttpStatus.CREATED); // 201 = insert
    }

    @GetMapping("/api/v1/book")
    public ResponseEntity<?> getBookList() {
        BookListRespDto bookListRespDto = bookService.책목록보기();
        return new ResponseEntity<>(CMRespDto.builder().code(1).msg("글 목록보기 성공").body(bookListRespDto).build(),
                HttpStatus.OK); // 200 = ok
    }

    // 3. 책한건보기
    @GetMapping("/api/v1/book/{id}")
    public ResponseEntity<?> getBookOne(@PathVariable Long id) {
        return null;

    }

    // 4. 책삭제하기
    @DeleteMapping("/api/v1/book/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable Long id) {
        return null;

    }

    // 5. 책수정하기
    @PutMapping("/api/v1/book/{id}")
    public ResponseEntity<?> updateBook(@PathVariable Long id, @RequestBody BookSaveReqDto bookSaveReqDto,
            BindingResult bindingResult) {
        return null;
    }

}
