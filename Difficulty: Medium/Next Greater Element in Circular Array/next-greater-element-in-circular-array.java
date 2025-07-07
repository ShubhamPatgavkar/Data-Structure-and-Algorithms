


class Solution {
    public ArrayList<Integer> nextLargerElement(int[] arr) {
        int n = arr.length;
        ArrayList<Integer> result = new ArrayList<>(Collections.nCopies(n, -1));
        Stack<Integer> st = new Stack<>();

        // Traverse the array twice in reverse to simulate circular behavior
        for (int i = 2 * n - 1; i >= 0; i--) {
            int index = i % n;

            while (!st.isEmpty() && st.peek() <= arr[index]) {
                st.pop();
            }

            if (i < n) {
                // Only update the result during the first pass (real positions)
                if (!st.isEmpty()) {
                    result.set(index, st.peek());
                }
            }

            st.push(arr[index]);
        }

        return result;
    }
}
