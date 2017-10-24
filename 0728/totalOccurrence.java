public class totalOccurrence {
	public static void main(String[] args) {
		int[] test = new int[11];
		for (int i = 0; i < test.length; i++) {
			test[i] = 1;
		}
		int num = ttO(test, 1);
		System.out.println(num);
	}

	public static int ttO(int[] A, int target) {
		if (A == null || A.length == 0) {
			return 0;
		}

		int left = 0, right = 0;
		int start = 0, end = A.length - 1;

		//find left
		while (start + 1 < end) {
			int mid = start + (end - start) / 2;
			if (A[mid] == target) {
				end = mid;
			} else if (A[mid] < target) {
				start = mid;
			} else {
				end = mid;
			}
		}
		System.out.println("start" + start);
		if (A[start] != target && A[end] != target) {
			return 0;
		}
		if (A[start] == target) {
			left = start;
		} else if (A[end] == target) {
			left = end;
		}
		System.out.println("left" + left);

		//find right
		end = A.length - 1;
		while (start + 1 < end) {
			int mid = start + (end - start) / 2;
			if (A[mid] == target) {
				start = mid;
			} else if (A[mid] < target) {
				start = mid;
			} else {
				end = mid;
			}
		}
		System.out.println("end" + end);
		System.out.println("start" + start);
		System.out.println(A[10]);
		System.out.println("aend" + A[end]);

		if (A[end] == target) {
			right = end;
		} else if (A[start] == target) {
			right = start;
		}

		System.out.println(right);
		System.out.println(left);

		return right - left + 1;

	}
}