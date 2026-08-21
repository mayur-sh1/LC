class Solution {

    TreeMap<Integer, Long> damage = new TreeMap<>();
    HashMap<Integer, Long> dp = new HashMap<>();

    public long maximumTotalDamage(int[] power) {

        for (int pow : power) {
            damage.put(pow, damage.getOrDefault(pow, 0L) + pow);
        }

        return solve(damage.firstKey());
    }

    long solve(int power) {

        if (power == 0) {
            return 0;
        }

        if (dp.containsKey(power)) {
            return dp.get(power);
        }

        // Next power we are allowed to take after 'power'
        Integer next = damage.higherKey(power + 2);

        long take = damage.get(power);

        if (next != null) {
            take += solve(next);
        }

        // Next existing power
        Integer skip = damage.higherKey(power);

        long skipValue = 0;

        if (skip != null) {
            skipValue = solve(skip);
        }

        long ans = Math.max(take, skipValue);

        dp.put(power, ans);

        return ans;
    }
}
// making array of max+1 size gives me memory limit exceeded
// so we can use hashmap but stilll it dont run on last estcases becz if arrays conatins [1,1000000] (recurrsion make cal for power+1, power+2)