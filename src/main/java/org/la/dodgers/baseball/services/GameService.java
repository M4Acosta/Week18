package org.la.dodgers.baseball.services;

 

import java.time.LocalDate;
import java.util.List;

import org.la.dodgers.baseball.domain.Game;
import org.la.dodgers.baseball.domain.Seat;

public interface GameService {
    List<Game> getAllGames();

    Game getGameById(Long screening_id);

    Game pushGame(Game newScreening);

    Game updateGame(Game updatedScreening, Long screening_id);

    List<Seat> getSeatsByGameId(Long screening_id);

    List<Game> getAllGames(LocalDate startDate, LocalDate endDate);
}
