package org.msm.finalproject.model;


import org.springframework.beans.support.MutableSortDefinition;
import org.springframework.beans.support.PropertyComparator;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.*;


@Entity
@Table(name = "pets")
public class Pet extends NamedEntity {

    @Column(name = "birth_date", columnDefinition = "DATE")
    private LocalDate birthDate;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "type_id")
    private PetType type;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Owner owner;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pet", fetch = FetchType.EAGER)
    private Set<Visit> visits;

    public LocalDate getBirthDate() {
        return this.birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public PetType getType() {
        return this.type;
    }

    public void setType(PetType type) {
        this.type = type;
    }

    public Owner getOwner() {
        return this.owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    protected Set<Visit> getVisitsInternal() {
        if (this.visits == null) {
            this.visits = new HashSet<>();
        }
        return this.visits;
    }

    protected void setVisitsInternal(Set<Visit> visits) {
        this.visits = visits;
    }

    public List<Visit> getVisits() {
        List<Visit> sortedVisits = new ArrayList<>(getVisitsInternal());
        PropertyComparator.sort(sortedVisits, new MutableSortDefinition("date", false, false));
        return Collections.unmodifiableList(sortedVisits);
    }

    public void setVisits(List<Visit> visits) {
        this.visits = new HashSet<>(visits);
    }

    public void addVisit(Visit visit) {
        getVisitsInternal().add(visit);
        visit.setPet(this);
    }

}