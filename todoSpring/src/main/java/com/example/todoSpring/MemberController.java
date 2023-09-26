package com.example.todoSpring;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/member")
public class MemberController {
    @Autowired
    MemberService memberService;

    Map<String, String> mapping = MemberDto.mapping;

    @PostMapping("/login")
    public void login(@RequestBody MemberDto memberDto) {
        int checkMember = memberService.checkMember(memberDto.getId(), memberDto.getPassword());
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        mapping.put(memberDto.getId(), uuid);
    }

    @GetMapping("/login")
    public Map<String, String> printMap() {
        return mapping;
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