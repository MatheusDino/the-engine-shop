package dino.ufrpe.tes.application.system.controller

import dino.ufrpe.tes.application.system.dto.CostumerDto
import dino.ufrpe.tes.application.system.service.implementation.CustomerService
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
}