package hu.papai.grana.model.security;

import hu.papai.grana.model.AbstractEntity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.Collection;

@Entity
public class GranaAuthority extends AbstractEntity {

    @Enumerated(EnumType.STRING)
    private AuthorityName name;

    @ManyToMany(mappedBy = "authorities")
    private Collection<GranaUser> users = new ArrayList<>();

    public AuthorityName getName() {
        return name;
    }

    public void setName(AuthorityName name) {
        this.name = name;
    }

    public Collection<GranaUser> getUsers() {
        return users;
    }

    public void setUsers(Collection<GranaUser> users) {
        this.users = users;
    }
}
