package com.poc.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class Excel {

	public static final String newFileName = "C:/teste/novo.xls";

	public static HSSFWorkbook abreValidaArquivo() throws IOException {
		FileInputStream arquivo = new FileInputStream(new File(newFileName));
		return new HSSFWorkbook(arquivo);
	}
}
