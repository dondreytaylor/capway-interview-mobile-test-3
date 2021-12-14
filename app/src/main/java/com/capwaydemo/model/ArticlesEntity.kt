package com.capwaydemo.model

data class ArticlesEntity(
    val title: String?,
    val author: String?,
    val publishedAt: String?,
    val urlToImage: String?,
    val content: String?,
    val mainArticleText: String?,
    val source: Source?,
    val description: String?
)

data class Source(
    val id: String,
    val name: String
)