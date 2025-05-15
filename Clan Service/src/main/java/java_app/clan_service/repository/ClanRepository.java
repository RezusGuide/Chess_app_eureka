package java_app.clan_service.repository;

import java_app.clan_service.model.Clan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClanRepository extends JpaRepository<Clan, Long> {
}