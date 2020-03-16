import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
 
/**
 * Created by zj on 2018/10/18.
 */
public class ImageReorganization {
 
    public static void main(String[] args) {
    	String title = "��#2020 SLI����minor#�� BO5";
        String backgroundPath = "D:\\ѧϰ\\Java\\workspace\\IMG_Test\\src\\bg3.png";
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
        overlapImage(backgroundPath,title,qrCodePath,outPutPath,hero_1,icon,team_r,team_d,team_r_name,team_d_name,r_score,d_score,winner);
    }
 
    public static String overlapImage(String backgroundPath,String title,String qrCodePath,String outPutPath,String heroPath,String iconPath,String team_rPath,String team_dPath,String team_r_name,String team_d_name, String r_score, String d_score, String winner){
        try {
            //����ͼƬ��С
//            BufferedImage background = resizeImage(618,1000, ImageIO.read(new File("�����Ǳ���ͼƬ��·����")));
            BufferedImage background = resizeImage(1000,900, ImageIO.read(new File(backgroundPath)));
//            BufferedImage qrCode = resizeImage(150,150,ImageIO.read(new File("�����ǲ����ά��ͼƬ��·����")));
            BufferedImage qrCode = resizeImage(996,600,ImageIO.read(new File(qrCodePath)));
            BufferedImage hero_1 = resizeImage(90,50,ImageIO.read(new File(heroPath)));
            BufferedImage icon = resizeImage(50,50,ImageIO.read(new File(iconPath)));
            BufferedImage team_r = resizeImage(150,90,ImageIO.read(new File(team_rPath)));
            BufferedImage team_d = resizeImage(150,90,ImageIO.read(new File(team_dPath)));
            //�ڱ���ͼƬ���������Ҫд�����Ϣ�����磺ɨ���·���ά�룬��ӭ�������ҵ��Ա����������ˣ��Ӽұر���ʡǮ����ר��С���飡
            //String message = "ɨ���·���ά�룬��ӭ�������ҵ��Ա����������ˣ��Ӽұر���ʡǮ����ר��С���飡";
            Graphics2D g = background.createGraphics();g.setColor(Color.white);g.setFont(new Font("����",Font.ITALIC,40));
            Graphics2D g2 = background.createGraphics();g2.setColor(new Color(153,170,64));g2.setFont(new Font("����",Font.BOLD,36));
            Graphics2D g3 = background.createGraphics();g3.setColor(new Color(198,56,42));g3.setFont(new Font("����",Font.BOLD,36));
            Graphics2D g4 = background.createGraphics();g4.setColor(new Color(153,170,64));g4.setFont(new Font("Comic Sans MS",Font.ITALIC,28));
            g.drawString(title,250,50);
            g2.drawString(team_r_name,300,150);
            g2.drawString(r_score, 450, 155);
            g4.drawString(winner, 110, 90);
            g.drawString(":",490,150);
            g3.drawString(team_d_name, 600, 150);
            g3.drawString(d_score, 510, 155);
            g.drawImage(icon, 475, 210, icon.getWidth(), icon.getHeight(), null);
//            g.drawString(message02,530 ,220);
            //�ڱ���ͼƬ����Ӷ�ά��ͼƬ
            g.drawImage(qrCode, 2, 280, qrCode.getWidth(), qrCode.getHeight(), null);
            g.drawImage(team_r, 80, 100, team_r.getWidth(), team_r.getHeight(), null);
            g.drawImage(team_d, 770, 100, team_d.getWidth(), team_d.getHeight(), null);
            
            g.drawImage(hero_1, 0, 210, hero_1.getWidth(), hero_1.getHeight(), null);
            g.drawImage(hero_1, 95, 210, hero_1.getWidth(), hero_1.getHeight(), null);
            g.drawImage(hero_1, 190, 210, hero_1.getWidth(), hero_1.getHeight(), null);
            g.drawImage(hero_1, 285, 210, hero_1.getWidth(), hero_1.getHeight(), null);
            g.drawImage(hero_1, 380, 210, hero_1.getWidth(), hero_1.getHeight(), null);
            
            g.drawImage(hero_1, 530, 210, hero_1.getWidth(), hero_1.getHeight(), null);
            g.drawImage(hero_1, 625, 210, hero_1.getWidth(), hero_1.getHeight(), null);
            g.drawImage(hero_1, 720, 210, hero_1.getWidth(), hero_1.getHeight(), null);
            g.drawImage(hero_1, 815, 210, hero_1.getWidth(), hero_1.getHeight(), null);
            g.drawImage(hero_1, 910, 210, hero_1.getWidth(), hero_1.getHeight(), null);
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

