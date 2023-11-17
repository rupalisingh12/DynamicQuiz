package com.projectForLeanPlatformTechnologies.projectForLeanPlatformTechnologies.Service;

import com.projectForLeanPlatformTechnologies.projectForLeanPlatformTechnologies.Dao.TestDataDao;
import com.projectForLeanPlatformTechnologies.projectForLeanPlatformTechnologies.Dao.TestResultDao;
import com.projectForLeanPlatformTechnologies.projectForLeanPlatformTechnologies.Dao.TestResultDao;
import com.projectForLeanPlatformTechnologies.projectForLeanPlatformTechnologies.Dao.UserDao;
import com.projectForLeanPlatformTechnologies.projectForLeanPlatformTechnologies.Entity.TestDataEntity;
import com.projectForLeanPlatformTechnologies.projectForLeanPlatformTechnologies.Entity.TestResultEntity;
import com.projectForLeanPlatformTechnologies.projectForLeanPlatformTechnologies.Entity.UserEntity;
import com.projectForLeanPlatformTechnologies.projectForLeanPlatformTechnologies.Model.TestDataModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import org.springframework.stereotype.Service;


import java.io.File;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class QuizServiceImple implements QuizService {

    TestDataDao testDataDao;
    TestResultDao testResultDao;
    UserDao userDao;

    @Autowired
    public QuizServiceImple(TestDataDao testDataDao,TestResultDao testResultDao,UserDao userDao) {
        this.testDataDao = testDataDao;
        this.testResultDao=testResultDao;
        this.userDao=userDao;
    }






    @Override
    public void uploadTestData(List<TestDataEntity> testDataEntity) {

        testDataDao.saveAll(testDataEntity);
    }

    @Override
    public TestDataEntity startTest(Long userId) {
        //Optional<UserEntity> userOptional = userDao.findById(userId);


        // Assuming the first question is the starting point
        TestDataEntity firstQuestion = testDataDao.findFirstByOrderByIdAsc();

        // Record the start of the test
        Optional<UserEntity> user = userDao.findById(userId) ;
        saveTestResult(user.get(), firstQuestion,null);
        return firstQuestion;
    }
    @Override
     public void saveTestResult(UserEntity userOptional, TestDataEntity firstQuestion, String selectedOption) {
        TestResultEntity testResult = new TestResultEntity();
        testResult.setUser(userOptional);
        testResult.setQuestion(firstQuestion);
        testResult.setSelectedOption(selectedOption);
        testResult.setTimestamp(LocalDateTime.now());
        // Calculate and set timeTakenInSeconds if needed
        // ...
        //testResultDao.save(testResult);
    }
    @Override
    public TestDataEntity getQuestion(Long questionId) {
        return testDataDao.findById(questionId)
                .orElseThrow(() -> new RuntimeException("Question not found"));
    }
    @Override

    public TestDataEntity redirectUser(Long userId, Long questionId, String selectedOption) {
        TestDataEntity currentQuestion = testDataDao.findById(questionId)
                .orElseThrow(() -> new RuntimeException("Question not found"));

        TestDataEntity nextQuestion = getNextQuestionBasedOnOption(currentQuestion, selectedOption);

        Optional<UserEntity> user = userDao.findById(userId);


        saveTestResult(user.get(), nextQuestion, selectedOption);

        return nextQuestion;
    }
    @Override

    public TestDataEntity getNextQuestionBasedOnOption(TestDataEntity currentQuestion, String selectedOption) {
        switch (selectedOption) {
            case "Option1":
                return currentQuestion.getNextQuestionOption1();
            case "Option2":
                return currentQuestion.getNextQuestionOption2();
            case "Option3":
                return currentQuestion.getNextQuestionOption3();
            case "Option4":
                return currentQuestion.getNextQuestionOption4();
            default:
                throw new RuntimeException("Invalid option selected");
        }
    }
     @Override
    public List<TestResultEntity> getUserResults(Long userId, LocalDateTime timestamp) {
        // Assuming timestamp is the time when the test was started
        return testResultDao.findByUserIdAndTimestamp(userId, timestamp);
    }
    @Override
    public List<TestResultEntity> getAllResults(int page) {
        // Assuming pagination with 10 results per page
        Pageable pageable = PageRequest.of(page, 10, Sort.by("timestamp").descending());
        return testResultDao.findAll(pageable).getContent();
    }
    @Override

    public void storeUserTestResult(UserEntity user, int totalQuestionsAttempted, List<TestDataEntity> pathOfQuestions) {
               TestResultEntity testResult = new TestResultEntity();
                testResult.setUser(user);
                testResult.setTotalQuestionsAttempted(totalQuestionsAttempted);
                //testResult.setPathOfQuestions(pathOfQuestions);
    }

}