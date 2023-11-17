package com.projectForLeanPlatformTechnologies.projectForLeanPlatformTechnologies.Model;

import com.projectForLeanPlatformTechnologies.projectForLeanPlatformTechnologies.Entity.TestDataEntity;
import com.projectForLeanPlatformTechnologies.projectForLeanPlatformTechnologies.Entity.UserEntity;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

public class TestResultModel {
    private Long testResultId;
    @ManyToOne
    @JoinColumn(name="used_id")
    private UserEntity user;
    @ManyToOne
    @JoinColumn(name="question_id")
    private TestDataEntity question;
    private String selectedOption;
    private LocalDateTime timestamp;
    private long timeTakenInSeconds;
    @ManyToOne(cascade = CascadeType.ALL)
    private UserEntity userId;

}
