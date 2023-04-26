package hh.healthhive.Repository;

import hh.healthhive.Model.Calorie;
import hh.healthhive.Model.Reply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReplyRepository extends JpaRepository<Reply,Long> {

    @Query(value = "select * from reply  where post_id = :postId", nativeQuery = true)
    List<Reply> findByPostId(Long postId);
}
