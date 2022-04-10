package me.nakashita.personal_dashboard.api.repository;

import me.nakashita.personal_dashboard.api.model.Group;
import me.nakashita.personal_dashboard.api.model.Shortcut;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShortcutRepository extends CrudRepository<Shortcut, Long> {
}
