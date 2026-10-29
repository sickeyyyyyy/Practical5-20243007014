package com.example.practicalfive;

public class TextProcessor {
    public static String processMunicipality(String input) {
        if (input == null || input.trim().isEmpty()) {
            return null; // empty inout
        }
        String cleanInput = input.trim().toLowerCase();
        switch (cleanInput) {
            case "beijing": return "Beijing";
            case "shanghai": return "Shanghai";
            case "chongqing": return "Chongqing";
            case "tianjin": return "Tianjin";
            default: return null; // useless input
        }
    }
}
