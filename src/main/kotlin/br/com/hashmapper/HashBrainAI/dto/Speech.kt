package br.com.hashmapper.HashBrainAI.dto

import jakarta.validation.constraints.NotBlank

data class Speech(
    @field:NotBlank(message = "Input is required.")
    val speech: String
)
