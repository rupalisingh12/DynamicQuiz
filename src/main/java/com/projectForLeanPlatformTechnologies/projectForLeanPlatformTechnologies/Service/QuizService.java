package com.projectForLeanPlatformTechnologies.projectForLeanPlatformTechnologies.Service;

import com.projectForLeanPlatformTechnologies.projectForLeanPlatformTechnologies.Entity.TestDataEntity;
import com.projectForLeanPlatformTechnologies.projectForLeanPlatformTechnologies.Entity.TestResultEntity;
import com.projectForLeanPlatformTechnologies.projectForLeanPlatformTechnologies.Entity.UserEntity;
import com.projectForLeanPlatformTechnologies.projectForLeanPlatformTechnologies.Model.TestDataModel;

import java.time.LocalDateTime;
import java.util.List;

public interface QuizService {
    public void uploadTestData(List<TestDataEntity> testDataEntity);
    public TestDataEntity startTest(Long userId);
 public void saveTestResult(UserEntity userOptional, TestDataEntity firstQuestion, String selectedOption);
    public TestDataEntity getQuestion(Long questionId);
    public TestDataEntity redirectUser(Long userId, Long questionId, String selectedOption);
    public TestDataEntity getNextQuestionBasedOnOption(TestDataEntity currentQuestion, String selectedOption);
    public List<TestResultEntity> getUserResults(Long userId, LocalDateTime timestamp);
    public List<TestResultEntity> getAllResults(int page);
    public void storeUserTestResult(UserEntity user, int totalQuestionsAttempted, List<TestDataEntity> pathOfQuestions);
}
