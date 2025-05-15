package java_app.matchmaking_service.repository;

import java_app.matchmaking_service.model.MatchRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatchmakingRepository extends JpaRepository<MatchRequest, Long> {
    MatchRequest findByUsername(String username);
}
