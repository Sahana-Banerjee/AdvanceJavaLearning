package org.example;

import java.util.stream.Stream;

public class CeaserEncryptDecrypt {
    /**
     *
     * @param s
     * @param shiftKey
     * Given an encrypted string s and an integer k, decrypt each character of the
     * string by finding the kth character behind it. Eg: str=kumar & k=3 then ans=hrjxo
     */
    public static void decryptString(String s, int shiftKey){
        final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
        String decryptStr = "", encStr = "";
        for (int i=0; i<s.length(); i++){
            int pos = ALPHABET.indexOf(s.charAt(i));
            int decryptPos = (pos - shiftKey);
            //At the time of handling decryption is important to handle -ve mod scenario.
            int decryptMod = decryptPos >= 0 ? decryptPos% 26 : (26+decryptPos)%26 ;// this gives the decryptpos
            char decryptChar = ALPHABET.charAt(decryptMod);
            decryptStr+=decryptChar;


            int encPos = (pos + shiftKey)%26;
            char encChar = ALPHABET.charAt(encPos);
            encStr += encChar;

        }

        System.out.println(s+ ":" + decryptStr+ " :"+ encStr);

    }

    public static void main(String[] args) {
        decryptString("sahana", 3);
    }
}
