package blog.api.blogpost;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogPostRepository extends JpaRepository<BlogPost, Long> {

    List<BlogPost> findByAuthorId(Long authorId);

    // case-insensitive search
    List<BlogPost> findByTitleContainingIgnoreCase(String keyword);

    @Query("SELECT p FROM BlogPost p ORDER BY p.createdAt DESC LIMIT :limit")
    List<BlogPost> findRecentPosts(@Param("limit") int limit);

    boolean existsByTitleAndAuthorId(String title, Long authorId);
}
