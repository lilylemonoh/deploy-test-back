package com.spring.config;

import org.assertj.core.api.Assertions;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class JasyptConfigTest {

    @Test
    public void jasypt(){
        // chat
        String secretKey = "jR1hVT0x5RFRTaVhmVHJOdFRQT2R2dkFxZEpiTGtyTFU=";
        String apiUrl = "https://ux4fajy2l5.apigw.ntruss.com/custom/v1/11690/63de699b1c48db0fd22aa85437c723dd2e47de3dacf31dcd2ef6bcbd52b769f3";



        String username = "https://ux4fajy2l5.apigw.ntruss.com/custom/v1/11690/63de699b1c48db0fd22aa85437c723dd2e47de3dacf31dcd2ef6bcbd52b769f3";
        String password = "1234";

        String encryptUrl = jasyptEncrypt(secretKey);
        String encryptUsername = jasyptEncrypt(apiUrl);

        System.out.println("encryptUrl : " + encryptUrl);
        System.out.println("encryptUsername : " + encryptUsername);

        Assertions.assertThat(secretKey).isEqualTo(jasyptDecryt(encryptUrl));
    }

    private String jasyptEncrypt(String input) {
        StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
        return encryptor.encrypt(input);
    }

    private String jasyptDecryt(String input){
        StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
        return encryptor.decrypt(input);
    }


}