package com.usa.ciclo3.reto3.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.usa.ciclo3.reto3.model.Score;
import com.usa.ciclo3.reto3.repository.CRUD.ScoreCrudRepositoryInterfaz;

@Repository
public class ScoreRepository {
    @Autowired
    public ScoreCrudRepositoryInterfaz scoreCrudRepositoryInterfaz;

    public List<Score> obtenerScore() {
        return (List<Score>) scoreCrudRepositoryInterfaz.findAll();
    }

    public Score salvarScore(Score score) {
        return scoreCrudRepositoryInterfaz.save(score);
    }

    public Optional<Score> getScore(int id) {
        return scoreCrudRepositoryInterfaz.findById(id);
    }

    public void delete(Score score) {
        scoreCrudRepositoryInterfaz.delete(score);
    }

}
