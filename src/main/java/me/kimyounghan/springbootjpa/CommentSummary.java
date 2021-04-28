package me.kimyounghan.springbootjpa;

// Projection based on interface
public interface CommentSummary {

    String getComment();

    int getUp();

    int getDown();

}
