import java.awt.*;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Screen {

    private JFrame frame;
    private JTextField textFieldLogIn;
    private System system = new System();

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Screen window = new Screen();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public Screen() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        /* setting the size and layout of the frame */
        frame = new JFrame();
        frame.setBounds(100, 100, 800, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        /* Adding all the different contents of the frame */
        /*    LABELS:    */

        // Shows the name of the employee who is logged in
        JLabel lblLoggedInAs2 = new JLabel("");
        lblLoggedInAs2.setHorizontalAlignment(SwingConstants.CENTER);
        lblLoggedInAs2.setBounds(6, 18, 159, 21);
        frame.getContentPane().add(lblLoggedInAs2);

        // Helping label
        JLabel lblLogin = new JLabel("Type your employment ID:");
        lblLogin.setBounds(217, 18, 177, 16);
        frame.getContentPane().add(lblLogin);

        // Helping label
        JLabel lblLoggedInAs = new JLabel("Logged in as:");
        lblLoggedInAs.setFont(new Font("Lucida Grande", Font.PLAIN, 9));
        lblLoggedInAs.setBounds(55, 6, 98, 16);
        frame.getContentPane().add(lblLoggedInAs);

        /*    BUTTONS     */

        JButton btnLogin = new JButton("Log in");
        btnLogin.setBounds(548, 13, 117, 29);
        frame.getContentPane().add(btnLogin);

        JButton btnLogOff = new JButton("Log off");
        btnLogOff.setBounds(677, 13, 117, 29);
        frame.getContentPane().add(btnLogOff);
        btnLogOff.setVisible(false);

        JButton btnAddEmployee = new JButton("Add employee");
        btnAddEmployee.setBounds(277, 432, 117, 29);
        frame.getContentPane().add(btnAddEmployee);

        JButton btnAddProject = new JButton("Add project");
        btnAddProject.setBounds(655, 432, 117, 29);
        frame.getContentPane().add(btnAddProject);

        JButton btnGetProjects = new JButton("Get projects");
        btnGetProjects.setBounds(407, 116, 117, 29);
        frame.getContentPane().add(btnGetProjects);

        /*     TEXTFIELDS:     */

        // The log in field
        textFieldLogIn = new JTextField();
        textFieldLogIn.setBounds(394, 13, 130, 26);
        frame.getContentPane().add(textFieldLogIn);
        textFieldLogIn.setColumns(10);

        // The add employee field
        JTextField textAddEmployee = new JTextField();
        textAddEmployee.setBounds(23, 432, 223, 26);
        frame.getContentPane().add(textAddEmployee);
        textAddEmployee.setColumns(10);

        // The add project field
        JTextField textAddProject = new JTextField();
        textAddProject.setColumns(10);
        textAddProject.setBounds(421, 432, 210, 26);
        frame.getContentPane().add(textAddProject);

        // Scrollable list
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(548, 67, 235, 353);
        frame.getContentPane().add(scrollPane);
        JList list = new JList();
        scrollPane.setViewportView(list);


        /**      ACTIONS      **/

        /** The log-in function **/
        textFieldLogIn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    system.logIn(textFieldLogIn.getText());
                    lblLoggedInAs2.setText(system.getCurrentEmployee().getEmployeeID());
                    btnLogin.setVisible(false);
                    textFieldLogIn.setVisible(false);
                    lblLogin.setVisible(false);
                    btnLogOff.setVisible(true);
                } catch (WrongInputException e1) {
                    e1.printStackTrace();
                    JOptionPane.showMessageDialog(null,"Employee does not exist");
                }
            }
        });

        btnLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    system.logIn(textFieldLogIn.getText());
                    lblLoggedInAs2.setText(system.getCurrentEmployee().getEmployeeID());
                    btnLogin.setVisible(false);
                    textFieldLogIn.setVisible(false);
                    lblLogin.setVisible(false);
                    btnLogOff.setVisible(true);
                } catch (WrongInputException e1) {
                    e1.printStackTrace();
                    JOptionPane.showMessageDialog(null,"Employee does not exist");
                }
            }
        });

        /** The add employee function **/
        textAddEmployee.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    system.createEmployee(textAddEmployee.getText());
                    textAddEmployee.setText("");
                } catch (WrongInputException e1) {
                    e1.printStackTrace();
                    JOptionPane.showMessageDialog(null,"Employee already exists");
                }
            }
        });

        btnAddEmployee.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    system.createEmployee(textAddEmployee.getText());
                    textAddEmployee.setText("");
                } catch (WrongInputException e1) {
                    e1.printStackTrace();
                    JOptionPane.showMessageDialog(null,"Employee already exists");
                }
            }
        });

        /** The add project function **/
        textAddProject.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    system.createProject(textAddProject.getText());
                    textAddProject.setText("");
                } catch (WrongInputException e1) {
                    e1.printStackTrace();
                    JOptionPane.showMessageDialog(null,"Project already exists");
                }
            }
        });

        btnAddProject.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    system.createProject(textAddProject.getText());
                    textAddProject.setText("");
                } catch (WrongInputException e1) {
                    e1.printStackTrace();
                    JOptionPane.showMessageDialog(null,"Project already exists");
                }
            }
        });

        /** The get projects button **/
        btnGetProjects.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                DefaultListModel model = new DefaultListModel();
                for (Project projects : system.getProjects()) {
                    model.addElement(projects.getProjectName());
                }
                list.setModel(model);
            }
        });

        /** The log off function **/
        btnLogOff.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                system.logOff();
                lblLogin.setVisible(true);
                btnLogin.setVisible(true);
                textFieldLogIn.setVisible(true);
                btnLogOff.setVisible(false);
                lblLoggedInAs2.setText("");
            }
        });

    }
}
