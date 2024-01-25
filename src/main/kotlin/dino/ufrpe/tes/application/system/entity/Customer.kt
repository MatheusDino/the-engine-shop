package dino.ufrpe.tes.application.system.entity

data class Customer(
    var firstName: String = "",
    var lastName: String = "",
    val cpf: String = "",
    var email: String = "",
    var password: String = "",
    var address: Address = Address(),
    var engines: List<Engine> = mutableListOf(),
    var id: Long? = null
)
