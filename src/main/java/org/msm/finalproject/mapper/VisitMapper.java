package org.msm.finalproject.mapper;

import org.msm.finalproject.dto.VisitDto;
import org.msm.finalproject.model.Visit;

public class VisitMapper {

    public static VisitDto toDto(Visit visit) {
        VisitDto dto = new VisitDto();
        dto.setId(visit.getId());
        dto.setDate(visit.getDate());
        dto.setDescription(visit.getDescription());

        if (visit.getVet() != null) {
            dto.setVetId(visit.getVet().getId());
        }
        if (visit.getPet() != null) {
            dto.setPetId(visit.getPet().getId());
        }

        return dto;
    }
}
