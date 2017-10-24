import java.util.*;

class validPassword{
	public static void main(String[] args) {
		String test = "a0ba4cddd2";
		int res = solution(test);
		System.out.println(res);

	}
	public static int solution(String S) {
		if (S == null || S.length() == 0) {
			return -1;
		}

		int max = -1;
		for (int i = 0; i < S.length() - 1; i++) {
			if (S.charAt(i) - 'A' >= 0 && S.charAt(i) - 'A' < 26) {
				int left = i;
				int right = i + 1;
				while (left >= 0 && isValid(S.charAt(left))) {
					left--;
				}
				while (right < S.length() && isValid(S.charAt(right))) {
					right++;
				}
				max = Math.max(max, right - left - 1);
			} else {
				continue;
			}
			
		}

		return max;

	}

	public static boolean isValid(char c) {
		if ((c - 'A' >= 0 && c - 'A' < 26) || (c - 'a' >= 0 && c - 'a' < 26)) {
			return true;
		}
		return false;
	}
}