package com.booleanuk;

public class Scrabble {
    String word;
    public Scrabble(String word) {
        StringBuilder sb = new StringBuilder();
        boolean doubleThing = false;
        boolean triple  = false;
        char lastBracket = '.';
        for (char c: word.toCharArray()) {
            String test = sb.toString();
            if (c == '{' && !doubleThing) {
                doubleThing = true;
                lastBracket = '{';
            } else if (c == '{' && doubleThing ) {
                break;
            } else if (c == '}' && doubleThing && lastBracket != '[') {
                doubleThing = false;
                lastBracket = '.';
            } else if (c == '}'&& !doubleThing) {
                doubleThing = true;
                break;
            } else if (c == '[' && !triple) {
                triple = true;
                lastBracket = '[';
            } else if (c == '[' && triple ) {
                break;
            } else if (c == ']' && triple && lastBracket != '{') {
                triple = false;
                lastBracket = '.';
            } else if (c == ']'&& !triple) {
                triple = true;
                break;
            } else if (doubleThing && triple) {
                sb.append(c);
                sb.append(c);
                sb.append(c);
                sb.append(c);
                sb.append(c);
                sb.append(c);
            } else if (doubleThing) {
                sb.append(c);
                sb.append(c);
            } else if (triple) {
                sb.append(c);
                sb.append(c);
                sb.append(c);
            }
            else {
                sb.append(c);
            }
        }
        if (!doubleThing && !triple) {
            this.word = sb.toString().toLowerCase();
        } else {
            this.word = "";
        }
    }

    public int score() {
        int score = 0;
        for (char c : word.toCharArray()){
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o'
                    || c == 'l' || c == 'n' || c == 'r' ||
                    c == 's' || c == 't' ||  c == 'u') {
                score  += 1;
            } else if (c == 'd' || c == 'g') {
                score += 2;
            } else if (c == 'b' || c == 'm' || c == 'c' || c == 'p'){
                score += 3;
            } else if (c == 'f' || c == 'h' || c == 'v' || c == 'w' || c == 'y') {
                score += 4;
            } else if (c == 'k') {
                score += 5;
            } else if (c == 'j' || c == 'x') {
                score += 8;
            } else if (c == 'q' || c == 'z') {
                score += 10;
            } else {
                score = 0;
                break;
            }
        }



        return score;
    }

}
