class Solution {

    void fn(int[] a, int n, int idx, List<Integer> diary,
            int sum, List<List<Integer>> res, int target) {

        if (idx >= n) {
            if (sum == target) {
                res.add(new ArrayList<>(diary));
            }
            return;
        }

        // Take current element
        if (sum + a[idx] <= target) {
            diary.add(a[idx]);

            // Same idx because element can be reused
            fn(a, n, idx, diary, sum + a[idx], res, target);

            diary.remove(diary.size() - 1);
        }

        // Skip current element
        fn(a, n, idx + 1, diary, sum, res, target);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> diary = new ArrayList<>();

        fn(candidates, candidates.length, 0, diary, 0, res, target);

        return res;
    }
}