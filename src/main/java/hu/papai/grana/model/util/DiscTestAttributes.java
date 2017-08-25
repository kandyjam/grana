package hu.papai.grana.model.util;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Embeddable
public class DiscTestAttributes implements Serializable {

    private static final long serialVersionUID = 8267137739545664368L;

    @NotNull
    private Double diameter;

    @NotNull
    private Double mass;

    public Double getDiameter() {
        return diameter;
    }

    public void setDiameter(Double diameter) {
        this.diameter = diameter;
    }

    public Double getMass() {
        return mass;
    }

    public void setMass(Double mass) {
        this.mass = mass;
    }

    @Override
    public String toString() {
        return "DiscTestAttributes{" +
        "diameter=" + diameter +
        ", mass=" + mass +
        "} " + super.toString();
    }
}
