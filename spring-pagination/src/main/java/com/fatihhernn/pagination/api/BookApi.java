package com.fatihhernn.pagination.api;

import com.fatihhernn.pagination.Model.Book;
import com.fatihhernn.pagination.repo.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book")
@RequiredArgsConstructor
public class BookApi {


    private final BookRepository bookRepository;


    @GetMapping
    public Page<Book> pagination(@RequestParam Integer pageSize,
                                 @RequestParam Integer page){

        Pageable pageable= PageRequest.of(page,pageSize);
        return bookRepository.findAll(pageable);

    }

    //sort yapmak için
    @GetMapping("/p")
    public Page<Book> pagination(Pageable pageable){
        //totalElements countQuery maliyetli oluyor
        return bookRepository.findAll(pageable);
    }

    //sort yapmak için
    @GetMapping("/s")
    public Slice<Book> pagination2(Pageable pageable){
        //totalElements countQuery maliyetli ilgilenmezz
        return bookRepository.findAll(pageable);
    }



}
