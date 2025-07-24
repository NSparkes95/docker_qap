package com.yourorg.dockerqap.service;

import com.yourorg.dockerqap.model.Member;
import com.yourorg.dockerqap.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class MemberService {
    private final MemberRepository memberRepository;

    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public Member saveMember(Member member) {
        return memberRepository.save(member);
    }

    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> getMemberById(Long id) {
        return memberRepository.findById(id);
    }

    public void deleteMember(Long id) {
        memberRepository.deleteById(id);
    }

    public List<Member> searchByName(String name) {
        return memberRepository.findByMemberNameContainingIgnoreCase(name);
    }

    public List<Member> searchByPhone(String phone) {
        return memberRepository.findByMemberPhoneNumberContaining(phone);
    }

    public List<Member> searchByStartDate(LocalDate date) {
        return memberRepository.findByStartDateOfMembership(date);
    }

    public List<Member> searchByDuration(Integer duration) {
        return memberRepository.findByDurationOfMembership(duration);
    }

}
