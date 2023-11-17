package com.projectForLeanPlatformTechnologies.projectForLeanPlatformTechnologies.Dao;

import com.projectForLeanPlatformTechnologies.projectForLeanPlatformTechnologies.Entity.TestDataEntity;
import com.projectForLeanPlatformTechnologies.projectForLeanPlatformTechnologies.Entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserDao extends JpaRepository<UserEntity,Long> {
    Optional<UserEntity> findById(Long userId);
}
