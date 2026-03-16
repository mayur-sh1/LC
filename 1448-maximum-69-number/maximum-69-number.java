class Solution {
    public int maximum69Number (int num) {
        int posi=0;
        int posiOfSix=-1;

        int temp=num;

        while(temp!=0){
            int rem=temp%10;

            if(rem==6){
                posiOfSix=posi;
            }
            temp=temp/10;
            posi++;
        }

        if(posiOfSix==-1) return num;

        return num+3*(int)Math.pow(10,posiOfSix);
    }
}