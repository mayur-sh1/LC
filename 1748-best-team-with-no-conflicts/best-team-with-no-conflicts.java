class Solution {
    int[][] players;
    int[][] dp;
    public int bestTeamScore(int[] scores, int[] ages) {
        int n=scores.length;
        
        players=new int[n][2];
        for(int i=0;i<n;i++){
            players[i][0]=ages[i];
            players[i][1]=scores[i];
        }

        Arrays.sort(players,(a,b)->{
            if(a[0]==b[0]) return a[1]-b[1];

            return a[0]-b[0];
        });

        dp=new int[n][n+1];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }

        // indexOfCurrentPlayer , index of pre selected player
        return solve(0,-1);
    }
    int solve(int index,int prev){
        if(index==players.length) return 0;

        if(dp[index][prev+1]!=-1) return dp[index][prev+1]; 

        int skip=solve(index+1,prev);
        
        int take=0; 
        // age toh badi ho gi hi sorting ki wajah se 
        if(prev==-1 || players[index][1]>=players[prev][1]){
            take=players[index][1]+solve(index+1,index);
        }

        return dp[index][prev+1]=Math.max(skip,take);

    }
}