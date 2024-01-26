package dino.ufrpe.tes.application.system.service

import dino.ufrpe.tes.application.system.entity.Customer

interface InCustomerService {

    fun saveCustomer(customer: Customer): Customer

    fun findById(id: Long): Customer

    fun delete(id: Long)


}