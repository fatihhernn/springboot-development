package com.fatihhernn.repository;

import com.fatihhernn.entity.User;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends ElasticsearchRepository<User,String> {

    @Query("{\"bool\": {\"must\": [{\"match\": {\"name\": \"?0\"}}]}}")  //elastic query
    List<User> getByCustomQuery(String search);

    List<User> findByNameLikeOrSurnameLike(String name,String surname);  //spring query
}
