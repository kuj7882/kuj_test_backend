package com.example.boards.comment.model;

import com.example.boards.board.model.Board;
import com.example.boards.board.model.BoardDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class CommentDto {
    @Getter
    public static class Commment {
        private int idx;
        private String content;
        private String writer;

        public Comment toEntity() {
            return Comment.builder()
                    .Content(content)
                    .writer(writer)
                    .build();
        }

    }
}
