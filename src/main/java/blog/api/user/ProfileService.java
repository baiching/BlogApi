package blog.api.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;

@Service
public class ProfileService {
    @Autowired
    private UserRepository userRepository;

    //private final FileStorageService fileStorageService;

    public ProfileResponse getUserProfile(String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        return new ProfileResponse(
                user.getUsername(),
                user.getEmail(),
                user.getProfilePictureUrl(),
                user.getCreatedAt()
        );
    }

    public ProfileResponse updateUserEmail(String username, ProfileRequest profileRequest) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        // Update email
        if (profileRequest.getEmail() != null) {
            user.setEmail(profileRequest.getEmail());
        }

        userRepository.save(user);

        return new ProfileResponse(
                user.getUsername(),
                user.getEmail(),
                user.getProfilePictureUrl(),
                user.getCreatedAt()
        );
    }
}
