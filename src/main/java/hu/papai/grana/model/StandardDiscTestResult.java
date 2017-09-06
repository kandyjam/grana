package hu.papai.grana.model;

import hu.papai.grana.model.util.DiscTestAttributes;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Collection;

@hu.papai.grana.validation.DiscTest
@Entity
public class StandardDiscTestResult extends AbstractEntity {

    @NotNull
    private Integer number;

    @NotNull
    private Double minThickness;

    @NotNull
    private Double maxThickness;

    @Valid
    @Embedded
    @AttributeOverrides({
        @AttributeOverride(name = "diameter", column = @Column(name = "diameter_before")),
        @AttributeOverride(name = "mass", column = @Column(name = "thickness_before"))
    })
    private DiscTestAttributes attributesBeforeTest = new DiscTestAttributes();

    @Valid
    @Embedded
    @AttributeOverrides({
        @AttributeOverride(name = "diameter", column = @Column(name = "diameter_after")),
        @AttributeOverride(name = "mass", column = @Column(name = "thickness_after"))
    })
    private DiscTestAttributes attributesAfterTest = new DiscTestAttributes();

    @ElementCollection
    private Collection<Double> cuttingTimes = new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StandardDiscTestResult standardDiscTestResult = (StandardDiscTestResult) o;

        return number.equals(standardDiscTestResult.number);
    }

    @Override
    public int hashCode() {
        return number.hashCode();
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Double getMinThickness() {
        return minThickness;
    }

    public void setMinThickness(Double minThickness) {
        this.minThickness = minThickness;
    }

    public Double getMaxThickness() {
        return maxThickness;
    }

    public void setMaxThickness(Double maxThickness) {
        this.maxThickness = maxThickness;
    }

    public DiscTestAttributes getAttributesBeforeTest() {
        return attributesBeforeTest;
    }

    public void setAttributesBeforeTest(DiscTestAttributes attributesBeforeTest) {
        this.attributesBeforeTest = attributesBeforeTest;
    }

    public DiscTestAttributes getAttributesAfterTest() {
        return attributesAfterTest;
    }

    public void setAttributesAfterTest(DiscTestAttributes attributesAfterTest) {
        this.attributesAfterTest = attributesAfterTest;
    }

    public Collection<Double> getCuttingTimes() {
        return cuttingTimes;
    }

    public void setCuttingTimes(Collection<Double> cuttingTimes) {
        this.cuttingTimes = cuttingTimes;
    }

    @Override
    public String toString() {
        return "StandardDiscTestResult{" +
        "number=" + number +
        ", minThickness=" + minThickness +
        ", maxThickness=" + maxThickness +
        ", attributesBeforeTest=" + attributesBeforeTest +
        ", attributesAfterTest=" + attributesAfterTest +
        ", cuttingTimes=" + cuttingTimes +
        "} " + super.toString();
    }
}
