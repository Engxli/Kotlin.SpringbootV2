package com.coded.spring.ordering.dto

data class OrderRequest(
    val user: String,
    val restaurant: String,
    val items: List<String>
) 