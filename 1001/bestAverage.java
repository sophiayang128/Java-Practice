import java.util.*;
class bestAverage{
	public static void main(String[] args) {
		String[][] test = {{"Bob","88"}, {"Ted", "100"}, {"Ted", "20"}};
		//System.out.println(test[0][0]);
		int ans = grade(test);
		System.out.println(ans);
	}
    
	public static int grade(String[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return 0;
		}

		Map<String, ArrayList<String>> map = new HashMap<>();
		for (int i = 0; i < matrix.length; i++) {
			if (!map.containsKey(matrix[i][0])) {
				map.put(matrix[i][0], new ArrayList<>());
			}
			map.get(matrix[i][0]).add(matrix[i][1]);

		}

		int highest = 0;
		for (String name: map.keySet()) {
			double sum = 0;
			for (String num: map.get(name)) {
				sum += Integer.parseInt(num);
			}
			int avg = (int)Math.floor(sum / map.get(name).size());
			if (avg > highest) {
				highest = avg;
			}
		}
		return highest;
	}
}