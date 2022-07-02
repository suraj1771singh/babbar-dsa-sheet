
import java.util.HashSet;

//Throw all elements to set and return size of set as it contains all unique elements

public class EffiApproach {
    public static int doUnion(int a[], int n, int b[], int m) {

        HashSet<Integer> set = new HashSet<>();
        for (int i : a)
            set.add(i);

        for (int j : b)
            set.add(j);

        return set.size();

    }
}

// Time Complexity : O(n+m)
