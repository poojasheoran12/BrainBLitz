package com.example.brainblitz.model



import androidx.lifecycle.ViewModel
import com.example.brainblitz.data.MAX_NO_OF_WORDS
import com.example.brainblitz.data.SCORE_INCREASE
import com.example.brainblitz.data.UnscrambleUiState
import com.example.brainblitz.data.allWords

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class UnscrambleViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(UnscrambleUiState())
    val uiState: StateFlow<UnscrambleUiState> = _uiState.asStateFlow()

    private lateinit var currentWord: String
    private var usedWords: MutableSet<String> = mutableSetOf()

    // Make this observable by GameScreen
    private val _userGuess = MutableStateFlow("")
    val userGuess: StateFlow<String> = _userGuess.asStateFlow()

    private fun pickRandomWordAndShuffle(): String {
        currentWord = allWords.random()
        return if (usedWords.contains(currentWord)) {
            pickRandomWordAndShuffle()
        } else {
            usedWords.add(currentWord)
            shuffleCurrentWord(currentWord)
        }
    }

    private fun shuffleCurrentWord(word: String): String {
        val tempWord = word.toCharArray()
        tempWord.shuffle()
        while (String(tempWord) == word) {
            tempWord.shuffle()
        }
        return String(tempWord)
    }

    fun resetGame() {
        usedWords.clear()
        _uiState.value = UnscrambleUiState(currentScrambledWord = pickRandomWordAndShuffle())
        _userGuess.value = ""
    }

    fun updateUserGuess(guessedWord: String) {
        _userGuess.value = guessedWord
    }
    fun checkUserGuess(){
        if(userGuess.value.equals(currentWord,false)){
            val updatedScore= _uiState.value.score.plus(SCORE_INCREASE)
            updateGameState(updatedScore)

        }else{

            _uiState.update { currentState->
                currentState.copy(isGuessedWordWrong =true)
            }

        }
        updateUserGuess("")
    }
    private fun updateGameState(updatedScore: Int) {
        if (usedWords.size == MAX_NO_OF_WORDS){
            //Last round in the game
            _uiState.update { currentState ->
                currentState.copy(
                    isGuessedWordWrong = false,
                    score = updatedScore,
                    isGameOver = true
                )
            }}else {
            _uiState.update { currentState ->
                currentState.copy(
                    isGuessedWordWrong = false,
                    currentScrambledWord = pickRandomWordAndShuffle(),

                    score = updatedScore,
                    currentWordCount = currentState.currentWordCount.inc(),
                )
            }
        }
    }
    fun skipWord() {
        updateGameState(_uiState.value.score)
        // Reset user guess
        updateUserGuess("")
    }

    init {
        resetGame()
    }
}
