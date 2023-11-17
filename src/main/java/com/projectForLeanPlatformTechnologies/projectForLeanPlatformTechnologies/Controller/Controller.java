package com.projectForLeanPlatformTechnologies.projectForLeanPlatformTechnologies.Controller;

import com.projectForLeanPlatformTechnologies.projectForLeanPlatformTechnologies.Entity.TestDataEntity;
import com.projectForLeanPlatformTechnologies.projectForLeanPlatformTechnologies.Entity.TestResultEntity;
import com.projectForLeanPlatformTechnologies.projectForLeanPlatformTechnologies.Model.TestDataModel;
import com.projectForLeanPlatformTechnologies.projectForLeanPlatformTechnologies.Service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RequestMapping
@RestController
public class Controller {

    private QuizService quizService;
    @Autowired
    public Controller(QuizService quizService){
        this.quizService=quizService;
    }
    @PostMapping("/uploadTestData")
    public void uploadTestData(@RequestBody List<TestDataEntity> testDataList) {
        quizService.uploadTestData(testDataList);
    }

    @PostMapping("/startTest/{userId}")
    public TestDataEntity startTest(@PathVariable Long userId) {
        return quizService.startTest(userId);
    }

    @GetMapping("/getQuestion/{questionId}")
    public TestDataEntity getQuestion(@PathVariable Long questionId) {
        return quizService.getQuestion(questionId);
    }

    @PostMapping("/redirectUser/{userId}/{questionId}")
    public TestDataEntity redirectUser(@PathVariable Long userId, @PathVariable Long questionId, @RequestParam String selectedOption) {
        return quizService.redirectUser(userId, questionId, selectedOption);
    }

    @GetMapping("/getUserResults/{userId}")
    public List<TestResultEntity> getUserResults(@PathVariable Long userId, @RequestParam LocalDateTime timestamp) {
        return quizService.getUserResults(userId, timestamp);
    }

    @GetMapping("/getAllResults/{page}")
    public List<TestResultEntity> getAllResults(@PathVariable int page) {
        return quizService.getAllResults(page);
    }
}






