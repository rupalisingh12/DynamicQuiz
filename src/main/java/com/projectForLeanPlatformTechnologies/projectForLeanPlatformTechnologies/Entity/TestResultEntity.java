package com.projectForLeanPlatformTechnologies.projectForLeanPlatformTechnologies.Entity;

import com.projectForLeanPlatformTechnologies.projectForLeanPlatformTechnologies.Model.TestDataModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TestResultEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long testResultId;
    @OneToOne(cascade = CascadeType.ALL)
    private UserEntity user;
    @OneToOne(cascade = CascadeType.ALL)
    private TestDataEntity testId;
    private int totalQuestionsAttempted;


    @OneToOne(cascade = CascadeType.ALL)
    private TestDataEntity question;
    private String selectedOption;
    private LocalDateTime timestamp;
    private long timeTakenInSeconds;
    @ManyToOne(cascade = CascadeType.ALL)
    private UserEntity userid;

}
