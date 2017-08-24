package hu.papai.grana.model.security;

import hu.papai.grana.model.AbstractEntity;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.Collection;

@Entity
public class GranaAuthority extends AbstractEntity {

    private String name;

    @ManyToMany(mappedBy = "authorities")
    private Collection<GranaUser> users = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<GranaUser> getUsers() {
        return users;
    }

    public void setUsers(Collection<GranaUser> users) {
        this.users = users;
    }
}
