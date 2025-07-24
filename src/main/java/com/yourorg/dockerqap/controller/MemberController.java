package com.yourorg.dockerqap.controller;

import com.yourorg.dockerqap.model.Member;
import com.yourorg.dockerqap.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/members")
public class MemberController {
    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    //Create Member
    @PostMapping
    public Member createMember(@RequestBody Member member) {
        return memberService.saveMember(member);
    }

    //Get All Members
    @GetMapping
    public List<Member> getAllMembers() {
        return memberService.getAllMembers();
    }

    //Get Member by ID
    @GetMapping("/{id}")
    public Optional<Member> getMemberById(@PathVariable Long id) {
        return memberService.getMemberById(id);
    }

    //Delete Member by ID
    @DeleteMapping("/{id}")
    public void deleteMember(@PathVariable Long id) {
        memberService.deleteMember(id);
    }

    // Search by Name
    @GetMapping("/search/name")
    public List<Member> searchByName(@RequestParam String name) {
        return memberService.searchByName(name);
    }

    // Search by Phone Number
    @GetMapping("/search/phone")
    public List<Member> searchByPhone(@RequestParam String phone) {
        return memberService.searchByPhone(phone);
    }

    // Search by Start Date of Membership
    @GetMapping("/search/startdate")
    public List<Member> searchByStartDate(@RequestParam String startDate) {
        LocalDate date = LocalDate.parse(startDate);
        return memberService.searchByStartDate(date);
    }

    // Search by Duration of Membership
    @GetMapping("/search/duration")
    public List<Member> searchByDuration(@RequestParam Integer duration) {
        return memberService.searchByDuration(duration);
    }

    // Update Member by ID
    @PutMapping("/{id}")
    public Member updateMember(@PathVariable Long id, @RequestBody Member updatedMember) {
        return memberService.getMemberById(id)
                .map(existingMember -> {
                    existingMember.setMemberName(updatedMember.getMemberName());
                    existingMember.setMemberAddress(updatedMember.getMemberAddress());
                    existingMember.setMemberEmailAddress(updatedMember.getMemberEmailAddress());
                    existingMember.setMemberPhoneNumber(updatedMember.getMemberPhoneNumber());
                    existingMember.setStartDateOfMembership(updatedMember.getStartDateOfMembership());
                    existingMember.setDurationOfMembership(updatedMember.getDurationOfMembership());
                    existingMember.setTournaments(updatedMember.getTournaments());
                    return memberService.saveMember(existingMember);
                })
                .orElseGet(() -> {
                    updatedMember.setId(id);
                    return memberService.saveMember(updatedMember);
                });
    }

}
