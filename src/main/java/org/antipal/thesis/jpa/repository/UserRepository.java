package org.antipal.thesis.jpa.repository;

import org.antipal.thesis.jpa.model.User;
import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	User findByUsername(String username)throws UsernameNotFoundException, DataAccessException;
}
