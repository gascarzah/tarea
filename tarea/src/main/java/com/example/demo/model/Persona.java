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

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
public class Persona {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPersona;
	
	@Schema(description = "nombres de la persona")
	@Size(min=3, message = "{persona.nombres}" )
	@Column(name = "nombres", nullable = false, length = 100)
	private String nombres;
	
	@Size(min=3, message = "{persona.size}" )
	@Column(name = "apellidos", nullable = false, length = 100)
	private String apellidos;

	
	@OneToMany(mappedBy = "persona",cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Venta> ventas;
}
