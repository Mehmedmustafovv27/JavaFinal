package org.msm.finalproject.mapper;

import org.msm.finalproject.dto.OwnerDto;
import org.msm.finalproject.model.Owner;

public class OwnerMapper {

    public static OwnerDto toDto(Owner owner) {
        return new OwnerDto(
                owner.getId(),
                owner.getFirstName(),
                owner.getLastName()
        );
    }
}
