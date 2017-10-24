public class SortArray{
	public static void main(String[] args){
		int[] test = {0,1,2,3};
		int[] res = resverseArray(test);
 		for (int i = 0; i < res.length; i++){
 			System.out.print(res[i] + " ");
 		}
 		System.out.println();
		

	}
	public static int[] resverseArray(int[] arr){
		int temp, originalLen = arr.length;
		int len = originalLen;
		for (int i = 0; i < originalLen/2; i++){
			temp = arr[len - 1];
			arr[len - 1] = arr[i];
			arr[i] = temp;
			len -= 1;
		}
		return arr;
	}
}