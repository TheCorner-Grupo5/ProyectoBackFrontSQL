package backapp.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import backapp.demo.models.Data;

public interface DataRepository extends JpaRepository<Data,Integer>{
    boolean existsByEmail(String email);
}
