class Pair {
    double ratio; // this will store GAIN
    int idx;

    Pair(double ratio, int idx) {
        this.ratio = ratio;
        this.idx = idx;
    }
}

class Solution {

    // helper to calculate gain
    private double gain(int p, int t) {
        return (double)(p + 1) / (t + 1) - (double)p / t;
    }

    public double maxAverageRatio(int[][] classes, int extraStudents) {

        int n = classes.length;

        // MAX heap (fix comparator)
        PriorityQueue<Pair> pq =
                new PriorityQueue<>((a, b) -> Double.compare(b.ratio, a.ratio));

        // initialization (fix object creation + ratio)
        for (int i = 0; i < n; i++) {
            pq.add(new Pair(
                    gain(classes[i][0], classes[i][1]),
                    i
            ));
        }

        // assign extra students ONE BY ONE
        while (extraStudents > 0) {
            Pair p = pq.poll();
            int i = p.idx;

            classes[i][0]++; // pass
            classes[i][1]++; // total
            extraStudents--;

            // push updated gain back
            pq.add(new Pair(
                    gain(classes[i][0], classes[i][1]),
                    i
            ));
        }

        // compute final average
        double finalRatio = 0.0;
        while (!pq.isEmpty()) {
            Pair p = pq.poll();
            int i = p.idx;
            finalRatio += (double) classes[i][0] / classes[i][1];
        }

        return finalRatio / n;
    }
}
