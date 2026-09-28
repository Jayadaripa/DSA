class Solution {
    public int myAtoi(String s) {

        // Remove Whitespace
        int i = 0;

        while (i < s.length() && s.charAt(i) == ' ') {
            i++;
        }

        // Signedness
        int sign = 1;

        if (i < s.length() && s.charAt(i) == '-') {
            sign = -1;
            i++;
        }
        else if (i < s.length() && s.charAt(i) == '+') {
            i++;
        }

        // Convert digits
        long num = 0;

        while (i < s.length() && Character.isDigit(s.charAt(i))) {

            int digit = s.charAt(i) - '0';

            num = num * 10 + digit;

            // Check overflow and underflow
            if (sign == 1 && num > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }

            else if (sign == -1 && num > (long) Integer.MAX_VALUE + 1) {
                return Integer.MIN_VALUE;
            }

            i++;
        }

        return (int)(sign * num);
    }
}