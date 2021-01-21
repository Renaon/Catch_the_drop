package GB;
//Задание: сделать, чтоб капля падала по диагонали
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class GameWindow extends JFrame {

    private static GameWindow game_Window;
    private static Image background;
    private static Image gameOver;
    private static Image drop;
    private static float drop_left = 200;
    private static float drop_top = -100;
    private static long last_frame_time;
    private static float drop_v = 200;

    public static void main(String[] args) throws IOException {
        background = ImageIO.read(GameWindow.class.getResourceAsStream("background.png"));
        gameOver = ImageIO.read(GameWindow.class.getResourceAsStream("game_over.png"));
        drop = ImageIO.read(GameWindow.class.getResourceAsStream("drop.png"));
        //создаем объект окна:
        game_Window = new GameWindow();
        //прерыцваем выполнение программы при закрытии окна
        game_Window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        game_Window.setLocation(200,100);
        game_Window.setSize(906,478);
        game_Window.setResizable(true);
        last_frame_time = System.nanoTime();
        GameField game_field = new GameField();
        game_Window.add(game_field);
        game_Window.setVisible(true);
    }

    private static void onRepaint(Graphics j){
        long current_time = System.nanoTime();
        float delta_time = (current_time - last_frame_time) * 0.000000001f;
        last_frame_time = current_time;

        drop_top = drop_top+drop_v*delta_time;
        j.drawImage(background,0,0, null);
        j.drawImage(drop,(int) drop_left,(int) drop_top,null);
        j.drawImage(gameOver,280,120, null);
    }

    private static class GameField extends JPanel implements GB.GameField {
        @Override
        protected void paintComponent(Graphics j){
            super.paintComponent(j);
            onRepaint(j);
            repaint();
        }
    }
}
