import java.util.*;

class Solution {
    
    //각 심사대나 심사를 받는 사람의 관점에서 생각하지 않고,
    //주어진 시간 안에 심사가 가능한지만 판단한다.
    //한 심사대가 심사에 걸리는 시간이 times이고
    //주어진 시간이 t라면
    //그 심사대는 t/times 만큼의 사람을 심사할 수 있다.
    //각 심사대의 합이 >= n 일 때, 주어진 시간 안에 심사가 가능하다.
    
    //심사에 걸리는 시간이 모두 10억분이고, 심사관이 1명
    //입국심사를 기다리는 사람이 10억명이라면
    //주어진 시간 t는 최대 10억*10억이 가능하다.
    
    public long solution(int n, int[] times) {
        long answer = 0;
        //걸릴 수 있는 최소 시간
        long start = 1;
        //걸릴 수 있는 최대 시간
        long end = (long) Math.pow(10, 18);
        long mid = (start+end)/2;
        
        //이분 탐색(lower bound...)
        while (start < end){
            
            long sum = 0;
            
            //가능한 인원 수를 센다
            for (int time : times) {
                sum += (mid/time);
            }
            System.out.println("가능한 인원 수 : "+sum);
            
            //가능하다면, 시간을 줄여본다
            if (sum >= n) {  
                end = mid;
                mid = (start + end)/2;
                
            //안되면, 시간을 늘려본다
            } else {
                //mid 시간에는 어챂 안되므로 mid+1부터 탐색
                //이 경우 
                start = mid + 1;
                mid = (start + end)/2;
            }
            
        }
        
        answer = start;
        
        
        return answer;
    }
}