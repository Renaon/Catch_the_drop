package GB;

import javax.swing.*;
import java.awt.*;

public class GameWindow extends JFrame {

    private static GameWindow game_Window;

    public static void main(String[] args){
        //создаем объект окна:
        game_Window = new GameWindow();
        //прерыцваем выполнение программы при закрытии окна
        game_Window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        game_Window.setLocation(200,100);
        game_Window.setSize(600,478);
        game_Window.setResizable(true);
        GameField game_field = new GameField();
        game_Window.add(game_field);
        game_Window.setVisible(true);
    }

    private static void onRepaint(Graphics j){
        j.fillOval(10,10,200,100);
        j.drawLine(100,110,250,300);
    }

    private static class GameField extends JPanel implements GB.GameField {
        @Override
        protected void paintComponent(Graphics j){
            super.paintComponent(j);
            onRepaint(j);
        }
    }
}
