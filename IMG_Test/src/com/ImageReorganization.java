package com;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
 
/**
 * Created by zj on 2018/10/18.
 */
public class ImageReorganization {
 
    public static void main(String[] args) {
    	String title = "��#2020 SLI����minor#�� BO5";
        //String backgroundPath = "D:\\ѧϰ\\Java\\workspace\\IMG_Test\\src\\bg3.png";
        //String qrCodePath = "D:\\ѧϰ\\Java\\workspace\\IMG_Test\\src\\data.png";
        String qrCodePath = "D:\\��Ŀ\\dota2_data\\Weplay!������ս��\\���þ�������.png";
        String icon = "D:\\ѧϰ\\Java\\workspace\\IMG_Test\\src\\icon1.png";
        String hero_1 = "D:\\��Ŀ\\dota2_data\\hero_imgs\\Storm Spirit.png";
        String team_r = "D:\\ѧϰ\\Java\\workspace\\IMG_Test\\src\\Aster.png";
        String team_d = "D:\\ѧϰ\\Java\\workspace\\IMG_Test\\src\\Alliance.png";
        String team_r_name = "Aster";
        String team_d_name = "Alliance";
        String outPutPath="end.jpg";
        String r_score = "31";
        String d_score = "18";
        String winner = "winner!";
        //overlapImage(title,qrCodePath,outPutPath,hero_1,icon,team_r,team_d,team_r_name,team_d_name,r_score,d_score,winner,);
    }
 
