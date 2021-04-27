package me.kimyounghan.springbootjpa;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    // 이전 커밋과 동일한 내용
    @EntityGraph(attributePaths = "post")
    Optional<Comment> getById(Long id);

}
