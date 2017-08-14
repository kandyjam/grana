package hu.papai.grana.model;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

@Entity
public class Disc extends AbstractEntity {

    /**
     * This value is supposed to be generated on creation, incremented from the previous version. It may happen to
     * be difficult to determine which record was lastly inserted. Consult about it.
     */
    @NotNull
    @Min(1_000)
    @Max(10_000)
    @Column(unique = true)
    private Integer uniqueNumber;

    @NotNull
    private Integer ratedDiameter;

    @NotNull
    private LocalDate measurementDate;

    /**
     * Four numbers followed by a dash followed by six numbers.
     */
    @Pattern(regexp = "^[0-9]{4}-[0-9]{6}$")
    private String productionNumber;

    @ManyToMany(cascade = CascadeType.ALL)
    private Collection<Fabric> fabrics = new ArrayList<>();

    private String comment;

    public Integer getUniqueNumber() {
        return uniqueNumber;
    }

    public void setUniqueNumber(Integer uniqueNumber) {
        this.uniqueNumber = uniqueNumber;
    }

    public Integer getRatedDiameter() {
        return ratedDiameter;
    }

    public void setRatedDiameter(Integer ratedDiameter) {
        this.ratedDiameter = ratedDiameter;
    }

    public LocalDate getMeasurementDate() {
        return measurementDate;
    }

    public void setMeasurementDate(LocalDate measurementDate) {
        this.measurementDate = measurementDate;
    }

    public String getProductionNumber() {
        return productionNumber;
    }

    public void setProductionNumber(String productionNumber) {
        this.productionNumber = productionNumber;
    }

    public Collection<Fabric> getFabrics() {
        return fabrics;
    }

    public void setFabrics(Collection<Fabric> fabrics) {
        this.fabrics = fabrics;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "Disc{" +
        "uniqueNumber=" + uniqueNumber +
        ", ratedDiameter=" + ratedDiameter +
        ", measurementDate=" + measurementDate +
        ", productionNumber='" + productionNumber + '\'' +
        ", fabrics=" + fabrics +
        ", comment='" + comment + '\'' +
        "} " + super.toString();
    }
}
