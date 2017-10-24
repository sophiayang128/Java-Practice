import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

class Permutations {
	public static void main(String[] args) {
		int[] number = new int[3];
		for (int i = 0; i < 3; i++) {
			number[i] = i + 1;
		}
		System.out.println(permute(number));

	}

	public static List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> results = new ArrayList<>();
		if (nums == null) {
			return results;
		}

		if (nums.length == 0) {
			results.add(new ArrayList<Integer>());
			return results;
		}

		Arrays.sort(nums);
		ArrayList<Integer> subset = new ArrayList<>();

		helper(results,nums,subset);
		return results;
	}

	private static void helper(List<List<Integer>> results,
		                int[] nums,
		                ArrayList<Integer> subset) {
		if (subset.size() == nums.length) {
			results.add(new ArrayList<Integer>(subset));
		}

		for (int i = 0; i < nums.length; i++) {
			if (subset.contains(nums[i])) {
				//System.out.println("contain");
				continue;
			}
			subset.add(nums[i]);
			//System.out.println(i);
			helper(results,nums,subset);
			//System.out.println("remove "+subset.get(subset.size()-1));
			subset.remove(subset.size()-1);
		}
	}
}