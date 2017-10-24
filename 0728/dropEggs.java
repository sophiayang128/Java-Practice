public class dropEggs {
	public static void main(String[] args) {
		int n = 100;
		System.out.println(dE(n));
	}

	public static int dE(int n) {
		long ans = 0;
		for (int i = 1; ; ++i) {
			ans += (long)i;
			System.out.println("ans " + ans);
			System.out.println("i " + i);
			if (ans >= (long)n) {
				return i;
			}
		}
	}
}