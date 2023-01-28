package com.github.azharjk.joane.posts;

public class PostJson {
  private Long id;
  private String content;
  private Long ownerId;

  public PostJson() {
  }

  public PostJson(Post post) {
    id = post.getId();
    content = post.getContent();
    ownerId = post.getOwner().getId();
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public Long getOwnerId() {
    return ownerId;
  }

  public void setOwnerId(Long ownerId) {
    this.ownerId = ownerId;
  }
}
