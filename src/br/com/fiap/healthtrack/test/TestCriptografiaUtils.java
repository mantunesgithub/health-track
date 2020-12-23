package br.com.fiap.healthtrack.test;

import br.com.fiap.healthtrack.util.CriptografiaUtils;

public class TestCriptografiaUtils {

	public static void main(String[] args) {
		try {
			System.out.println(CriptografiaUtils.criptografar("123456"));
			System.out.println(CriptografiaUtils.criptografar("123456"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
