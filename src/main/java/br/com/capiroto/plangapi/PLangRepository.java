package br.com.capiroto.plangapi;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface PLangRepository extends MongoRepository<PLang, String> {
    
}
