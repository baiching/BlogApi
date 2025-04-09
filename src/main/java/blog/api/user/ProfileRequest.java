package blog.api.user;

import jakarta.validation.constraints.Email;
import lombok.Data;

@Data
public class ProfileRequest {
    @Email
    private String email;

    private String bio;
}
