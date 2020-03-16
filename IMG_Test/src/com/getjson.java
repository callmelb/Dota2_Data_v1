package com;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONObject.*;
import org.apache.commons.io.FileUtils;

public class getjson {
	public static void main(String[] args) throws IOException {		
		/*JSONObject json = readTxttoJson("f:/test1.json");
		System.out.println(json.get("radiant_team"));
		System.out.println(json.get("league_name"));
		System.out.println(json.get("r_score"));
		String aa = json.get("radiant_heroids").toString().trim();
		String aaa =aa.substring(1,aa.length()-1);
		System.out.println(aaa);
		ArrayList list = new ArrayList(Arrays.asList(aaa.split(",")));
		System.out.println(list.get(1).toString().trim());*/
		}
	public static JSONObject readTxttoJson(String txt){
		File file = new File(txt);
		String jsonStr = "";
		FileInputStream fis = null;
		InputStreamReader isr = null;
		BufferedReader br = null;
		try {
			fis = new FileInputStream(file);
			isr = new InputStreamReader(fis,"utf-8");
			br = new BufferedReader(isr);
			String line = null;
			while((line = br.readLine()) != null){
						jsonStr += line;
			}
			return JSONObject.parseObject(jsonStr);
		} catch (IOException e) {
			return null;
		}finally{		
			if(br != null){
				
				try {
					br.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(isr != null){
				
				try {
					br.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(fis != null){
				
				try {
					br.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
		
	//}
	
}