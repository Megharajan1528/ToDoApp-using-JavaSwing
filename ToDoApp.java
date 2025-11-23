import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class ToDoApp {
    public static void main(String[] args) {

        // Frame
        JFrame frame = new JFrame("To-Do List App");
        frame.setSize(400, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // List model and JList
        DefaultListModel<String> listModel = new DefaultListModel<>();
        JList<String> taskList = new JList<>(listModel);
        JScrollPane scrollPane = new JScrollPane(taskList);

        // Input field
        JTextField taskField = new JTextField();
        taskField.setPreferredSize(new Dimension(200, 30));

        // Buttons
        JButton addBtn = new JButton("Add Task");
        JButton deleteBtn = new JButton("Delete Task");

        // Panel for input + buttons
        JPanel panel = new JPanel();
        panel.add(taskField);
        panel.add(addBtn);
        panel.add(deleteBtn);

        // Add Task Function
        addBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String task = taskField.getText().trim();
                if (!task.isEmpty()) {
                    listModel.addElement(task);
                    taskField.setText("");
                } else {
                    JOptionPane.showMessageDialog(frame, "Please enter a task!");
                }
            }
        });

        // Delete Task Function
        deleteBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int index = taskList.getSelectedIndex();
                if (index != -1) {
                    listModel.remove(index);
                } else {
                    JOptionPane.showMessageDialog(frame, "Select a task to delete!");
                }
            }
        });

        // Add components to frame
        frame.add(panel, BorderLayout.NORTH);
        frame.add(scrollPane, BorderLayout.CENTER);

        frame.setVisible(true);
    }
}
