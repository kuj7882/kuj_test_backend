package com.example.boards.comment;

import com.example.boards.comment.model.Comment;
import com.example.boards.comment.model.CommentDto;
import com.example.boards.comment.model.CommentRes;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CommentService {

    private final CommentRepository commentRepository;

    @Transactional
    public Comment create(Long idx, String content, String writer) {
        Comment comment = Comment.builder()
                .idx(idx)
                .Content(content)
                .writer(writer)
                .build();

        return commentRepository.save(comment);
    }

    @Transactional(readOnly = true)
    public CommentDto read(Long idx) {
        Optional<Comment> result = commentRepository.findById(idx);

        if (result.isPresent()) {
            Comment comment = result.get();
            return CommentDto.builder()
                    .Content(comment.getContent())
                    .writer(comment.getWriter())
                    .build();
        }

        return null;
    }

    public void addComment(Long postId, CommentDto commentDto) {
    }

    public void addReply(Long postId, Long parentCommentId, CommentDto commentDto) {
    }
}
