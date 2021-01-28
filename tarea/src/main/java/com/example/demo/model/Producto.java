package com.example.demo.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
public class Producto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idProducto;

	@Size(min=5, message = "{producto.nombre.size}" )
	@Column(name = "nombre", nullable = false, length = 100)
	private String nombre;
	
	@Size(min=5, message = "{producto.marca.size}" )
	@Column(name = "marca", nullable = false, length = 100)
	private String marca;
	
	
	@OneToMany(mappedBy = "producto", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<DetalleVenta> detalleVentas;
}
