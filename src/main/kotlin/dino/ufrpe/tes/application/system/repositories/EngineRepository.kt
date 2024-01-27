package dino.ufrpe.tes.application.system.repositories

import dino.ufrpe.tes.application.system.entity.Engine
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface EngineRepository: JpaRepository<Engine, Long> {
    fun findByEngineNumber(engineNumber: UUID): Engine?

    @Query(value = "SELECT * FROM MOTORES WHERE CUSTOMER_ID = ?1", nativeQuery = true)
    fun findAllByCostumerID(customerId: Long): List<Engine>
}