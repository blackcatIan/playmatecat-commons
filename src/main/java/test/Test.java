package test;

import com.playmatecat.mina.NioTransferAdapter;
import com.playmatecat.utils.UtilsNioClient;

public class Test {
	public static void main(String[] args) throws Exception{
		
		NioTransferAdapter nta1;
		long start = System.currentTimeMillis();
		for(int i = 0;i < 100;i++) {
			nta1 = new NioTransferAdapter(String.valueOf(i), "{}", null);
			UtilsNioClient.write(nta1);
		}
		long end = System.currentTimeMillis();
		System.out.println("finish:" + (end -start) + " ms");
	}
}
