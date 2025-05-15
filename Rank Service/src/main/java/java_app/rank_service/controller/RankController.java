package java_app.rank_service.controller;

import java_app.rank_service.model.Rank;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ranks")
public class RankController {

    @GetMapping("/{userId}")
    public Rank getRank(@PathVariable Long userId) {
        Rank rank = new Rank();
        rank.setUserId(userId);
        rank.setRank(1000); // Placeholder rank
        return rank;
    }
}