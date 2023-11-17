package com.projectForLeanPlatformTechnologies.projectForLeanPlatformTechnologies.Dao;

import com.projectForLeanPlatformTechnologies.projectForLeanPlatformTechnologies.Entity.TestDataEntity;
import com.projectForLeanPlatformTechnologies.projectForLeanPlatformTechnologies.Entity.TestResultEntity;
import com.projectForLeanPlatformTechnologies.projectForLeanPlatformTechnologies.Entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
@Repository
public interface TestResultDao extends JpaRepository<TestResultEntity,Long> {
    List<TestResultEntity> findByUserIdAndTimestamp(Long userId, LocalDateTime timestamp);

}
