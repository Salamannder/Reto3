package com.usa.ciclo3.reto3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usa.ciclo3.reto3.model.Score;
import com.usa.ciclo3.reto3.repository.ScoreRepository;

@Service
public class ScoreService {
    @Autowired
    private ScoreRepository scoreRepository;

    public List<Score> obtenerScore() {
        return scoreRepository.obtenerScore();
    }

    public Score salvarScore(Score score) {
        if (score.getId() == null) {
            return scoreRepository.salvarScore(score);
        } else {
            return score;
        }
    }

}
