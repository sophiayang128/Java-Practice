import java.util.*;

public class simplifyString{
	public static void main(String[] args) {
		String test = "AAAAAABBBCC";
		String test2 = simplify(test);
		System.out.println(test2);

	}

	public static String simplify(String s) {
		if (s == null || s.length() == 0) {
			return s;
		}

		Map<Character, Integer> map = new HashMap<>();

		for (char c: s.toCharArray()) {
			if (map.containsKey(c)) {
				map.put(c, map.get(c) + 1);
			}else {
				map.put(c, 1);
			}
		}

		String res = "";

		for (char key: map.keySet()) {
			res += map.get(key);
			res += key;
		}
		/*
		for (Map.Entry<Character, Integer> entry: map.entrySet()) {
			res += entry.getValue();
			res += entry.getKey();
		}
		*/

		return res;

	}
}