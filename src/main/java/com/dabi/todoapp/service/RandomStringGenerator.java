package com.dabi.todoapp.service;

import org.springframework.stereotype.Service;

@Service
public class RandomStringGenerator {

    public String getAlphaNumericString(int n)
    {

        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "0123456789"
                + "abcdefghijklmnopqrstuvxyz";

        StringBuilder sb = new StringBuilder(n);

        for (int i = 0; i < n; i++) {

            int index
                    = (int)(AlphaNumericString.length()
                    * Math.random());

            sb.append(AlphaNumericString
                    .charAt(index));
        }

        return sb.toString();
    }


    public String linkCreator( String activationCode, String path){
        //String activationCode = getAlphaNumericString(20);
        String link = path + "/userValidation" + "?" + "activationCode=" + activationCode;

        return link;
    }
}
