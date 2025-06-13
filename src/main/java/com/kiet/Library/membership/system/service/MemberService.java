package com.kiet.Library.membership.system.service;

import com.kiet.Library.membership.system.model.Member;
import com.kiet.Library.membership.system.repository.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public List<Member> findAll() {
        return memberRepository.findAll();
    }

    public Optional<Member> findById(Long id) {
        return memberRepository.findById(id);
    }

    public List<Member> findActiveMembers() {
        return memberRepository.findByActiveTrue();
    }

    public Member save(Member member) {
        return memberRepository.save(member);
    }

    public void deleteById(Long id) {
        memberRepository.deleteById(id);
    }
}
