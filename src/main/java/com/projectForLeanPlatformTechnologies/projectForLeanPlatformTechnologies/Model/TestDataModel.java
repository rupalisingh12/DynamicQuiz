package com.projectForLeanPlatformTechnologies.projectForLeanPlatformTechnologies.Model;

import com.projectForLeanPlatformTechnologies.projectForLeanPlatformTechnologies.Entity.TestDataEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@AllArgsConstructor
@NoArgsConstructor
@Data

public class TestDataModel {
    private Long testId;
    private String questionText;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    @ManyToOne
    @JoinColumn(name="next_question_id_option1")
    private TestDataEntity nextQuestionOption1;

    @ManyToOne
    @JoinColumn(name="next_question_id_option2")
    private TestDataEntity nextQuestionOption2;
    @ManyToOne
    @JoinColumn(name="next_question_id_option3")
    private TestDataEntity nextQuestionOption3;
    @ManyToOne
    @JoinColumn(name="next_question_id_option4")
    private TestDataEntity nextQuestionOption4;
}
