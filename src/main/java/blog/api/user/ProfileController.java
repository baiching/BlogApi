package blog.api.user;

import blog.api.security.services.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/profile")
public class ProfileController {
    @Autowired
    private ProfileService profileService;

    @GetMapping
    public ResponseEntity<ProfileResponse> getProfile(
            @AuthenticationPrincipal UserDetailsImpl currentUser
            ) {
        ProfileResponse response = profileService.getUserProfile(currentUser.getUsername());
        return ResponseEntity.ok(response);
    }

    @PutMapping
    public ResponseEntity<ProfileResponse> updateEmail(
            @AuthenticationPrincipal UserDetailsImpl currentUser,
            ProfileRequest profileRequest
    ) {
        ProfileResponse response = profileService.updateUserEmail(
                currentUser.getUsername(),
                profileRequest
        );

        return ResponseEntity.ok(response);
    }
}
