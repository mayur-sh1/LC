class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int maxUnsatCustomer=0;
        int currUnsatCustomer=0;
        for(int i=0;i<minutes;i++){
            if(grumpy[i]==1) currUnsatCustomer+=customers[i];
        }

        maxUnsatCustomer=currUnsatCustomer;

        for(int i=minutes;i<customers.length;i++){
            if(grumpy[i]==1) currUnsatCustomer+=customers[i];
            if(grumpy[i-minutes]==1)currUnsatCustomer-=customers[i-minutes];

            maxUnsatCustomer=Math.max(maxUnsatCustomer,currUnsatCustomer);
        }

        int totalSat=maxUnsatCustomer; // itne ko toh satisyfy kr hi dunga using power
        for(int i=0;i<customers.length;i++){
            if(grumpy[i]==0) totalSat+=customers[i];
        }
        return totalSat;
    }
}