package com.yunidarifa.githubusers

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("search/users")
    @Headers("Authorization: token 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")
    fun getSearchUser(
        @Query("q") query: String
    ): Call<UserResponse>

    @GET("users/{username}")
    @Headers("Authorization: token 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")
    fun getUserDetail(
        @Path("username") username: String
    ): Call<DetailUserResponse>

    @GET("users/{username}/followers")
    @Headers("Authorization: token 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")
    fun getFollowers(
        @Path("username") username: String
    ): Call<ArrayList<User>>

    @GET("users/{username}/following")
    @Headers("Authorization: token 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")
    fun getFollowing(
        @Path("username") username: String
    ): Call<ArrayList<User>>
}