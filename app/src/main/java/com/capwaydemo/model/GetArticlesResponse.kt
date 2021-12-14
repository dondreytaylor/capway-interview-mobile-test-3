package com.capwaydemo.model

data class GetArticlesResponse(
    val status: String,
    val articles: List<ArticlesEntity>
)
