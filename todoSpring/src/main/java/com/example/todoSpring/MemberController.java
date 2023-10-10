package com.example.todoSpring;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/member")
public class MemberController {
    @Autowired
    MemberService memberService;
    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @PostMapping("/login")
    public String login(@RequestBody MemberDto memberDto) {
        memberService.checkMember(memberDto.getId(), memberDto.getPassword());
        return jwtTokenProvider.generateToken(memberDto.getId());
    }

    @PostMapping("")
    public void insertMember(@RequestBody MemberDto memberDto) {
        memberService.insertMember(memberDto);
    }

    @GetMapping("")
    public JSONObject selectMember() {
        return memberService.selectMember();
    }
}