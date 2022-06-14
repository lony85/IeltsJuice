package com.ieltsjuice.placement_test

import com.ieltsjuice.model.PlacementQuizRepository
import com.ieltsjuice.model.Question

class PlacementQuizViewModel(
    private val placementQuizRepository: PlacementQuizRepository
) {
    fun getQuestions():List<Question>{
        return placementQuizRepository.getQuestions()
    }

}