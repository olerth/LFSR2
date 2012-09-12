
public class teste {
	public static void main(String args[]) {
		long a = 0x72L;
		//System.out.println(Long.toBinaryString(a));
		long b = a>>1;
		//System.out.println(a/b);
		b = d(a);
		System.out.println(a+"' = "+b);
		System.out.println(deg(a));
	}

	static long d(long x) {
		for(long i = 1; i < x; i<<=2) 
			if((x & i) == i) 
				x^=i;
		return x>>1;
	}
	static int deg(long x) {
		int d = 0;
		for(int i = 1; i < x; i<<=1) {
			if((x&i)==i)
				d = i;
		}
		return (int)(Math.log(d)/Math.log(2));
	}
}
