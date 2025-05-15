package java_app.bot_service.controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bot")
public class BotController {

    @GetMapping("/move")
    public String generateBotMove(@RequestParam String boardState) {
        return "e2e4";
    }
}

