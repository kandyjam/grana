package hu.papai.grana.model.security;

import com.fasterxml.jackson.annotation.JsonIgnore;
import hu.papai.grana.model.AbstractEntity;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
public class GranaUser extends AbstractEntity {

    @NotEmpty
    @Column(unique = true)
    private String username;

    @JsonIgnore
    @NotEmpty
    private String password;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Collection<GranaAuthority> authorities = new ArrayList<>();

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Collection<GranaAuthority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Collection<GranaAuthority> authorities) {
        this.authorities = authorities;
    }
}
