# DynamicQuiz

## Introduction

Welcome to the Quiz Application project! This web application is designed to facilitate users in taking dynamic quizzes with multiple-choice questions. The project includes features such as uploading test data, commencing quizzes, retrieving specific questions, redirecting users based on their answers, storing user test results, and providing access to test results.

## Getting Started

To understand the project better, there is one API dedicated to uploading an Excel sheet that contains the test data. The format for this Excel sheet will be provided by you. Each question in the quiz has four multiple-choice options, and the next question displayed is determined by the user's selection.

For example, if the user selects Option 1 for Question 1, the next question will be Question 2. The dynamic nature of the quiz requires a structured relation of options to questions in the Excel form.

## Features

### 1. Upload Test Data

- Users can conveniently upload test data by providing an Excel sheet containing questions, options, and the corresponding relation between options and questions.
- The application parses the data and stores it in the database for later use.

### 2. Start Test

- Initiating a test marks the beginning of the user's quiz-taking journey.
- Users are presented with the first question from the uploaded test data.

### 3. Get Question

- Users have the capability to retrieve specific questions based on their unique question number or identifier.
- The API furnishes users with all relevant details of the question, including available options.

### 4. Redirect User

- The application's unique feature redirects users based on their chosen option.
- After selecting an answer, users are directed to the subsequent question according to the test's predefined structure.

### 5. Store User Test Result

- The application diligently tracks and stores user test actions.
- Records include the total questions attempted by the user and the chronological path of questions they answered during the test.

### 6. Get Result

- Users can access their test results by providing their user ID along with the date and time of the test attempt.
- This feature enables users to review their performance in previous quizzes.

### 7. Get All Test Results

- The application provides access to all test results in a paginated format.
- Results are sorted by the latest date, allowing users to analyze their progress over time.

## Database Tables

To support the application's functionality, the following database tables are required:

- **User:** Stores user information, including user ID and other relevant details.
- **TestData:** Stores the uploaded test data, including questions, options, and subsequent questions from each option.
- **TestResult:** Records user test results, including total marks, the sequence of questions that the user follows, the answered option during the test, and the time taken to complete the test.
