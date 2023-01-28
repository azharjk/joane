package com.github.azharjk.joane.posts;

public class PostResponse {
  private PostJson post;

  public PostResponse() {
  }

  public PostResponse(Post post) {
    this.post = new PostJson(post);
  }

  public PostJson getPost() {
    return post;
  }

  public void setPost(PostJson post) {
    this.post = post;
  }
}
