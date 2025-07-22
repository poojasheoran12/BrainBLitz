package com.example.brainblitz.model

import androidx.lifecycle.ViewModel
import com.example.brainblitz.data.GameUiState
import com.example.brainblitz.data.Question
import com.example.brainblitz.data.questionList
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class GameViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(GameUiState())
    val uiState: StateFlow<GameUiState> = _uiState.asStateFlow()

    private val _offsetX = MutableStateFlow(0f)
    val offsetX: StateFlow<Float> = _offsetX.asStateFlow()

    private val usedQuestions: MutableSet<Question> = mutableSetOf()
    private lateinit var currentQuestion: Question

    private val maxQuestions = 10

    init {
        resetGame()
    }

    fun updateOffset(delta: Float) {
        _offsetX.value = (_offsetX.value + delta).coerceIn(-160f, 160f)
    }

    fun setDifficulty(difficulty: String) {
        _uiState.update {
            it.copy(difficulty = difficulty)
        }
    }

    fun getQuestion(selectedDifficulty: String): Question {
        val filteredQuestions = questionList.filter { it.difficulty == selectedDifficulty }
        val unusedQuestions = filteredQuestions.filterNot { it in usedQuestions }

        currentQuestion = if (unusedQuestions.isEmpty()) {
            usedQuestions.clear()
            usedQuestions.addAll(filteredQuestions)
            filteredQuestions.random()
        } else {
            unusedQuestions.random().also { usedQuestions.add(it) }
        }

        return currentQuestion
    }

    fun loadNextQuestion(selectedDifficulty: String): Question {
        val next = getQuestion(selectedDifficulty)
        _uiState.update {
            it.copy(currentQuestion = next, selectedOption = "")
        }
        return next
    }
    fun checkAns() {
        val currentState = uiState.value
        val isCorrect = currentState.selectedOption == currentState.currentQuestion.answer
        val nextQuestionNumber = currentState.questionNumber + 1
        val isLastQuestion = nextQuestionNumber > maxQuestions

        if (isLastQuestion) {
            _uiState.update {
                it.copy(
                    score = if (isCorrect) it.score + 5 else it.score,
                    selectedOption = "",
                    isGameOver = true
                )
            }
        } else {
            val nextQuestion = getQuestion(currentState.difficulty)
            _uiState.update {
                it.copy(
                    score = if (isCorrect) it.score + 5 else it.score,
                    selectedOption = "",
                    questionNumber = nextQuestionNumber,
                    currentQuestion = nextQuestion,
                    isGameOver = false
                )
            }
        }
    }




fun onSkip() {
    _uiState.update { current ->
        val nextQuestionNumber = current.questionNumber + 1
        val totalQuestions = 10
        val isLastQuestion = nextQuestionNumber > totalQuestions

        if (isLastQuestion) {
            current.copy(
                selectedOption = "",
                isGameOver = true
            )
        } else {
            current.copy(
                selectedOption = "",
                questionNumber = nextQuestionNumber,
                currentQuestion = loadNextQuestion(current.difficulty),
                isGameOver = false
            )
        }
    }
}


    fun selectOption(option: String) {
        _uiState.update {
            it.copy(selectedOption = option)
        }
    }

    fun resetGame() {
        usedQuestions.clear()
        val difficulty = uiState.value.difficulty
        val firstQuestion = getQuestion(difficulty)
        _uiState.value = GameUiState(
            currentQuestion = firstQuestion,
            difficulty = difficulty,
            selectedOption = "",
            questionNumber = 1,
            score = 0,
            isGameOver = false

        )
    }
}
