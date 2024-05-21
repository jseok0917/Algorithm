import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        
        int l = commands.length;
        int[] answer = new int[l];
        
        for (int t = 0; t < l; t++){
            int i = commands[t][0];
            int j = commands[t][1];
            int k = commands[t][2];
            
            int[] subArray = new int[j-i+1];
            for (int s = 0; s < (j-i+1); s++){
                subArray[s] = array[s+i-1];
            }
            
            Arrays.sort(subArray);
            answer[t] = subArray[k-1];
        }
        
        
        
        return answer;
    }
}