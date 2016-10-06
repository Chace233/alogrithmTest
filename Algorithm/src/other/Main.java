package other;
import java.util.Arrays;
import java.util.Scanner;


public class Main {
	public static void main(String[] args){
		Main ain = new Main();
		int n = 0, m = 0;
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		m = in.nextInt();
		int[] ts = new int[n];
		Scanner inp = new Scanner(System.in);
		for(int i = 0; i < n; i++){
			ts[i] = inp.nextInt();
		}
		int res = ain.numOf(m, ts);
		System.out.println(res);
	}
	
	public int numOf(int m , int[] ts){
		int num = 0;
		Arrays.sort(ts);
		for(int i = 0; i < ts.length-1; i++){
			for(int j = ts.length-1; j > i ; j--){
				if((ts[i] ^ ts[j]) > m){
					num ++;
				}else{
					break;
				}
			}
		}
		return num;
	}
}
