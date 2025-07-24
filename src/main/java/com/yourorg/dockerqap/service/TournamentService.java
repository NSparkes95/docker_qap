package com.yourorg.dockerqap.service;

import com.yourorg.dockerqap.model.Tournament;
import com.yourorg.dockerqap.repository.TournamentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class TournamentService {

    private final TournamentRepository tournamentRepository;

    @Autowired
    public TournamentService(TournamentRepository tournamentRepository) {
        this.tournamentRepository = tournamentRepository;
    }

    public Tournament saveTournament(Tournament tournament) {
        return tournamentRepository.save(tournament);
    }

    public List<Tournament> getAllTournaments() {
        return tournamentRepository.findAll();
    }

    public Optional<Tournament> getTournamentById(Long id) {
        return tournamentRepository.findById(id);
    }

    public Tournament createTournament(Tournament tournament) {
        return tournamentRepository.save(tournament);
    }

    public void deleteTournament(Long id) {
        tournamentRepository.deleteById(id);
    }

    public List<Tournament> searchByStartDate(LocalDate startDate) {
        return tournamentRepository.findByStartDate(startDate);
    }

    public List<Tournament> searchByEndDateBefore(LocalDate date) {
        return tournamentRepository.findByEndDateBefore(date);
    }

    public List<Tournament> searchByLocation(String location) {
        return tournamentRepository.findByLocationContainingIgnoreCase(location);
    }
}
