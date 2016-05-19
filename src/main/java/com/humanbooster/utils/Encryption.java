package com.humanbooster.utils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

public class Encryption {
    public static String encryption(String toEncrypt){
        String generatingKey = UUID.randomUUID().toString().replaceAll("-", "").substring(0, 16);
        String encryptPassword;
        String encryptPasswordWithkey;
		try {
			encryptPassword = Encryption.encodSHA256(toEncrypt);
			encryptPasswordWithkey = Encryption.encodSHA256(String.valueOf(encryptPassword) + generatingKey);
			return "$SHA$" + generatingKey + "$" + encryptPasswordWithkey;
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return null;
		}
        
        
    }

    public static Boolean compareEncryption(String inBase, String inTest) {
        String[] decompose = inBase.split("\\$");
        String key = decompose[2];
        String keyCompose = decompose[3];
        String encodPassword;
        String encodPasswordWithKey;
		try {
			encodPassword = Encryption.encodSHA256(inTest);
			encodPasswordWithKey = Encryption.encodSHA256(String.valueOf(encodPassword) + key);
			if (keyCompose.equals(encodPasswordWithKey)) {
	            return true;
	        }
	        return false;
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}       
    }

    private static String encodSHA256(String mdp) throws NoSuchAlgorithmException {
        MessageDigest sha256 = MessageDigest.getInstance("SHA-256");
        sha256.reset();
        sha256.update(mdp.getBytes());
        byte[] digest = sha256.digest();
        return String.format("%0" + (digest.length << 1) + "x", new BigInteger(1, digest));
    }
}

