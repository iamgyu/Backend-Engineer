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
    @Autowired
    private JwtTokenProvider jwtTokenProvider;
    @PostMapping("")
    public void insert(@RequestHeader("Authorization") String token, @RequestBody TodoDto todoDto) {
        String id = jwtTokenProvider.getUserIdFromJWT(token);
        todoService.insertTodo(id, todoDto);
    }

    @GetMapping("/all")
    public JSONObject selectAll() {
        return todoService.selectTodo();
    }

    @GetMapping("")
    public JSONObject selectOne(@RequestHeader("Authorization") String token) {
        String id = jwtTokenProvider.getUserIdFromJWT(token);
        return todoService.selectOneTodo(id);
    }

    @PatchMapping("/{pk}")
    public void update(@PathVariable int pk, @RequestHeader("Authorization") String token, @RequestBody TodoDto todoDto) {
        String id = jwtTokenProvider.getUserIdFromJWT(token);
        todoService.updateTodo(pk, id, todoDto);
    }

    @DeleteMapping("/{pk}")
    public void delete(@PathVariable int pk, @RequestHeader("Authorization") String token) {
        String id = jwtTokenProvider.getUserIdFromJWT(token);
        todoService.deleteTodo(pk, id);
    }
}
