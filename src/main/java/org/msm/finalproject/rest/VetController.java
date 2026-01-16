package org.msm.finalproject.rest;

import org.msm.finalproject.model.Vet;
import org.msm.finalproject.service.VetService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vets")
public class VetController {

    private final VetService vetService;

    public VetController(VetService vetService) {
        this.vetService = vetService;
    }

    @PostMapping
    public Vet create(@RequestBody Vet vet) {
        return vetService.save(vet);
    }

    @GetMapping
    public List<Vet> getAll() {
        return vetService.findAll();
    }

    @GetMapping("/{id}")
    public Vet getById(@PathVariable Long id) {
        return vetService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        vetService.deleteById(id);
    }
}
