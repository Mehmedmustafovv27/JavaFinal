package org.msm.finalproject.repository;

import org.msm.finalproject.model.Vet;
import org.msm.finalproject.model.Visit;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class VisitRepositoryTest {

    @Autowired
    private VisitRepository visitRepository;

    @Autowired
    private VetRepository vetRepository;

    @Test
    void findVisitsForVetOnDate_shouldReturnVisits() {
        Vet vet = new Vet();
        vet.setFirstName("Ivan");
        vet.setLastName("Petrov");
        vet = vetRepository.save(vet);

        Visit visit = new Visit();
        visit.setVet(vet);
        visit.setDate(LocalDate.now());
        visit.setDescription("Checkup");
        visitRepository.save(visit);

        List<Visit> visits =
                visitRepository.findVisitsForVetOnDate(
                        vet.getId().longValue(),
                        LocalDate.now()
                );


        assertThat(visits).hasSize(1);
    }
}
