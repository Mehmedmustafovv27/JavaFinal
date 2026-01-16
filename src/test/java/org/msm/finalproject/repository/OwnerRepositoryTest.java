package org.msm.finalproject.repository;

import org.msm.finalproject.model.Owner;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class OwnerRepositoryTest {

    @Autowired
    private OwnerRepository ownerRepository;

    @Test
    void saveOwner_shouldPersist() {
        Owner owner = new Owner();
        owner.setFirstName("Ali");
        owner.setLastName("Mustafa");

        Owner saved = ownerRepository.save(owner);

        assertThat(saved.getId()).isNotNull();
    }
}
