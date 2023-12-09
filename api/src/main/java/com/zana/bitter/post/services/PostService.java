package com.zana.bitter.post.services;

import com.zana.bitter.post.mappers.PostEntityToPostResponse;
import com.zana.bitter.post.mappers.PostResponseToPostEntity;
import com.zana.bitter.post.repositories.PostRepository;
import com.zana.bitter.post.responses.PostResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    private final PostEntityToPostResponse postEntityToPostResponse;
    private final PostResponseToPostEntity postResponseToPostEntity;

    public PostResponse getById(long id) {
        return postRepository.findById(id)
                .map(postEntityToPostResponse)
                .orElseThrow();
    }

    public void save(PostResponse postResponse) {
        final var postEntity = postResponseToPostEntity.apply(postResponse);
        postRepository.save(postEntity);
    }

    public List<PostResponse> findAll() {
        final var postEntities = postRepository.findAll();
        return postEntities
                .stream()
                .map(postEntityToPostResponse)
                .toList();
    }

    public void deleteById(long id) {
        if (postRepository.existsById(id)) postRepository.deleteById(id);
        else throw new RuntimeException();
    }
}
