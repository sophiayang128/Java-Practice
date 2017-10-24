import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

class PermutationsII {
	public static void main(String[] args) {
		int[] number = new int[3];
		number[0] = 1;
		number[1] = 2;
		number[2] = 2;
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

		int[] visited = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			visited[i] = 0;
		}

		helper(results,nums,subset,visited);
		return results;
	}

	private static void helper(List<List<Integer>> results,
		                int[] nums,
		                ArrayList<Integer> subset,
		                int[] visited) {
		if (subset.size() == nums.length) {
			results.add(new ArrayList<Integer>(subset));
		}

		for (int i = 0; i < nums.length; i++) {
			if (visited[i] == 1 || (i != 0 && nums[i] == nums[i-1] && visited[i-1] == 0)) {
				//System.out.println("contain");
				continue;
			}

			visited[i] = 1;
			subset.add(nums[i]);
			//System.out.println(i);
			helper(results,nums,subset,visited);
			//System.out.println("remove "+subset.get(subset.size()-1));
			subset.remove(subset.size()-1);
			visited[i] = 0;
		}
	}
}