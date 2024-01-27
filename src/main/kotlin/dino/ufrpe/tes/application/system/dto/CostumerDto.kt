package dino.ufrpe.tes.application.system.dto

import dino.ufrpe.tes.application.system.entity.Address
import dino.ufrpe.tes.application.system.entity.Customer

data class CostumerDto(
    val firstName: String,
    val lastName: String,
    val cpf: String,
    val email: String,
    val password: String,
    val postalCode: String,
    val street: String
) {
   fun toEntity(): Customer = Customer(
       firstName = this.firstName,
       lastName = this.lastName,
       cpf = this.cpf,
       email = this.email,
       password = this.password,
       address = Address(
           postalCode = this.postalCode,
           street = this.street
       )
   )
}