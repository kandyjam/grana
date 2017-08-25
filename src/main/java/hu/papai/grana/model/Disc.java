package hu.papai.grana.model;

import hu.papai.grana.validation.Dictionary;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Disc extends AbstractEntity {

    /**
     * This value is supposed to be generated on creation, incremented from the previous version. It may happen to
     * be difficult to determine which record was lastly inserted. Consult about it.
     */
    @NotNull
    @Range(min = 1_000, max = 99_999)
    @Column(unique = true)
    private Integer uniqueNumber;

    @NotNull
    @Dictionary(DictionaryKey.RATED_DIAMETER)
    private String ratedDiameter;

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
    private String productionNumber;

    @ManyToMany(cascade = CascadeType.ALL)
    private Collection<Fabric> fabrics = new ArrayList<>();

    private String comment;

    @NotNull
    @Dictionary(DictionaryKey.TESTER_NAME)
    private String testerName;

    @NotNull
    @Dictionary(DictionaryKey.MACHINE_TYPE)
    private String machineType;

    @NotNull
    @Dictionary(DictionaryKey.TEST_TYPE)
    private String testType;

    @NotNull
    @Dictionary(DictionaryKey.TEST_MATERIAL_QUALITY)
    private String testMaterialQuality;

    @NotNull
    @Dictionary(DictionaryKey.TEST_MATERIAL_SIZE)
    private String testMaterialSize;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<DiscTest> tests = new HashSet<>();

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

    public String getTesterName() {
        return testerName;
    }

    public void setTesterName(String testerName) {
        this.testerName = testerName;
    }

    public String getMachineType() {
        return machineType;
    }

    public void setMachineType(String machineType) {
        this.machineType = machineType;
    }

    public String getTestType() {
        return testType;
    }

    public void setTestType(String testType) {
        this.testType = testType;
    }

    public String getTestMaterialQuality() {
        return testMaterialQuality;
    }

    public void setTestMaterialQuality(String testMaterialQuality) {
        this.testMaterialQuality = testMaterialQuality;
    }

    public String getTestMaterialSize() {
        return testMaterialSize;
    }

    public void setTestMaterialSize(String testMaterialSize) {
        this.testMaterialSize = testMaterialSize;
    }

    public Set<DiscTest> getTests() {
        return tests;
    }

    public void setTests(Set<DiscTest> tests) {
        this.tests = tests;
    }
}
