package org.la.dodgers.baseball.services;

 

import java.util.List;

import org.la.dodgers.baseball.domain.Court;

public interface CourtService {
    List<Court> getAllCourts();

    Court getCourtById(Long court_id);

    Court pushCourt(Court newCourt);

    Court updateCourt(Court updatedCourt, Long court_id);

    void deleteCourtById(Long court_id);
}
