class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int count=0;
        int n=people.length,i=0,j=n-1;

        Arrays.sort(people);

        while(i<=j){
            if(people[i]+people[j]<=limit){
                count++;
                i++;j--;
            }
            else if(people[j]<=limit){
                count++;
                j--;
            }
            else if(people[i]<=limit){
                count++;
                i++;
            }
        }
        return count;
    }
}