package com.yunidarifa.githubusers

import com.google.gson.annotations.SerializedName


data class User(

    @field: SerializedName("login")
    val login: String,

    @field: SerializedName("id")
    val id: Int,

    @field: SerializedName("avatar_url")
    val avatar_url: String,

    @field: SerializedName("html_url")
    val html_url: String
)
