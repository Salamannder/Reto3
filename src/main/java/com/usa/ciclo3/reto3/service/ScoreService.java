package com.usa.ciclo3.reto3.service;

import java.util.List;
import java.util.Optional;

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

    public Score actualizaScore(Score score) {
        if (score.getId() != null) {
            Optional<Score> e = scoreRepository.getScore(score.getId());
            if (!e.isEmpty()) {
                if (score.getRating() != null) {
                    e.get().setRating(score.getRating());
                }
                if (score.getMessageText() != null) {
                    e.get().setMessageText(score.getMessageText());
                }
                scoreRepository.salvarScore(e.get());
                return e.get();

            } else {
                return score;
            }
        } else {
            return score;
        }
    }

    public boolean borrarScore(int scoreId) {
        boolean flag = false;
        Optional<Score> c = scoreRepository.getScore(scoreId);
        if (c.isPresent()) {
            scoreRepository.delete(c.get());
            flag = true;
        }
        return flag;

    }

}
