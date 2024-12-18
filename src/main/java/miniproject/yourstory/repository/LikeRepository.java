package miniproject.yourstory.repository;

import miniproject.yourstory.entity.Likes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LikeRepository extends JpaRepository<Likes, Long> {
    Likes findByBookIdAndMemberUsername(long book_id, String username);
}