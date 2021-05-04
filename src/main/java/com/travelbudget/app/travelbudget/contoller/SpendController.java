package com.travelbudget.app.travelbudget.contoller;

import com.travelbudget.app.travelbudget.dto.SpendDto;
import com.travelbudget.app.travelbudget.service.SpendService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@Validated
@RequestMapping(value = "/api/spends")
public class SpendController {

    private SpendService spendService;

    public SpendController(SpendService spendService) {
        this.spendService = spendService;
    }

    @CrossOrigin
    @GetMapping(value = "")
    public List<SpendDto> getSpends() {
        return spendService.getSpends();
    }

    @CrossOrigin
    @GetMapping(value = "/{id}")
    public SpendDto getById(HttpServletRequest request, @PathVariable Long id) {
        return spendService.getById(id);
    }

    @CrossOrigin
    @PostMapping(value = "/create")
    public void create(HttpServletRequest request, @RequestBody SpendDto spendDto) {
        spendService.create(spendDto);
    }

    @CrossOrigin
    @PutMapping(value = "/update")
    public void update(HttpServletRequest request, @RequestBody SpendDto spendDto) {
        spendService.update(spendDto);
    }

    @CrossOrigin
    @DeleteMapping(value = "/delete")
    public void delete(HttpServletRequest request, @RequestBody SpendDto spendDto) {
        spendService.delete(spendDto);
    }
}
