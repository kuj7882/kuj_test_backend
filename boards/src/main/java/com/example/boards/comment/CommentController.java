package com.example.boards.comment;

import com.example.boards.comment.model.CommentDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/comment")
public class CommentController {

    private final CommentService commentService;

    // 댓글 작성
    @PostMapping("/{postId}")
    @ResponseStatus(HttpStatus.CREATED)
    public void addComment(@PathVariable Long postId, @RequestBody CommentDto commentDto) {
        commentService.addComment(postId, commentDto);
    }

    // 대댓글 작성
    @PostMapping("/{postId}/{parentCommentId}")
    @ResponseStatus(HttpStatus.CREATED)
    public void addReply(@PathVariable Long postId, @PathVariable Long parentCommentId,
                         @RequestBody CommentDto commentDto) {
        commentService.addReply(postId, parentCommentId, commentDto);
    }


}
