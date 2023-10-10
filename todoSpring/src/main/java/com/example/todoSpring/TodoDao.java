package com.example.todoSpring;

import org.json.simple.JSONObject;
import org.springframework.stereotype.Repository;

@Repository
public class TodoDao {
    private final Todo_Sqlite todo_sqlite = new Todo_Sqlite();

    public JSONObject selectTodo(){
        return todo_sqlite.selectDB();
    }

    public JSONObject selectOneTodo(String id) {
        return todo_sqlite.selectOneDB(id);
    }

    public void insertTodo(String id, TodoDto todoDto){
        todo_sqlite.insertDB(id, todoDto);
    }

    public void updateTodo(int pk, String id, TodoDto todoDto){
        todo_sqlite.updateDB(pk, id, todoDto);
    }

    public void deleteTodo(int pk, String id){
        todo_sqlite.deleteDB(pk, id);
    }
}
