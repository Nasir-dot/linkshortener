package com.linkshortener;
import java.util.HashMap;
import java.util.Random;
public class LinkShortener {
        private static final String BASE_URL = "http://short.ly/";
        private static final String CHARACTERS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        private static final int SHORT_URL_LENGTH = 6;
        private HashMap<String, String> urlMap = new HashMap<>();
        private HashMap<String, String> reverseMap = new HashMap<>();
        private Random random = new Random();

        // Method to generate a short URL
        public String shortenURL(String longURL) {
            if (reverseMap.containsKey(longURL)) {
                return BASE_URL + reverseMap.get(longURL);
            }

            String shortKey;
            do {
                shortKey = generateRandomKey();
            } while (urlMap.containsKey(shortKey));

            urlMap.put(shortKey, longURL);
            reverseMap.put(longURL, shortKey);

            return BASE_URL + shortKey;
        }

        // Method to retrieve the original URL
        public String expandURL(String shortURL) {
            String key = shortURL.replace(BASE_URL, "");
            return urlMap.getOrDefault(key, "URL not found");
        }

        // Helper method to generate a random key
        private String generateRandomKey() {
            StringBuilder key = new StringBuilder();
            for (int i = 0; i < SHORT_URL_LENGTH; i++) {
                key.append(CHARACTERS.charAt(random.nextInt(CHARACTERS.length())));
            }
            return key.toString();
        }


}
