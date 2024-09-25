package br.com.hashmapper.HashBrainAI.configuration

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Configuration

@Configuration
class OpenAIConfig {
    @Value("\${azure.key.url}")
    lateinit var keyVault: String
//    @Value("\${openai.api.key}")
//    lateinit var apiKey: String
//
//    @Value("\${openai.endpoint}")
//    lateinit var endpoint: String
//
//    @Value("\${openai.model}")
//    lateinit var model: String
}