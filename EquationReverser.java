/**
 * EquationReverser.java
 *
 * Your Name:        Doğa Kasaplı
 * Your Student ID:  240444403
 * Your Date:        26.10.2026
 */
public class EquationReverser {
    public static String reverseEquation(String equation) {
        // create the object of the TokenStack class
        TokenStack stack = new TokenStack();

        int i = 0;
        int n = equation.length();

        // TODO 1 & 2 & 3: Traverse the equation from left to right.
        while (i < n) {
            char current = equation.charAt(i);

            // If the current character is a digit, extract the whole multi-digit number
            if (Character.isDigit(current)) {
                int start = i;
                // Move forward while the characters are digits
                while (i < n && Character.isDigit(equation.charAt(i))) {
                    i++;
                }
                // Extract the entire number and push it
                String number = equation.substring(start, i);
                stack.push(number);
            }
            // Otherwise, push the operator
            else {
                stack.push(String.valueOf(current));
                i++;
            }
        }
        // TODO 4: Pop all items from the stack and append them to a StringBuilder.
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }

        return result.toString();
    }
}
