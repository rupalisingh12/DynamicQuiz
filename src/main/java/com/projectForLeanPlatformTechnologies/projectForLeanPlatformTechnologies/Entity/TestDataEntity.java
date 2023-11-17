package com.projectForLeanPlatformTechnologies.projectForLeanPlatformTechnologies.Entity;

import com.projectForLeanPlatformTechnologies.projectForLeanPlatformTechnologies.Model.TestDataModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class TestDataEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String questionText;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    @OneToOne(cascade = CascadeType.ALL)
    private TestDataEntity nextQuestionOption1;

    @OneToOne(cascade = CascadeType.ALL)
    private TestDataEntity nextQuestionOption2;
    @OneToOne(cascade = CascadeType.ALL)
    private TestDataEntity nextQuestionOption3;
   @OneToOne(cascade = CascadeType.ALL)
    private TestDataEntity nextQuestionOption4;
   @ManyToOne(cascade = CascadeType.ALL)
    private UserEntity userid;



}
