package dino.ufrpe.tes.application.system.dto

import dino.ufrpe.tes.application.system.entity.Customer
import jakarta.validation.constraints.NotEmpty

data class CustomerUpdateDto(
    @field:NotEmpty(message = "Por favor digite algo!") val firstName: String,
    @field:NotEmpty(message = "Por favor digite algo!") val lastName: String,
    @field:NotEmpty(message = "Por favor digite algo!") val postalCode: String,
    @field:NotEmpty(message = "Por favor digite algo!") val street: String
) {
    fun toEntity(customer: Customer): Customer {
        customer.firstName = this.firstName
        customer.lastName = this.lastName
        customer.address.postalCode = this.postalCode
        customer.address.street = this.street
        return customer
    }
}