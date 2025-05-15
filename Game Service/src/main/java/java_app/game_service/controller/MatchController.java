package java_app.game_service.controller;

import java_app.game_service.model.Match;
import java_app.game_service.repository.MatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/matches")
public class MatchController {

    @Autowired
    private MatchRepository matchRepository;

    @PostMapping
    public Match createMatch(@RequestBody Match match) {
        return matchRepository.save(match);
    }

    @GetMapping
    public List<Match> getAllMatches() {
        return matchRepository.findAll();
    }
}

