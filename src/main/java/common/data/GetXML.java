package common.data;

import java.io.*;
import java.util.*;
import org.dom4j.*; 
import org.dom4j.io.*;

public class GetXML {
	
	
	public static Object[][] getXML(String address,String caseId){
		File file = new File(address);
		SAXReader reader = new SAXReader();
		List<String> list_caseName = new ArrayList<String>();
		List<Map<String, String>> list_map = new ArrayList<Map<String,String>>();
		try {
			Document document = reader.read(file);
			Element root = document.getRootElement();
			Element foo = null;
			for(Iterator<Element> i = root.elementIterator(caseId);i.hasNext();){
				foo = i.next();
				Map<String, String> map = new HashMap<String, String>();
				for(Iterator<Element> ii = foo.elementIterator();ii.hasNext();){
					Element foo2 = ii.next();
					map.put(foo2.getName(), foo2.getTextTrim());	
				}
				try {
					list_caseName.add(map.get("caseName"));
				} catch (Exception e) {
					// TODO: handle exception
					list_caseName.add("这条用例没有用例名称!!!");
				}
				list_map.add(map);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		Object[][] objects = new Object[list_map.size()][2];
		for (int i = 0; i < list_map.size(); i++) {
			objects[i][0] = list_caseName.get(i);
			objects[i][1] = list_map.get(i);
		}
		return objects;
	}
}
