//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Job {
    int id, profit, deadline;

    Job(int x, int y, int z) {
        this.id = x;
        this.deadline = y;
        this.profit = z;
    }
}

class GfG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            String[] jobIDStrings = sc.nextLine().split(" ");
            String[] deadlineStrings = sc.nextLine().split(" ");
            String[] profitStrings = sc.nextLine().split(" ");

            // Convert the input strings to integer arrays
            int[] jobIDs = new int[jobIDStrings.length];
            int[] deadlines = new int[deadlineStrings.length];
            int[] profits = new int[profitStrings.length];

            for (int i = 0; i < jobIDStrings.length; i++) {
                jobIDs[i] = Integer.parseInt(jobIDStrings[i]);
                deadlines[i] = Integer.parseInt(deadlineStrings[i]);
                profits[i] = Integer.parseInt(profitStrings[i]);
            }
            Solution obj = new Solution();
            ArrayList<Integer> ans = obj.JobSequencing(jobIDs, deadlines, profits);
            System.out.println(ans.get(0) + " " + ans.get(1));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends




class Solution {
    static class Job {
        int id, deadline, profit;
        Job(int id, int deadline, int profit) {
            this.id = id;
            this.deadline = deadline;
            this.profit = profit;
        }
    }

    public ArrayList<Integer> JobSequencing(int[] id, int[] deadline, int[] profit) {
        int n = profit.length;

        // Creating a list of jobs
        Job[] jobs = new Job[n];
        for (int i = 0; i < n; i++) {
            jobs[i] = new Job(id[i], deadline[i], profit[i]);
        }

        // Sort jobs in descending order of profit
        Arrays.sort(jobs, (a, b) -> b.profit - a.profit);

        int maxDeadline = 0;
        for (int i = 0; i < n; i++) {
            maxDeadline = Math.max(maxDeadline, jobs[i].deadline);
        }

        // Slots for scheduling
        int[] slot = new int[maxDeadline + 1];
        Arrays.fill(slot, -1);

        int maxProfit = 0, countJobs = 0;
        for (Job job : jobs) {
            for (int j = job.deadline; j > 0; j--) {
                if (slot[j] == -1) { // Check if slot is available
                    slot[j] = job.id;
                    maxProfit += job.profit;
                    countJobs++;
                    break;
                }
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        result.add(countJobs);
        result.add(maxProfit);
        return result;
    }
}