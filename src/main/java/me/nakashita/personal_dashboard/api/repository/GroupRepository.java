package me.nakashita.personal_dashboard.api.repository;

import me.nakashita.personal_dashboard.api.model.Group;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepository extends CrudRepository<Group, Long> {
}
