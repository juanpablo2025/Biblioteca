package com.example.Biblioteca.Entidades;


import jakarta.persistence.*;

@Entity
@Table(name = "Ubicacion")
public class Ubicacion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
    
	@Column(name = "Piso",max=20)
    /*@Size(20)  varchar ?*/
	private String Piso;
    @Lob
    @Column(name ="Salon",max=20)
    final String Salon;

    @Column(name="Estante",max=20)
    private String estante;

}
