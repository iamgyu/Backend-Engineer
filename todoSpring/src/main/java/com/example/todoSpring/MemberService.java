package com.example.todoSpring;

import org.json.simple.JSONObject;
import org.springframework.stereotype.Service;

import java.lang.reflect.Member;

@Service
public class MemberService {
    private final Member_Sqlite member_sqlite = new Member_Sqlite();

    public void insertMember(MemberDto memberDto) {
        member_sqlite.insertMember(memberDto);
    }

    public JSONObject selectMember() {
        return member_sqlite.selectMember();
    }

    public int checkMember(String id, String password) {
        return member_sqlite.checkMember(id, password);
    }

    public int checkMemberId(String id) {
        return member_sqlite.checkMemberId(id);
    }

}
