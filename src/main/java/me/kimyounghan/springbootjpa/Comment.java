package me.kimyounghan.springbootjpa;

import javax.persistence.*;

@Entity
public class Comment {

    @Id @GeneratedValue
    private Long id;

    private String comment;

    @ManyToOne(fetch = FetchType.LAZY) // ToOne 인 경우 FetchType 기본은 EAGER, ToMany 인 경우 FetchType 기본은 LAZY
    private Post post;

    private int up;

    private int down;

    private boolean best;

    public Long getId() {
        return id;
    }

    public String getComment() {
        return comment;
    }

    public Post getPost() {
        return post;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setPost(Post post) {
        this.post = post;
    }
}
