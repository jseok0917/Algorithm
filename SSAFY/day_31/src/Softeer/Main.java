package Softeer;

import java.io.*;
import java.util.*;

public class Main {

    static long mod = 1000000007;
    static long K,P,N;

    public static void main(String[] args) {

      Scanner sc = new Scanner(System.in);
      K = sc.nextLong();
      P = sc.nextLong();
      N = sc.nextLong();

      long result = (K*divide(P, 10*N))%mod;
      System.out.println(result);
        
    }
    static long divide(long P, long n){
      if (n == 1){
        return P;
      } else {

        long A = divide(P, n/2);

        long result = (A*A)%mod;
        
        if (n%2 == 0){
          return result;
        } else {
          return (result*P)%mod;
        }
      }
    }
}