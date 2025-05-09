//{ Driver Code Starts


import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {
            int n = Integer.parseInt(read.readLine());
            Solution ob = new Solution();
            if (ob.isPrime(n)) {
                System.out.println("true");
            } else {
                System.out.println("false");
            }
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {
    static boolean isPrime(int n) {
        // code here
        int count = 0;
        for(int i = 1; i*i <= n ; i++){
            if(n % i == 0){
                count++;
                if((n / i )!= i){
                    count++;
                }
            }
        }
        
        return count == 2 ? true : false ;
    }
}