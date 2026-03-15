class Solution {
    public int brokenCalc(int startValue, int target) {
        int i=0;

        while(target>startValue){
            if(target%2==0) target/=2;
            
            else target+=1;

            i++;

        }
        // after this loop two possibilities target<startValue( so there is only one way to reach startvalue i.e addition ) and target==startValue
        return i + (startValue-target);
    }
}