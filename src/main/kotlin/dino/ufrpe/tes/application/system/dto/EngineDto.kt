package dino.ufrpe.tes.application.system.dto

import dino.ufrpe.tes.application.system.entity.Engine
import dino.ufrpe.tes.application.system.entity.Customer
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import java.math.BigDecimal

data class EngineDto(
    @field:NotEmpty(message = "Por favor digite algo!") val manufacturer: String,
    @field:NotEmpty(message = "Por favor digite algo!") val nominationCode: String,
    @field:NotEmpty(message = "Por favor digite algo!") val name: String,
    @field:NotNull(message = "Por favor digite algo") val liter: BigDecimal,
    @field:NotNull(message = "Por favor digite algo") val cylinder: Int,
    @field:NotNull(message = "Por favor digite algo") val valves: Int,
    @field:NotEmpty(message = "Por favor digite algo!") val fuel: String,
    @field:NotNull(message = "Por favor digite algo") val price: BigDecimal,
    @field:NotNull(message = "Por favor digite algo") val customerId: Long
) {
    fun toEntity(): Engine = Engine(
        manufacturer = this.manufacturer,
        nominationCode = this.nominationCode,
        name = this.name,
        liter = this.liter,
        cylinder = this.cylinder,
        valves = this.valves,
        fuel = this.fuel,
        price = this.price,
        customer = Customer(id = -1))
}
