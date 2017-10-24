public class reverseWord{
	public static void main(String[] args) {
		String test = "Hello World";
		String test2 = reverse(test);
		System.out.println(test2);

	}

	public static String reverse(String s) {
		if (s == null || s.length() == 0) {
			return s;
		}

		String[] words = s.split("\\s+");
		StringBuilder res = new StringBuilder();

		for (String w: words) {
			res.append(new StringBuilder(w).reverse() + " ");
		}

		return res.toString().trim();
	}
}