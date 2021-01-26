package com.company;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

public class SHA256Helper {

    public static String generateHash(String data){
        String hexaString;
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hashByteArray = digest.digest(data.getBytes(StandardCharsets.UTF_8));
            hexaString = bytesToHash(hashByteArray);
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
        return hexaString;
    }

    public static String bytesToHash(byte[] byteArray){
        StringBuffer hexStringBuilder = new StringBuffer();

        for (int i = 0; i < byteArray.length; ++i){
            String hexa = Integer.toHexString(0xff & byteArray[i]);
            if (hexa.length() == 1) hexStringBuilder.append('0');
            hexStringBuilder.append(hexa);
        }
        return hexStringBuilder.toString();
    }

    public static String mergeHash(String data1, String data2){
        String concatenatedString = data1 + data2;
        String hexaString;
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hashByteArray = digest.digest(concatenatedString.getBytes(StandardCharsets.UTF_8));
            hexaString = bytesToHash(hashByteArray);
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
        return hexaString;
    }

}