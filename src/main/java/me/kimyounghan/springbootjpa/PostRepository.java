package me.kimyounghan.springbootjpa;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {

    List<Post> findByTitleStartsWith(String title);

    List<Post> findByTitle1(String title);

    @Query(value = "SELECT p FROM #{#entityName} AS p WHERE p.title = :title")
    List<Post> findByTitle2(@Param("title") String keyword, Sort sort);

    @Modifying(clearAutomatically = true, flushAutomatically = true)
    @Query(value = "UPDATE Post p SET p.title = ?1 WHERE p.id =?2")
    int updateTitle(String title, Long id);
}
