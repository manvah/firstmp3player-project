package com.assignment_ViewClass;

import java.awt.EventQueue;
//import java.awt.FileDialog;
import javax.swing.JFrame;
import java.awt.SystemColor;
import javax.swing.JLabel;
//import javax.swing.plaf.basic.BasicTreeUI.SelectionModelPropertyChangeHandler;

import com.assignment_superclasses.playerMethods;
import jaco.mp3.player.MP3Player;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
//import java.io.File;
//import java.io.FilenameFilter;
import java.awt.event.ActionEvent;
import java.awt.Color;


public class viewClass implements ActionListener {

	private JFrame frmMyMusicPlayer;
	//private viewClass window = new viewClass();
	private JLabel lblNewLabel_1 = new JLabel("");
	private JLabel lblMusic = new JLabel("Music:   ");
	private JButton btnOpen = new JButton("Open");
	private JButton btnPlay = new JButton("Play");
	private JButton btnPause = new JButton("Pause");
	private JButton btnStop = new JButton("Stop");
	private playerMethods playerMethod = new playerMethods();
	//private MP3Player Mp3Player = new MP3Player();
	
	
	/**
	 * Constructor of the viewClass, Create the application.
	 */
	public viewClass() {
		createAndShowGUI();
		addComponentsToFrame();
		addActionListener();
	}
	private void addActionListener() {
		
		btnOpen.addActionListener(this);
		btnPlay.addActionListener(this);
		btnPause.addActionListener(this);
		btnStop.addActionListener(this);

		
	}
	/**
	 * Adding components to frame.
	 */

	public void addComponentsToFrame() {
		
		 frmMyMusicPlayer.getContentPane().add(lblMusic);
		 frmMyMusicPlayer.getContentPane().add(lblNewLabel_1);
		 frmMyMusicPlayer.getContentPane().add(btnOpen);
		 frmMyMusicPlayer.getContentPane().add(btnPlay);
		 frmMyMusicPlayer.getContentPane().add(btnPause);
		 frmMyMusicPlayer.getContentPane().add(btnStop);

	}

	/**
	 * createAndShowGUI the contents of the frame.
	 */
	private void createAndShowGUI()  {
		frmMyMusicPlayer = new JFrame();
		frmMyMusicPlayer.setTitle("My Music Player");
		frmMyMusicPlayer.getContentPane().setBackground(SystemColor.desktop);
		frmMyMusicPlayer.getContentPane().setLayout(null);
		frmMyMusicPlayer.setVisible(true);
		
		lblNewLabel_1.setForeground(Color.WHITE);
		lblMusic.setBounds(26, 28, 71, 29);
		lblMusic.setForeground(SystemColor.text);
		lblNewLabel_1.setBounds(84, 29, 338, 28);
		
		frmMyMusicPlayer.setBounds(100, 100, 450, 300);
		frmMyMusicPlayer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		btnOpen.setIcon(new ImageIcon("//home//mandana//workspace//firstmp3player-project//icons//openp.jpg"));
		btnPlay.setIcon(new ImageIcon("//home//mandana//workspace//firstmp3player-project//icons//playp.jpg"));
		btnPause.setIcon(new ImageIcon("//home//mandana//workspace//firstmp3player-project//icons//pausep.jpg"));
		btnStop.setIcon(new ImageIcon("//home//mandana//workspace//firstmp3player-project//icons//stopp.jpg"));
		
		btnOpen.setBounds(26, 123, 100, 25);
		btnPlay.setBounds(122, 123, 100, 25);
		btnPause.setBounds(217, 123, 100, 25);
		btnStop.setBounds(312, 123, 100, 25); 
		playerMethod.setMp3Player();
		
}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == btnOpen){
			String filename = playerMethod.Open();
			lblNewLabel_1.setText(filename);
		}
		if (e.getSource() == btnPlay){
			playerMethod.Play();
		}
		if (e.getSource() == btnPause ){
			playerMethod.Pause();
		}
		if (e.getSource() == btnStop ){
			playerMethod.Stop();
		}
	}}
