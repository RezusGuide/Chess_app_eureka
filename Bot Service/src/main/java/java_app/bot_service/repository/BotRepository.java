package java_app.bot_service.repository;

import java_app.bot_service.model.Bot;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BotRepository extends JpaRepository<Bot, Long> {
    Bot findByUsername(String username);
}
