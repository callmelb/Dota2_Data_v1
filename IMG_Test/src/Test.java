import java.util.ArrayList;
import java.util.Arrays;

import com.alibaba.fastjson.JSONObject;

public class Test extends getjson {
	public static void main(String[] args) {
		String match_id = "5212816885";
		
	}

	
	public void total(String match_id){
		JSONObject json = readTxttoJson("f:/testdata/data/"+match_id+"/"+match_id+".json");
		System.out.println(json.get("radiant_team"));
		System.out.println(json.get("league_name"));
		System.out.println(json.get("r_score"));
		String aa = json.get("radiant_heroids").toString().trim();
		String aaa =aa.substring(1,aa.length()-1);
		System.out.println(aaa);
		ArrayList list = new ArrayList(Arrays.asList(aaa.split(",")));
		System.out.println(list.get(1).toString().trim());
		
		
	}
}
