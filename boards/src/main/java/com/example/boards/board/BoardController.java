package com.example.demo.controller;


import com.example.boards.board.model.Board;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import  com.example.boards.board.BoardService;

import java.util.List;

@RestController
@RequestMapping("/board")
public class BoardController {

    @Autowired
    private BoardService boardService;

    // 게시글 목록 조회
    @GetMapping("/list")
    public ResponseEntity<List<Board>> getBoardList() {
        List<Board> boardList = boardService.getAllBoards();
        return ResponseEntity.ok(boardList);
    }

    // 게시글 작성
    @PostMapping("/form")
    public ResponseEntity<Board> createBoard(@RequestBody Board board) {
        Board createdBoard = boardService.createBoard(board);
        return ResponseEntity.ok(createdBoard);
    }
}