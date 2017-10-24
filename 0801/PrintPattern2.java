public class PrintPattern2 {
	public static void main(String[] args) {
		for (int i = 1; i <= 3; i++){
			char ch = 'a';
			char print = ch;
			for (int j = 0; j < i; j++) {
				System.out.print(ch++);
			}
			System.out.println();
			
		}
		
	}
}