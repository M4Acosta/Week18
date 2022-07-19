package org.la.dodgers.baseball.services;

 

import java.time.LocalDate;
import java.util.List;

import org.la.dodgers.baseball.domain.BaseBallEvent;
import org.la.dodgers.baseball.domain.Game;

public interface BaseBallEventService {
    List<BaseBallEvent> getAllBaseBallEvents();

    BaseBallEvent getBaseBallEventById(Long event_id);

    BaseBallEvent pushBaseBallEvent(BaseBallEvent event);

    BaseBallEvent updateBaseBallEvent(BaseBallEvent updatedEvent, Long event_id);

    void deleteBaseBallEvent(Long event_id);

    List<Game> getAllGamesByEventId(Long event_id);

    List<Game> getAllGamesByEventIdAndDate(Long event_id, LocalDate localDate);
}