package uet.repository;

import uet.model.Post;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Tu on 10-Nov-16.
 */
@Repository
public interface PostRepository extends CrudRepository<Post, Integer> {

}