    public static  String overlapImage(String title,String qrCodePath,String outPutPath,String hero_1Path,String iconPath,String team_rPath,String team_dPath,String team_r_name,String team_d_name, String r_score, String d_score, String winner,
    		ArrayList r_list,ArrayList d_list){
        try {
            //����ͼƬ��С
//            BufferedImage background = resizeImage(618,1000, ImageIO.read(new File("�����Ǳ���ͼƬ��·����")));
        	String backgroundPath = "D:\\ѧϰ\\Java\\workspace\\IMG_Test\\src\\bg3.png";
            BufferedImage background = resizeImage(1000,900, ImageIO.read(new File(backgroundPath)));
//            BufferedImage qrCode = resizeImage(150,150,ImageIO.read(new File("�����ǲ����ά��ͼƬ��·����")));
            BufferedImage qrCode = resizeImage(996,600,ImageIO.read(new File(qrCodePath)));
    
            BufferedImage icon = resizeImage(50,50,ImageIO.read(new File(iconPath)));
            BufferedImage team_r = resizeImage(150,90,ImageIO.read(new File(team_rPath)));
            BufferedImage team_d = resizeImage(150,90,ImageIO.read(new File(team_dPath)));
            //�ڱ���ͼƬ���������Ҫд�����Ϣ�����磺ɨ���·���ά�룬��ӭ�������ҵ��Ա����������ˣ��Ӽұر���ʡǮ����ר��С���飡
            //String message = "ɨ���·���ά�룬��ӭ�������ҵ��Ա����������ˣ��Ӽұر���ʡǮ����ר��С���飡";
            Graphics2D g = background.createGraphics();g.setColor(Color.white);g.setFont(new Font("����",Font.ITALIC,40));
            Graphics2D g2 = background.createGraphics();g2.setColor(new Color(153,170,64));g2.setFont(new Font("����",Font.BOLD,36));
            Graphics2D g3 = background.createGraphics();g3.setColor(new Color(198,56,42));g3.setFont(new Font("����",Font.BOLD,36));
            Graphics2D g4 = background.createGraphics();g4.setColor(new Color(153,170,64));g4.setFont(new Font("Comic Sans MS",Font.ITALIC,30));
            Graphics2D g5 = background.createGraphics();g5.setColor(new Color(198,56,42));g5.setFont(new Font("Comic Sans MS",Font.ITALIC,30));
            g.drawString(title,160,50);
            g2.drawString(team_r_name,300,150);
            g2.drawString(r_score, 455, 155);
            if (winner.equals(team_r_name)){
            	g4.drawString("winner!", 110, 90);
            }else{
            	g5.drawString("winner!", 800, 90);
            }
            
            g.drawString(":",490,150);
            g3.drawString(team_d_name, 600, 150);
            g3.drawString(d_score, 515, 155);
            g.drawImage(icon, 475, 210, icon.getWidth(), icon.getHeight(), null);
//            g.drawString(message02,530 ,220);
            //�ڱ���ͼƬ����Ӷ�ά��ͼƬ
            g.drawImage(qrCode, 2, 280, qrCode.getWidth(), qrCode.getHeight(), null);
            g.drawImage(team_r, 80, 100, team_r.getWidth(), team_r.getHeight(), null);
            g.drawImage(team_d, 770, 100, team_d.getWidth(), team_d.getHeight(), null);
            
            
            System.out.println("r:"+r_list);
            BufferedImage hero_1_1 = resizeImage(90,50,ImageIO.read(new File("D:\\��Ŀ\\dota2_data\\hero_imgs\\"+r_list.get(0).toString().trim()+".png")));
            BufferedImage hero_1_2 = resizeImage(90,50,ImageIO.read(new File("D:\\��Ŀ\\dota2_data\\hero_imgs\\"+r_list.get(1).toString().trim()+".png")));
            BufferedImage hero_1_3 = resizeImage(90,50,ImageIO.read(new File("D:\\��Ŀ\\dota2_data\\hero_imgs\\"+r_list.get(2).toString().trim()+".png")));
            BufferedImage hero_1_4 = resizeImage(90,50,ImageIO.read(new File("D:\\��Ŀ\\dota2_data\\hero_imgs\\"+r_list.get(3).toString().trim()+".png")));
            BufferedImage hero_1_5 = resizeImage(90,50,ImageIO.read(new File("D:\\��Ŀ\\dota2_data\\hero_imgs\\"+r_list.get(4).toString().trim()+".png")));
            g.drawImage(hero_1_1, 0, 210, hero_1_1.getWidth(), hero_1_1.getHeight(), null);
            g.drawImage(hero_1_2, 95, 210, hero_1_2.getWidth(), hero_1_2.getHeight(), null);
            g.drawImage(hero_1_3, 190, 210, hero_1_3.getWidth(), hero_1_3.getHeight(), null);
            g.drawImage(hero_1_4, 285, 210, hero_1_4.getWidth(), hero_1_4.getHeight(), null);
            g.drawImage(hero_1_5, 380, 210, hero_1_5.getWidth(), hero_1_5.getHeight(), null);
            
            System.out.println("d:"+d_list);
            BufferedImage hero_2_1 = resizeImage(90,50,ImageIO.read(new File("D:\\��Ŀ\\dota2_data\\hero_imgs\\"+d_list.get(0).toString().trim()+".png")));
            BufferedImage hero_2_2 = resizeImage(90,50,ImageIO.read(new File("D:\\��Ŀ\\dota2_data\\hero_imgs\\"+d_list.get(1).toString().trim()+".png")));
            BufferedImage hero_2_3 = resizeImage(90,50,ImageIO.read(new File("D:\\��Ŀ\\dota2_data\\hero_imgs\\"+d_list.get(2).toString().trim()+".png")));
            BufferedImage hero_2_4 = resizeImage(90,50,ImageIO.read(new File("D:\\��Ŀ\\dota2_data\\hero_imgs\\"+d_list.get(3).toString().trim()+".png")));
            BufferedImage hero_2_5 = resizeImage(90,50,ImageIO.read(new File("D:\\��Ŀ\\dota2_data\\hero_imgs\\"+d_list.get(4).toString().trim()+".png")));
            g.drawImage(hero_2_1, 530, 210, hero_2_1.getWidth(), hero_2_1.getHeight(), null);
            g.drawImage(hero_2_2, 625, 210, hero_2_2.getWidth(), hero_2_2.getHeight(), null);
            g.drawImage(hero_2_3, 720, 210, hero_2_3.getWidth(), hero_2_3.getHeight(), null);
            g.drawImage(hero_2_4, 815, 210, hero_2_4.getWidth(), hero_2_4.getHeight(), null);
            g.drawImage(hero_2_5, 910, 210, hero_2_5.getWidth(), hero_2_5.getHeight(), null);
            g.dispose();
  

//            ImageIO.write(background, "jpg", new File("������һ�����ͼƬ��·��"));
            ImageIO.write(background, "jpg", new File(outPutPath));
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
 
    public static BufferedImage resizeImage(int x, int y, BufferedImage bfi){
        BufferedImage bufferedImage = new BufferedImage(x, y, BufferedImage.TYPE_INT_RGB);
        bufferedImage.getGraphics().drawImage(
                bfi.getScaledInstance(x, y, Image.SCALE_SMOOTH), 0, 0, null);
        return bufferedImage;
    }
}

