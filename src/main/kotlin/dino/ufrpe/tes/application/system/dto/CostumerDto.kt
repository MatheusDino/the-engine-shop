package dino.ufrpe.tes.application.system.dto

import dino.ufrpe.tes.application.system.entity.Address
import dino.ufrpe.tes.application.system.entity.Customer
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotEmpty
import org.hibernate.validator.constraints.br.CPF

data class CostumerDto(
    @field:NotEmpty(message = "Por favor digite algo!") val firstName: String,
    @field:NotEmpty(message = "Por favor digite algo!") val lastName: String,
    @field:CPF(message = "Por favor insira um CPF válido") val cpf: String,
    @field:Email(message = "Por favor digite um e-mail válido!")
    @field:NotEmpty(message = "Por favor digite algo!") val email: String,
    @field:NotEmpty(message = "Por favor digite algo!") val password: String,
    @field:NotEmpty(message = "Por favor digite algo!") val postalCode: String,
    @field:NotEmpty(message = "Por favor digite algo!") val street: String
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