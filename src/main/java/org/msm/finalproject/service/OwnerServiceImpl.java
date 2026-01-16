package org.msm.finalproject.service;

import org.msm.finalproject.model.Owner;
import org.msm.finalproject.repository.OwnerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class OwnerServiceImpl implements OwnerService {

    private final OwnerRepository ownerRepository;

    public OwnerServiceImpl(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    @Override
    public Owner save(Owner owner) {
        return ownerRepository.save(owner);
    }

    @Override
    public List<Owner> findByLastName(String lastName) {
        return ownerRepository.findByLastNameContainingIgnoreCase(lastName);
    }
}
