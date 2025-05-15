package java_app.rank_service.repository;

import java_app.rank_service.model.Rank;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RankRepository extends JpaRepository<Rank, Long> {
    Rank findByUsername(String username);
}
