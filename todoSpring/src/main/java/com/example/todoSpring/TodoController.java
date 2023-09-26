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
    public void insert(@RequestHeader("Authorization") String uuid, @RequestBody TodoDto todoDto) {
        todoService.insertTodo(uuid, todoDto);
    }

    @GetMapping("/all")
    public JSONObject selectAll() {
        return todoService.selectTodo();
    }

    @GetMapping("")
    public JSONObject selectOne(@RequestHeader("Authorization") String uuid) {
        return todoService.selectOneTodo(uuid);
    }

    @PatchMapping("/{pk}")
    public void update(@PathVariable int pk, @RequestHeader("Authorization") String uuid, @RequestBody TodoDto todoDto) {
        todoService.updateTodo(pk, uuid, todoDto);
    }

    @DeleteMapping("/{pk}")
    public void delete(@PathVariable int pk, @RequestHeader("Authorization") String uuid) {
        todoService.deleteTodo(pk, uuid);
    }
}
