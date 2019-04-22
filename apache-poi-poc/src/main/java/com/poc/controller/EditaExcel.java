package com.poc.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import com.poc.util.Constantes;

/***
 * 
 * @author andre.melo
 * @Date 14/12/2018
 * @description Classe responsável por abrir um arquivo excel, ler os dados,
 *              atualizar as informações e gerar um novo arquivo atualizado.
 *
 */
@SuppressWarnings("resource")
public class EditaExcel {

	public static void main(String[] args) throws IOException {

		try {
			// Abrindo o arquivo.
			FileInputStream file = new FileInputStream(new File(Constantes.newFileName));

			// Validando se o arquivo é ou não um arquivo excel.
			HSSFWorkbook workbook = new HSSFWorkbook(file);

			// Abrindo a planilha com índice 0.
			HSSFSheet sheetAlunos = workbook.getSheetAt(0);

			// Trecho que percorre todas as linhas para atualizar valores.
			for (int i = 0; i < sheetAlunos.getPhysicalNumberOfRows(); i++) {

				Row row = sheetAlunos.getRow(i);
				Cell cellNota1 = row.getCell(2);
				if (cellNota1.getNumericCellValue() < 9) {
					cellNota1.setCellValue(cellNota1.getNumericCellValue() + 1);
				} else {
					cellNota1.setCellValue(10);
				}
				Cell cellNota2 = row.getCell(3);
				Cell cellMedia = row.getCell(4);
				cellMedia.setCellValue((cellNota1.getNumericCellValue() + cellNota2.getNumericCellValue()) / 2);
				Cell cellAprovado = row.getCell(5);
				cellAprovado.setCellValue(cellMedia.getNumericCellValue() >= 6);
			}

			file.close();

			// Cria um novo arquivo atualizado.
			FileOutputStream outFile = new FileOutputStream(new File(Constantes.newFileName));
			workbook.write(outFile);
			outFile.close();
			System.out.println("Arquivo Excel editado com sucesso!");

		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("Arquivo Excel não encontrado!");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Erro na edição do arquivo!");
		}

	}
}
