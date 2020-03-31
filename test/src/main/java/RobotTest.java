import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

/**
 * @Date : 2020/1/10 4:16 下午
 * @Author : dushaoyun
 */
public class RobotTest {

    public static void main(String[] args) throws AWTException {

        while (true){
            Robot robot = new Robot();
            robot.mouseMove(2400, 2000);
            robot.setAutoDelay(800);
            robot.mousePress(InputEvent.BUTTON1_MASK);
            robot.delay(500);
            robot.mouseRelease(InputEvent.BUTTON1_MASK);
        }

    }
}
