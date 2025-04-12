package blog.api.user.dto;

import jakarta.validation.constraints.Email;

public class ProfileRequest {
    public @Email String getEmail() {
        return email;
    }

    public void setEmail(@Email String email) {
        this.email = email;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    @Email
    private String email;

    private String bio;
}
