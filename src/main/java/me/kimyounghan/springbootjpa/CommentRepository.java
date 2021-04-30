package me.kimyounghan.springbootjpa;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import java.util.List;
import java.util.Optional;

public interface CommentRepository extends JpaRepository<Comment, Long>, JpaSpecificationExecutor<Comment>, QueryByExampleExecutor<Comment> {

    // 이전 커밋과 동일한 내용
    @EntityGraph(attributePaths = "post")
    Optional<Comment> getById(Long id);

    // Closed Projection
    <T> List<T> findByPost_Id(Long id, Class<T> type);

}
