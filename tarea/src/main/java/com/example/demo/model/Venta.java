package com.example.demo.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
public class Venta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idVenta;
	
	@NotEmpty(message = "{venta.fecha}")
	@Column(name = "fecha", nullable = false)
	private LocalDateTime fecha;
	
	@ManyToOne
	@JoinColumn(name = "id_persona", nullable = false, foreignKey = @ForeignKey(name = "FK_consolta_persona"))
	private Persona persona;
	
	@NotEmpty(message = "{venta.importe}")
	@Column(name = "importe", nullable = false)
	private Float importe;
	
	@OneToMany(mappedBy = "venta",cascade = CascadeType.ALL, orphanRemoval = true)
	private List<DetalleVenta> detalleVentas;
}
