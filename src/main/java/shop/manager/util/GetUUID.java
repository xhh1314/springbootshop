package shop.manager.util;

import java.util.UUID;

public class GetUUID {
	
	private static final SnowflakeIdWorker sfid=new SnowflakeIdWorker(1,1);
	
	public static String  getUuid(){
		
		return Double.toString(sfid.nextId());
		//return UUID.randomUUID().toString();
		
	}
	

}
