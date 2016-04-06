package com.helper.finance.client.form;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Size;
import java.util.Objects;
/**
 * Created by dvasd on 01.04.2016.
 */
public class UserForm {

    private String id;

    @Email @NotEmpty
    private String email;

    @Size(min = 3, max = 30)
    private String firstName;

    @Size(min = 3, max = 30)
    private String lastName;

    @NotEmpty
    private String password;
    private boolean active;

    public UserForm() {
    }

    public UserForm(String id, String email, String firstName, String lastName, String password, boolean active) {
        this.id = id;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.active = active;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserForm)) return false;
        UserForm userForm = (UserForm) o;
        return Objects.equals(active, userForm.active) &&
                Objects.equals(email, userForm.email) &&
                Objects.equals(firstName, userForm.firstName) &&
                Objects.equals(lastName, userForm.lastName) &&
                Objects.equals(password, userForm.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, firstName, lastName, password, active);
    }
}
