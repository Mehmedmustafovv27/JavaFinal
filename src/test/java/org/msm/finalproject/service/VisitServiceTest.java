package org.msm.finalproject.service;

import org.msm.finalproject.model.Visit;
import org.msm.finalproject.repository.VisitRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

class VisitServiceTest {

    private final VisitRepository visitRepository = Mockito.mock(VisitRepository.class);
    private final VisitService visitService = new VisitServiceImpl(visitRepository);

    @Test
    void getVisitsForVetOnDate_shouldReturnList() {
        Visit visit = new Visit();
        visit.setDate(LocalDate.now());

        when(visitRepository.findVisitsForVetOnDate(1L, LocalDate.now()))
                .thenReturn(List.of(visit));

        List<Visit> result =
                visitService.getVisitsForVetOnDate(1L, LocalDate.now());

        assertThat(result).hasSize(1);
    }
}
