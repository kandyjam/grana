package hu.papai.grana.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

@Entity
public class Manufacture extends AbstractEntity {

    @NotNull
    @Size(min = 1)
    private String purpose;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "manufacture_id")
    private Collection<Disc> discs = new ArrayList<>();

    @NotNull
    private LocalDate plannedManufactureDate;

    @NotNull
    private Integer plannedManufacturedPiece;

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public Collection<Disc> getDiscs() {
        return discs;
    }

    public void setDiscs(Collection<Disc> discs) {
        this.discs = discs;
    }

    public LocalDate getPlannedManufactureDate() {
        return plannedManufactureDate;
    }

    public void setPlannedManufactureDate(LocalDate plannedManufactureDate) {
        this.plannedManufactureDate = plannedManufactureDate;
    }

    public Integer getPlannedManufacturedPiece() {
        return plannedManufacturedPiece;
    }

    public void setPlannedManufacturedPiece(Integer plannedManufacturedPiece) {
        this.plannedManufacturedPiece = plannedManufacturedPiece;
    }

    @Override
    public String toString() {
        return "Manufacture{" +
                "purpose='" + purpose + '\'' +
                ", discs=" + discs +
                ", plannedManufactureDate=" + plannedManufactureDate +
                ", plannedManufacturedPiece=" + plannedManufacturedPiece +
                "} " + super.toString();
    }
}
