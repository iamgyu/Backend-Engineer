package com.example.todoSpring;

import org.json.simple.JSONObject;
import org.springframework.stereotype.Repository;

@Repository
public class TodoDao {
    private final Todo_Sqlite todo_sqlite = new Todo_Sqlite();

    public JSONObject selectTodo(){
        return todo_sqlite.selectDB();
    }

    public JSONObject selectOneTodo(TodoDto todoDto) {
        return todo_sqlite.selectOneDB(todoDto);
    }

    public void insertTodo(TodoDto todoDto){
        todo_sqlite.insertDB(todoDto);
    }

    public void updateTodo(int pk, TodoDto todoDto){
        todo_sqlite.updateDB(pk, todoDto);
    }

    public void deleteTodo(int pk, TodoDto todoDto){
        todo_sqlite.deleteDB(pk, todoDto);
    }
}
