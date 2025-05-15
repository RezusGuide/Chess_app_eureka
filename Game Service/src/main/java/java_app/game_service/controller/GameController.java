package java_app.game_service.controller;

import java_app.game_service.model.*;
import java_app.game_service.service.GameService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/game")
public class GameController {

    @Autowired
    private GameService gameService;

    @GetMapping("/board")
    public Board getBoard() {
        return gameService.getBoard();
    }

    @GetMapping("/turn")
    public Color getCurrentTurn() {
        return gameService.getCurrentTurn();
    }

    @PostMapping("/move")
    public ResponseEntity<?> makeMove(@RequestBody MoveRequest moveRequest) {
        boolean success = gameService.makeMove(moveRequest.getFrom(), moveRequest.getTo());
        if (success) {
            return ResponseEntity.ok(gameService.getBoard());
        } else {
            return ResponseEntity.badRequest().body("Invalid move");
        }
    }

    @PostMapping("/reset")
    public void resetGame() {
        gameService.resetGame();
    }
}

