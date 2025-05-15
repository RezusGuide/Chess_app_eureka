package java_app.clan_service.controller;

import java_app.clan_service.model.Clan;
import java_app.clan_service.repository.ClanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clans")
public class ClanController {

    @Autowired
    private ClanRepository clanRepository;

    @PostMapping
    public Clan createClan(@RequestBody Clan clan) {
        return clanRepository.save(clan);
    }

    @GetMapping
    public List<Clan> getAllClans() {
        return clanRepository.findAll();
    }
}


