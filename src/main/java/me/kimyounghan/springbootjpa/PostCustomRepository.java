package me.kimyounghan.springbootjpa;

import java.util.List;

public interface PostCustomRepository<T> {

    List<Post> findMyPost();

    void delete(T entity);

}
