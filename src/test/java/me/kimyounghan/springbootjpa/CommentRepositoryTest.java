package me.kimyounghan.springbootjpa;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CommentRepositoryTest {

    @Autowired
    CommentRepository commentRepository;

    @Test
    public void crud() {
        this.createComment(100, "spring data jpa");
        this.createComment(50, "HIBERNATE SPRING");

        List<Comment> comments = commentRepository.findByCommentContainsIgnoreCaseOrderByLikeCountDesc("Spring");
        assertThat(comments.size()).isEqualTo(2);
        assertThat(comments).first().hasFieldOrPropertyWithValue("LikeCount", 100);
    }

    private void createComment(int likeCount, String comment) {
        Comment newComment = new Comment();
        newComment.setComment("spring data jpa");
        newComment.setLikeCount(likeCount);
        commentRepository.save(newComment);
    }

}