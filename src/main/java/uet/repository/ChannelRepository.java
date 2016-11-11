package uet.repository;

/**
 * Created by Tu on 10-Nov-16.
 */

import uet.model.Channel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChannelRepository extends CrudRepository<Channel, Integer>{

}
