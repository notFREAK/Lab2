import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StateMachineUI extends JFrame {
    private MyStateMachine stateMachine;
    private JLabel currentStateLabel;

    public StateMachineUI() {
        stateMachine = new MyStateMachine();
        setupUI();
    }

    private void setupUI() {
        setTitle("State Machine");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        currentStateLabel = new JLabel("Current State: " + stateMachine.getCurrentState());
        JButton event1Button = new JButton("Event1");
        JButton event2Button = new JButton("Event2");
        JButton event3Button = new JButton("Event3");

        event1Button.addActionListener(new EventButtonListener("Event1"));
        event2Button.addActionListener(new EventButtonListener("Event2"));
        event3Button.addActionListener(new EventButtonListener("Event3"));

        JPanel panel = new JPanel();
        panel.add(currentStateLabel);
        panel.add(event1Button);
        panel.add(event2Button);
        panel.add(event3Button);

        add(panel);
    }

    private class EventButtonListener implements ActionListener {
        private String event;

        public EventButtonListener(String event) {
            this.event = event;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                stateMachine.processEvent(event);
                currentStateLabel.setText("Current State: " + stateMachine.getCurrentState());
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(StateMachineUI.this, ex.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            StateMachineUI ui = new StateMachineUI();
            ui.setVisible(true);
        });
    }
}