package org.la.dodgers.baseball.services.impl;

 
import org.la.dodgers.baseball.dao.BaseBallEventRepository;
import org.la.dodgers.baseball.domain.BaseBallEvent;
import org.la.dodgers.baseball.domain.Game;
import org.la.dodgers.baseball.exception.BaseBallEventNotFoundException;
import org.la.dodgers.baseball.services.BaseBallEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Primary
public class BaseBallEventServiceImpl implements BaseBallEventService {
    private BaseBallEventRepository eventRepository;

    @Autowired
    public BaseBallEventServiceImpl(BaseBallEventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
    public List<BaseBallEvent> getAllBaseBallEvents() {
        return eventRepository.findAll();
    }

    @Override
    public BaseBallEvent getBaseBallEventById(Long event_id) {
        return eventRepository.findById(event_id).orElseThrow(() -> new BaseBallEventNotFoundException(event_id));
    }

    @Override
    public BaseBallEvent pushBaseBallEvent(BaseBallEvent newMovie) {
        return null;
    }

    @Override
    public BaseBallEvent updateBaseBallEvent(BaseBallEvent updatedMovie, Long event_id) {
        return null;
    }

    @Override
    public List<Game> getAllGamesByEventId(Long event_id) {
        BaseBallEvent event = getBaseBallEventById(event_id);
        return new ArrayList<>(event.getGames());
    }

    @Override
    public void deleteBaseBallEvent(Long event_id) {
        eventRepository.deleteById(event_id);
    }

    @Override
    public List<Game> getAllGamesByEventIdAndDate(Long event_id, LocalDate date) {
        BaseBallEvent event = getBaseBallEventById(event_id);
        return event.getGames().stream().filter(screening -> screening.getDate().equals(date)).collect(Collectors.toList());
    }
}
