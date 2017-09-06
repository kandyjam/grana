package hu.papai.grana.model;

import hu.papai.grana.validation.Dictionary;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
public class StandardDiscTestDataSheet extends AbstractEntity {

    @NotNull
    @Dictionary(DictionaryKey.TESTER_NAME)
    private String testerName;

    @NotNull
    private LocalDate date;

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
    private Set<StandardDiscTestResult> testResults = new HashSet<>();

    @OneToOne(optional = false)
    private Disc disc;

    public String getTesterName() {
        return testerName;
    }

    public void setTesterName(String testerName) {
        this.testerName = testerName;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
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

    public Set<StandardDiscTestResult> getTestResults() {
        return testResults;
    }

    public void setTestResults(Set<StandardDiscTestResult> testResults) {
        this.testResults = testResults;
    }

    public Disc getDisc() {
        return disc;
    }

    public void setDisc(Disc disc) {
        this.disc = disc;
    }
}
