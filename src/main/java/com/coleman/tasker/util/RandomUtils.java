package com.coleman.tasker.util;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class RandomUtils {

    Random r = new Random();
    private final String characters="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0987654321098765432109876543210987654321098765432109876543210987654321098765432109876543210987654321";
    private final int charactersLength = characters.length();

    public String randomCharacters(int places) {
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < places; i++) {
            sb.append(characters.charAt(r.nextInt(charactersLength)));
        }
        return sb.toString();
    }
}
