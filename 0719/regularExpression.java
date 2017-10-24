public class regularExpression{
	public static void main(String[] args){
		String s="The sky is  blue";
		String[] words = s.trim().split("\\s+");

		StringBuilder res = new StringBuilder();
		for (int i=words.length-1;i>=0;i--){
			if(i==0){
				res.append(words[i]);
			}
			else{
				res.append(words[i]+" ");
			}
		}
		System.out.println(res.toString());
	}
}