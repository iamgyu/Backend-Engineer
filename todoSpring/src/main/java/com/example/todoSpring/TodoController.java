package com.example.todoSpring;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/todo")
public class TodoController {
    @Autowired
    private TodoService todoService;

    @PostMapping("")
    public void insert(@RequestBody TodoDto todoDto) {
        todoService.insertTodo(todoDto);
    }

    @GetMapping("/all")
    public JSONObject selectAll() {
        return todoService.selectTodo();
    }

    @GetMapping("")
    public JSONObject selectOne(@RequestBody TodoDto todoDto) {
        return todoService.selectOneTodo(todoDto);
    }

    @PatchMapping("/{pk}")
    public void update(@PathVariable int pk, @RequestBody TodoDto todoDto) {
        todoService.updateTodo(pk, todoDto);
    }

    @DeleteMapping("/{pk}")
    public void delete(@PathVariable int pk, @RequestBody TodoDto todoDto) {
        todoService.deleteTodo(pk, todoDto);
    }
}
