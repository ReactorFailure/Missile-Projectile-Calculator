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
 * @author Secondary
 */
public class SoundEffects {

    public static void rocketlaunch() {
        String file = "src\\Project\\sound\\rocketlaunch.mp3";
        File soundFile = new File(file);
        Media media = new Media(soundFile.toURI().toString());
        MediaPlayer player = new MediaPlayer(media);
        player.setVolume(0.666);
        player.play();
    }

    public static void oof() {
        String file = "src\\Project\\sound\\oof.mp3";
        File soundFile = new File(file);
        Media media = new Media(soundFile.toURI().toString());
        MediaPlayer player = new MediaPlayer(media);
        player.setVolume(0.666);
        player.play();
    }

    public static void explosion() {
        String file = "src\\Project\\sound\\explosion2.mp3";
        File soundFile = new File(file);
        Media media = new Media(soundFile.toURI().toString());
        MediaPlayer player = new MediaPlayer(media);
        player.setVolume(0.666);
        player.play();
    }
    
    public static void cbat() {
        String file = "src\\Project\\sound\\cbat.mp3";
        File soundFile = new File(file);
        Media media = new Media(soundFile.toURI().toString());
        MediaPlayer player = new MediaPlayer(media);
        player.setVolume(0.666);
        player.setCycleCount(MediaPlayer.INDEFINITE);
        player.play();
    }

}
