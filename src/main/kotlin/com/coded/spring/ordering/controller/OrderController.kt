package com.coded.spring.ordering.controller

import com.coded.spring.ordering.dto.OrderRequest
import com.coded.spring.ordering.model.Order
import com.coded.spring.ordering.repository.OrderRepository
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/orders")
class OrderController(private val orderRepository: OrderRepository) {

    @PostMapping
    fun createOrder(@RequestBody request: OrderRequest): ResponseEntity<Order> {
        val order = Order(
            user = request.user,
            restaurant = request.restaurant
        )
        // Add items to the order
        request.items.forEach { order.addItem(it) }
        
        val savedOrder = orderRepository.save(order)
        return ResponseEntity.ok(savedOrder)
    }

    @GetMapping
    fun listOrders(): ResponseEntity<List<Order>> {
        val orders = orderRepository.findAllByOrderByCreatedAtAsc()
        return ResponseEntity.ok(orders)
    }
} 