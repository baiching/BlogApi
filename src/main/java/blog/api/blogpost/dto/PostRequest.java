package blog.api.blogpost.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PostRequest {
    @NotBlank
    private String title;

    @NotBlank
    private String content;
}
