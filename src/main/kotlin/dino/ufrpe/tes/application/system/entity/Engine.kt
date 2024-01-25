package dino.ufrpe.tes.application.system.entity

import dino.ufrpe.tes.application.system.entity.ennumeration.Status
import jakarta.persistence.*
import java.math.BigDecimal
import java.util.*

@Entity(name = "Motores")
data class Engine(
    @Column(nullable = false, unique = true) val engineNumber: UUID = UUID.randomUUID(),

    @Column(nullable = false) val price: BigDecimal = BigDecimal.ZERO,

    @Column(nullable = false) val manufacturer: String = "",

    @Column(nullable = false) val name: String = "",

    @Column(nullable = false) val nominationCode: String = "",

    @Column(nullable = false) val liter: BigDecimal = BigDecimal.ZERO,

    @Column(nullable = false) val cylinder: Int = 0,

    @Column(nullable = false) val valves: Int = 0,

    @Column(nullable = false) val fuel: String = "",

    @Enumerated val status: Status = Status.ARRIVING,

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) var id: Long? = null,

    @ManyToOne val customer: Customer? = null
)
