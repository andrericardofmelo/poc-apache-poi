package com.poc.main;

import java.io.IOException;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.poc.entity.Aluno;
import com.poc.service.AlunoService;
import com.poc.service.ArquivoService;

public class CriarExcel {
	public static void main(String[] args) throws IOException {
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheetAlunos = workbook.createSheet("Alunos");
		List<Aluno> listaAlunos = AlunoService.criaListaAlunos();
		ArquivoService.populaArquivo(sheetAlunos, listaAlunos);
		ArquivoService.criaNovoArquivo(workbook);
	}
}
