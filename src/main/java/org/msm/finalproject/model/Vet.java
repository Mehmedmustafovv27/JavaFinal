package org.msm.finalproject.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.beans.support.MutableSortDefinition;
import org.springframework.beans.support.PropertyComparator;

import jakarta.persistence.*;
import jakarta.xml.bind.annotation.XmlElement;
import java.util.*;

/**
 * Veterinarian entity with optimistic locking and daily visit limit.
 */
@Entity
@Table(name = "vets")
public class Vet extends Person {

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "vet_specialties",
            joinColumns = @JoinColumn(name = "vet_id"),
            inverseJoinColumns = @JoinColumn(name = "specialty_id")
    )
    private Set<Specialty> specialties;

    /**
     * Optimistic locking field.
     * Used to prevent two users booking the same last available slot.
     */
    @Version
    private Integer version;

    /**
     * How many visits this vet can have per day.
     */
    @Column(name = "daily_limit")
    private int dailyLimit = 10;

    // ===== Existing PetClinic logic =====

    @JsonIgnore
    protected Set<Specialty> getSpecialtiesInternal() {
        if (this.specialties == null) {
            this.specialties = new HashSet<>();
        }
        return this.specialties;
    }

    protected void setSpecialtiesInternal(Set<Specialty> specialties) {
        this.specialties = specialties;
    }

    @XmlElement
    public List<Specialty> getSpecialties() {
        List<Specialty> sortedSpecs = new ArrayList<>(getSpecialtiesInternal());
        PropertyComparator.sort(sortedSpecs, new MutableSortDefinition("name", true, true));
        return Collections.unmodifiableList(sortedSpecs);
    }

    public void setSpecialties(List<Specialty> specialties) {
        this.specialties = new HashSet<>(specialties);
    }

    @JsonIgnore
    public int getNrOfSpecialties() {
        return getSpecialtiesInternal().size();
    }

    public void addSpecialty(Specialty specialty) {
        getSpecialtiesInternal().add(specialty);
    }

    public void clearSpecialties() {
        getSpecialtiesInternal().clear();
    }

    // ===== New business logic getters/setters =====

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public int getDailyLimit() {
        return dailyLimit;
    }

    public void setDailyLimit(int dailyLimit) {
        this.dailyLimit = dailyLimit;
    }
}