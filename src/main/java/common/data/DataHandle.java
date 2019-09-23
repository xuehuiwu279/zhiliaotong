package common.data;

import java.util.Map;

import com.alibaba.fastjson.JSON;

public class DataHandle {
	
	/**
	 * String类型转化为Map
	 * @param str
	 * @return
	 */
	public static Map<String, String>  strToMap(String str){
		@SuppressWarnings("unchecked")
		Map<String, String> map = JSON.parseObject(str, Map.class);
		return map;
	}

}
