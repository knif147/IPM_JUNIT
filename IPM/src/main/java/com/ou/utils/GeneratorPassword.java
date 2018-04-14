package com.ou.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public final class GeneratorPassword {
	private static final int LENGTH = 8;
	private static final String LOWER = "abcdefghijklmnopqrstuvwxyz";
    private static final String UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String DIGITS = "0123456789";
    private static final String PUNCTUATION = "!@#$%&*?><";
    
    public static String generate() {
    	StringBuilder password = new StringBuilder(LENGTH);
        Random random = new Random(System.nanoTime());
        
        List<String> charCategories = new ArrayList<String>();
        charCategories.add(LOWER);
        charCategories.add(UPPER);
        charCategories.add(DIGITS);
        charCategories.add(PUNCTUATION);
        
        String charCategory = null;
        int position = 0;
        for (int i = 0; i < LENGTH; i++) {
            charCategory = charCategories.get(random.nextInt(charCategories.size()));
            position = random.nextInt(charCategory.length());
            password.append(charCategory.charAt(position));
        }
        
        return new String(password);
    }
}
