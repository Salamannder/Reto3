package com.usa.ciclo3.reto3.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.usa.ciclo3.reto3.model.Score;
import com.usa.ciclo3.reto3.service.ScoreService;

@RestController
@RequestMapping("/api/Score")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE,
        RequestMethod.PUT })

public class ScoreController {
    @Autowired
    public ScoreService scoreService;

    @GetMapping("/all")
    public List<Score> obtenerScore() {
        return scoreService.obtenerScore();
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Score salvarScore(@RequestBody Score Score) {
        return scoreService.salvarScore(Score);

    }
}
