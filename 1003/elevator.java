import java.util.*;
class elevator{
	public static void main(String[] args) {
		int[] A = {60, 80, 40};
		int[] B = {2, 3, 5};
		int M = 5;
		int X = 2;
		int Y = 200;
		int res = solution(A, B, M, X, Y);
		System.out.println(res);

	}
	public static int solution(int[] A, int[] B, int M, int X, int Y) {
		if (A == null || B == null || A.length == 0 || B.length == 0) {
			return 0;
		}

		int count = 0;
		int peopleNum = A.length;
		int i = 0,j = 0;

		while (i < peopleNum) {
			int w = 0;   //weight
			j = i;   //the pointer point to the first people of one time elevator
			Set<Integer> set = new HashSet<>();   //store the target floor
			while ( i < peopleNum && i - j < X && w + A[i] <= Y) {
				w += A[i];
				set.add(B[i]);
				i++;
			}
			count += set.size() + 1;    //target floors + ground floor
		} 
		return count;

	}
}