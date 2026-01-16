package org.msm.finalproject.service;

import org.msm.finalproject.model.Vet;

import java.util.List;

public interface VetService {

    Vet save(Vet vet);

    Vet findById(Long id);

    List<Vet> findAll();

    void deleteById(Long id);
}
