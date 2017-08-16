package hu.papai.grana.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class DictionaryCodomain extends AbstractEntity {

    @Enumerated(EnumType.STRING)
    @Column(unique = true)
    private DictionaryKey key;

    @ElementCollection
    private Collection<String> values;

    public DictionaryKey getKey() {
        return key;
    }

    public void setKey(DictionaryKey key) {
        this.key = key;
    }

    public Collection<String> getValues() {
        return values;
    }

    public void setValues(Collection<String> values) {
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
