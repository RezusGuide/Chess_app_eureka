package java_app.matchmaking_service.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class MatchRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    private String mode;
    private String username;

    public Long getUserId() {
        return userId;
    }

    public String getMode() {
        return mode;
    }
}