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

    public JSONObject selectOneTodo(String encodeData){
        return todoDao.selectOneTodo(encodeData);
    }

    public void insertTodo(String encodeData, TodoDto todoDto){
        todoDao.insertTodo(encodeData, todoDto);
    }

    public void updateTodo(int pk, String encodeData, TodoDto todoDto){
        todoDao.updateTodo(pk, encodeData, todoDto);
    }

    public void deleteTodo(int pk, String encodeData){
        todoDao.deleteTodo(pk, encodeData);
    }
}
