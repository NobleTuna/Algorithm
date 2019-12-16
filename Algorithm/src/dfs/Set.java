package dfs;

public class Set {
	static int cnt = 0;
	public static void main(String[] args) {
		int[] arr = new int[5];
		for(int i=0; i<arr.length; i++) {
			arr[i] = i+1;
		}
		boolean[] chk = new boolean[5];
		go(arr, chk, 0);
		System.out.println(cnt);
	}
	public static void go(int[] arr, boolean[] chk, int idx) {
		if(idx==5) {
			for(int i=0; i<5; i++) {
				if(chk[i]) {
					System.out.print(arr[i]);
				}
			}System.out.println();
			cnt++;
			return;
		}
		chk[idx] = true;
		go(arr, chk, idx+1);
		chk[idx] = false;
		go(arr, chk, idx+1);
		
	}

}
