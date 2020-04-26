package com.company;

public class Knapsack {
    
    int[] v = {7,2,1,6,12};
    int[] w = {3,1,2,4,6};

    //int[] v = {21,16,8,26,35,21};
    //int[] w = {30,20,25,35,45,19};

    int c = 10, n;
    public Knapsack() {
    this.n = w.length;
    }

    public int solve(){return solve(c,0);};
    public int solve(int c, int i) {
        if(i > n-1){
            return 0;
        }
        if(c < w[i]){
            return solve(c,i+1);
        }
        else{
            return Math.max(solve(c,i+1),v[i]+solve(c-w[i],i+1));
        }
    }
}
