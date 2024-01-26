package dino.ufrpe.tes.application.system.entity

import jakarta.persistence.*

@Entity(name = "Clientes")
data class Customer(
    @Column(nullable = false) var firstName: String = "",

    @Column(nullable = false) var lastName: String = "",

    @Column(nullable = false, unique = true) val cpf: String = "",

    @Column(nullable = false, unique = true) var email: String = "",

    @Column(nullable = false) var password: String = "",

    @Column(nullable = false) @Embedded var address: Address = Address(),

    @Column(nullable = false) @OneToMany(fetch = FetchType.LAZY,         // essa anotação OneToMany é complicada
        cascade = arrayOf(CascadeType.REMOVE, CascadeType.PERSIST),      // precisa pesquisar melhor sobre ela
        mappedBy = "customer")                                           // lembrar de usar a ManyToOne na outra class
    var engines: List<Engine> = mutableListOf(),

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) var id: Long? = null
)
