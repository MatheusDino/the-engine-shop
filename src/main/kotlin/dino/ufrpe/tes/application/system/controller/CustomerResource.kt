package dino.ufrpe.tes.application.system.controller

import dino.ufrpe.tes.application.system.dto.CostumerDto
import dino.ufrpe.tes.application.system.dto.CustomerUpdateDto
import dino.ufrpe.tes.application.system.dto.CustomerView
import dino.ufrpe.tes.application.system.entity.Customer
import dino.ufrpe.tes.application.system.service.implementation.CustomerService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/customers")
class CustomerResource(
    private val customerService: CustomerService
) {

    @PostMapping
    fun saveCustomer(@RequestBody @Valid customerDto: CostumerDto): ResponseEntity<String> {
        val savedCustomer = (this.customerService.saveCustomer(customerDto.toEntity()))
        return ResponseEntity.status(HttpStatus.CREATED)
            .body("Cliente ${savedCustomer.firstName} ${savedCustomer.lastName} cadastrado com sucesso!")
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): ResponseEntity<CustomerView> {
        val customer: Customer = this.customerService.findById(id)
        return ResponseEntity.status(HttpStatus.OK).body(CustomerView(customer))
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    fun deleteCustomer(@PathVariable id: Long) = this.customerService.delete(id)

    @PatchMapping
    fun updateCustomer(
        @RequestParam(value = "customerID") id: Long,
        @RequestBody @Valid customerUpdateDto: CustomerUpdateDto
    ): ResponseEntity<CustomerView> {
        val customer: Customer = this.customerService.findById(id)
        val customerUpdating: Customer = customerUpdateDto.toEntity(customer)
        val customerUpdated: Customer = this.customerService.saveCustomer(customerUpdating)
        return ResponseEntity.status(HttpStatus.OK).body(CustomerView(customerUpdated))
    }
}