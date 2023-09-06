package com.example.todoSpring;

import jakarta.validation.constraints.Pattern;
import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class TestController {
    @GetMapping("/plus")
    public JSONObject plus(@RequestParam int n1, @RequestParam int n2) {
        Map<String, Object> map = new HashMap<>();

        int sum = n1 + n2;
        map.put("sum", sum);

        // Map -> JSON 후 return
        return new JSONObject(map);
    }

    @GetMapping("/multi")
    public JSONObject multi(@RequestParam @Pattern(regexp = "^[0-9]*$") int n1,
                            @RequestParam @Pattern(regexp = "^[0-9]*$") int n2) {
        Map<String, Object> map = new HashMap<>();

        int sum = n1 * n2;
        map.put("multi", sum);

        // Map -> JSON 후 return
        return new JSONObject(map);
    }
}