package dino.ufrpe.tes.application.system.exception

data class IdNotFoundException(override val message: String?): RuntimeException(message)
