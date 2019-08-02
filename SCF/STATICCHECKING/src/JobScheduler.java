public class JobScheduler {
	private static int[][] jobs;
	private int[] ct, wt, tat;

	public JobScheduler(int n) {
		jobs = new int[n][2];
		ct = new int[n];
		wt = new int[n];
		tat = new int[n];
	}

	public void readJobs(int arr[][]) {
		jobs = arr;

	}

	public int[] completionTime() {
		int arrivalTime = 0;
		int n = jobs.length;
		int cTime = 0;
		for (int i = 1; i < n; i++) {
			cTime = arrivalTime + jobs[i - 1][1];
			ct[i - 1] = cTime;
			if (jobs[i][0] > cTime)
				arrivalTime = jobs[i][0];
			else
				arrivalTime = cTime;
		}
		cTime = arrivalTime + jobs[n - 1][1];
		ct[n - 1] = cTime;
		return ct;
	}

	public int[] waitingTime() {
		int n = jobs.length;
		for (int i = 0; i < n; i++) {
			wt[i] = tat[i] - jobs[i][1];
		}
		return wt;
	}

	public int[] turnAroundTime() {
		int n = jobs.length;
		for (int i = 0; i < n; i++) {
			tat[i] = ct[i] - jobs[i][0];
		}
		return tat;
	}

	public double avgWaitingTime() {
		int n = jobs.length;
		double sum = 0;
		for (int i = 0; i < n; sum += wt[i], i++)
			;
		return (sum / n);
	}

	public int maxWaitingTime() {
		int max = wt[0];
		int n = jobs.length;
		for (int i = 1; i < n; i++) {
			if (wt[i] > wt[i - 1])
				max = wt[i];
		}
		return max;
	}

	public static void main(String[] args) {
		JobScheduler jobObj = new JobScheduler(4); // 4 is Number Of Jobs
		int[][] jobs = new int[][] { { 0, 10 }, { 6, 20 }, { 60, 10 },
				{ 110, 5 } };
		jobObj.readJobs(jobs);
		int ct[] = jobObj.completionTime();
		int tat[] = jobObj.turnAroundTime();
		int wt[] = jobObj.waitingTime();
		System.out
				.println("Process      Arrival Time      Burst Time       Completion Time      TAT      Waiting Time");
		for (int i = 0; i < ct.length; i++) {
			System.out.print("P" + (i + 1));
			System.out.print("                " + jobs[i][0]);
			System.out.print("                " + jobs[i][1]);
			System.out.print("                " + ct[i]);
			System.out.print("                " + tat[i]);
			System.out.print("                " + wt[i]);
			System.out.println();
		}
		System.out.println("\n\nAverage waiting Time is :"
				+ jobObj.avgWaitingTime());
		System.out.println("\nMaximum waiting Time is :"
				+ jobObj.maxWaitingTime());
	}

}