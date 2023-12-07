package com.zana.bitter.post.controllers;

import com.zana.bitter.post.responses.PostResponse;
import com.zana.bitter.post.services.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    /**
     * Finds all posts in database.
     *
     * @return List of {@link PostResponse}
     */
    @GetMapping
    public ResponseEntity<List<PostResponse>> findAll() {
        return ResponseEntity.ok(postService.findAll());
    }

    /**
     * Gets a single post by its {id}.
     *
     * @param id the post id
     * @return a single {@link PostResponse}
     */
    @GetMapping("{id}")
    public ResponseEntity<PostResponse> getById(@PathVariable long id) {
        return ResponseEntity.ok(postService.getById(id));
    }

    /**
     * Persists a single post to the database.
     *
     * @param postResponse the post to save
     */
    @PostMapping
    public ResponseEntity<Void> save(@RequestBody PostResponse postResponse) {
        postService.save(postResponse);
        return ResponseEntity.ok().build();
    }

    /**
     * Deletes a single post by its id.
     *
     * @param id the post id
     */
    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteById(@PathVariable long id) {
        postService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
