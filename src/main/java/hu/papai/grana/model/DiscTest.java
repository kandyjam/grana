package hu.papai.grana.model;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Collection;

@Entity
public class DiscTest extends AbstractEntity {

    @NotNull
    private Integer number;

    @Valid
    private DiscTestAttributes attributesBeforeTest;

    @Valid
    private DiscTestAttributes attributesAfterTest;

    @ElementCollection
    private Collection<Double> cuttingTimes = new ArrayList<>();

    /**
     * Even though this relationship is not meant to be bidirectional, {@link ManyToOne} is needed, so JPA doesn't
     * generate a join table.
     */
    @ManyToOne
    private Disc disc;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DiscTest discTest = (DiscTest) o;

        return number.equals(discTest.number);
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

    public Disc getDisc() {
        return disc;
    }

    public void setDisc(Disc disc) {
        this.disc = disc;
    }

    @Override
    public String toString() {
        return "DiscTest{" +
        "number=" + number +
        ", attributesBeforeTest=" + attributesBeforeTest +
        ", attributesAfterTest=" + attributesAfterTest +
        ", cuttingTimes=" + cuttingTimes +
        "} " + super.toString();
    }
}
