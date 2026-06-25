class Solution {
    public boolean canBeValid(String s, String locked) {
        if(s.length()%2==1) return false;

        Stack<Integer> open=new Stack<>();
        Stack<Integer> openClose=new Stack<>();

        int n=s.length();
        for(int i=0;i<n;i++){
            if(locked.charAt(i)=='0') openClose.push(i);
            else if(s.charAt(i)=='(') open.push(i);
            else{ // locked
                if(!open.isEmpty()) open.pop();
                else if(!openClose.isEmpty()) openClose.pop();
                else return false;
            }
        }

        while(!open.isEmpty() &&  !openClose.isEmpty()){
            if(open.peek()<openClose.peek()){
                open.pop();
                openClose.pop();
            }
            else return false;
        }
        return open.isEmpty();

    }
}