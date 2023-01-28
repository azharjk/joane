package com.github.azharjk.joane.posts;

import jakarta.validation.constraints.NotEmpty;

public class PostBody {
  @NotEmpty
  private String content;

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }
}
