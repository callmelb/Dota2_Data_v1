package com;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;

import com.alibaba.fastjson.JSONObject;
import com.ImageReorganization;
public class Test extends getjson {
	public static void main(String[] args) throws IOException{
		String match_id = "5289041688";
		
        
		total(match_id);
	}

	
	public static void total(String match_id){
		JSONObject json = readTxttoJson("f:/testdata/data/"+match_id+"/"+match_id+".json");
		String title = "「#"+(String) json.get("league_name")+"#」";
		System.out.println(title.length());
		String qrCodePath = "f:/testdata/data/"+match_id+"/"+match_id+".png";
		String outPutPath = "f:/testdata/data/"+match_id+"/"+match_id+"show"+".png";
		String heroPath = "D:\\项目\\dota2_data\\hero_imgs\\4.png";
		String iconPath = "D:\\学习\\Java\\workspace\\IMG_Test\\src\\icon1.png";
		String team_r_name =  json.get("radiant_team").toString();
		String team_d_name =  json.get("dire_team").toString();
		String team_rPath = "F:\\testdata\\team_imgs\\"+team_r_name+".png";
		String team_dPath = "F:\\testdata\\team_imgs\\"+team_d_name+".png";
		String r_score =  json.getInteger("r_score").toString();
		String d_score =  json.getInteger("d_score").toString();
		String winner = (String) json.get("win_team");
		String duration = json.getInteger("duration").toString();
	
		
		String r = json.getString("radiant_heroids");
		String rr =r.substring(0,r.length());
		ArrayList r_list = new ArrayList(Arrays.asList(rr.split(",")));

		String d = json.getString("dire_heroids");
		String dd =d.substring(0,d.length());
		ArrayList d_list = new ArrayList(Arrays.asList(dd.split(",")));
		
		
		ImageReorganization ir = new ImageReorganization();
		ir.overlapImage(title, qrCodePath, outPutPath, heroPath, iconPath, team_rPath, team_dPath, team_r_name, team_d_name, r_score, d_score, winner,r_list,d_list);
		System.out.println("绘制完成!");
		
	}
}
