package java_app.matchmaking_service.controller;

import java_app.matchmaking_service.model.MatchRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/matchmaking")
public class MatchmakingController {

    @PostMapping("/request")
    public String requestMatch(@RequestBody MatchRequest request) {
        return "Match request received for user: " + request.getUserId() + " in mode: " + request.getMode();
    }
}

