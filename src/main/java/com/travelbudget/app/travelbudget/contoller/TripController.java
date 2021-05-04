package com.travelbudget.app.travelbudget.contoller;

import com.travelbudget.app.travelbudget.dto.TripDto;
import com.travelbudget.app.travelbudget.service.TripService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@Validated
@RequestMapping(value = "/api/trips")
public class TripController {

    private TripService tripService;

    public TripController(TripService tripService) {
        this.tripService = tripService;
    }

    @CrossOrigin
    @GetMapping(value = "")
    public List<TripDto> getTrips() {
        return tripService.getTrips();
    }

    @CrossOrigin
    @GetMapping(value = "/{id}")
    public TripDto getById(HttpServletRequest request, @PathVariable Long id) {
        return tripService.getById(id);
    }

    @CrossOrigin
    @PostMapping(value = "/create")
    public void create(HttpServletRequest request, @RequestBody TripDto tripDto) {
        tripService.create(tripDto);
    }

    @CrossOrigin
    @PutMapping(value = "/update")
    public void update(HttpServletRequest request, @RequestBody TripDto tripDto) {
        tripService.update(tripDto);
    }

    @CrossOrigin
    @DeleteMapping(value = "/delete")
    public void delete(HttpServletRequest request, @RequestBody TripDto tripDto) {
        tripService.delete(tripDto);
    }

}
