package org.msm.finalproject.rest;

import org.msm.finalproject.dto.VisitDto;
import org.msm.finalproject.mapper.VisitMapper;
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

    // ✅ CREATE – приема entity (OK), връща DTO
    @PostMapping
    public VisitDto create(@RequestBody Visit visit) {
        Visit saved = visitService.save(visit);
        return VisitMapper.toDto(saved);
    }

    // ✅ READ – връща DTO вместо entity
    @GetMapping("/vet/{vetId}")
    public List<VisitDto> getForVetOnDate(
            @PathVariable Long vetId,
            @RequestParam LocalDate date) {

        return visitService.getVisitsForVetOnDate(vetId, date)
                .stream()
                .map(VisitMapper::toDto)
                .toList();
    }
}
