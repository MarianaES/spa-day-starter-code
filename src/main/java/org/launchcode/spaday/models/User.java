package org.launchcode.spaday.models;

import javax.validation.constraints.*;

public class User {

    @NotBlank(message = "Username required")
    @Size(min=5, max=15, message = "Username must have between 5 and 15 characters")
    private String username;

    @Email
    private String email;

    @NotBlank(message = "Password required")
    @Size(min=6)
    private String password;

    @NotBlank(message = "Verify password, please")
    @NotNull(message = "Passwords do not match")
    @Size(min=6)
    private String verifyPassword;

    public User() {

    }

    public User(String username, String email, String password, String verifyPassword) {
        this();
        this.username = username;
        this.email = email;
        this.password = password;
        this.verifyPassword = verifyPassword;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
        checkPassword();
    }

    public String getVerifyPassword() {
        return verifyPassword;
    }

    public void setVerifyPassword(String verifyPassword) {
        this.verifyPassword = verifyPassword;
        checkPassword();
    }

    private void checkPassword() {
        if (!password.equals(verifyPassword) && password != null && verifyPassword != null) {
            setVerifyPassword(null);
        }
    }
}
