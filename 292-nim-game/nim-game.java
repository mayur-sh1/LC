class Solution {
    public boolean canWinNim(int n) {

        // If n is a multiple of 4, you will lose
        // because every move gives the opponent a winning position
        return n % 4 != 0;
    }
}
