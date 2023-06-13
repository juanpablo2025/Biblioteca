package com.example.Biblioteca.Entidades;


import jakarta.persistence.*;

@Entity
@Table(name = "Ubicacion")
public class Ubicacion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "Piso",length = 10)

	private String Piso;

    @Column(name ="Salon",length = 10)
    private String Salon;

    @Column(name="Estante",length = 10)
    private String estante;

    @Transient
    private String mensajeError;

    public Ubicacion(Integer id, String piso, String salon, String estante) {
        this.id = id;
        Piso = piso;
        Salon = salon;
        this.estante = estante;
    }

    public Ubicacion() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPiso() {
        return Piso;
    }

    public void setPiso(String piso) {
        Piso = piso;
    }

    public String getSalon() {
        return Salon;
    }

    public void setSalon(String salon) {
        Salon = salon;
    }

    public String getEstante() {
        return estante;
    }

    public void setEstante(String estante) {
        this.estante = estante;
    }

    public String getMensajeError() {
        return mensajeError;
    }

    public void setMensajeError(String mensajeError) {
        this.mensajeError = mensajeError;
    }
}
