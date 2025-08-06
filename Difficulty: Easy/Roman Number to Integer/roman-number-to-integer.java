class Solution {
    
    public int valOf(char ch) {
        switch(ch) {
            case 'I' : return 1;
            case 'V' : return 5;
            case 'X' : return 10;
            case 'L' : return 50;
            case 'C' : return 100;
            case 'D' : return 500;
            case 'M' : return 1000;
            default : return -1;
        }
    }
    
    public int romanToDecimal(String s) {
        int i = s.length() - 1;
        int sum = 0;
        
        while (i >= 0) {
            if (i > 0 && valOf(s.charAt(i)) > valOf(s.charAt(i - 1))) {
                // Subtractive case
                sum += valOf(s.charAt(i)) - valOf(s.charAt(i - 1));
                i -= 2;  // skip the pair
            } else {
                // Normal case
                sum += valOf(s.charAt(i));
                i--;  // move one step
            }
        }
        
        return sum;
    }
}
