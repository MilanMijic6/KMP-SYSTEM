package com.vega.data.api

import com.vega.data.BASE_URL
import com.vega.data.Constants
import com.vega.data.Constants.EMAIL
import com.vega.data.Constants.NAME
import com.vega.data.Constants.PAGE_NUMBER
import com.vega.data.Constants.PAGE_SIZE
import com.vega.data.Constants.PROFILE_PICTURE
import com.vega.domain.model.create_event.CreateEventRequestBody
import com.vega.domain.model.login.LoginRequestBody
import com.vega.domain.model.register.RegisterRequestBody
import com.vega.domain.model.update_event.UpdateEventRequestBody
import io.ktor.client.HttpClient
import io.ktor.client.request.delete
import io.ktor.client.request.get
import io.ktor.client.request.headers
import io.ktor.client.request.post
import io.ktor.client.request.put
import io.ktor.client.request.setBody
import io.ktor.client.request.url
import io.ktor.http.ContentType
import io.ktor.http.HttpHeaders
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

    override suspend fun getUser(endpoint: String, token: String) =
        httpClient.get {
            url(BASE_URL + endpoint)
            headers {
                append(HttpHeaders.Authorization, "${Constants.BEARER} $token")
            }
        }

    override suspend fun getEventDetails(endpoint: String, token: String) =
        httpClient.get(BASE_URL + endpoint) {
            url(BASE_URL + endpoint)
            contentType(ContentType.Application.Json)
            headers {
                append(HttpHeaders.Authorization, "${Constants.BEARER} $token")
            }
        }

    override suspend fun reserveEvent(endpoint: String, token: String) =
        httpClient.get(BASE_URL + endpoint) {
            url(BASE_URL + endpoint)
            contentType(ContentType.Application.Json)
            headers {
                append(HttpHeaders.Authorization, "${Constants.BEARER} $token")
            }
        }

    override suspend fun updateUser(
        endpoint: String,
        token: String,
        name: String,
        email: String,
        profilePicture: String
    ) = httpClient.put {
        url(BASE_URL + endpoint)
        headers {
            append(HttpHeaders.Authorization, "${Constants.BEARER} $token")
        }
        url {
            parameters.append(NAME, name)
            parameters.append(EMAIL, email)
            parameters.append(PROFILE_PICTURE, profilePicture)
        }
    }

    override suspend fun deleteEvent(endpoint: String, token: String) =
        httpClient.delete(BASE_URL + endpoint) {
            url(BASE_URL + endpoint)
            contentType(ContentType.Application.Json)
            headers {
                append(HttpHeaders.Authorization, "${Constants.BEARER} $token")
            }
        }

    override suspend fun updateEvent(
        endpoint: String,
        token: String,
        params: UpdateEventRequestBody
    ) = httpClient.put {
        url(BASE_URL + endpoint)
        headers {
            append(HttpHeaders.Authorization, "${Constants.BEARER} $token")
        }
        setBody(params)
    }

    override suspend fun getMyEvents(
        endpoint: String,
        token: String,
        page: Int,
        pageSize: Int
    ) = httpClient.get {
        url(BASE_URL + endpoint)
        url {
            parameters.append(PAGE_NUMBER, page.toString())
            parameters.append(PAGE_SIZE, pageSize.toString())
        }
        headers {
            append(HttpHeaders.Authorization, "${Constants.BEARER} $token")
        }
    }

    override suspend fun createEvent(
        endpoint: String,
        token: String,
        params: CreateEventRequestBody
    ) = httpClient.post {
        url(BASE_URL + endpoint)
        headers {
            append(HttpHeaders.Authorization, "${Constants.BEARER} $token")
        }
        setBody(params)
    }
}