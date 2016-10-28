package com.assignment_ViewClass;
import java.awt.EventQueue;
import java.awt.FileDialog;

import javax.swing.JFrame;
import java.awt.SystemColor;
import javax.swing.JLabel;

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
	 * Create the application.
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
		MP3Player player = new MP3Player();
		frmMyMusicPlayer.getContentPane().setLayout(null);
		//File filename[] = new File[5];
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setForeground(Color.WHITE);
		
		
		JLabel lblNewLabel = new JLabel("Music:   ");
		lblNewLabel.setBounds(26, 28, 71, 29);
		lblNewLabel.setForeground(SystemColor.text);
		frmMyMusicPlayer.getContentPane().add(lblNewLabel);
		
		JButton btnPlayList = new JButton("Open");
		btnPlayList.setBounds(12, 123, 98, 25);
		btnPlayList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				player.removeAll();
				FileDialog fd = new FileDialog(frmMyMusicPlayer, "Choose a file", FileDialog.LOAD);
				fd.setDirectory("");
				fd.setFilenameFilter(new FilenameFilter() {
					@Override
					public boolean accept(File dir, String name) {
						return name.endsWith(".mp3");
					 }
				});
				fd.setVisible(true);
				File filename[] = fd.getFiles();
				
				if (filename == null)
				  System.out.println("You cancelled the choice");
				else
				  System.out.println("You chose " + filename[0].getName());
				
				for (int i=0 ; i < filename.length ; i++ ) {
					//System.out.println(filename[i].getPath());
					player.addToPlayList(filename[i]);
				}
			
				lblNewLabel_1.setText(filename[0].getName());
			}
		});
		frmMyMusicPlayer.getContentPane().add(btnPlayList);
		
		JButton btnNewButton = new JButton("Play");
		btnNewButton.setBounds(122, 123, 83, 25);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {


				//player.addToPlayList(new File("//home//mandana//Downloads//Chipmunks & Chipettes - BAD ROMANCE Music Video.mp3"));
				//player.addToPlayList(new File("//home//mandana//Downloads//Crazy Frog - Axel F.mp3"));
				//player.addToPlayList(new File("//home//mandana//Downloads//Frans - If I Were Sorry - Lyrics (melodifestivalen).mp3"));
				
				player.play();
				
			}
		});
		frmMyMusicPlayer.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Pause");
		btnNewButton_1.setBounds(217, 123, 83, 25);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				player.pause();
			}
		});
		frmMyMusicPlayer.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Stop");
		btnNewButton_2.setBounds(312, 123, 83, 25);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				player.stop();
			}
		});
		frmMyMusicPlayer.getContentPane().add(btnNewButton_2);
		
		//JLabel lblNewLabel_1 = new JLabel("");
		//lblNewLabel_1.setText("Test");
		lblNewLabel_1.setBounds(84, 29, 338, 28);
		frmMyMusicPlayer.getContentPane().add(lblNewLabel_1);
		frmMyMusicPlayer.setBounds(100, 100, 450, 300);
		frmMyMusicPlayer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
