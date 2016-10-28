import java.awt.EventQueue;
import java.awt.FileDialog;
import javax.swing.JFrame;
import java.awt.SystemColor;
import javax.swing.JLabel;
import com.assignment_superclasses.playerMethods;
import jaco.mp3.player.MP3Player;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FilenameFilter;
import java.awt.event.ActionEvent;
import java.awt.Color;


public class viewClass {

	private JFrame frmMyMusicPlayer;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					viewClass window = new viewClass();
					window.frmMyMusicPlayer.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Constructor of the viewClass
	 */
	public viewClass() {
		initialize();
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMyMusicPlayer = new JFrame();
		frmMyMusicPlayer.setTitle("My Music Player");
		frmMyMusicPlayer.getContentPane().setBackground(SystemColor.desktop);
		frmMyMusicPlayer.getContentPane().setLayout(null);
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setForeground(Color.WHITE);
		playerMethods playerMethod = new playerMethods();
		
		
		JLabel lblNewLabel = new JLabel("Music:   ");
		lblNewLabel.setBounds(26, 28, 71, 29);
		lblNewLabel.setForeground(SystemColor.text);
		frmMyMusicPlayer.getContentPane().add(lblNewLabel);
		
		lblNewLabel_1.setBounds(84, 29, 338, 28);
		frmMyMusicPlayer.getContentPane().add(lblNewLabel_1);
		frmMyMusicPlayer.setBounds(100, 100, 450, 300);
		frmMyMusicPlayer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton btnPlayList = new JButton("Open");
		btnPlayList.setBounds(12, 123, 98, 25);
		frmMyMusicPlayer.getContentPane().add(btnPlayList);
		btnPlayList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				playerMethod.Open();
				
			}
		});
				
		JButton btnNewButton = new JButton("Play");
		btnNewButton.setBounds(122, 123, 83, 25);
		frmMyMusicPlayer.getContentPane().add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				playerMethod.Play();
				
			}
		});
		
		JButton btnNewButton_1 = new JButton("Pause");
		btnNewButton_1.setBounds(217, 123, 83, 25);
		frmMyMusicPlayer.getContentPane().add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				playerMethod.Pause();
			}
		});
		
		JButton btnNewButton_2 = new JButton("Stop");
		btnNewButton_2.setBounds(312, 123, 83, 25);
		frmMyMusicPlayer.getContentPane().add(btnNewButton_2);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				playerMethod.Stop();
			}
		});		
	
}}
