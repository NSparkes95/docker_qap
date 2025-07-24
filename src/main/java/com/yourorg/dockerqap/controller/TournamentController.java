package com.yourorg.dockerqap.controller;

import com.yourorg.dockerqap.model.Tournament;
import com.yourorg.dockerqap.service.TournamentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tournaments")
public class TournamentController {
    private final TournamentService tournamentService;

    @Autowired
    public TournamentController(TournamentService tournamentService) {
        this.tournamentService = tournamentService;
    }

    //Create Tournament
    @PostMapping
    public Tournament createTournament(@RequestBody Tournament tournament) {
        return tournamentService.createTournament(tournament);
    }

    //Get All Tournaments
    @GetMapping
    public List<Tournament> getAllTournaments() {
        return tournamentService.getAllTournaments();
    }

    //Get Tournament by ID
    @GetMapping("/{id}")
    public Optional<Tournament> getTournamentById(@PathVariable Long id) {
        return tournamentService.getTournamentById(id);
    }

    // Update Tournament by ID
    @PutMapping("/{id}")
    public Tournament updateTournament(@PathVariable Long id, @RequestBody Tournament updatedTournament) {
        return tournamentService.getTournamentById(id)
                .map(existingTournament -> {
                    existingTournament.setStartDate(updatedTournament.getStartDate());
                    existingTournament.setEndDate(updatedTournament.getEndDate());
                    existingTournament.setLocation(updatedTournament.getLocation());
                    existingTournament.setEntryFee(updatedTournament.getEntryFee());
                    existingTournament.setCashPrizeAmount(updatedTournament.getCashPrizeAmount());
                    existingTournament.setMembers(updatedTournament.getMembers());
                    return tournamentService.saveTournament(existingTournament);
                })
                .orElseGet(() -> {
                    updatedTournament.setId(id);
                    return tournamentService.saveTournament(updatedTournament);
                });
    }


    //Delete Tournament
    @DeleteMapping("/{id}")
    public void deleteTournament(@PathVariable Long id) {
        tournamentService.deleteTournament(id);
    }

    // Search by Start date
    @GetMapping("/search/startDate")
    public List<Tournament> getTournamentsByStartDate(@RequestParam LocalDate startDate) {
        return tournamentService.getTournamentsByStartDate(startDate);
    }

    // Search by End date
    @GetMapping("/search/endDate")
    public List<Tournament> getTournamentsByEndDate(@RequestParam LocalDate endDate) {
        return tournamentService.getTournamentsByEndDate(endDate);
    }

    // Search by Location
    @GetMapping("/search/location")
    public List<Tournament> getTournamentsByLocation(@RequestParam String location) {
        return tournamentService.getTournamentsByLocation(location);
    }
}
