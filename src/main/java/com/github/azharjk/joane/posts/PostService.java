package com.github.azharjk.joane.posts;

import com.github.azharjk.joane.users.User;
import org.springframework.security.oauth2.jwt.Jwt;

public class PostService {
  private final PostRepository postRepository;

  public PostService(PostRepository postRepository) {
    this.postRepository = postRepository;
  }

  public Post save(Jwt jwt, PostBody body) {
    Long id = Long.parseLong(jwt.getSubject());
    User user = new User();
    user.setId(id);

    Post post = new Post(body.getContent());
    post.setOwner(user);

    return postRepository.save(post);
  }
}
