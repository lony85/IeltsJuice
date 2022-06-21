package com.ieltsjuice.model

import com.ieltsjuice.model.PlacementTestQuestions.questionList


class PlacementQuizRepository {
     fun getQuestions(): List<Question> {
        return questionList
    }
}