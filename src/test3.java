import java.util.ArrayList;
import java.util.Random;

public class test3 {
	public static void main(String args[]) {
		Random r = new Random();
		ArrayList<LFSR> g = new ArrayList<LFSR>();
		LFSR a = new LFSR(0xF,0xFL); //2⁴ //init, mask
		LFSR b = new LFSR(0xF,0xCL); //2⁴
		LFSR c = new LFSR(0x7,0xAL); //2⁵
		LFSR d = new LFSR(0xF,0x9L); 	
		LFSR e = new LFSR(0x7,0xCL); 
		LFSR f = new LFSR(0x3,0x9L);
		LFSR g1 = new LFSR(0x7,0x6L);
		g.add(a); 
		g.add(b); 
		g.add(c); 
		g.add(d); 
		g.add(e);
		g.add(f); 
		g.add(g1); 
		long start = System.currentTimeMillis();
		for(int j = 0; j < g.size(); j++) 
			for (int i = 0; i < 1000; i++)
				g.get(j).update();

		int l = r.nextInt(g.size());
		int[] ut = new int[10000];
		int p = 0;
		for (int i = 0; i < ut.length; i++) {
			p = l;
			ut[i] = g.get(l).ut();
			//System.out.print(ut[i]);
			while(p == l) {
				g.get(l).update();
				l = fun((int)g.get(l).getInit());
			}
		}
		//System.out.println();
		berlekamp_massey(ut);
		System.out.println("Tok "+((System.currentTimeMillis()-start)/1000.0)+" sekund");
	}
	public static int fun(int n) {
		return ((0x7 & n) > 6 ? 3 : 0x1&n) ^ 2;
	}
	
	public static int[] berlekamp_massey(int[] s) {
		final int N = s.length;
		int[] b = new int[N];
		int[] c = new int[N];
		int[] temp = new int[N];
		b[0] = 1; 
		c[0] = 1;
		int l = 0; int m = -1; int d = 0;
		for (int n = 0; n < N; n++) {
			d = 0;
			for(int i = 0; i <= l; i++) 
				d ^= c[i] * s[n-i]; //Computing n-th discrepancy
			if(d == 1) { //If n-th discrepancy is one, calculate new generating polynomial and complexity
				for(int i = 0; i < N; i++) 
					temp[i] = c[i];
				for (int i = 0; i < N - (n-m); i++) 
					c[(n-m) + i] ^= b[i];
				if (l <= n / 2) {
					l = n + 1 - l;
					m = n;
					for(int i = 0; i < N; i++)
						b[i] = temp[i];
				}
			}
		}

		//Checking if discrepancy is 0 for every l-subsequence
		for(int j = 1; j < N-l; j++) {
			d = (int) s[N-j];
			for(int i = 1; i <= l; i++) 
				d ^= c[i]*s[N-i-j];
			if(d != 0) System.out.println("Error!");
		}
		System.out.println("Complexity is "+l);
		System.out.print("Generating polynomial is: ");
		for(int i = 0; i < l; i++) 
			System.out.print((c[i] > 0) ? "x^"+(l-i)+((i<l-1) ? "+" : "") : "");
		System.out.println("+1");
		
		return c;
	}
}
