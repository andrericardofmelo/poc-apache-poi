package br.com.desafio.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SaqueDTO {

	private int quantidade;
	private int cedula;
	
}
