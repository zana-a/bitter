package com.zana.bitter.post.responses;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Builder
@Getter
public class PostResponse {
    private long id;
    private String content;
    private LocalDateTime createdAt;
    private List<PostResponse> replies;
}
