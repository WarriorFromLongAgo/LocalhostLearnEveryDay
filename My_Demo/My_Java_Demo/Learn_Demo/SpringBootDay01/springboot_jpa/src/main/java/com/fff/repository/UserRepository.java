package com.fff.repository;

import com.fff.domain.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @PackageName：com.fff.repository
 * @ClassName：
 * @Description：
 * @author：
 * @date：2019/11/15 17:37
 */
public interface UserRepository extends JpaRepository<UserInfo, Integer> {

}
