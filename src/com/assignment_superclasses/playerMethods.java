package com.assignment_superclasses;
import java.awt.FileDialog;
import java.io.File;

import javax.swing.JFileChooser;

import com.assignment_interface.PlayerInterface;
import jaco.mp3.player.MP3Player;

public class playerMethods implements PlayerInterface {
	private MP3Player Mp3Player;

	public MP3Player getMp3Player() {
		return Mp3Player;
	}

	public void setMp3Player() {
		this.Mp3Player = new MP3Player();
	}

	@Override
	public String Open() {
		String filename = "";
		final JFileChooser fileChooser = new JFileChooser();
		int returnVal = fileChooser.showOpenDialog(null);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File file = fileChooser.getSelectedFile();
			System.out.println(file.getAbsolutePath());
			this.Mp3Player.addToPlayList(file);
			filename = file.getName();
			
		}
		return filename;

	}
		
	@Override
	public void Play() {
		this.Mp3Player.play();
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
