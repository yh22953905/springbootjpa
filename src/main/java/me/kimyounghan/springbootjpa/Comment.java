package me.kimyounghan.springbootjpa;

import javax.persistence.*;

// name : 그래프의 이름, attributeNodes : 연관 관계의 이름
@NamedEntityGraph(name = "Comment.post", attributeNodes = @NamedAttributeNode("post"))
@Entity
public class Comment {

    @Id @GeneratedValue
    private Long id;

    private String comment;

    @ManyToOne(fetch = FetchType.LAZY) // ToOne 인 경우 FetchType 기본은 EAGER, ToMany 인 경우 FetchType 기본은 LAZY
    private Post post;

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
