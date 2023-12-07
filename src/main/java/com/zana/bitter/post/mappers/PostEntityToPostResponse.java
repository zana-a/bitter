package com.zana.bitter.post.mappers;

import com.zana.bitter.post.entities.PostEntity;
import com.zana.bitter.post.responses.PostResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class PostEntityToPostResponse implements Function<PostEntity, PostResponse> {

    @Override
    public PostResponse apply(PostEntity postEntity) {
        return PostResponse.builder()
                .id(postEntity.getId())
                .content(postEntity.getContent())
                .createdAt(postEntity.getCreatedAt())
                .build();
    }
}
