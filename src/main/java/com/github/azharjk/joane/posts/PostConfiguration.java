package com.github.azharjk.joane.posts;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PostConfiguration {
  @Bean
  public PostService postService(PostRepository postRepository) {
    return new PostService(postRepository);
  }
}
