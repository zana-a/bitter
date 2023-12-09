package com.zana.bitter.post.mappers;

import com.zana.bitter.post.entities.PostEntity;
import com.zana.bitter.post.responses.PostResponse;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class PostResponseToPostEntity implements Function<PostResponse, PostEntity> {

    @Override
    public PostEntity apply(PostResponse postResponse) {
        return PostEntity.builder()
                .id(postResponse.getId())
                .content(postResponse.getContent())
                .createdAt(postResponse.getCreatedAt())
                .build();
    }
}
