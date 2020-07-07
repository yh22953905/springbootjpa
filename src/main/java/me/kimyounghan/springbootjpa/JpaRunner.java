package me.kimyounghan.springbootjpa;

import org.hibernate.Session;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Component
@Transactional
public class JpaRunner implements ApplicationRunner {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void run(ApplicationArguments args) throws Exception {
//        Post post = new Post();
//        post.setTitle("스프링 데이터 JPA");
//
//        Comment comment1 = new Comment();
//        comment1.setComment("댓글1");
//        post.addComment(comment1);
//
//        Comment comment2 = new Comment();
//        comment2.setComment("댓글2");
//        post.addComment(comment2);

        Session session = entityManager.unwrap(Session.class);
//        session.save(post);
//        Post post = session.get(Post.class, 4l);
        Comment comment = session.get(Comment.class, 5l);
        System.out.println("==================================================");
        System.out.println(comment.getComment());
        System.out.println("==================================================");
    }

}
