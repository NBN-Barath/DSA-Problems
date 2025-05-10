//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(read.readLine());
            Solution ob = new Solution();
            boolean flag = ob.armstrongNumber(n);
            if (flag) {
                System.out.println("true");

            } else {
                System.out.println("false");
            }

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Solution {
    static boolean armstrongNumber(int n) {
        // code here
       int m = n;
        int sum = 0;
        int n1 = m % 10;
        m /= 10;
        int n2 = m % 10;
        m /= 10;
        int n3 = m % 10;
        sum = (int)(Math.pow(n1,3) + Math.pow(n2,3) + Math.pow(n3,3));
    if(sum == n){
        return true;
    }
    return false;
}
}