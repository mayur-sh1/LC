class Solution {
    public int maxCompatibilitySum(int[][] students, int[][] mentors) {
        int n=students.length;
        boolean takenMentors[]=new boolean[n];
        int res[]=new int[1]; // final score
        int index=0;
        int score=0;// initial score

        solve(students,mentors,takenMentors,index,score,res,n);

        return res[0];
    }
    public void solve(int[][] students,int[][] mentors,boolean takenMentors[],int index,int score,int res[],int n){
        if(index>=n){
            res[0]=Math.max(res[0],score);
            return;
        }

        int compatibilityScore=0;
        for(int i=0;i<n;i++){
            if(!takenMentors[i]){
                takenMentors[i]=true;
                compatibilityScore=calculate(students,mentors,index,i);
                solve(students,mentors,takenMentors,index+1,score+compatibilityScore,res,n);
                takenMentors[i]=false;
            }
        }
    }
    public int calculate(int[][] students, int[][] mentors,int sIndex,int mIndex){
        int score=0;
        for(int i=0;i<students[sIndex].length;i++){
            if(students[sIndex][i]==mentors[mIndex][i]) score++;
        }
        return score;
    }
}