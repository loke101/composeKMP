package Presentation.Login

import dev.icerock.moko.mvvm.viewmodel.ViewModel
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

class LoginViewModel:ViewModel() {

    private val httpClient = HttpClient {
        install(ContentNegotiation) {
            json(Json {
                prettyPrint = true
                isLenient = true
            })
        }
    }
//    private suspend fun getPosts(): List<UserPosts> {
//        return httpClient.get("https://jsonplaceholder.typicode.com/posts").body<List<UserPosts>>()
//    }
}