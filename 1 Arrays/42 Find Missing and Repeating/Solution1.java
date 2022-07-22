class Solve {
    int[] findTwoElement(int arr[], int n) {
        int a=0, b=0;
        for(int i=0; i<n; i++){
            int ind=Math.abs(arr[i])-1;
            if(arr[ind]<0)  b=ind+1;
            else arr[ind]=arr[ind]*-1;
        }
        for(int i=0; i<n; i++)
            if(arr[i]>0) a=i+1;
        return new int[]{b,a};
        
    }
}
//Time complexity : O(n) : 2 passes
//Space complexiy : O(1)