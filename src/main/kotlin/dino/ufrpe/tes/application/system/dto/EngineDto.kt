package dino.ufrpe.tes.application.system.dto

import dino.ufrpe.tes.application.system.entity.Engine
import dino.ufrpe.tes.application.system.entity.Customer
import java.math.BigDecimal

data class EngineDto(
    val manufacturer: String,
    val nominationCode: String,
    val name: String,
    val liter: BigDecimal,
    val cylinder: Int,
    val valves: Int,
    val fuel: String,
    val price: BigDecimal,
    val customerId: Long
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
