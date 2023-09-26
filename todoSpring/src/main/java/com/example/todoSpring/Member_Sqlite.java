package com.example.todoSpring;

import org.json.simple.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class Member_Sqlite {
    public static final String DB_URL = "jdbc:sqlite:todo.db";

    public void insertMember(MemberDto memberDto) {
        try {
            Connection conn = DriverManager.getConnection(DB_URL);
            Statement statement = conn.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS members (pk INTEGER PRIMARY KEY, id TEXT UNIQUE, password TEXT NOT NULL)";
            statement.executeUpdate(sql);
            statement.close();

            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO members(id, password) VALUES(?, ?)");
            pstmt.setString(1, memberDto.getId());
            pstmt.setString(2, memberDto.getPassword());
            pstmt.executeUpdate();
            pstmt.close();

        } catch (SQLException e) {
            e.printStackTrace();
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }

    public JSONObject selectMember() {
        Map<String, Object> map = new HashMap<>();
        try {
            Connection conn = DriverManager.getConnection(DB_URL);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM members");

            while (rs.next()) {
                Map<String,Object> member = new HashMap<>();
                int pk = rs.getInt("pk");
                member.put("pk", pk);
                String id = rs.getString("id");
                member.put("id", id);
                String password = rs.getString("password");
                member.put("password", password);
                map.put("member" + pk, member);
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return new JSONObject(map);
    }

    public int checkMember(String id, String password){
        try {
            Connection conn = DriverManager.getConnection(DB_URL);
            Statement stmt = conn.createStatement();
            String sql = "SELECT pk FROM members WHERE id = '" + id + "' AND password = '" + password + "';";
            ResultSet rs = stmt.executeQuery(sql);
            int result = rs.getInt(1);

            rs.close();
            stmt.close();
            conn.close();

            if (result == 0){
                throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
            }

            return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int checkMemberId(String id){
        try {
            Connection conn = DriverManager.getConnection(DB_URL);
            Statement stmt = conn.createStatement();
            String sql = "SELECT pk FROM members WHERE id = '" + id + "';";
            ResultSet rs = stmt.executeQuery(sql);
            int result = rs.getInt(1);

            rs.close();
            stmt.close();
            conn.close();

            if (result == 0){
                throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
            }

            return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
