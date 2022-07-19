package org.la.dodgers.baseball.services.impl;

 
import org.la.dodgers.baseball.dao.GameRepository;
import org.la.dodgers.baseball.domain.Game;
import org.la.dodgers.baseball.domain.Seat;
import org.la.dodgers.baseball.exception.GameNotFoundException;
import org.la.dodgers.baseball.exception.ScreeningNotFoundException;
import org.la.dodgers.baseball.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Primary
public class GameServiceImpl implements GameService {
    private GameRepository gameRepository;

    @Autowired
    public GameServiceImpl(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    @Override
    public List<Game> getAllGames() {
        return gameRepository.findAll();
    }

    @Override
    public List<Game> getAllGames(LocalDate startDate, LocalDate endDate) {
        return gameRepository.findAll().stream().filter(screening -> screening.getDate().isAfter(startDate) && screening.getDate().isBefore(endDate)).collect(Collectors.toList());
    }

    @Override
    public Game getGameById(Long screening_id) {
        return gameRepository.findById(screening_id).orElseThrow(ScreeningNotFoundException :: new);
    }

    @Override
    public Game pushGame(Game newGame) {
        return gameRepository.save(newGame);
    }

    @Override
    public Game updateGame(Game updatedGame, Long screening_id) {
    	  return gameRepository.save(updatedGame);
    }

    @Override
    public List<Seat> getSeatsByGameId(Long screening_id) {
        Game screening = getGameById(screening_id);
        if (screening.getIsFull()) {
            return new ArrayList<>();
        }
        return new ArrayList<>(screening.getAuditorium().getSeats());
    }
}
