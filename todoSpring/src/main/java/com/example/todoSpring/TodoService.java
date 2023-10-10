package com.example.todoSpring;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoService {
    @Autowired
    TodoDao todoDao;

    public JSONObject selectTodo(){
        return todoDao.selectTodo();
    }

    public JSONObject selectOneTodo(String id){
        return todoDao.selectOneTodo(id);
    }

    public void insertTodo(String id, TodoDto todoDto){
        todoDao.insertTodo(id, todoDto);
    }

    public void updateTodo(int pk, String id, TodoDto todoDto){
        todoDao.updateTodo(pk, id, todoDto);
    }

    public void deleteTodo(int pk, String id){
        todoDao.deleteTodo(pk, id);
    }
}
