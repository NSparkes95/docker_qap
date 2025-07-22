package com.yourorg.dockerqap.model;

import javax.persistence.Entity;
import javax.print.attribute.standard.PrintQuality;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
public class member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String memberName;
    private String memberAddress;
    private String memberEmailAddress;
    private String memberPhoneNumber;
    private LocalDate startDateOfMembership;
    private Integer durationOfMembership;

    private Set<Tournament> tournaments = new HashSet<>();

    public member() {}

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
        tournament.getMembers().add(this);
    }

    public void setTournaments(Set<Tournament> tournaments) {
        this.tournaments = tournaments;
    }


}
