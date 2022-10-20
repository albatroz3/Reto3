package co.usa.ciclo3.ciclo3.Service;

import co.usa.ciclo3.ciclo3.Repository.CategoryRepository;
import co.usa.ciclo3.ciclo3.Repository.ScoreRepository;
import co.usa.ciclo3.ciclo3.model.Category;
import co.usa.ciclo3.ciclo3.model.Client;
import co.usa.ciclo3.ciclo3.model.Score;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ScoreService {

    @Autowired
    private ScoreRepository scoreRepository;

    public List<Score> getAll() { return scoreRepository.getAll(); }

    public Optional<Score> getScore(int id) { return scoreRepository.getScore(id); }

    public Score save(Score score) {
        Optional<Score> aux = scoreRepository.getScore(score.getId());
        if (aux.isPresent()) {
            return score;
        }else{
            return scoreRepository.save(score);
        }
    }
    @NotNull
    public Score update(Score score) {
        Optional<Score> c = scoreRepository.getScore(score.getId());
        if (c.isPresent()){
            if(score.getMessageText() != null) {
                c.get().setMessageText(score.getMessageText());
            }
            if (score.getStarts() != null) {
                c.get().setStarts(score.getStarts());
            }
            if (score.getReservation() != null) {
                c.get().setReservation(score.getReservation());
            }
            scoreRepository.save(c.get());
            return c.get();
        } else {
             return score;
        }
    }
    public boolean delete( int id) {
         boolean flag = false;
         Optional<Score> b = scoreRepository.getScore(id);
         if(b.isPresent()){
             scoreRepository.delete(b.get());
         }
        return flag;
    }
}
