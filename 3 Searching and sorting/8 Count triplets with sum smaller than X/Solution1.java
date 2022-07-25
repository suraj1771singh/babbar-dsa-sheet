import java.util.Arrays;

//-------------EFFICIENT SOLUTION

class Solution1
{
    long countTriplets(long arr[], int n,int sum)
    {
        long ans=0;
        Arrays.sort(arr);
        for(int i=0; i<n-2; i++)
            ans+=findPair(i+1, sum-arr[i],arr);
        return ans;
        

    }
    long findPair(int i,long x, long []arr ){
        int j=arr.length-1;
        long ans=0;
        while(i<j){
            if(arr[i]+arr[j] >= x) j--;
            else {
                ans+=j-i;
                i++;
            }
        }
        return ans;
    }
}
//Time complexity : O(n^2)
//Space complexity : O(1)