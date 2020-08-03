package me.kimyounghan.springbootjpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface BookRepository extends MyRepository<Book, Long>, QuerydslPredicateExecutor<Book> {
}
