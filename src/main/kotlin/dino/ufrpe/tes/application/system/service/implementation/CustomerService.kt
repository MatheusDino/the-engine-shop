package dino.ufrpe.tes.application.system.service.implementation

import dino.ufrpe.tes.application.system.entity.Customer
import dino.ufrpe.tes.application.system.repositories.CustomerRepository
import dino.ufrpe.tes.application.system.service.InCustomerService
import org.springframework.stereotype.Service

@Service
class CustomerService(private val customerRepo: CustomerRepository): InCustomerService {

    override fun saveCustomer(customer: Customer): Customer =
        this.customerRepo.save(customer)


    override fun findById(id: Long): Customer =
        this.customerRepo.findById(id).orElseThrow {
            RuntimeException("O ID $id não foi encontrado. ")
        }


    override fun delete(id: Long) = this.customerRepo.deleteById(id)

}