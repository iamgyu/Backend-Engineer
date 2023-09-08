package com.example.todoSpring;

import org.json.simple.JSONObject;
import org.springframework.stereotype.Repository;

@Repository
public class TodoDao {
    private final Todo_Sqlite todo_sqlite = new Todo_Sqlite();

    public JSONObject selectTodo(){
        return todo_sqlite.selectDB();
    }

    public JSONObject selectOneTodo(int pk) {
        return todo_sqlite.selectOneDB(pk);
    }

    public void insertTodo(TodoDto todoDto){
        todo_sqlite.insertDB(todoDto);
    }

    public void updateTodo(int pk, TodoDto todoDto){
        todo_sqlite.updateDB(pk, todoDto);
    }

    public void deleteTodo(int pk){
        todo_sqlite.deleteDB(pk);
    }
}
