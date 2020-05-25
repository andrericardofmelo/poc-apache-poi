package com.poc.main;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.poc.domain.Constantes;
import com.poc.service.ArquivoService;

public class EditarExcel {

	public static void main(String[] args) throws IOException {
		FileInputStream arquivo = new FileInputStream(new File(Constantes.FILE_NAME));
		HSSFWorkbook workbook = new HSSFWorkbook(arquivo);
		HSSFSheet sheetAlunos = workbook.getSheetAt(0);
		ArquivoService.AlteraArquivo(sheetAlunos);
		ArquivoService.criaNovoArquivo(workbook);
	}

}
