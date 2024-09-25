package br.com.hashmapper.HashBrainAI.services

import br.com.hashmapper.HashBrainAI.configuration.OpenAIService
import br.com.hashmapper.HashBrainAI.dto.Speech
import com.azure.ai.openai.OpenAIClientBuilder
import com.azure.ai.openai.models.ChatCompletionsOptions
import com.azure.ai.openai.models.ChatRequestMessage
import com.azure.ai.openai.models.ChatRequestSystemMessage
import com.azure.core.credential.AzureKeyCredential
import org.springframework.stereotype.Service

@Service
class OpenAIClient(
    private val openAIService: OpenAIService
) {
    private val client = OpenAIClientBuilder()
        .credential(AzureKeyCredential(openAIService.getSecret("ApiKey")))
        .endpoint(openAIService.getSecret("Endpoint"))
        .buildClient()

    fun checkProfanity(input: Speech): String {
        val chatMessages = ArrayList<ChatRequestMessage>()
        chatMessages.add(ChatRequestSystemMessage("Por favor, analise o seguinte texto e diga se ele contém palavras de baixo calão ou xingamentos: \"$input\". Responda com 'Sim' se houver e 'Não' se não houver."))

        val chatCompletionsOptions = ChatCompletionsOptions(chatMessages)

        val chatCompletions = client.getChatCompletions(openAIService.getSecret("Model"), chatCompletionsOptions)

        return chatCompletions.choices[0].message.content.trim()
    }
}
