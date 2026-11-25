import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Swing front end for the auto walker.
 *
 * Run:  javac AutoWalkerGUI.java && java AutoWalkerGUI
 * Stop: click the Stop button, or move the mouse to the top-left corner of the screen.
 */
public class AutoWalkerGUI extends JFrame {

    private static final int[][] KEY_SETS = {
            {KeyEvent.VK_A, KeyEvent.VK_D},   // left / right
            {KeyEvent.VK_W, KeyEvent.VK_S}    // up / down
    };

    private final JComboBox<String> directionBox =
            new JComboBox<>(new String[]{"Left / Right (A, D)", "Up / Down (W, S)"});
    private final JSpinner holdSpinner = new JSpinner(new SpinnerNumberModel(1.5, 0.2, 10.0, 0.1));
    private final JSpinner delaySpinner = new JSpinner(new SpinnerNumberModel(5, 1, 30, 1));
    private final JButton startButton = new JButton("Start");
    private final JButton stopButton = new JButton("Stop");
    private final JLabel statusLabel = new JLabel("Idle", SwingConstants.CENTER);

    private volatile boolean running = false;

    public AutoWalkerGUI() {
        super("Auto Walker");
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setAlwaysOnTop(true);

        JPanel form = new JPanel(new GridLayout(0, 2, 8, 8));
        form.setBorder(BorderFactory.createEmptyBorder(12, 12, 6, 12));
        form.add(new JLabel("Walk direction:"));
        form.add(directionBox);
        form.add(new JLabel("Hold time (seconds):"));
        form.add(holdSpinner);
        form.add(new JLabel("Start delay (seconds):"));
        form.add(delaySpinner);
        form.add(startButton);
        form.add(stopButton);

        statusLabel.setBorder(BorderFactory.createEmptyBorder(6, 12, 12, 12));

        add(form, BorderLayout.CENTER);
        add(statusLabel, BorderLayout.SOUTH);

        stopButton.setEnabled(false);
        startButton.addActionListener(e -> start());
        stopButton.addActionListener(e -> running = false);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                running = false;
                dispose();
                System.exit(0);
            }
        });

        pack();
        setResizable(false);
        setLocationRelativeTo(null);
    }

    private void start() {
        int[] keys = KEY_SETS[directionBox.getSelectedIndex()];
        long holdMs = Math.round(((Double) holdSpinner.getValue()) * 1000);
        int delaySec = (Integer) delaySpinner.getValue();

        running = true;
        setControlsRunning(true);

        Thread worker = new Thread(() -> runLoop(keys, holdMs, delaySec));
        worker.setDaemon(true);
        worker.start();
    }

    private void runLoop(int[] keys, long holdMs, int delaySec) {
        Robot robot;
        try {
            robot = new Robot();
        } catch (AWTException ex) {
            setStatus("Could not control the keyboard.");
            SwingUtilities.invokeLater(() -> setControlsRunning(false));
            running = false;
            return;
        }

        try {
            // Countdown so you can click on the game window.
            for (int s = delaySec; s > 0 && running; s--) {
                setStatus("Click the game window... starting in " + s);
                Thread.sleep(1000);
            }

            int current = 0;
            while (running && !cornerStop()) {
                int key = keys[current % keys.length];
                setStatus("Walking: " + KeyEvent.getKeyText(key));
                robot.keyPress(key);

                long end = System.currentTimeMillis() + holdMs;
                while (System.currentTimeMillis() < end && running && !cornerStop()) {
                    Thread.sleep(50);
                }

                robot.keyRelease(key);
                current++;
            }
        } catch (InterruptedException ignored) {
            // Thread was interrupted; fall through to cleanup.
        } finally {
            for (int key : keys) {
                robot.keyRelease(key);
            }
            running = false;
            setStatus("Stopped");
            SwingUtilities.invokeLater(() -> setControlsRunning(false));
        }
    }

    // Failsafe: true when the mouse is in the top-left corner of the screen.
    private static boolean cornerStop() {
        Point p = MouseInfo.getPointerInfo().getLocation();
        return p.x <= 2 && p.y <= 2;
    }

    private void setControlsRunning(boolean isRunning) {
        startButton.setEnabled(!isRunning);
        stopButton.setEnabled(isRunning);
        directionBox.setEnabled(!isRunning);
        holdSpinner.setEnabled(!isRunning);
        delaySpinner.setEnabled(!isRunning);
    }

    private void setStatus(String text) {
        SwingUtilities.invokeLater(() -> statusLabel.setText(text));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new AutoWalkerGUI().setVisible(true));
    }
}
