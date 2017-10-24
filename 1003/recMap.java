import java.util.*;

class Coordinate{
	int x;
	int y;
	public Coordinate (int x, int y) {
		this.x = x;
		this.y = y;
	}
}
class recMap{
	public static void main(String[] args) {
		int[][] test = new int[7][3];
		test[0][0] = 5;
		test[0][1] = 4;
		test[0][2] = 4;
		test[1][0] = 4;
		test[1][1] = 3;
		test[1][2] = 4;
		test[2][0] = 3;
		test[2][1] = 2;
		test[2][2] = 4;
		test[3][0] = 2;
		test[3][1] = 2;
		test[3][2] = 2;
		test[4][0] = 3;
		test[4][1] = 3;
		test[4][2] = 4;
		test[5][0] = 1;
		test[5][1] = 4;
		test[5][2] = 4;
		test[6][0] = 4;
		test[6][1] = 1;
		test[6][2] = 1;

		int res = solution(test);
		System.out.println(res);
	}

	static int m,n;
	static int[] deltaX = {-1, 1, 0, 0};
	static int[] deltaY = {0, 0, -1, 1};

	public static int solution(int[][] A) {
		if (A == null || A.length == 0 || A[0].length == 0) {
			return 0;
		}

		n = A.length;   //rows
		m = A[0].length;  //cols
		int count = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (A[i][j] != Integer.MAX_VALUE) {
					//System.out.println("A = " + A[i][j]);
					markByBFS(A, i, j);
				    count++;
				    //System.out.println("count = " + count + "i = " + i + "j = " + j);
				}
			}
		}

		return count;

	}

	public static void markByBFS(int[][] A, int x, int y) {
		Queue<Coordinate> queue = new LinkedList<>();
		queue.offer(new Coordinate(x, y));
		int val = A[x][y];
		A[x][y] = Integer.MAX_VALUE;


		while (!queue.isEmpty()) {
			//System.out.println("*****");
			Coordinate node = queue.poll();
			for (int i = 0; i < 4; i++) {
				Coordinate neighbor = new Coordinate(node.x + deltaX[i], node.y + deltaY[i]);
				//System.out.println("neighbor = "+ neighbor.x + neighbor.y);

				if (!isValid(A, neighbor) || A[neighbor.x][neighbor.y] != val) {
					continue;
				}
				//System.out.println("pass");
				//System.out.println("neiVal = " + A[neighbor.x][neighbor.y]);
				if (A[neighbor.x][neighbor.y] == Integer.MAX_VALUE) {
					continue;
				}
				

				queue.offer(neighbor);
				//System.out.println("nei.x = " + neighbor.x + "nei.y = " + neighbor.y);
				A[neighbor.x][neighbor.y] = Integer.MAX_VALUE;
			}
		}

	}

	public static boolean isValid(int[][] A, Coordinate point) {
		int n = A.length;
		int m = A[0].length;
		if (point.x < 0 || point.x >= n) {
			return false;
		}

		if (point.y < 0 || point.y >= m) {
			return false;
		}

		return true;
	}
}