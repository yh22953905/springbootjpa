package me.kimyounghan.springbootjpa;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {

    List<Post> findByTitleStartsWith(String title);

    List<Post> findByTitle1(String title);

    @Query(value = "SELECT p FROM Post AS p WHERE p.title = ?1")
    List<Post> findByTitle2(String title, Sort sort);

}
