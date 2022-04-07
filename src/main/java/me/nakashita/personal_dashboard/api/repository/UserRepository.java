package me.nakashita.personal_dashboard.api.repository;

import me.nakashita.personal_dashboard.api.model.User;
import me.nakashita.personal_dashboard.security.AuthenticationType;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends CrudRepository<User, Long> {

    @Query("SELECT u FROM User u WHERE u.username = :username")
    public User getUserByUsername(@Param("username") String username);

    @Modifying
    @Query("UPDATE User u SET u.authType = ?2 WHERE u.username = ?1")
    public void updateAuthenticationType(String username, AuthenticationType authType);
}
