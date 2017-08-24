package hu.papai.grana.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class DictionaryCodomain extends AbstractEntity {

    @Enumerated(EnumType.STRING)
    @Column(unique = true)
    private DictionaryKey key;

    @ElementCollection
    private Set<String> values = new HashSet<>();

    public DictionaryKey getKey() {
        return key;
    }

    public void setKey(DictionaryKey key) {
        this.key = key;
    }

    public Set<String> getValues() {
        return values;
    }

    public void setValues(Set<String> values) {
        this.values = values;
    }

    @Override
    public String toString() {
        return "DictionaryCodomain{" +
        "key=" + key +
        ", values=" + values +
        "} " + super.toString();
    }
}
