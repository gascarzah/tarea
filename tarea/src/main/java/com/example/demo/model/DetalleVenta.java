package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "detalle_venta")
@AllArgsConstructor
@NoArgsConstructor
public class DetalleVenta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idDetalleVenta;
	
	@ManyToOne
	@JoinColumn(name = "id_venta", nullable = false, foreignKey = @ForeignKey(name = "FK_detalle_venta"))
	private Venta venta;
	
	@ManyToOne
	@JoinColumn(name = "id_producto", nullable = false, foreignKey = @ForeignKey(name = "FK_detalle_producto"))
	private Producto producto;
	
	@Column(name = "cantidad", nullable = false)
	private Integer cantidad;
}
