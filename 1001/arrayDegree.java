import java.util.*;
class arrayDegree{
	public static void main(String[] args) {
		int[] test = {6,1,1,2,1,2,2};
		int res = degreeOfArray(test);
		System.out.println(res);
	}

	public static int degreeOfArray(int[] arr) {
		if (arr == null || arr.length == 0) {
			return 0;
		}

		Map<Integer, ArrayList<Integer>> map = new HashMap<>();
		int len = arr[0];
		int degree = 0;

		for (int i = 1; i < len + 1; i++) {
			if (!map.containsKey(arr[i])) {
				map.put(arr[i], new ArrayList<>());
			}
			map.get(arr[i]).add(i);
			if (map.get(arr[i]).size() > degree) {
				degree = map.get(arr[i]).size();
			}
		}

		int minLen = Integer.MAX_VALUE;

		for (int num: map.keySet()) {
			if (map.get(num).size() == degree) {
				int currLen = map.get(num).get(degree - 1) - map.get(num).get(0) + 1;
				if (currLen < minLen) {
					minLen = currLen;
				}
			}
		}

		return minLen;
	}
}