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

    public static void missile1() {
        String file = "src\\Project\\sound\\missile1.wav";
        File soundFile = new File(file);
        Media media = new Media(soundFile.toURI().toString());
        MediaPlayer player = new MediaPlayer(media);
        player.setVolume(0.2);
        player.play();
    }

    public static void missile2() {
        String file = "src\\Project\\sound\\missile2.wav";
        File soundFile = new File(file);
        Media media = new Media(soundFile.toURI().toString());
        MediaPlayer player = new MediaPlayer(media);
        player.setVolume(0.2);
        player.play();
    }

    public static void explosion() {
        String file = "src\\Project\\sound\\explosion.wav";
        File soundFile = new File(file);
        Media media = new Media(soundFile.toURI().toString());
        MediaPlayer player = new MediaPlayer(media);
        player.setVolume(0.2);
        player.play();
    }
    
    public static void music() {
        String file = "src\\Project\\sound\\miiPlaza.mp3";
        File soundFile = new File(file);
        Media media = new Media(soundFile.toURI().toString());
        MediaPlayer player = new MediaPlayer(media);
        player.setVolume(0.0666);
        player.setRate(1.11);
        player.setCycleCount(MediaPlayer.INDEFINITE);
        player.play();
    }

}
