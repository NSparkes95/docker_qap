package com.yourorg.dockerqap.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.JoinTable;
import jakarta.persistence.JoinColumn;

import java.time.LocalDate;
import java.util.Set;
import java.util.HashSet;

@Entity
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String memberName;
    private String memberAddress;
    private String memberEmailAddress;
    private String memberPhoneNumber;
    private LocalDate startDateOfMembership;
    private Integer durationOfMembership;

    @ManyToMany(mappedBy = "members")
    private Set<Tournament> tournaments = new HashSet<>();

    public Member() {}

    public long getId(){
        return id;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getMemberAddress() {
        return memberAddress;
    }

    public void setMemberAddress(String memberAddress) {
        this.memberAddress = memberAddress;
    }

    public String getMemberEmailAddress() {
        return memberEmailAddress;
    }

    public void setMemberEmailAddress(String memberEmailAddress) {
        this.memberEmailAddress = memberEmailAddress;
    }

    public String getMemberPhoneNumber() {
        return memberPhoneNumber;
    }

    public void setMemberPhoneNumber(String memberPhoneNumber) {
        this.memberPhoneNumber = memberPhoneNumber;
    }

    public LocalDate getStartDateOfMembership() {
        return startDateOfMembership;
    }

    public void setStartDateOfMembership(LocalDate startDateOfMembership) {
        this.startDateOfMembership = startDateOfMembership;
    }

    public Integer getDurationOfMembership() {
        return durationOfMembership;
    }

    public void setDurationOfMembership(Integer durationOfMembership) {
        this.durationOfMembership = durationOfMembership;
    }

    public Set<Tournament> getTournaments() {
        return tournaments;
    }

    public void addTournament(Tournament tournament) {
        tournaments.add(tournament);
    }

    public void setTournaments(Set<Tournament> tournaments) {
        this.tournaments = tournaments;
    }

    public void setId(Long id) {
        this.id = id;
    }



}
