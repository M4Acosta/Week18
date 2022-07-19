package org.la.dodgers.baseball.services.impl;

 
import org.la.dodgers.baseball.dao.CourtRepository;
import org.la.dodgers.baseball.domain.Court;
import org.la.dodgers.baseball.services.CourtService;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
public class CourtServiceImpl implements CourtService {
    private CourtRepository theatreRepository;

    public CourtServiceImpl(CourtRepository theatreRepository) {
        this.theatreRepository = theatreRepository;
    }


    @Override
    public List<Court> getAllCourts() {
        return theatreRepository.findAll();
    }

    @Override
    public Court getCourtById(Long theatre_id) {
        return null;
    }

    @Override
    public Court pushCourt(Court newCourt) {
        return theatreRepository.save(newCourt);
    }

    @Override
    public Court updateCourt(Court updatedCourt, Long theatre_id) {
    	 return theatreRepository.save(updatedCourt);
    }

    @Override
    public void deleteCourtById(Long theatre_id) {
    	   theatreRepository.deleteById(theatre_id);

    }
}
