package com.coded.spring.ordering.model

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "orders")
class Order(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
    
    @Column(name = "user_id", nullable = false)
    var user: String,
    
    @Column(nullable = false)
    var restaurant: String,
    
    @OneToMany(mappedBy = "order", cascade = [CascadeType.ALL], orphanRemoval = true)
    var items: MutableList<OrderItem> = mutableListOf(),
    
    @Column(name = "created_at", nullable = false)
    var createdAt: LocalDateTime = LocalDateTime.now()
) {
    // Required by JPA
    constructor() : this(
        id = null,
        user = "",
        restaurant = "",
        items = mutableListOf(),
        createdAt = LocalDateTime.now()
    )

    fun addItem(item: String) {
        val orderItem = OrderItem(item = item, order = this)
        items.add(orderItem)
    }
} 