package br.com.fiap.services;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import br.com.fiap.interfaces.ICryptographyService;

public class CryptographyService implements ICryptographyService{
	
	public CryptographyService() {};
	
	public String GenerateMD5Hash(String input) {
		try {
            // Cria uma instância do MessageDigest para MD5
            MessageDigest md5 = MessageDigest.getInstance("MD5");

            // Converte o input para bytes
            byte[] inputBytes = input.getBytes("ASCII");

            // Calcula o hash
            byte[] hashBytes = md5.digest(inputBytes);

            // Constrói a string hexadecimal
            StringBuilder sb = new StringBuilder();
            for (byte b : hashBytes) {
                sb.append(String.format("%02X", b));
            }

            return sb.toString();

        } catch (NoSuchAlgorithmException e) { 
            throw new RuntimeException("No such algorithm: MD5", e);
            
        } catch (java.io.UnsupportedEncodingException e) {
            throw new RuntimeException("Unsupported encoding: ASCII", e);
            
        }
	}

}
