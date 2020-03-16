import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
 
/**
 * Created by zj on 2018/10/18.
 */
public class ImageReorganization {
 
    public static void main(String[] args) {
    	String title = "「#2020 SLI基辅minor#」 BO5";
        String backgroundPath = "D:\\学习\\Java\\workspace\\IMG_Test\\src\\bg3.png";
        //String qrCodePath = "D:\\学习\\Java\\workspace\\IMG_Test\\src\\data.png";
        String qrCodePath = "D:\\项目\\dota2_data\\Weplay!狂月挑战赛\\经济经验曲线.png";
        String icon = "D:\\学习\\Java\\workspace\\IMG_Test\\src\\icon1.png";
        String hero_1 = "D:\\项目\\dota2_data\\hero_imgs\\Storm Spirit.png";
        String team_r = "D:\\学习\\Java\\workspace\\IMG_Test\\src\\Aster.png";
        String team_d = "D:\\学习\\Java\\workspace\\IMG_Test\\src\\Alliance.png";
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
            //设置图片大小
//            BufferedImage background = resizeImage(618,1000, ImageIO.read(new File("这里是背景图片的路径！")));
            BufferedImage background = resizeImage(1000,900, ImageIO.read(new File(backgroundPath)));
//            BufferedImage qrCode = resizeImage(150,150,ImageIO.read(new File("这里是插入二维码图片的路径！")));
            BufferedImage qrCode = resizeImage(996,600,ImageIO.read(new File(qrCodePath)));
            BufferedImage hero_1 = resizeImage(90,50,ImageIO.read(new File(heroPath)));
            BufferedImage icon = resizeImage(50,50,ImageIO.read(new File(iconPath)));
            BufferedImage team_r = resizeImage(150,90,ImageIO.read(new File(team_rPath)));
            BufferedImage team_d = resizeImage(150,90,ImageIO.read(new File(team_dPath)));
            //在背景图片中添加入需要写入的信息，例如：扫描下方二维码，欢迎大家添加我的淘宝返利机器人，居家必备，省钱购物专属小秘书！
            //String message = "扫描下方二维码，欢迎大家添加我的淘宝返利机器人，居家必备，省钱购物专属小秘书！";
            Graphics2D g = background.createGraphics();g.setColor(Color.white);g.setFont(new Font("楷体",Font.ITALIC,40));
            Graphics2D g2 = background.createGraphics();g2.setColor(new Color(153,170,64));g2.setFont(new Font("楷体",Font.BOLD,36));
            Graphics2D g3 = background.createGraphics();g3.setColor(new Color(198,56,42));g3.setFont(new Font("楷体",Font.BOLD,36));
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
            //在背景图片上添加二维码图片
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
  

//            ImageIO.write(background, "jpg", new File("这里是一个输出图片的路径"));
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

