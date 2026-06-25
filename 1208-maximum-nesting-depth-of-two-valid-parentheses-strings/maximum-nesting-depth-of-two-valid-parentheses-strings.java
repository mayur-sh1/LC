class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        int[] ans = new int[seq.length()];
        int depth = 0;

        for (int i = 0; i < seq.length(); i++) {
            if (seq.charAt(i) == '(') {
                depth+=1;// enter a new level
                ans[i] = depth % 2;
            } else {
                ans[i] = depth % 2;// use the level being closed
                depth-=1;           // then leave that level
            }
        }
        return ans;
    }
}