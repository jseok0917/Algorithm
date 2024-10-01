class Solution {
    
    static int t = 0;
    static int cnt = 0;
    
    public int solution(int[] numbers, int target) {
        t = target;
        
        bruteForce(numbers, 0, 0);
        
        return cnt;
    }
    
    public void bruteForce(int[] numbers, int idx, int sum) {
        
        //모든 숫자의 개수를 연산했을 때 결과를 판단
        if (idx == numbers.length) {
            if (sum == t) {
                cnt++;
                return;
            }
            
            return;
        }
        
        //더하거나 빼거나 둘중하나
        sum += numbers[idx];
        //더했다면 다음걸로 넘어간다
        bruteForce(numbers, idx+1, sum);
        
        //아니면 빼본다
        //원상복구 시키고
        sum -= numbers[idx];
        //빼기
        sum -= numbers[idx];
        //뺐다면 다음 순번으로
        bruteForce(numbers, idx+1, sum);
        
        
    }
    
}