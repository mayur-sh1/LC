class Solution {
    public int minimumRounds(int[] tasks) {
        // bcz i need ascending order of keys
        TreeMap<Integer,Integer> map=new TreeMap<>();
        for(int t:tasks) map.put(t,map.getOrDefault(t,0)+1);

        int rounds=0;

        for(int value:map.values()){
            if(value==1) return -1;
            if(value%3==0){
                rounds=rounds+(value/3);
            }
            else{
                rounds=rounds+(value+2)/3;
            }
        }
        return rounds;
    }
}