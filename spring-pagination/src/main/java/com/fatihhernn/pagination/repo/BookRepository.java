package com.fatihhernn.pagination.repo;

import com.fatihhernn.pagination.Model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Long> {
}
