import java.util.ArrayList;
import java.util.Random;

public class test {
	public static void main(String args[]) {
		Random r = new Random();
		//long init = 0xFFFFL;
		LFSR a = new LFSR(0xF,0x9L); //2⁴ //init, mask
		LFSR b = new LFSR(0xF,0xCL); //2⁴
		LFSR c = new LFSR(0x7,0x6L); //2³
		LFSR d = new LFSR(1,0x9);
		LFSR e = new LFSR(2,0xCL);
		LFSR f = new LFSR(3,0x6L);
		LFSR g = new LFSR(0xF,0x9L);
		ArrayList<LFSR> graph = new ArrayList<LFSR>();
		graph.add(a);
		graph.add(b);
		graph.add(c);
		graph.add(d);
		graph.add(e);
		graph.add(f);
		graph.add(g);
		/*
		long ini = graph.get(0).getInit();
		graph.get(0).update();
		int ctr = 1;
		while(graph.get(0).getInit() != ini) {
			ctr++;
			graph.get(0).update();
		}
		System.out.println(ctr+"\n");
		 */

		for(int j = 0; j < graph.size(); j++) {
			for(int i = 0; i < 0xFFF; i++) {
				//graph.get(j).update();
			}
		}
		/*
		int[] ut1 = graph.get(0).getNextN(100);
		int[] ut2 = graph.get(1).getNextN(100);
		int[] ut3 = graph.get(2).getNextN(100);
		*/
		long[] ut = new long[100];
		long l = r.nextInt(7);
		long p = 0;
		for (int i = 0; i < ut.length; i++) {
			ut[i] = graph.get((int)l).ut();
			System.out.print(ut[i]);
			p = l;
			//System.out.println(fun((int)graph.get(l).getInit()));
			//System.out.println(p);
			l = fun(graph.get((int)p).getInit());
			if(p == l) {
				graph.get((int)p).update();
				l = fun(graph.get((int)p).getInit());				
			}
		}
		System.out.println();
		int[] ny = berlekamp_massey(ut);
		for(int i = 0; i < ny.length; i++) {
			System.out.print(ny[i]);
		}
		
		for(int i = 0; i < graph.size(); i++) {
			//System.out.println(fun(graph.get(i).getInit()));
			//graph.get(i).update();
		}
		
	}
	public static int bin2int(int [] in) {
		int ret = 0;
		for(int i = 0; i < in.length; i++) 
			ret += in[i]*Math.pow(2,in.length-i-1);
		return ret;
	}
	
	public static int[] berlekamp_massey(long[] s) {
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
	public static int f(int x1, int x2, int x3) {
		return (x1*x2)^x1^x2^x3;
	}
	
	public static long fun(long n) {
		return (0x7 & n) > 6 ? 3 : 0x7&n;

	}
}
