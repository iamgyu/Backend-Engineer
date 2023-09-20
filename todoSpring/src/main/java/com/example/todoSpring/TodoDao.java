package com.example.todoSpring;

import org.json.simple.JSONObject;
import org.springframework.stereotype.Repository;

@Repository
public class TodoDao {
    private final Todo_Sqlite todo_sqlite = new Todo_Sqlite();

    public JSONObject selectTodo(){
        return todo_sqlite.selectDB();
    }

    public JSONObject selectOneTodo(String encodeData) {
        return todo_sqlite.selectOneDB(encodeData);
    }

    public void insertTodo(String encodeData, TodoDto todoDto){
        todo_sqlite.insertDB(encodeData, todoDto);
    }

    public void updateTodo(int pk, String encodeData, TodoDto todoDto){
        todo_sqlite.updateDB(pk, encodeData, todoDto);
    }

    public void deleteTodo(int pk, String encodeData){
        todo_sqlite.deleteDB(pk, encodeData);
    }
}
