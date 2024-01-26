package dino.ufrpe.tes.application.system.service

import java.util.*

interface InEngineService {

    fun saveEngine(engine: dino.ufrpe.tes.application.system.entity.Engine): dino.ufrpe.tes.application.system.entity.Engine

    fun findAllByCustomer(customerId: Long): List<dino.ufrpe.tes.application.system.entity.Engine>

    fun findByEngineNumber(customerId: Long, engineNumber: UUID): dino.ufrpe.tes.application.system.entity.Engine
}