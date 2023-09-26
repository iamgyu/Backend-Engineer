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

    public JSONObject selectOneTodo(String uuid){
        return todoDao.selectOneTodo(uuid);
    }

    public void insertTodo(String uuid, TodoDto todoDto){
        todoDao.insertTodo(uuid, todoDto);
    }

    public void updateTodo(int pk, String uuid, TodoDto todoDto){
        todoDao.updateTodo(pk, uuid, todoDto);
    }

    public void deleteTodo(int pk, String uuid){
        todoDao.deleteTodo(pk, uuid);
    }
}
