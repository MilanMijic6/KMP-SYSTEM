package com.vega.data.api

import com.vega.data.BASE_URL
import com.vega.data.Constants.PAGE_NUMBER
import com.vega.data.Constants.PAGE_SIZE
import com.vega.domain.model.login.LoginRequestBody
import com.vega.domain.model.register.RegisterRequestBody
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.client.request.url
import io.ktor.http.ContentType
import io.ktor.http.contentType

class ApiClientImpl(
    private val httpClient: HttpClient
) : ApiClient {
    override suspend fun login(endpoint: String, params: LoginRequestBody) =
        httpClient.post {
            url(BASE_URL + endpoint)
            contentType(ContentType.Application.Json)
            setBody(params)
        }

    override suspend fun register(endpoint: String, params: RegisterRequestBody) =
        httpClient.post {
            url(BASE_URL + endpoint)
            contentType(ContentType.Application.Json)
            setBody(params)
        }

    override suspend fun getUpcomingEvents(
        endpoint: String,
        page: Int,
        pageSize: Int
    ) = httpClient.get {
        url(BASE_URL + endpoint)
        url {
            parameters.append(PAGE_NUMBER, page.toString())
            parameters.append(PAGE_SIZE, pageSize.toString())
        }
    }
}