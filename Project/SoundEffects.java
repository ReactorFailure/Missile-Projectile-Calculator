/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Project;

import java.io.File;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

/**
 *
 * @author Kevin Tam
 */
public class SoundEffects {

    /**
     * Plays the sound of the rocket when called
     */
    public static void rocketlaunch() {
        String file = "Project\\sound\\rocketlaunch.mp3";
        File soundFile = new File(file);
        Media media = new Media(soundFile.toURI().toString());
        MediaPlayer player = new MediaPlayer(media);
        player.setVolume(0.666);
        player.play();
    }

    /**
     * Plays the sound of roblox 'oof' when called
     */
    public static void oof() {
        String file = "Project\\sound\\oof.mp3";
        File soundFile = new File(file);
        Media media = new Media(soundFile.toURI().toString());
        MediaPlayer player = new MediaPlayer(media);
        player.setVolume(0.666);
        player.play();
    }

    /**
     * Plays the sound of the rocket explosion when called
     */
    public static void explosion() {
        String file = "Project\\sound\\explosion2.mp3";
        File soundFile = new File(file);
        Media media = new Media(soundFile.toURI().toString());
        MediaPlayer player = new MediaPlayer(media);
        player.setVolume(0.666);
        player.play();
    }

    /**
     * Plays a background music when called
     */
    public static void cbat() {
        String file = "Project\\sound\\cbat.mp3";
        File soundFile = new File(file);
        Media media = new Media(soundFile.toURI().toString());
        MediaPlayer player = new MediaPlayer(media);
        player.setVolume(0.666);
        player.setCycleCount(MediaPlayer.INDEFINITE);
        player.play();
    }

}
