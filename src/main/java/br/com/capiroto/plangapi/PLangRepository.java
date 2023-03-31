package br.com.capiroto.plangapi;

import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;
public interface PLangRepository extends MongoRepository<PLang, String> {
    
    List<PLang> findByOrderByRanking();

}
