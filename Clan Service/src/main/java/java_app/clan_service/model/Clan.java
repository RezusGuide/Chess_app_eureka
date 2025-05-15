package java_app.clan_service.model;

import jakarta.persistence.*;

@Entity
public class Clan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
}