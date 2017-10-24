import java.io.*;
import java.util.*;

class folder {
	int indegree;
	int outdegree;
	boolean isShared;
	Set<Integer> cow;
	public folder (int indegree, int outdegree, boolean isShared) {
		this.indegree = indegree;
		this.outdegree = outdegree;
		this.isShared = isShared;
		cow = new HashSet<Integer>();
	}
}

public class folderAndCow{
	public static void main(String[] args){
		//Scanner sc = new Scanner(System.in);
		try{
		Scanner sc = new Scanner(new File("test.txt"));
		int Q = sc.nextInt(); // num of cows

		int M = sc.nextInt();  //num of shared folders 
		int N = sc.nextInt();  //num of confidential folders

		Map<Integer, folder> folderSet = new HashMap<>();

		for (int i = 0; i < M; i++) {
			int id_s = sc.nextInt();
			folderSet.put(id_s, new folder(0, 0, true));

			int cow_num = sc.nextInt();

		    String[] cowS_string = sc.nextLine().split(" ");
		    //System.out.println("string:" + cowS_string[1]);
		    int[] cow_s = new int[cow_num + 1];
		    for (int k = 1; k < cow_num + 1 ; k++) {
		    	cow_s[k] = Integer.parseInt(cowS_string[k]);
		    	folderSet.get(id_s).cow.add(cow_s[k]);
		    }
			
		}

		for (int i = 0; i < N; i++) {
			int id_c = sc.nextInt();
			folderSet.put(id_c, new folder(0, 0, false));

			int cow_num = sc.nextInt();

	        String[] cowC_string = sc.nextLine().split(" ");
	        int[] cow_c = new int[cow_num + 1];
	        for (int k = 1; k < cow_num + 1 ; k++) {
	        	cow_c[k] = Integer.parseInt(cowC_string[k]);
	        	folderSet.get(id_c).cow.add(cow_c[k]);
	        }
			
		}


		//construct tree structure
		Map<Integer, ArrayList<Integer>> map = new HashMap<>();
		int G = sc.nextInt();
		for (int i = 0; i < G; i++) {
			int parent_id = sc.nextInt();
			folderSet.get(parent_id).outdegree += 1;
			if (!map.containsKey(parent_id)) {
				map.put(parent_id, new ArrayList<Integer>());
			}
			int son_id = sc.nextInt();
			folderSet.get(son_id).indegree += 1;
			map.get(parent_id).add(son_id);
		}


		//System.out.println("tree:" + map.get(1).get(0)+ map.get(1).get(1));
		//System.out.println("outdegree" + folderSet.get(1).outdegree);

		int root = 0;
		for (int key : folderSet.keySet()) {
			if (folderSet.get(key).indegree == 0) {
				root = key;
			}
		}

		Map<Integer, ArrayList<Integer>> cowAccess = new HashMap<>();

		//bfs
		bfs(root, map, folderSet, cowAccess);

		//leafs
		int leaf_num = 0;
		for (int key: folderSet.keySet()) {
			if (folderSet.get(key).outdegree == 0) {
				leaf_num += 1;
			}
		}
		//System.out.println("leaf" + leaf_num);


		ArrayList<Integer> uncool = new ArrayList<>();
		for (int key : cowAccess.keySet()) {
			if (cowAccess.get(key).size() != leaf_num) {
				uncool.add(key);
				//System.out.println("key" + key);
			}
		}

		Collections.sort(uncool);
		//output
		for (int i = 0; i < uncool.size() - 1; i++) {
			System.out.print(uncool.get(i) + " ");
		}
		System.out.print(uncool.get(uncool.size() - 1));




		/*
		System.out.println("Result:shared");
		for (int key: shared.keySet()) {
			System.out.println("key:" + key);
			ArrayList<Integer> arr = shared.get(key);
			System.out.println("value:");
			for (int i = 0; i < arr.size(); i++) {
				System.out.print(" " + arr.get(i));
			}	
		}*/

     }
     catch (FileNotFoundException e) {
     	e.printStackTrace();
     }

	}

	public static void bfs(int root, Map<Integer, ArrayList<Integer>> map, Map<Integer, folder> folderSet, 
		                   Map<Integer, ArrayList<Integer>> cowAccess) {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(root);

		while (!queue.isEmpty()) {
			int node_id = queue.poll();
			for (int son: map.get(node_id)) {
				if (folderSet.get(son).isShared) {
					folderSet.get(son).cow.addAll(folderSet.get(node_id).cow);
				}
				if (folderSet.get(son).outdegree != 0) {
					queue.offer(son);
				} else {  //leaf
					for (int c : folderSet.get(son).cow) {
						if (!cowAccess.containsKey(c)) {
							cowAccess.put(c, new ArrayList<Integer>());
						}
						cowAccess.get(c).add(son);
					}
					
				}
			}
		}
	}


	
}