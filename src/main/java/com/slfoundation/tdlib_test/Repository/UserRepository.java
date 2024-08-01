package com.slfoundation.tdlib_test.Repository;

import com.slfoundation.tdlib_test.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {



}
