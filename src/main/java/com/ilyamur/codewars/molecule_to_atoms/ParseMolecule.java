package com.ilyamur.codewars.molecule_to_atoms;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

class ParseMolecule {

    private static final Pattern PATTERN_ELEMENT = Pattern.compile("([A-Z][a-z]?)(\\d+)?");

    private static final List<Pattern> PATTERNS_PARENTHESES = Arrays.asList(
            getParenthesesPattern('(', ')'),
            getParenthesesPattern('{', '}'),
            getParenthesesPattern('[', ']')
    );

    private static Pattern getParenthesesPattern(char left, char right) {
        return Pattern.compile("\\" + left + "([^()]*)\\" + right + "(\\d+)?");
    }

    public static void main(String[] args) {
        Map<String, Integer> atoms = getAtoms("K4[ON(SO3)2]2");
    }

    public static Map<String, Integer> getAtoms(String formula) {

        if (formula.matches(".*[a-z]{2,}.*")) {
            throw new IllegalArgumentException();
        }

        String explodedFormula = explodeParentheses(formula);

        if (Stream.of("(", ")", "{", "}", "[", "]").anyMatch(explodedFormula::contains)) {
            throw new IllegalArgumentException();
        }

        Map<String, Integer> map = new HashMap<>();

        Matcher m = PATTERN_ELEMENT.matcher(explodedFormula);
        int sz = 0;
        while (m.find()) {
            sz++;
            if (sz > 100) {
                throw new RuntimeException();
            }
            String elementName = m.group(1);
            Integer elementCount = map.get(elementName);
            if (elementCount == null) {
                elementCount = 0;
            }
            elementCount += toCount(m.group(2));
            map.put(elementName, elementCount);
        }

        return map;
    }

    private static String explodeParentheses(String formula) {
        String explodedFormula = formula;
        String prevExplodedFormula = formula;
        int sz = 0;
        while (true) {
            sz++;
            if (sz > 100) {
                throw new RuntimeException();
            }
            for (Pattern pattern : PATTERNS_PARENTHESES) {
                explodedFormula = explodeParentheses(explodedFormula, pattern);
            }
            if (prevExplodedFormula.equals(explodedFormula)) {
                break;
            }
            prevExplodedFormula = explodedFormula;
        }
        return explodedFormula;
    }

    private static String explodeParentheses(String formula, Pattern pattern) {
        StringBuffer sb = new StringBuffer();
        Matcher m = pattern.matcher(formula);
        int sz = 0;
        while (m.find()) {
            sz++;
            if (sz > 100) {
                throw new RuntimeException();
            }
            String explodedSubformula = m.group(1);
            int repeatTimes = toCount(m.group(2));
            String replacement = repeat(explodedSubformula, repeatTimes);
            m.appendReplacement(sb, replacement);
        }
        m.appendTail(sb);
        return sb.toString();
    }

    private static String repeat(String s, int times) {
        StringBuilder repeatedString = new StringBuilder();
        for (int i = 0; i < times; i++) {
            repeatedString.append(s);
        }
        return repeatedString.toString();
    }

    private static int toCount(String countRepr) {
        return (countRepr != null) ? Integer.valueOf(countRepr) : 1;
    }
}
