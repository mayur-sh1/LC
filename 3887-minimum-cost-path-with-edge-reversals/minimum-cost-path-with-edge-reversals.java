class Pair{
    int node;
    int wt;

    Pair(int node,int wt){
        this.node=node;
        this.wt=wt;
    }
}
class Solution {
    public int minCost(int n, int[][] edges) {
        List<List<Pair>> adj=new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());

        for(int i=0;i<edges.length;i++){
            int u=edges[i][0],v=edges[i][1],wt=edges[i][2];

            adj.get(u).add(new Pair(v,wt));
            adj.get(v).add(new Pair(u,2*wt));
        }

        // min heap;
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->a.wt-b.wt);

        int distance[]=new int[n];
        Arrays.fill(distance,Integer.MAX_VALUE);
        distance[0]=0;
         pq.add(new Pair(0, 0));
        while(!pq.isEmpty()){
            int node=pq.peek().node;
            int wt=pq.peek().wt;

            pq.poll();

            if(node==n-1) return wt;
            
            for(Pair p:adj.get(node)){
                int adjNode=p.node;
                int edgeWt=p.wt;

                if(wt+edgeWt<distance[adjNode]){
                    distance[adjNode]=wt+edgeWt;
                    pq.add(new Pair(adjNode,distance[adjNode]));
                }
            }
        }
        return -1;
    }
}