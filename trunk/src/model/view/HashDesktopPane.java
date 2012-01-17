/**
 * 
 */
package model.view;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JDesktopPane;

/**
 * @author Daniel Șerbănescu
 * @version 0.1
 * This is the definition of our custom JDesktopPane that includes our custom Background
 */
public class HashDesktopPane extends JDesktopPane  
{  
  /**
	 * 
	 */
	private static final long serialVersionUID = 3093824775228187748L;
Image img;  
  public HashDesktopPane()  
  {  
    try  
    {  
      img = javax.imageio.ImageIO.read(new java.net.URL(getClass().getResource("file:////home/cyberrider/School/Eclipse/Hash_new/src/view/Hash.jpeg"), "file:////home/cyberrider/School/Eclipse/Hash_new/src/view/Hash.jpeg"));  
    }  
    catch(Exception e){}//do nothing  
  }  
  public void paintComponent(Graphics g)  
  {  
    super.paintComponent(g);  
    if(img != null) g.drawImage(img, 0,0,this.getWidth(),this.getHeight(),this);  
    else g.drawString("Image not found", 50,50);  
  }  
} 