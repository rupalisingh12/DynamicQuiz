package com.projectForLeanPlatformTechnologies.projectForLeanPlatformTechnologies.Dao;

import com.projectForLeanPlatformTechnologies.projectForLeanPlatformTechnologies.Entity.TestDataEntity;
import com.projectForLeanPlatformTechnologies.projectForLeanPlatformTechnologies.Model.TestDataModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TestDataDao extends JpaRepository<TestDataEntity,Long> {
   TestDataEntity findFirstByOrderByIdAsc();


}
