package dino.ufrpe.tes.application.system.entity

import dino.ufrpe.tes.application.system.entity.ennumeration.Status
import java.math.BigDecimal
import java.util.*

data class Engine(
    val engineNumber: UUID = UUID.randomUUID(),
    val price: BigDecimal = BigDecimal.ZERO,
    val manufacturer: String = "",
    val name: String = "",
    val nominationCode: String = "",
    val liter: BigDecimal = BigDecimal.ZERO,
    val cylinder: Int = 0,
    val valves: Int = 0,
    val fuel: String = "",
    val status: Status = Status.ARRIVING,
    val id: Long? = null,
    val customer: Customer? = null
)
