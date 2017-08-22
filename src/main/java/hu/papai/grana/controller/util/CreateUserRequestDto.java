package hu.papai.grana.controller.util;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Utility class that represents a request coming from the client for new user creation. The reason why {@link hu.papai.grana.model.security.GranaUser}
 * is not used because {@link com.fasterxml.jackson.annotation.JsonIgnore} is present on the password field.
 */
public class CreateUserRequestDto {

    @NotEmpty
    private String username;

    @NotNull
    @Size(min = 6)
    private String password;

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
}
