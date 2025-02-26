package com.example.boards.board;

import com.example.boards.board.model.Board;

import com.example.boards.board.model.BoardDto;

import com.example.boards.board.BoardRepository;


import com.example.boards.board.model.Board;
import jakarta.persistence.Id;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BoardService {

        @Autowired
        private BoardRepository boardRepository;

        public List<Board> getAllBoards() {
            return boardRepository.findAll();
        }

        public Board createBoard(Board board) {
            return boardRepository.save(board);
        }

        public Board updateBoard(Long id, Board board) {
            Optional<Board> existingBoard = boardRepository.findById(id);
            if (existingBoard.isPresent()) {
                board.getIdx();
                return boardRepository.save(board);
            }
            return null;
        }

    }