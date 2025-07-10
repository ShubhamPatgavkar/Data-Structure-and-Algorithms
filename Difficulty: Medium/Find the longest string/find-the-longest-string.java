
class Solution {
    public String longestString(String[] arr) {
        // Sort the array to make sure we process lexicographically smaller strings first
        Arrays.sort(arr);
        Set<String> built = new HashSet<>();
        String result = "";

        for (String word : arr) {
            if (word.length() == 1 || built.contains(word.substring(0, word.length() - 1))) {
                built.add(word);
                // Update result if word is longer or same length but lexicographically smaller
                if (word.length() > result.length()) {
                    result = word;
                }
            }
        }

        return result;
    }
}
