package hu.unideb.inf.autokereskedes.data.repository;

import hu.unideb.inf.autokereskedes.data.entity.ExtrakEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExtrakRepository extends JpaRepository<ExtrakEntity, Long> {
}
