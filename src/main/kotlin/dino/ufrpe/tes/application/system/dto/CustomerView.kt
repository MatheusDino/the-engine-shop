package dino.ufrpe.tes.application.system.dto

import dino.ufrpe.tes.application.system.entity.Customer

data class CustomerView(
    val firstName: String,
    val lastname: String,
    val cpf: String,
    val email: String,
    val postalCode: String,
    val street: String
) {
    constructor(customer: Customer): this (
        firstName = customer.firstName,
        lastname = customer.lastName,
        cpf = customer.cpf,
        email = customer.email,
        postalCode = customer.address.postalCode,
        street = customer.address.street
    )
}