package me.kimyounghan.springbootjpa;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    // value : 연관 관계 EntityGraph 의 이름
    // type : FETCH : 설정한 엔티티 애트리뷰트는 EAGER, 나머지는 LAZY / LOAD : 설정한 엔티티 애트리뷰트는 EAGER, 나머지는 기본 전략 따름.
    // 두 type 모두 설정한 엔티티 애트리뷰트는 EAGER fetch
    @EntityGraph(value = "Comment.post", type = EntityGraph.EntityGraphType.LOAD)
    Optional<Comment> getById(Long id);

}
