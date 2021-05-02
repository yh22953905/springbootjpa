package me.kimyounghan.springbootjpa;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import static me.kimyounghan.springbootjpa.CommentSpecs.isBest;
import static me.kimyounghan.springbootjpa.CommentSpecs.isGood;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CommentRepositoryTest {

    @Autowired
    CommentRepository commentRepository;

    @Autowired
    PostRepository postRepository;

    @Test
    public void getComment() {
        Post post = new Post();
        post.setTitle("jpa");
        Post savedPost = postRepository.save(post);

        Comment comment = new Comment();
        comment.setComment("spring data jpa projection");
        comment.setPost(savedPost);
        comment.setUp(10);
        comment.setDown(1);
        commentRepository.save(comment);

        commentRepository.findByPost_Id(1L, CommentOnly.class).forEach(c -> {
            System.out.println(c.getComment());
        });
    }

    @Test
    public void specs() {
        Page<Comment> page = commentRepository
                .findAll(isBest().and(isGood()), PageRequest.of(0, 5));
    }

    @Test
    public void queryByExample() {
        Comment comment = new Comment();
        comment.setBest(true);

        ExampleMatcher exampleMatcher = ExampleMatcher.matchingAny().withIgnoreCase();
        Example<Comment> example = Example.of(comment, exampleMatcher);

        commentRepository.findAll(example);
    }

}