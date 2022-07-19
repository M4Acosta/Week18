package org.la.dodgers.baseball.controllers;

 
import org.la.dodgers.baseball.domain.Auditorium;
import org.la.dodgers.baseball.services.AuditoriumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;

import java.util.List;

@RestController
public class AuditoriumController {
    private AuditoriumService auditoriumService;

    @Autowired
    public AuditoriumController(AuditoriumService auditoriumService) {
        this.auditoriumService = auditoriumService;
    }

    @GetMapping("/auditoriums")
    @ApiOperation(value = "Returns list of auditoriums available in the application")
    public List<Auditorium> getAllAuditoriums() {
        return auditoriumService.getAllAuditoriums();
    }
}
