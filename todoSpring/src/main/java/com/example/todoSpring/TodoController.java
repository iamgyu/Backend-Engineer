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

    @PostMapping("/webclient")
    public void insert1000(@RequestBody TodoDto todoDto) {
        WebClient webClient = WebClient.create();

        for(int i = 0; i < 1000; i++) {
            webClient.post()
                    .uri("http://localhost:8080/todo")
                    .body(BodyInserters.fromValue(todoDto))
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();
        }
    }

    @PostMapping("")
    public void insert(@RequestBody TodoDto todoDto) {
        todoService.insertTodo(todoDto);
    }

    @GetMapping("")
    public JSONObject select() {
        return todoService.selectTodo();
    }

    @GetMapping("/{pk}")
    public JSONObject selectOne(@PathVariable int pk) {
        return todoService.selectOneTodo(pk);
    }

    @PatchMapping("/{pk}")
    public void update(@PathVariable int pk, @RequestBody TodoDto todoDto) {
        todoService.updateTodo(pk, todoDto);
    }

    @DeleteMapping("/{pk}")
    public void delete(@PathVariable int pk) {
        todoService.deleteTodo(pk);
    }
}
