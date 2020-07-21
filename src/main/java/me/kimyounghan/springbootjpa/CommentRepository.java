package me.kimyounghan.springbootjpa;


import org.springframework.data.domain.Pageable;

import java.util.stream.Stream;

public interface CommentRepository extends MyRepository<Comment, Long> {

    Stream<Comment> findByCommentContainsIgnoreCase(String keyword, Pageable pageable);

}
