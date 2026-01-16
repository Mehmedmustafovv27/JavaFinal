package org.msm.finalproject.repository;

import org.springframework.stereotype.Repository;

import org.msm.finalproject.model.Visit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface VisitRepository extends JpaRepository<Visit, Long> {

    @Query("""
        SELECT v FROM Visit v
        WHERE v.vet.id = :vetId
          AND v.date = :date
    """)
    List<Visit> findVisitsForVetOnDate(
            @Param("vetId") Long vetId,
            @Param("date") LocalDate date
    );
}
