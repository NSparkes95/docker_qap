package com.yourorg.dockerqap.repository;

import com.yourorg.dockerqap.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    List<Member> findByMemberNameContainingIgnoreCase(String name);
    List<Member> findByMemberPhoneNumberContaining(String phoneNumber);
    List<Member> findByStartDateOfMembership(LocalDate startDate);
    List<Member> findByDurationOfMembership(Integer duration);
}
