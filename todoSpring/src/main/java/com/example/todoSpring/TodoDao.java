package com.example.todoSpring;

import org.json.simple.JSONObject;
import org.springframework.stereotype.Repository;

@Repository
public class TodoDao {
    private final Todo_Sqlite todo_sqlite = new Todo_Sqlite();

    public JSONObject selectTodo(){
        return todo_sqlite.selectDB();
    }

    public JSONObject selectOneTodo(String uuid) {
        return todo_sqlite.selectOneDB(uuid);
    }

    public void insertTodo(String uuid, TodoDto todoDto){
        todo_sqlite.insertDB(uuid, todoDto);
    }

    public void updateTodo(int pk, String uuid, TodoDto todoDto){
        todo_sqlite.updateDB(pk, uuid, todoDto);
    }

    public void deleteTodo(int pk, String uuid){
        todo_sqlite.deleteDB(pk, uuid);
    }
}
