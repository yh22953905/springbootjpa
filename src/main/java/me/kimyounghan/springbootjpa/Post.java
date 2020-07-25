package me.kimyounghan.springbootjpa;

import javax.persistence.*;

@Entity
public class Post {

    @Id @GeneratedValue
    private Long id;

    private String title;

    @Lob
    private String content;

    @Temporal(TemporalType.TIMESTAMP)

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
