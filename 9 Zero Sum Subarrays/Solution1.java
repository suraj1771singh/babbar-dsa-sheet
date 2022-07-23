//-----------NAIVE SOLUTION
//Go through every sub array and keep count of subarray whoes sum is 0

class Solution1{
    
    public static long findSubarray(long[] arr ,int n) 
    {
        long ans=0; 
        for(int i=0; i<n; i++){
            int sum=0; 
            for(int j=i; j<n; j++){
                sum+=arr[j];
                if(sum==0) ans++;
            }
        }
        return ans;
    }
}
//Time complexity : O(n^2)
//Space compleixty : O(1)