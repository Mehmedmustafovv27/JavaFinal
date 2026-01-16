package org.msm.finalproject.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import java.time.LocalDate;

@Entity
@Table(name = "visits")
public class Visit extends BaseEntity {

    @Column(name = "visit_date", columnDefinition = "DATE")
    private LocalDate date;

    @NotEmpty
    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "pet_id")
    private Pet pet;

    @ManyToOne
    @JoinColumn(name = "vet_id")
    private Vet vet;

    public Visit() {
        this.date = LocalDate.now();
    }

    public LocalDate getDate() {
        return this.date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Pet getPet() {
        return this.pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    // 🔥 ADDED for business logic
    public Vet getVet() {
        return vet;
    }

    public void setVet(Vet vet) {
        this.vet = vet;
    }
}