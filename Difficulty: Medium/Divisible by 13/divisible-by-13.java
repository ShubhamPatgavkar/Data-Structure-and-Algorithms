class Solution {
    public boolean divby13(String numStr) {
        // code here
          int remainder = 0;

        for (int i = 0; i < numStr.length(); i++) {
            int digit = numStr.charAt(i) - '0';
            remainder = (remainder * 10 + digit) % 13;
        }

        return remainder == 0;
        
    }
}