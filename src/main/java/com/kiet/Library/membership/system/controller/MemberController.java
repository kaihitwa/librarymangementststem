package com.kiet.Library.membership.system.controller;

import com.kiet.Library.membership.system.model.Member;
import com.kiet.Library.membership.system.service.MemberService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/members")
    public String listMembers(Model model) {
        model.addAttribute("members", memberService.findAll());
        return "members";
    }


    @GetMapping("/member/{id}")
    public String getMemberById(@PathVariable Long id, Model model) {
        Optional<Member> memberOpt = memberService.findById(id);
        if (memberOpt.isPresent()) {
            model.addAttribute("member", memberOpt.get());
            return "member-detail";
        } else {
            return "redirect:/members";
        }
    }

    @GetMapping("/members/active")
    public String listActiveMembers(Model model) {
        model.addAttribute("members", memberService.findActiveMembers());
        return "members-active";
    }

    @GetMapping("/member/new")
    public String showCreateForm(Model model) {
        model.addAttribute("member", new Member());
        return "member-form";
    }

    @PostMapping("/member")
    public String createMember(@Valid @ModelAttribute("member") Member member,
                               BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "member-form";
        }
        memberService.save(member);
        return "redirect:/members";
    }

    @GetMapping("/member/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Optional<Member> memberOpt = memberService.findById(id);
        if (memberOpt.isPresent()) {
            model.addAttribute("member", memberOpt.get());
            return "member-form";
        } else {
            return "redirect:/members";
        }
    }

    @PostMapping("/member/{id}")
    public String updateMember(@PathVariable Long id,
                               @Valid @ModelAttribute("member") Member member,
                               BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "member-form";
        }
        member.setId(id);
        memberService.save(member);
        return "redirect:/members";
    }

    @GetMapping("/member/delete/{id}")
    public String deleteMember(@PathVariable Long id) {
        memberService.deleteById(id);
        return "redirect:/members";
    }
}
