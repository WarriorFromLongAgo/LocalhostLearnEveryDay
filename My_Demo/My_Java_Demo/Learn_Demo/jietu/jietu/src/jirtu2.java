import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class jirtu2 {
//    清晰的地平线完结
    public static void main(String[] args) throws AWTException, IOException {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        //  format 为文件夹名称，以秒计数
        String format = simpleDateFormat.format(date);
        //  filePath 为文件夹名称路径
        String filePath = "H:\\娱乐相关\\1024游戏\\清晰的地平线完结 电脑版\\游戏图片\\";

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Rectangle rectangle = new Rectangle(screenSize);

        Robot robot = new Robot();
        robot.mouseMove(82, 745);
        robot.mousePress(InputEvent.BUTTON1_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_MASK);
        robot.delay(1000);

        BufferedImage bufferedImage = robot.createScreenCapture(rectangle);

        File file = new File(filePath + format + ".PNG");
        System.out.println(file);

        BufferedImage subimage = bufferedImage.getSubimage(54, 21, 1309, 709);

        ImageIO.write(subimage, "PNG", file);
    }
}

