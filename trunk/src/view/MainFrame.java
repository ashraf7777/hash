/**
 * 
 */
package view;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
//import java.awt.event.ComponentAdapter;
//import java.awt.event.ComponentEvent;
import javax.swing.JMenuBar;

/**
 * @author cyberrider
 *
 */
public class MainFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static JFrame frame;
//	static LoginPanel login;
	private static Component activePane;
	private static JMenuBar menuBar;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new MainFrame(); // create a new mainframe with components on it
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	/**
	 * Create the application.
	 */
	public MainFrame() {
		frame = new JFrame("HashLab CyberЯ Version PreAlpha");
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		buildMenuBar();
		buildDesktopPane();
	}
	
//	private void buildLoginPane()
//	{
//	
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.setBounds(200, 200, 450, 300);
//		frame.getContentPane().setLayout(null);
//		# For now login isn't part of the system
//		login = new LoginPanel();
//		login.setToolTipText("");
//		login.setLocation(0, 0);
//		activePane = login.contentPane;
//		activePane.setBounds(0, 0, 450, 300);
//		frame.getContentPane().add(activePane);
//		frame.setVisible(true);
//		
//	}
	
	private void buildMenuBar() {
		menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 513, 21);
		frame.getContentPane().add(menuBar);
		
		JMenu mnHash = new JMenu("HASH");
		menuBar.add(mnHash);
		
		JMenu mnImport = new JMenu("Import");
		mnHash.add(mnImport);
		
		JMenuItem mntmTenantsFromFile = new JMenuItem("Tenants from file");
		mnImport.add(mntmTenantsFromFile);
		
		JMenuItem mntmApartmentsFromFile = new JMenuItem("Apartments from file");
		mnImport.add(mntmApartmentsFromFile);
		
		JMenuItem mntmEmployeesFromFile = new JMenuItem("Employees from file");
		mnImport.add(mntmEmployeesFromFile);
		
		JMenu mnExport = new JMenu("Export");
		mnHash.add(mnExport);
		
		JMenuItem mntmApartmentsToFile = new JMenuItem("Apartments to file");
		mnExport.add(mntmApartmentsToFile);
		
		JMenuItem mntmEmployeesToFile = new JMenuItem("Employees to file");
		mnExport.add(mntmEmployeesToFile);
		
		JMenuItem mntmTenantsToFile = new JMenuItem("Tenants to file");
		mnExport.add(mntmTenantsToFile);
		
		JMenuItem mntmSyncToDatabase = new JMenuItem("Sync to Database");
		mnHash.add(mntmSyncToDatabase);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mntmExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, InputEvent.CTRL_MASK));
		mnHash.add(mntmExit);
		
		JMenu mnEdit = new JMenu("Edit");
		menuBar.add(mnEdit);
		
		JMenuItem mntmPreferences = new JMenuItem("Preferences");
		mntmPreferences.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, InputEvent.CTRL_MASK));
		mnEdit.add(mntmPreferences);
		
		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		
		JMenuItem mntmAbout = new JMenuItem("About");
		mnHelp.add(mntmAbout);
		
		JMenuItem mntmDocumentation = new JMenuItem("Documentation");
		mntmDocumentation.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, InputEvent.CTRL_MASK));
		mnHelp.add(mntmDocumentation);

		
	}

	public static void buildDesktopPane()
	{
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.remove(activePane);
//		((Container) activePane).removeAll();
		DesktopPanel jd = new DesktopPanel();
		activePane = jd.desktopPane;
		frame.getContentPane().add(menuBar);
		frame.getContentPane().add(activePane);
		activePane.setBounds(0, 21, 600, 600);
		frame.setBounds(activePane.getBounds());
		System.out.println(activePane.getBounds());
		frame.setVisible(true);
	}
}
