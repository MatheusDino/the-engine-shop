package dino.ufrpe.tes.application.system.controller

import dino.ufrpe.tes.application.system.dto.EngineDto
import dino.ufrpe.tes.application.system.dto.EngineView
import dino.ufrpe.tes.application.system.dto.EngineViewList
import dino.ufrpe.tes.application.system.entity.Engine
import dino.ufrpe.tes.application.system.service.implementation.EngineService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController
import java.util.UUID
import java.util.stream.Collectors

@RestController
@RequestMapping("/api/engines")
class EngineResource(
    private val engineService: EngineService
) {

    @PostMapping
    fun saveEngine(@RequestBody @Valid engineDto: EngineDto): ResponseEntity<String> {
        val engine: Engine = this.engineService.saveEngine(engineDto.toEntity())
        return ResponseEntity.status(HttpStatus.CREATED)
            .body("Motor ${engine.nominationCode} ${engine.name} cadastrado com sucesso!")
    }

    @GetMapping
    fun findAllByCustomerId(@RequestParam(value = "customerId") customerId: Long): ResponseEntity<List<EngineViewList>> {
        val engineViewList: List<EngineViewList> =
            this.engineService.findAllByCustomer(customerId).stream().map { engine: Engine -> EngineViewList(engine) }
                .collect(Collectors.toList())
        return ResponseEntity.status(HttpStatus.OK).body(engineViewList)
    }

    @GetMapping("/{engineNumber}")
    fun findByEngineNumber(
        @RequestParam(value = "customerId") customerId: Long,
        @PathVariable engineNumber: UUID
    ): ResponseEntity<EngineView> {
        val engine: Engine = this.engineService.findByEngineNumber(customerId, engineNumber)
        return ResponseEntity.status(HttpStatus.OK).body(EngineView(engine))
    }
}