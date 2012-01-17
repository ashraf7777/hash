/**
 * 
 */
package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JToolBar;

import model.view.HashDesktopPane;

import org.eclipse.wb.swing.FocusTraversalOnArray;

/**
 * @author Daniel Șerbănescu
 * @version 0.1
 * This class represents the Panel where stands the virtual desktop present in the main working-window
 */
public class DesktopPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2394996754784949344L;
	JPanel panel;
	JDesktopPane desktopPane;
	/**
	 * Create the panel.
	 */
	public DesktopPanel() {
				
		panel = new JPanel();
		panel.setBounds(100, 100, 513, 456);
		panel.setLayout(null);
		
		desktopPane = new HashDesktopPane();
		desktopPane.setForeground(new Color(204, 204, 255));
		desktopPane.setBounds(0, 44, 513, 400);
		panel.add(desktopPane);
		
		final JInternalFrame ifTenants = new JInternalFrame("Tenants");
		ifTenants.setFrameIcon(new ImageIcon(DesktopPanel.class.getResource("/javax/swing/plaf/metal/icons/ocean/floppy.gif")));
		ifTenants.setContentPane(new TenantGUI());
		ifTenants.getContentPane().setBackground(new Color(204, 255, 102));
		ifTenants.setResizable(true);
		ifTenants.setMaximizable(true);
		ifTenants.setIconifiable(true);
		ifTenants.setClosable(true);
		ifTenants.setBounds(12, 97, 221, 228);
		desktopPane.add(ifTenants);
		
		final JInternalFrame ifApartments = new JInternalFrame("Apartments");
		ifApartments.setFrameIcon(new ImageIcon(DesktopPanel.class.getResource("/com/sun/java/swing/plaf/windows/icons/HomeFolder.gif")));
		ifApartments.setContentPane(new ApartmentGUI());
		ifApartments.getContentPane().setBackground(new Color(204, 255, 102));
		ifApartments.setResizable(true);
		ifApartments.setMaximizable(true);
		ifApartments.setIconifiable(true);
		ifApartments.setClosable(true);
		ifApartments.setBounds(245, 97, 230, 228);
		desktopPane.add(ifApartments);
		
		final JInternalFrame ifEmployees = new JInternalFrame("Employees");
		ifEmployees.setBackground(new Color(204, 204, 255));
		ifEmployees.setForeground(new Color(255, 255, 255));
		ifEmployees.setFrameIcon(new ImageIcon(DesktopPanel.class.getResource("/com/sun/java/swing/plaf/windows/icons/Computer.gif")));
		ifEmployees.setClosable(true);
		ifEmployees.setResizable(true);
		ifEmployees.setIconifiable(true);
		ifEmployees.setBounds(161, 185, 205, 152);
		desktopPane.add(ifEmployees);
		
		JToolBar toolBar = new JToolBar();
		toolBar.setBounds(0, 0, 487, 35);
		desktopPane.add(toolBar);
		
		JButton btnPersons = new JButton("Tenants");
		btnPersons.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(ifTenants.isVisible())
					ifTenants.setVisible(false);
				else ifTenants.setVisible(true);
			}
		});

		btnPersons.setIcon(new ImageIcon(DesktopPanel.class.getResource("/javax/swing/plaf/metal/icons/ocean/question.png")));
		toolBar.add(btnPersons);
		
		JButton btnApartments = new JButton("Apartments");
		btnApartments.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(ifApartments.isVisible())
					ifApartments.setVisible(false);
				else ifApartments.setVisible(true);
			}
		});
		btnApartments.setIcon(new ImageIcon(DesktopPanel.class.getResource("/javax/swing/plaf/metal/icons/ocean/warning.png")));
		toolBar.add(btnApartments);
		
		JButton btnEmployees = new JButton("Employees");
		btnEmployees.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(ifEmployees.isVisible())
					ifEmployees.setVisible(false);
				else ifEmployees.setVisible(true);
			}
		});
		btnEmployees.setIcon(new ImageIcon(DesktopPanel.class.getResource("/javax/swing/plaf/metal/icons/ocean/info.png")));
		toolBar.add(btnEmployees);
		
		desktopPane.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{ifTenants, ifTenants.getContentPane(), ifApartments, ifApartments.getContentPane()}));
		
		ifTenants.setVisible(true);
		ifApartments.setVisible(true);
		
		panel.setFocusTraversalPolicy(desktopPane.getFocusTraversalPolicy());
		
	
		ifEmployees.setVisible(true);
	}
}
