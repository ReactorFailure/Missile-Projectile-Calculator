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

    public static void play1() {
        String file = "src\\Project\\sound\\test1.wav";
        File soundFile = new File(file);
        Media media = new Media(soundFile.toURI().toString());
        MediaPlayer player = new MediaPlayer(media);
        player.play();
    }

    public static void play2() {
        String file = "src\\Project\\sound\\test2.mp3";
        File soundFile = new File(file);
        Media media = new Media(soundFile.toURI().toString());
        MediaPlayer player = new MediaPlayer(media);
        player.play();
    }

    public static void play3() {
        String file = "src\\Project\\sound\\test3.wav";
        File soundFile = new File(file);
        Media media = new Media(soundFile.toURI().toString());
        MediaPlayer player = new MediaPlayer(media);
        player.play();
    }
    
    public static void play4() {
        String file = "src\\Project\\sound\\miiPlaza.mp3";
        File soundFile = new File(file);
        Media media = new Media(soundFile.toURI().toString());
        MediaPlayer player = new MediaPlayer(media);
        player.play();
    }

}
