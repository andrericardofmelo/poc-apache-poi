package com.poc.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/***
 * 
 * @author andre.melo
 * @Date 14/12/2018
 * @description Classe responsável pelo objeto aluno.
 *
 */

@Getter
@Setter
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
