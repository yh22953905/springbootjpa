package me.kimyounghan.springbootjpa;

import org.springframework.beans.factory.annotation.Value;

// Projection based on interface
public interface CommentSummary {

    String getComment();

    int getUp();

    int getDown();

    // Closed Projection 의 장점을 살리며 커스텀 컬럼
    default String getVotes() {
        return getUp() + " " + getDown();
    }

    // Open Projection
//    @Value("#{target.up + ' ' + target.down}")
//    String getVotes();

}
