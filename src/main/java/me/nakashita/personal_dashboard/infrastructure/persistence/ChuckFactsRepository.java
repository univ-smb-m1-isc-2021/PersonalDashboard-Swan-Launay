package me.nakashita.personal_dashboard.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChuckFactsRepository extends JpaRepository<ChuckFact, Long> {

    ChuckFact findByName(String name);

}
