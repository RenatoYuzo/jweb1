package com.htcursos.util;

import java.io.BufferedReader;
import java.io.IOException;

public class JsonUtil {

	public static String lerJson(BufferedReader leitor) {
		// Ler o corpo da requisição
		StringBuffer json = new StringBuffer();
		String linha = "";

		try {
			linha = leitor.readLine();
			while (linha != null) {
				json.append(linha);
				linha = leitor.readLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		
		return json.toString();
		
	}

}
