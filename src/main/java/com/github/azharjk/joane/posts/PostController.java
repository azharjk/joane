package com.github.azharjk.joane.posts;

import com.github.azharjk.joane.utils.JoaneResponse;
import jakarta.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/posts")
public class PostController {
  private final PostService postService;

  public PostController(PostService postService) {
    this.postService = postService;
  }

  @PreAuthorize("hasAuthority('SCOPE_write')")
  @PostMapping
  public JoaneResponse<Void, PostResponse> save(@AuthenticationPrincipal Jwt jwt, @RequestBody @Valid PostBody body) {
    return new JoaneResponse<>(null, new PostResponse(postService.save(jwt, body)));
  }
}
