package org.msm.finalproject.rest;

import org.msm.finalproject.model.Visit;
import org.msm.finalproject.service.VisitService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/visits")
public class VisitController {

    private final VisitService visitService;

    public VisitController(VisitService visitService) {
        this.visitService = visitService;
    }

    @PostMapping
    public Visit create(@RequestBody Visit visit) {
        return visitService.save(visit);
    }

    @GetMapping("/vet/{vetId}")
    public List<Visit> getForVetOnDate(
            @PathVariable Long vetId,
            @RequestParam LocalDate date) {

        return visitService.getVisitsForVetOnDate(vetId, date);
    }
}
