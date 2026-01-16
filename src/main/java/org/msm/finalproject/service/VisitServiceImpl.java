package org.msm.finalproject.service;

import org.msm.finalproject.model.Visit;
import org.msm.finalproject.repository.VisitRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
public class VisitServiceImpl implements VisitService {

    private final VisitRepository visitRepository;

    public VisitServiceImpl(VisitRepository visitRepository) {
        this.visitRepository = visitRepository;
    }

    @Override
    public Visit save(Visit visit) {
        return visitRepository.save(visit);
    }

    @Override
    public List<Visit> getVisitsForVetOnDate(Long vetId, LocalDate date) {
        return visitRepository.findVisitsForVetOnDate(vetId, date);
    }
}
