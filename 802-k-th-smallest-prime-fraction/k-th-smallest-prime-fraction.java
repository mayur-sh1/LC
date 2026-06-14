class HeapElement {
    double fraction;
    int i, j;

    HeapElement(double fraction, int i, int j) {
        this.fraction = fraction;
        this.i = i;
        this.j = j;
    }
}

class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {

        int n = arr.length;

        PriorityQueue<HeapElement> pq =
                new PriorityQueue<>(
                        (a, b) -> Double.compare(a.fraction, b.fraction));

        Set<Pair<Integer, Integer>> set = new HashSet<>();

        pq.add(new HeapElement(1.0 * arr[0] / arr[n - 1], 0, n - 1));
        set.add(new Pair<>(0, n - 1));

        int counter = 1;

        while (counter < k) {

            HeapElement ele = pq.poll();

            int i = ele.i;
            int j = ele.j;

            // move numerator forward
            if (i + 1 < j && !set.contains(new Pair<>(i + 1, j))) {

                pq.add(new HeapElement(
                        1.0 * arr[i + 1] / arr[j],
                        i + 1,
                        j));

                set.add(new Pair<>(i + 1, j));
            }

            // move denominator backward
            if (i < j - 1 && !set.contains(new Pair<>(i, j - 1))) {

                pq.add(new HeapElement(
                        1.0 * arr[i] / arr[j - 1],
                        i,
                        j - 1));

                set.add(new Pair<>(i, j - 1));
            }

            counter++;
        }

        HeapElement ans = pq.peek();

        return new int[] { arr[ans.i], arr[ans.j] };
    }
}