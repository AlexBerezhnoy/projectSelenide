package com.hillel.auto.model;

public class CommentResponce {
    private CommentApi[] commentResponce;

    public CommentResponce() {
    }

    public CommentResponce(CommentApi[] commentResponce) {
        this.commentResponce = commentResponce;
    }

    public CommentApi[] getCommentApi() {
        return commentResponce;
    }

    public void getComment(CommentApi[] commentResponce) {
        this.commentResponce = commentResponce;
    }
}
