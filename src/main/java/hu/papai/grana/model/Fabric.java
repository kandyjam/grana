package hu.papai.grana.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Collection;

@Entity
public class Fabric extends AbstractEntity {

    @NotNull
    private Integer itemNumber;

    @NotNull
    private String manufacturer;

    @NotNull
    private Integer size;

    @NotNull
    private String position;

    @JsonIgnore
    @ManyToMany(mappedBy = "fabrics")
    private Collection<Disc> discs = new ArrayList<>();

    public Integer getItemNumber() {
        return itemNumber;
    }

    public void setItemNumber(Integer itemNumber) {
        this.itemNumber = itemNumber;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Collection<Disc> getDiscs() {
        return discs;
    }

    public void setDiscs(Collection<Disc> discs) {
        this.discs = discs;
    }

    @Override
    public String toString() {
        return "Fabric{" +
        "itemNumber=" + itemNumber +
        ", manufacturer='" + manufacturer + '\'' +
        ", size=" + size +
        ", position='" + position + '\'' +
        "} " + super.toString();
    }
}
