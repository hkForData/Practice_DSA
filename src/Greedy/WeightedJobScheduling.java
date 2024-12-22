package Greedy;

import java.util.Arrays;
import java.util.Comparator;

public class WeightedJobScheduling {
	public static int weightedJobSchedule(int A[][]) {
		int n = A.length;
		JobPair act[] = new JobPair[n];
        int i;

        for(i=0;i<n;i++)
        {
            act[i]=new JobPair(A[i][0],A[i][1],A[i][2]);
        }

        Arrays.sort(act, new Comparator<JobPair>() {

//To Sort based on end time, if end time is equal then it is sorted based on start time        
    
                    
            public int compare(JobPair a, JobPair b)
            {
                if(a.end<b.end)
                {
                    return -1;
                }
                else if(a.end>b.end)
                {
                    return 1;
                }
                else
                {
                    return a.start-b.start;
                }
            }
        });
//[[1,5,7],[2,5,1],[3,6,3],[6,6,3],[3,7,7],[5,7,8],[6,7,8],[7,8,7],[3,10,9]]
        int ans[]=new int[n];
        ans[0]=act[0].profit;

        for(i=1;i<n;i++)
        {
            int ep = ans[i-1];
            int ip = act[i].profit;

            int index = searchBinary(act,i);

            if(index!=-1)
            {
                ip+=ans[index];
            }

            ans[i] = Math.max(ip,ep);
        }

        return ans[n-1];
     
    }

// binary search to find the latest non-conflicting job before the current job.

    public static int searchBinary(JobPair[] act,int i)
    {
        int s=0;
        int e=i-1;
        int ans=-1;

        while(s<=e)
        {
            int mid = (s+e)/2;

            if(act[mid].end<=act[i].start)
            {
                ans=mid;
                s=mid+1;
            }
            else
            {
                e=mid-1;
            }
        }

        return ans;
	}
	public static void main(String[] args) {
		int arr[][] = new int[9][3];
		
			arr[0][0] = 1;
			arr[0][1] = 5;
			arr[0][2] = 7;
			
			arr[1][0] = 2;
			arr[1][1] = 5;
			arr[1][2] = 1;
			
			arr[2][0] = 3;
			arr[2][1] = 6;
			arr[2][2] = 3;
			
			arr[3][0] = 6;
			arr[3][1] = 6;
			arr[3][2] = 3;
			
			arr[4][0] = 3;
			arr[4][1] = 7;
			arr[4][2] = 7;		
			
			arr[5][0] = 5;
			arr[5][1] = 7;
			arr[5][2] = 8;
			
			arr[6][0] = 6;
			arr[6][1] = 7;
			arr[6][2] = 8;
			
			arr[7][0] = 7;
			arr[7][1] = 8;
			arr[7][2] = 7;
			
			arr[8][0] = 3;
			arr[8][1] = 10;
			arr[8][2] = 9;
			
			
			int output = weightedJobSchedule(arr);
			System.out.println(output);
	}
}
class JobPair{
    int start;
    int end;
    int profit;
    JobPair(int start, int end, int profit){
        this.start = start;
        this.end = end;
        this.profit = profit;
    }
}

/*Q3. Weighted Job Scheduling
Solved
feature icon
Get your doubts resolved blazing fast with Chat GPT Help
Check Chat GPT
feature icon
Using hints is now penalty free
Use Hint
Problem Description
Given N jobs where every job is represented by following three elements of it.
Start Time
Finish Time
Profit Associated
Find and return the maximum profit subset of jobs such that no two jobs in the subset overlap.


Problem Constraints
1 <= N <= 105
1 <= A[i][0], A[i][1], A[i][2] <= 105


Input Format
The first and the only line of input contains a 2d array, A, of N x 3 integers:
A[i][0] : Start Time
A[i][1] : Finish Time
A[i][2] : Profit


Output Format
Return the maximum possible profit under the given conditions.


Example Input
Input 1:
A = [ [1, 2, 50],
      [3, 5, 20],
      [6, 19, 100],
      [2, 100, 200] ]
Input 2:
A = [ [10, 20, 50],
      [20, 30, 20],
      [30, 40, 100] ]


Example Output
Output 1:
250
Output 2:
170


Example Explanation
Explanation 1:
We can perform the 1st and the 4th job.
Profit = 50 + 200 = 250.
Explanation 2:
We can perform all the jobs, since no two jobs overlap.
So the total profit is 50 + 20 + 100 = 170*/
