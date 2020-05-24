package com.poc.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Aluno {

	private String nome;
	private String ra;
	private double nota1;
	private double nota2;
	private double media;
	private boolean aprovado;
}
