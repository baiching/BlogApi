package blog.api.comments;

import org.hibernate.type.descriptor.converter.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaAttributeConverter<Comment, Long> {

    List<Comment> findByPostId(Long postId);

    List<Comment> findByAuthorId(Long authorId);

    // query to count comments for a post
    @Query("SELECT COUNT(c) FROM Comment c WHERE c.postId = :postId")
    long countByPostId(@Param("postId") Long postId);

    // find recent comments with limit
    @Query("SELECT c FROM Comment c ORDER BY c.createdAt DESC LIMIT :limit")
    List<Comment> findRecentComments(@Param("limit") int limit);
}
