package dino.ufrpe.tes.application.system.repositories

import dino.ufrpe.tes.application.system.entity.Engine
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface EngineRepository: JpaRepository<Engine, Long>