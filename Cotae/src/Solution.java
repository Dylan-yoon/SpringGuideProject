// class Solution {
//     public int solution(int[] diffs, int[] times, long limit) {
//         int n = diffs.length;
//         int level = 0;
//         boolean[] low = new boolean[n];
//         long value = 0l;

//         loop: while (level < 100001) {
//             level++;
//             long now = value;

//             for (int i = 0; i < n; i++) {
//                 if (low[i]) {
//                     continue;
//                 }

//                 if (diffs[i] <= level) {
//                     now += times[i];
//                     value += times[i];
//                     low[i] = true;
//                 } else {
//                     now += ((diffs[i] - level) * (times[i] + times[i-1]) + times[i]);
//                 }

//                 if (limit < now) {
//                     continue loop;
//                 }
//             }
//             break;
//         }
//         return level;
//     }
// }

// class Solution {
//     public int solution(int[] diffs, int[] times, long limit) {
//         int n = diffs.length;
//         int level = 0;

//         loop: while (level < 100001) {
//             level++;
//             long now = 0l;

//             for (int i = 0; i < n; i++) {
//                 if (diffs[i] <= level) {
//                     now += times[i];
//                 } else {
//                     now += ((diffs[i] - level) * (times[i] + times[i-1]) + times[i]);
//                 }

//                 if (limit < now) {
//                     continue loop;
//                 }
//             }
//             break;
//         }
//         return level;
//     }
// }

// class Solution {
//     public int solution(int[] diffs, int[] times, long limit) {
//         int n = diffs.length;
//         int[] sum = new int[n];
//         for (int i = 1; i < n; i++) {
//             sum[i] = times[i] + times[i-1];
//         }

//         loop: for(int level = 1; level < 100001; level++) {
//             long now = 0l;

//             for (int i = 0; i < n; i++) {
//                 if (diffs[i] <= level) {
//                     now += times[i];
//                 } else {
//                     now += ((diffs[i] - level) * (sum[i])) + times[i];
//                 }

//                 if (limit < now) {
//                     continue loop;
//                 }
//             }
//             return level;
//         }
//     }
// }

class Solution {
	public int solution(int[] diffs, int[] times, long limit) {
		int n = diffs.length;
		long[] values = new long[n];
		// level 1일 때 일단 구함?
		// level 2 부터 level == diff[] 같을때까지 sum을 빼줌?
		long[] sum = new long[n];

		for (int i = 1; i < n; i++) {
			sum[i] = times[i] + times[i - 1];
		}
		long result = 0l;
		for (int i = 0; i < n; i++) {
			if (diffs[i] <= 1) {
				values[i] = times[i];
				result = times[i];
			} else {
				values[i] = ((diffs[i] - 1) * (sum[i])) + times[i];
				result = ((diffs[i] - 1) * (sum[i])) + times[i];
			}
		}

		loop: for (int level = 2; level < 100001; level++) {
			long now = 0l;

			for (int i = 0; i < n; i++) {
				if (diffs[i] <= level) {
					now += times[i];
				} else {
					now += (values[i] - sum[i]);
					values[i] = -sum[i];
				}

				if (limit < now) {
					continue loop;
				}
			}
			return level;
		}
	}
}