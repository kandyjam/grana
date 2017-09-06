package hu.papai.grana.model;

import hu.papai.grana.validation.Dictionary;
import org.hibernate.validator.constraints.Range;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
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
     *
     * Ideas:
     * * table containing the last inserted id (it's always the greatest)
     * * using some auto_generated value like the {@link AbstractEntity} id field
     */
    @NotNull
    @Range(min = 1_000, max = 99_999)
    @Column(unique = true)
    private Integer uniqueNumber;

    @NotNull
    @Dictionary(DictionaryKey.RATED_DIAMETER)
    private String ratedDiameter;

    // TODO: cross-field validation with machineSide
    @NotNull
    @Dictionary(DictionaryKey.PRESS_MACHINE)
    private String pressMachine;

    @NotNull
    @Dictionary(DictionaryKey.MACHINE_SIDE)
    private String machineSide;

    @NotNull
    @Dictionary(DictionaryKey.NEST_NUMBER)
    private String nestNumber;

    @NotNull
    private LocalDate measurementDate;

    /**
     * Four numbers followed by a dash followed by six numbers.
     */
    @NotNull
    @Pattern(
        regexp = "^[0-9]{4}-[0-9]{6}$",
        message = "Format must follow 4 digits followed by a dash followed by 6 digits."
    )
    private String dollopProductionNumber;

    @ManyToMany(cascade = CascadeType.ALL)
    private Collection<Fabric> fabrics = new ArrayList<>();

    public Integer getUniqueNumber() {
        return uniqueNumber;
    }

    public void setUniqueNumber(Integer uniqueNumber) {
        this.uniqueNumber = uniqueNumber;
    }

    public String getRatedDiameter() {
        return ratedDiameter;
    }

    public void setRatedDiameter(String ratedDiameter) {
        this.ratedDiameter = ratedDiameter;
    }

    public String getPressMachine() {
        return pressMachine;
    }

    public void setPressMachine(String pressMachine) {
        this.pressMachine = pressMachine;
    }

    public String getMachineSide() {
        return machineSide;
    }

    public void setMachineSide(String machineSide) {
        this.machineSide = machineSide;
    }

    public String getNestNumber() {
        return nestNumber;
    }

    public void setNestNumber(String nestNumber) {
        this.nestNumber = nestNumber;
    }

    public LocalDate getMeasurementDate() {
        return measurementDate;
    }

    public void setMeasurementDate(LocalDate measurementDate) {
        this.measurementDate = measurementDate;
    }

    public String getDollopProductionNumber() {
        return dollopProductionNumber;
    }

    public void setDollopProductionNumber(String dollopProductionNumber) {
        this.dollopProductionNumber = dollopProductionNumber;
    }

    public Collection<Fabric> getFabrics() {
        return fabrics;
    }

    public void setFabrics(Collection<Fabric> fabrics) {
        this.fabrics = fabrics;
    }
}
