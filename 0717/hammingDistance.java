public class hammingDistance{
	public static void main(String[] arg){
	    int x=1,y=4;
	    System.out.println(distance(x,y));
	    }

	
	public static int distance(int x, int y){
		int xor=x^y;
		int count=0;
	    while(xor!=0){
	    	count+=xor & 1;
	    	xor>>=1;
	    }
	    return count;
	}
}