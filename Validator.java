import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * Parses and validates text-based representations of binary trees and hash maps.
 *
 * Binary Tree format: (value left right) where _ = null, value = integer
 *   Example: (10 (5 (3 _ _) (7 _ _)) (15 (12 _ _) (20 _ _)))
 *
 * Hash Map format: key: value (one per line)
 *   Example:
 *     name: Alice
 *     age: 30
 */
public class Validator {

    // Tree node

    static class TreeNode {
        int value;
        TreeNode left, right;
        TreeNode(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    // File I/O

    /** Reads an entire text file into a single String. */
    public static String readFile(String path) throws IOException {
        StringBuilder sb = new StringBuilder();
        Scanner scanner = new Scanner(new File(path));
        while (scanner.hasNextLine()) {
            if (sb.length() > 0) sb.append("\n");
            sb.append(scanner.nextLine());
        }
        scanner.close();
        return sb.toString();
    }

    // Binary tree parsing

    private static int parsePos;

    /**
     * Parses a binary tree from parenthesized notation.
     * Throws IllegalArgumentException on any syntax error.
     */
    public static TreeNode parseBinaryTree(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("Input is null or empty");
        }
        parsePos = 0;
        String s = input.trim();
        TreeNode root = parseTreeNode(s);
        skipSpaces(s);
        if (parsePos != s.length()) {
            throw new IllegalArgumentException(
                "Unexpected characters after tree at position " + parsePos);
        }
        return root;
    }

    private static TreeNode parseTreeNode(String s) {
        skipSpaces(s);
        if (parsePos >= s.length()) {
            throw new IllegalArgumentException("Unexpected end of input");
        }
        // Null node
        if (s.charAt(parsePos) == '_') {
            parsePos++;
            return null;
        }
        // Must start with '('
        if (s.charAt(parsePos) != '(') {
            throw new IllegalArgumentException(
                "Expected '(' or '_' at position " + parsePos);
        }
        parsePos++;
        skipSpaces(s);

        // Parse integer value
        int start = parsePos;
        if (parsePos < s.length()
                && (s.charAt(parsePos) == '-' || s.charAt(parsePos) == '+')) {
            parsePos++;
        }
        while (parsePos < s.length() && Character.isDigit(s.charAt(parsePos))) {
            parsePos++;
        }
        if (parsePos == start) {
            throw new IllegalArgumentException(
                "Expected integer value at position " + start);
        }
        int value;
        try {
            value = Integer.parseInt(s.substring(start, parsePos));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(
                "Invalid integer: " + s.substring(start, parsePos));
        }

        TreeNode node = new TreeNode(value);
        skipSpaces(s);
        node.left = parseTreeNode(s);
        skipSpaces(s);
        node.right = parseTreeNode(s);
        skipSpaces(s);

        if (parsePos >= s.length() || s.charAt(parsePos) != ')') {
            throw new IllegalArgumentException(
                "Expected ')' at position " + parsePos);
        }
        parsePos++;
        return node;
    }

    private static void skipSpaces(String s) {
        while (parsePos < s.length() && s.charAt(parsePos) == ' ') {
            parsePos++;
        }
    }

    // Binary tree validation

    /** Returns true if every node obeys left < parent < right. */
    public static boolean validateBSTOrdering(TreeNode node) {
        return bstHelper(node, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private static boolean bstHelper(TreeNode node, long min, long max) {
        if (node == null) return true;
        if (node.value <= min || node.value >= max) return false;
        return bstHelper(node.left, min, node.value)
            && bstHelper(node.right, node.value, max);
    }

    /** Returns true if no value appears more than once. */
    public static boolean validateNoDuplicates(TreeNode node) {
        return collectValues(node, new HashSet<>());
    }

    private static boolean collectValues(TreeNode node, Set<Integer> seen) {
        if (node == null) return true;
        if (!seen.add(node.value)) return false;
        return collectValues(node.left, seen)
            && collectValues(node.right, seen);
    }

    // Hash map parsing

    /**
     * Parses a hash map from colon-delimited text.
     * Every non-empty line must follow "key: value" format.
     * Throws IllegalArgumentException on bad syntax.
     */
    public static Map<String, String> parseHashMap(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("Input is null or empty");
        }
        Map<String, String> map = new LinkedHashMap<>();
        String[] lines = input.split("\n");
        for (int i = 0; i < lines.length; i++) {
            String line = lines[i].trim();
            if (line.isEmpty()) continue;
            int idx = line.indexOf(": ");
            if (idx == -1) {
                throw new IllegalArgumentException(
                    "Line " + (i + 1) + " missing ': ' delimiter: " + line);
            }
            String key   = line.substring(0, idx);
            String value = line.substring(idx + 2);
            map.put(key, value);
        }
        return map;
    }

    // Hash map validation

    /** Returns true if no key appears more than once. */
    public static boolean validateNoDuplicateKeys(String input) {
        String[] lines = input.split("\n");
        Set<String> keys = new HashSet<>();
        for (String line : lines) {
            line = line.trim();
            if (line.isEmpty()) continue;
            int idx = line.indexOf(": ");
            if (idx == -1) continue;
            if (!keys.add(line.substring(0, idx))) return false;
        }
        return true;
    }

    /** Returns true if every key is non-empty and alphanumeric (a-z, A-Z, 0-9, _). */
    public static boolean validateKeyFormat(String input) {
        String[] lines = input.split("\n");
        for (String line : lines) {
            line = line.trim();
            if (line.isEmpty()) continue;
            int idx = line.indexOf(": ");
            if (idx == -1) continue;
            String key = line.substring(0, idx);
            if (key.isEmpty() || !key.matches("[a-zA-Z0-9_]+")) return false;
        }
        return true;
    }

    /** Returns true if every value is non-empty. */
    public static boolean validateValuesNonEmpty(String input) {
        String[] lines = input.split("\n");
        for (String line : lines) {
            line = line.trim();
            if (line.isEmpty()) continue;
            int idx = line.indexOf(": ");
            if (idx == -1) continue;
            if (line.substring(idx + 2).trim().isEmpty()) return false;
        }
        return true;
    }
}
