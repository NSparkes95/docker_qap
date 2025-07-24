package com.yourorg.dockerqap.repository;

import com.yourorg.dockerqap.model.Tournament;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface TournamentRepository extends JpaRepository<Tournament, Long> {
    List<Tournament> findByStartDate(LocalDate startDate);
    List<Tournament> findByEndDateBefore(LocalDate date);
    List<Tournament> findByLocationContainingIgnoreCase(String location);

    Tournament save(Tournament tournament);

    List<Tournament> findAll();

    Optional<Tournament> findById(Long id);

    void deleteById(Long id);
}
