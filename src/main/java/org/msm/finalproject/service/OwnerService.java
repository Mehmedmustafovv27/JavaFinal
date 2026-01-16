package org.msm.finalproject.service;

import org.msm.finalproject.model.Owner;

import java.util.List;

public interface OwnerService {

    Owner save(Owner owner);

    List<Owner> findByLastName(String lastName);
}
