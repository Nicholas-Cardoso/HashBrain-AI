package br.com.hashmapper.HashBrainAI.controller

import br.com.hashmapper.HashBrainAI.dto.Speech
import br.com.hashmapper.HashBrainAI.services.OpenAIClient
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/safe-speech")
class SpeechFilterController(
    private val openAIClient: OpenAIClient
) {

    @PostMapping
    fun checkSafeSpeech(@RequestBody @Valid input: Speech): String {
        return openAIClient.checkProfanity(input)
    }
}