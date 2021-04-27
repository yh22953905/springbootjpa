package me.kimyounghan.springbootjpa;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.JpaSort;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class PostRepositoryTest {

    @Autowired
    PostRepository postRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @Test
    public void save() {
        Post post = new Post();
        post.setTitle("jpa");
        Post savedPost = postRepository.save(post);// persist

        Post postUpdate = new Post();
        postUpdate.setId(post.getId());
        postUpdate.setTitle("hibernate");
        Post updatedPost = postRepository.save(postUpdate);// merge

        //postUpdate.setTitle("kimyounghan");
        updatedPost.setTitle("kimyounghan"); // Persistent 상태의 객체의 변화를 감지하여 반영하기 때문에 save 메소드의 리턴 값을 사용해야 한다.

        List<Post> all = postRepository.findAll();
        assertThat(all.size()).isEqualTo(1);
    }

    @Test
    public void findByTitleStartsWith() {
        savePost();
        List<Post> all = postRepository.findByTitleStartsWith("Spring");
        assertThat(all.size()).isEqualTo(1);
    }

    @Test
    public void findByTitle1() {
        savePost();
        List<Post> all = postRepository.findByTitle1("Spring");
        assertThat(all.size()).isEqualTo(1);
    }

    @Test
    public void findByTitle2() {
        savePost();
//        List<Post> all = postRepository.findByTitle2("Spring", Sort.by("title"));
        List<Post> all = postRepository.findByTitle2("Spring", JpaSort.unsafe("length(title)")); // 프로퍼티 혹은 alias가 아닌 값으로 정렬하는 방법
        assertThat(all.size()).isEqualTo(1);
    }

    private Post savePost() {
        Post post = new Post();
        post.setTitle("Spring");
        return postRepository.save(post); // persist
    }

    @Test
    public void updateTitle() {
        Post spring = savePost();

        String hibernate = "hibernate";
        int update = postRepository.updateTitle(hibernate, spring.getId());
        assertThat(update).isEqualTo(1);

        Optional<Post> byId = postRepository.findById(spring.getId());
        assertThat(byId.get().getTitle()).isEqualTo(hibernate);
        // clear 또는 flush 해주지 않으면
        // spring 변수에 해당하는 Post 객체가 여전히 Persistent Context 에 남아 있기 때문에 select 를 하지 않아 update 가 일어나지 않음.
    }

}