
public class bah {
	public static void main(String args[]) {
		for (int i = 0; i < 100; i++) {
			System.out.println(f(i));
		}
	}
	public static int f(int n) {
		return (0x7 & n) > 6 ? 3 : 0x7&n;
	}
}
//