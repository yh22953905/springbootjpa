package me.kimyounghan.springbootjpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostController {

    @Autowired
    PostRepository postRepository;

    @GetMapping("/posts/{id}")
    public String getAPost(@PathVariable Post post) {
        return post.getTitle();
    }

    public PagedModel<Post> getPosts(Pageable pageable, PagedResourcesAssembler assembler) {
        Page<Post> all = postRepository.findAll(pageable);
        return assembler.toModel(all);
    }
}
