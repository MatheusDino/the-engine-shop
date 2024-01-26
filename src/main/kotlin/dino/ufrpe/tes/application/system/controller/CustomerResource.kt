package dino.ufrpe.tes.application.system.controller

import dino.ufrpe.tes.application.system.dto.CostumerDto
import dino.ufrpe.tes.application.system.dto.CustomerView
import dino.ufrpe.tes.application.system.entity.Customer
import dino.ufrpe.tes.application.system.service.implementation.CustomerService
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/customers")
class CustomerResource(
    private val customerService: CustomerService
) {

    @PostMapping
    fun saveCustomer(@RequestBody customerDto: CostumerDto): String {
       val savedCustomer = (this.customerService.saveCustomer(customerDto.toEntity()))
        return "Cliente ${savedCustomer.firstName} ${savedCustomer.lastName} cadastrado com sucesso!"
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): CustomerView {
        val customer: Customer = this.customerService.findById(id)
        return CustomerView(customer)
    }

    @DeleteMapping("/{id}")
    fun deleteCustomer(@PathVariable id: Long) = this.customerService.delete(id)
}