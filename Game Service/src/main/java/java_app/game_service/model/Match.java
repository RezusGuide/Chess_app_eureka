package java_app.game_service.model;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Match {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long matchId;

    private Long player1Id;
    private Long player2Id;
    private Long categoryId;
    private String result;
    private LocalDateTime matchDate;

    // Getters and Setters
}