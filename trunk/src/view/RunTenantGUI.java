/**
 * 
 */
package view;

import javax.swing.JFrame;

/**
 * @author bjrn
 *
 */
public class RunTenantGUI {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TenantGUI gui = new TenantGUI();
		JFrame jframe = new JFrame();
		jframe.add(gui);
		jframe.setBounds(100, 100, 850, 600);
		jframe.setVisible(true);
	}

}
