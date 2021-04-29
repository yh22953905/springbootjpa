package me.kimyounghan.springbootjpa;

import org.springframework.data.jpa.domain.Specification;

public class CommentSpecs {

    public static Specification<Comment> isBest() {
        return (Specification<Comment>) (root, query, builder) -> builder.isTrue(root.get(Comment_.best));
    }

    public static Specification<Comment> isGood() {
        return (Specification<Comment>) (root, query, builder) -> builder.greaterThan(root.get(Comment_.up), 10);
    }

}
