package blog.api.user.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

//@Data
//@AllArgsConstructor
@NoArgsConstructor
public class ProfileResponse {
    private String username;
    private String email;
    private String profilePictureUrl;
    private LocalDateTime createdAt;

    public ProfileResponse(String username, String email, String profilePictureUrl, LocalDateTime createdAt) {
        this.username = username;
        this.email = email;
        this.profilePictureUrl = profilePictureUrl;
        this.createdAt = createdAt;
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

    public String getProfilePictureUrl() {
        return profilePictureUrl;
    }

    public void setProfilePictureUrl(String profilePictureUrl) {
        this.profilePictureUrl = profilePictureUrl;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
