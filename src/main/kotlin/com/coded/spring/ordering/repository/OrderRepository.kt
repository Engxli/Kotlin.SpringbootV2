package com.coded.spring.ordering.repository

import com.coded.spring.ordering.model.Order
import org.springframework.data.jpa.repository.JpaRepository

interface OrderRepository : JpaRepository<Order, Long> {
    fun findAllByOrderByCreatedAtAsc(): List<Order>
} 