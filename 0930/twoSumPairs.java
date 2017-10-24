import java.util.*;
class twoSumPairs{
	public static void main(String[] args){
		int[] test = {5,4,3,2,2,3};
		int pairs = pair(test);
		System.out.println(pairs);
	}

	public static int pair(int[] array) {
		if (array == null || array.length == 0) {
			return 0;
		}

		int target = array[0];
		int len = array[1];
		int res = 0;

		int slow, fast;

		for (slow = 2; slow < len + 1; slow++) {
			int comp = target - array[slow];
			for (fast = slow + 1; fast < len + 2; fast++) {
				if (array[fast] == comp) {
					res++;
				}
			}
		}

		return res;
	}
}