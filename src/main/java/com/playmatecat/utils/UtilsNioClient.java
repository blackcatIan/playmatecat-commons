package com.playmatecat.utils;

import java.util.concurrent.ConcurrentHashMap;

import org.apache.log4j.Logger;
import org.apache.mina.core.session.IoSession;

import com.playmatecat.mina.NioTransferAdapter;
import com.playmatecat.mina.client.NioTCPClient;

/**
 * mina Nio客户端工具类
 * @author blackcat
 *
 */
public class UtilsNioClient {
	private static Logger logger = Logger.getLogger(UtilsNioClient.class);
	
	public final static ConcurrentHashMap<String, NioTransferAdapter> resultMap = new ConcurrentHashMap<String, NioTransferAdapter>();
	
	private UtilsNioClient(){}
	
	/**
	 * 
	 */
	public static void write(NioTransferAdapter nta) {
		//若未创建连接，则创建
		if(NioTCPClient.getConnector() == null) {
			try {
				NioTCPClient.init();
			} catch (Exception e) {
				logger.error("创建nio连接失败！", e);
			}
		}
		
		IoSession session = NioTCPClient.getSession();
		String GUID = UtilsGUID.getGUID();
		nta.setGUID(GUID);
		
		System.out.println("write sesion!!!!");
		session.write(nta);
		
//		//获得返回数据
//		while(true) {
//			NioTransferAdapter rtnNta = resultMap.get(GUID);
//			if(rtnNta != null) {
//				//释放空间
//				resultMap.remove(GUID);
//				System.out.println("I got " + rtnNta.getJSONdata());
//				return;
//			}
//		}
		
	}
}
