package dino.ufrpe.tes.application.system.service.implementation

import dino.ufrpe.tes.application.system.entity.Engine
import dino.ufrpe.tes.application.system.exception.IdNotFoundException
import dino.ufrpe.tes.application.system.repositories.EngineRepository
import dino.ufrpe.tes.application.system.service.InEngineService
import org.springframework.stereotype.Service
import java.util.*

@Service
class EngineService(
    private val engineRepo: EngineRepository,
    private val customerService: CustomerService
): InEngineService {

    override fun saveEngine(engine: Engine): Engine {
        engine.apply {
            customer = customerService.findById(engine.customer?.id!!)
        }
        return this.engineRepo.save(engine)
    }

    override fun findAllByCustomer(customerId: Long): List<Engine> = this.engineRepo.findAllByCostumerID(customerId)

    override fun findByEngineNumber(customerId: Long, engineNumber: UUID): Engine {
        val engine: Engine = (this.engineRepo.findByEngineNumber(engineNumber)
            ?: throw IdNotFoundException("O número de motor $engineNumber não existe."))
        return if (engine.customer?.id == customerId) engine else throw IllegalArgumentException("Algo está errado. Por favor entre em contato com o suporte.")
    }
}