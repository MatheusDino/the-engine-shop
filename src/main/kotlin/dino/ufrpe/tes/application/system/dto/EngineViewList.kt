package dino.ufrpe.tes.application.system.dto

import dino.ufrpe.tes.application.system.entity.Engine
import java.math.BigDecimal
import java.util.UUID

data class EngineViewList(
    val engineNumber: UUID,
    val manufacturer: String,
    val nominationCode: String,
    val name: String,
    val liter: BigDecimal,
    val cylinder: Int,
    val valves: Int,
    val fuel: String,
    val price: BigDecimal
) {
    constructor(engine: Engine): this(
        engineNumber = engine.engineNumber,
        manufacturer = engine.manufacturer,
        nominationCode = engine.nominationCode,
        name = engine.name,
        liter = engine.liter,
        cylinder = engine.cylinder,
        valves = engine.valves,
        fuel = engine.fuel,
        price = engine.price
    )
}
