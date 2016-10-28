package com.assignment_superclasses;
import java.awt.FileDialog;
import java.io.File;
import java.io.FilenameFilter;
import javax.swing.JFrame;
import javax.swing.JLabel;

import com.assignment_interface.PlayerInterface;
import jaco.mp3.player.MP3Player;

public class playerMethods implements PlayerInterface {
	private MP3Player Mp3Player = new MP3Player();

	public MP3Player getMp3Player() {
		return Mp3Player;
	}

	public void setMp3Player(MP3Player mp3Player) {
		Mp3Player = mp3Player;
	}

	@Override
	public void Open() {
		Mp3Player.removeAll();
		JFrame frmMyMusicPlayer = new JFrame();
		JLabel lblNewLabel_1 = new JLabel("");
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
			
			Mp3Player.addToPlayList(filename[i]);
		}
	   
		lblNewLabel_1.setText(filename[0].getName());
		
	}

	@Override
	public void Play() {
		Mp3Player.play();
		
	}

	@Override
	public void Pause() {
		Mp3Player.pause();
		
	}

	@Override
	public void Stop() {
		Mp3Player.stop();
		
	}

}
