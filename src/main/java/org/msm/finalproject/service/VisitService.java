package org.msm.finalproject.service;

import org.msm.finalproject.model.Visit;

import java.time.LocalDate;
import java.util.List;

public interface VisitService {

    Visit save(Visit visit);

    List<Visit> getVisitsForVetOnDate(Long vetId, LocalDate date);
}
