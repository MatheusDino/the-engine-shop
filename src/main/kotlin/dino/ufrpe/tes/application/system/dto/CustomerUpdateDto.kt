package dino.ufrpe.tes.application.system.dto

import dino.ufrpe.tes.application.system.entity.Customer

data class CustomerUpdateDto(
    val firstName: String,
    val lastName: String,
    val postalCode: String,
    val street: String
) {
    fun toEntity(customer: Customer): Customer {
        customer.firstName = this.firstName
        customer.lastName = this.lastName
        customer.address.postalCode = this.postalCode
        customer.address.street = this.street
        return customer
    }
}