package hu.papai.grana.model;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
public class DiscTestAttributes extends AbstractEntity implements Serializable {

    private static final long serialVersionUID = 8267137739545664368L;

    @NotNull
    private Double diameter;

    @NotNull
    private Double mass;

    @NotNull
    private Double thickness;

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

    public Double getThickness() {
        return thickness;
    }

    public void setThickness(Double thickness) {
        this.thickness = thickness;
    }

    @Override
    public String toString() {
        return "DiscTestAttributes{" +
        "diameter=" + diameter +
        ", mass=" + mass +
        ", thickness=" + thickness +
        '}';
    }
}
