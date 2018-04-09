package com.xym.springcloud.dao;

import com.xym.springcloud.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author xym
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
