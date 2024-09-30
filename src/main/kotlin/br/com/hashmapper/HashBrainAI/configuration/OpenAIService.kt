package br.com.hashmapper.HashBrainAI.configuration

import com.azure.identity.DefaultAzureCredentialBuilder
import com.azure.security.keyvault.secrets.SecretClientBuilder
import org.springframework.stereotype.Component

//@Component
//class OpenAIService(openAIConfig: OpenAIConfig) {
//    private val secret = SecretClientBuilder()
//        .vaultUrl(openAIConfig.keyVault)
//        .credential(DefaultAzureCredentialBuilder().build())
//        .buildClient()
//
//    fun getSecret(secretName: String): String {
//        return secret.getSecret(secretName).name
//    }
//}