package me.kimyounghan.springbootjpa;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CommentRepository extends MyRepository<Comment, Long> {

//    @Query(value = "SELECT c FROM Comment AS c", nativeQuery = true)
    List<Comment> findByCommentContains(String keyword);

//    Page<Comment> findByTitleIgnoreCase(String title, Pageable pageable);

    Page<Comment> findByLikeCountGreaterThanAndPost(int likeCount, Post post, Pageable pageable);

}
