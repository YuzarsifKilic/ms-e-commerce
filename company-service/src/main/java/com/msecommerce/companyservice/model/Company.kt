package com.msecommerce.companyservice.model

import jakarta.persistence.Column
import jakarta.persistence.ElementCollection
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import org.hibernate.annotations.GenericGenerator

@Entity
data class Company @JvmOverloads constructor(

    @Id
    @Column(name = "company_id")
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    val id: String? = "",
    val companyName: String,
    val email: String,
    val webSite: String,

    @ElementCollection
    val productList: List<String> = ArrayList()
)
