package sw3131;

public class Solution {
	public static void main(String[] args) {
		boolean chk[] = new boolean[1000000];

		int k = 2;
		while (true) {

			if (k > chk.length / 2)
				break;

			for (int i = 2; i * k < chk.length; i++) {
				chk[i * k] = true;
			}
			k++;
		}
		for (int i = 2; i < chk.length; i++)
			if (!chk[i])
				System.out.print(i + " ");
		
	}
}
