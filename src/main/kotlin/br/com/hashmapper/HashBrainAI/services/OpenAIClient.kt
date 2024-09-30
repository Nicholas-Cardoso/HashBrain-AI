package br.com.hashmapper.HashBrainAI.services

import br.com.hashmapper.HashBrainAI.configuration.OpenAIConfig
import br.com.hashmapper.HashBrainAI.dto.Speech
import com.azure.ai.openai.OpenAIClientBuilder
import com.azure.ai.openai.models.ChatCompletionsOptions
import com.azure.ai.openai.models.ChatRequestMessage
import com.azure.ai.openai.models.ChatRequestSystemMessage
import com.azure.core.credential.AzureKeyCredential
import org.springframework.stereotype.Service

@Service
class OpenAIClient(
//    private val openAIService: OpenAIService
    private val openAiConfig: OpenAIConfig
) {
    private val client = OpenAIClientBuilder()
        .credential(AzureKeyCredential(openAiConfig.apiKey))
        .endpoint(openAiConfig.endpoint)
        .buildClient()

    fun checkProfanity(input: Speech): Boolean? {
        val chatMessages = ArrayList<ChatRequestMessage>()
        chatMessages.add(ChatRequestSystemMessage("Por favor, analise o seguinte texto e diga se ele contém palavras de baixo calão ou xingamentos: \"$input\". Responda apenas com 'Sim' se houver e 'Não' se não houver."))

        val chatCompletionsOptions = ChatCompletionsOptions(chatMessages)
        val chatCompletions = client.getChatCompletions(openAiConfig.model, chatCompletionsOptions)

        val responseContext = chatCompletions.choices[0].message.content.trim()
        println(responseContext)
        return when {
            responseContext.contains("sim", ignoreCase = true) -> true
            responseContext.contains("não", ignoreCase = true) -> false
            else -> null
        }
    }
}
