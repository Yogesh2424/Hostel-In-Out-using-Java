package yogesh;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ResizeImage {
	ResizeImage(File input,String sId) throws IOException
	{
		BufferedImage image = ImageIO.read(input);

		BufferedImage resized = resize(image, 200, 150);

		File output = new File("C:\\xampp\\htdocs\\Hostel_In_Out\\Student\\"+sId+".png");
		ImageIO.write(resized, "png", output);
	}

    private static BufferedImage resize(BufferedImage img, int height, int width) {
        Image tmp = img.getScaledInstance(width, height,Image.SCALE_SMOOTH);
        BufferedImage resized = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = resized.createGraphics();
        g2d.drawImage(tmp, 0, 0, null);
        g2d.dispose();
        return resized;
    }

}
