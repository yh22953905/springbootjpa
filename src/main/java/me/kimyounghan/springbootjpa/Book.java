package me.kimyounghan.springbootjpa;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;

@Data
@Entity
public class Book {

    @Id @GeneratedValue
    private Long id;

    private String title;

    @Lob
    private String content;

}
