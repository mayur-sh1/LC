class Solution {
    public void helper(List<List<Integer>> ans, List<Integer> sub, int[] arr, int index) {
        ans.add(new ArrayList<>(sub));

        for (int i = index; i < arr.length; i++) {
            if (i > index && arr[i - 1] == arr[i])
                continue;
            sub.add(arr[i]);
            helper(ans, sub, arr, i + 1);
            sub.remove(sub.size() - 1);
        }
    }

    public List<List<Integer>> subsetsWithDup(int[] arr) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> sub = new ArrayList<>();
        Arrays.sort(arr);
        helper(ans, sub, arr, 0);
        return ans;
    }
}