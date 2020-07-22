package me.kimyounghan.springbootjpa;


import org.springframework.data.domain.Pageable;
import org.springframework.scheduling.annotation.Async;

import java.util.List;
import java.util.concurrent.Future;
import java.util.stream.Stream;

public interface CommentRepository extends MyRepository<Comment, Long> {

    @Async
    Future<List<Comment>> findByCommentContainsIgnoreCase(String keyword, Pageable pageable);

}
