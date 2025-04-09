package blog.api.user;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class ProfileResponse {
    private String username;
    private String email;
    private String profilePictureUrl;
    private LocalDateTime createdAt;
}
