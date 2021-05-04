package com.travelbudget.app.travelbudget.contoller;

import com.travelbudget.app.travelbudget.dto.TripDto;
import com.travelbudget.app.travelbudget.service.TripService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@Validated
@RequestMapping(value = "/api/v1/trip")
public class TripController {

    private TripService tripService;

    public TripController(TripService tripService) {
        this.tripService = tripService;
    }

    @CrossOrigin
    @GetMapping(value = "")
    public List<TripDto> getAllWithFilters() {
        return tripService.getTrips();
    }

}
