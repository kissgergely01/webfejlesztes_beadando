package hu.unideb.inf.autokereskedes.data.repository;

import hu.unideb.inf.autokereskedes.data.entity.AutoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AutoRepository extends JpaRepository<AutoEntity, Long> {

    //select * from esemeny where nev like '%nev%';
    List<AutoEntity> findAllByGyartoContains(String gyarto);
}