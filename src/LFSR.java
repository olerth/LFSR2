
public class LFSR {
	long init, mask, res;
	boolean bit;

	public LFSR() {
		setInit(2^(19)-1);
		setMask(0x72001);
	}

	public LFSR(long init, long mask) {
		setInit(init);
		setMask(mask);
	}

	public void setInit(long init) {
		this.init = init; 
	}

	public long getInit() {
		return init;
	}

	public String getInitHex() {
		return Long.toHexString(init);
	}

	public String getInitBin() {
		return Long.toBinaryString(init);
	}

	public void setMask(long mask) {
		this.mask = mask;
	}

	public long getMask() {
		return mask;
	}

	public String getMaskHex() {
		return Long.toHexString(mask);
	}


	public String getMaskBin() {
		return Long.toBinaryString(mask);
	}
	
	public void update() {
		init = (init >> 1) ^(-(init&1)&mask);
	}
	
	public int ut() {
		init = (init >> 1) ^(-(init&1)&mask);
		return (int) (init & 1);
	}
	
	public int[] getNextN(int n) {
		int[] ret = new int[n];
		for(int i = 0; i < n; i++) {
			ret[i] = (int)ut();
		}
		return ret;
	}

	public String toString() {
		return "Polynomial: 0x"+getMaskHex();
	}
}
