package dino.ufrpe.tes.application.system.dto

import dino.ufrpe.tes.application.system.entity.Customer

data class CustomerUpdateDto(
    val firsName: String,
    val lastname: String,
    val postalCode: String,
    val street: String
) {
    fun toEntity(customer: Customer): Customer {
        customer.firstName = this.firsName
        customer.lastName = this.lastname
        customer.address.postalCode = this.postalCode
        customer.address.street = this.street
        return customer
    }
}