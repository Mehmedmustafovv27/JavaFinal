package org.msm.finalproject.rest;

import org.msm.finalproject.model.Owner;
import org.msm.finalproject.service.OwnerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/owners")
public class OwnerController {

    private final OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @PostMapping
    public Owner create(@RequestBody Owner owner) {
        return ownerService.save(owner);
    }

    @GetMapping("/search")
    public List<Owner> search(@RequestParam String lastName) {
        return ownerService.findByLastName(lastName);
    }
}
