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

    public JSONObject selectOneTodo(TodoDto todoDto){
        return todoDao.selectOneTodo(todoDto);
    }

    public void insertTodo(TodoDto todoDto){
        todoDao.insertTodo(todoDto);
    }

    public void updateTodo(int pk, TodoDto todoDto){
        todoDao.updateTodo(pk, todoDto);
    }

    public void deleteTodo(int pk, TodoDto todoDto){
        todoDao.deleteTodo(pk, todoDto);
    }
}
