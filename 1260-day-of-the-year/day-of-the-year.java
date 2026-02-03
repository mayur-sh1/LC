class Solution {
    public int dayOfYear(String date) {
        String[] parts=date.split("-");
        
        int year=Integer.parseInt(parts[0]);
        int month=Integer.parseInt(parts[1]);
        int day=Integer.parseInt(parts[2]);

        int days[]={31,28,31,30,31,30,31,31,30,31,30,31};

        // check leap year
        if(isLeap(year)) days[1]=29; //add one day

        // add days or previous months
        int result=0;
        for(int i=0;i<month-1;i++){
            result+=days[i];
        }
        // add current days
        result+=day;

        return result;
    }
    public boolean isLeap(int n){
        return ((n%400==0) || (n%4==0 && n%100!=0));
    }
}