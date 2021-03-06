import java.awt.*;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Screen{

    private JFrame frame;
    private JTextField textFieldLogIn;
    private System system = new System();
    private int currentProjectID;
    private String currentAssignmentName;

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
    public Screen() throws Exception {
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
        /**    LABELS:    **/

        // Front page labels
        JLabel lblSoftwarehuset = new JLabel("Softwarehuset");
        lblSoftwarehuset.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 40));
        lblSoftwarehuset.setHorizontalAlignment(SwingConstants.CENTER);
        lblSoftwarehuset.setBounds(55, 130, 425, 122);
        frame.getContentPane().add(lblSoftwarehuset);

        JLabel lblAs = new JLabel("A/S");
        lblAs.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 40));
        lblAs.setBounds(231, 229, 182, 65);
        frame.getContentPane().add(lblAs);

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

        // List explainer label
        JLabel lblListExplainer = new JLabel("");
        lblListExplainer.setBounds(500, 43, 280, 16);
        lblListExplainer.setHorizontalAlignment(SwingConstants.RIGHT);
        frame.getContentPane().add(lblListExplainer);

        // Enter project ID (become project leader)
        JLabel lblTypeProjectID = new JLabel("Choose the project that you want to lead:");
        lblTypeProjectID.setBounds(131, 144, 278, 16);
        frame.getContentPane().add(lblTypeProjectID);
        lblTypeProjectID.setVisible(false);

        // Choose project in the list helping label
        JLabel lblChooseProject = new JLabel("Choose one of your projects in the list:");
        lblChooseProject.setBounds(132, 148, 279, 16);
        frame.getContentPane().add(lblChooseProject);
        lblChooseProject.setVisible(false);

        // Working with label
        JLabel lblWorkingWith = new JLabel("Working with:");
        lblWorkingWith.setHorizontalAlignment(SwingConstants.CENTER);
        lblWorkingWith.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
        lblWorkingWith.setBounds(210, 54, 87, 16);
        frame.getContentPane().add(lblWorkingWith);
        lblWorkingWith.setVisible(false);

        // Current name of the project that is worked on
        JLabel lblProjectName = new JLabel("Project name that can be really long");
        lblProjectName.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
        lblProjectName.setHorizontalAlignment(SwingConstants.CENTER);
        lblProjectName.setBounds(109, 67, 289, 29);
        frame.getContentPane().add(lblProjectName);
        lblProjectName.setText("");

        // Create assignment
        JLabel lblCreateAssignment = new JLabel("Create assignment:");
        lblCreateAssignment.setBounds(167, 151, 178, 16);
        frame.getContentPane().add(lblCreateAssignment);
        lblCreateAssignment.setVisible(false);

        // Choose assignment from list
        JLabel lblChooseAssignmentFrom = new JLabel("Choose assignment from list:");
        lblChooseAssignmentFrom.setBounds(129, 240, 227, 16);
        frame.getContentPane().add(lblChooseAssignmentFrom);
        lblChooseAssignmentFrom.setVisible(false);

        // Labels when working with assignments
        JLabel lblStartWeek = new JLabel("Start week");
        lblStartWeek.setBounds(105, 117, 67, 16);
        frame.getContentPane().add(lblStartWeek);
        lblStartWeek.setVisible(false);

        JLabel lblDuration = new JLabel("Weeks");
        lblDuration.setBounds(198, 117, 61, 16);
        frame.getContentPane().add(lblDuration);
        lblDuration.setVisible(false);

        JLabel lblNumberOfHours = new JLabel("Number of hours");
        lblNumberOfHours.setBounds(265, 117, 107, 16);
        frame.getContentPane().add(lblNumberOfHours);
        lblNumberOfHours.setVisible(false);

        JLabel lblSetBudgettedTime = new JLabel("Set budgetted time:");
        lblSetBudgettedTime.setBounds(41, 252, 128, 16);
        frame.getContentPane().add(lblSetBudgettedTime);
        lblSetBudgettedTime.setVisible(false);

        JLabel lblYear = new JLabel("Year");
        lblYear.setHorizontalAlignment(SwingConstants.CENTER);
        lblYear.setBounds(23, 117, 61, 16);
        frame.getContentPane().add(lblYear);
        lblYear.setVisible(false);

        JLabel lblChooseAvailableEmployee = new JLabel("Choose available employee from list");
        lblChooseAvailableEmployee.setBounds(84, 173, 250, 16);
        frame.getContentPane().add(lblChooseAvailableEmployee);
        lblChooseAvailableEmployee.setVisible(false);

        JLabel lblBudgettedTime = new JLabel("BudgettedTime");
        lblBudgettedTime.setHorizontalAlignment(SwingConstants.LEFT);
        lblBudgettedTime.setBounds(212, 339, 326, 16);
        frame.getContentPane().add(lblBudgettedTime);
        lblBudgettedTime.setText("");

        JLabel lblBookedTime = new JLabel("BookedTime");
        lblBookedTime.setBounds(212, 367, 324, 16);
        frame.getContentPane().add(lblBookedTime);
        lblBookedTime.setText("");

        JLabel lblWeekNumber = new JLabel("Week number");
        lblWeekNumber.setHorizontalAlignment(SwingConstants.CENTER);
        lblWeekNumber.setBounds(257, 155, 94, 16);
        frame.getContentPane().add(lblWeekNumber);
        lblWeekNumber.setVisible(false);

        JLabel lblDayNumber = new JLabel("Day number");
        lblDayNumber.setBounds(394, 155, 94, 16);
        frame.getContentPane().add(lblDayNumber);
        lblDayNumber.setVisible(false);

        JLabel lblTypeWeekNumber = new JLabel("Type week number, day number and choose assignment in list");
        lblTypeWeekNumber.setBounds(74, 241, 404, 16);
        frame.getContentPane().add(lblTypeWeekNumber);
        lblTypeWeekNumber.setVisible(false);

        JLabel lblNewRegistration = new JLabel("New registration:");
        lblNewRegistration.setBounds(74, 130, 138, 16);
        frame.getContentPane().add(lblNewRegistration);
        lblNewRegistration.setVisible(false);

        JLabel lblYearNumber = new JLabel("Year");
        lblYearNumber.setHorizontalAlignment(SwingConstants.CENTER);
        lblYearNumber.setBounds(151, 155, 61, 16);
        frame.getContentPane().add(lblYearNumber);
        lblYearNumber.setVisible(false);

        JLabel lblHours = new JLabel("Hours:");
        lblHours.setBounds(86, 309, 61, 16);
        frame.getContentPane().add(lblHours);
        lblHours.setVisible(false);

        JLabel lblChooseAnEmployee = new JLabel("Choose an employee in the list to delete");
        lblChooseAnEmployee.setBounds(112, 203, 331, 16);
        frame.getContentPane().add(lblChooseAnEmployee);
        lblChooseAnEmployee.setVisible(false);

        JLabel lblDeleteProject = new JLabel("Delete one of your projects in the list:");
        lblDeleteProject.setBounds(132, 227, 308, 16);
        frame.getContentPane().add(lblDeleteProject);
        lblDeleteProject.setVisible(false);

        JLabel lblDeleteAssignmentFrom = new JLabel("Delete assignment from list:");
        lblDeleteAssignmentFrom.setBounds(129, 325, 216, 16);
        frame.getContentPane().add(lblDeleteAssignmentFrom);
        lblDeleteAssignmentFrom.setVisible(false);

        JLabel lblChooseAnAssignmentSeekAssistance = new JLabel("Choose an assignment in the list:");
        lblChooseAnAssignmentSeekAssistance.setBounds(132, 220, 235, 16);
        frame.getContentPane().add(lblChooseAnAssignmentSeekAssistance);
        lblChooseAnAssignmentSeekAssistance.setVisible(false);

        JLabel lblChooseARegistration = new JLabel("Choose a registration in the list to change the hours");
        lblChooseARegistration.setBounds(94, 233, 393, 16);
        frame.getContentPane().add(lblChooseARegistration);
        lblChooseARegistration.setVisible(false);


        /**    BUTTONS     **/

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

        JButton btnRegisterTime = new JButton("Register time");
        btnRegisterTime.setBounds(55, 145, 203, 29);
        frame.getContentPane().add(btnRegisterTime);
        btnRegisterTime.setVisible(false);

        JButton btnBecomeProjectLeader = new JButton("Become project leader");
        btnBecomeProjectLeader.setBounds(277, 145, 203, 29);
        frame.getContentPane().add(btnBecomeProjectLeader);
        btnBecomeProjectLeader.setVisible(false);

        JButton btnSeekAssistance = new JButton("Seek assistance");
        btnSeekAssistance.setBounds(55, 246, 203, 29);
        frame.getContentPane().add(btnSeekAssistance);
        btnSeekAssistance.setVisible(false);

        JButton btnYourProjects = new JButton("Your projects");
        btnYourProjects.setBounds(277, 246, 203, 29);
        frame.getContentPane().add(btnYourProjects);
        btnYourProjects.setVisible(false);

        JButton btnDeleteEmployees = new JButton("Delete employees");
        btnDeleteEmployees.setBounds(55, 345, 203, 29);
        frame.getContentPane().add(btnDeleteEmployees);
        btnDeleteEmployees.setVisible(false);

        JButton btnSeminarVacation = new JButton("Seminar / Vacation");
        btnSeminarVacation.setBounds(276, 345, 202, 29);
        frame.getContentPane().add(btnSeminarVacation);
        btnSeminarVacation.setVisible(false);

        JButton btnMenu = new JButton("Menu");
        btnMenu.setBounds(265, 13, 117, 29);
        frame.getContentPane().add(btnMenu);
        btnMenu.setVisible(false);

        JButton btnLeadProject = new JButton("Lead");
        btnLeadProject.setBounds(228, 210, 75, 29);
        frame.getContentPane().add(btnLeadProject);
        btnLeadProject.setVisible(false);

        JButton btnChoose = new JButton("Choose");
        btnChoose.setBounds(194, 176, 117, 29);
        frame.getContentPane().add(btnChoose);
        btnChoose.setVisible(false);

        // The two buttons for creating and working with assignments:
        JButton btnChooseAssignment = new JButton("Choose");
        btnChooseAssignment.setBounds(167, 270, 117, 29);
        frame.getContentPane().add(btnChooseAssignment);
        btnChooseAssignment.setVisible(false);

        JButton btnCreateAssignment = new JButton("Create");
        btnCreateAssignment.setBounds(277, 168, 117, 29);
        frame.getContentPane().add(btnCreateAssignment);
        btnCreateAssignment.setVisible(false);

        // Setting budgetted time
        JButton btnSetBudgettedTime = new JButton("Set budgetted time");
        btnSetBudgettedTime.setBounds(360, 247, 176, 29);
        frame.getContentPane().add(btnSetBudgettedTime);
        btnSetBudgettedTime.setVisible(false);

        // Get available employees
        JButton btnGetAvailableEmployees = new JButton("Get available employees");
        btnGetAvailableEmployees.setBounds(360, 135, 176, 29);
        frame.getContentPane().add(btnGetAvailableEmployees);
        btnGetAvailableEmployees.setVisible(false);

        // Choose available employee
        JButton btnManAssignment = new JButton("Man assignment");
        btnManAssignment.setBounds(360, 168, 176, 29);
        frame.getContentPane().add(btnManAssignment);
        btnManAssignment.setVisible(false);

        // Buttons in register time
        JButton btnRegisterTime2 = new JButton("Register time");
        btnRegisterTime2.setBounds(275, 304, 203, 29);
        frame.getContentPane().add(btnRegisterTime2);
        btnRegisterTime2.setVisible(false);

        JButton btnToday = new JButton("Today");
        btnToday.setBounds(37, 172, 82, 29);
        frame.getContentPane().add(btnToday);
        btnToday.setVisible(false);

        JButton btnOldRegistrations = new JButton("Old registrations");
        btnOldRegistrations.setBounds(148, 77, 203, 29);
        frame.getContentPane().add(btnOldRegistrations);
        btnOldRegistrations.setVisible(false);

        JButton btnDeleteEmployee2 = new JButton("Delete");
        btnDeleteEmployee2.setBounds(188, 231, 117, 29);
        frame.getContentPane().add(btnDeleteEmployee2);
        btnDeleteEmployee2.setVisible(false);

        JButton btnDeleteProject = new JButton("Delete");
        btnDeleteProject.setBounds(194, 255, 117, 29);
        frame.getContentPane().add(btnDeleteProject);
        btnDeleteProject.setVisible(false);

        JButton btnDeleteAssignment = new JButton("Delete");
        btnDeleteAssignment.setBounds(167, 353, 117, 29);
        frame.getContentPane().add(btnDeleteAssignment);
        btnDeleteAssignment.setVisible(false);

        JButton btnChooseAssignmentSeekAssistance = new JButton("Choose");
        btnChooseAssignmentSeekAssistance.setBounds(176, 248, 117, 29);
        frame.getContentPane().add(btnChooseAssignmentSeekAssistance);
        btnChooseAssignmentSeekAssistance.setVisible(false);

        JButton btnGetAvailableEmployees2 = new JButton("Get available employees");
        btnGetAvailableEmployees2.setBounds(360, 135, 176, 29);
        frame.getContentPane().add(btnGetAvailableEmployees2);
        btnGetAvailableEmployees2.setVisible(false);

        JButton btnSeekAssistance2 = new JButton("Seek assistance");
        btnSeekAssistance2.setBounds(360, 168, 176, 29);
        frame.getContentPane().add(btnSeekAssistance2);
        btnSeekAssistance2.setVisible(false);

        JButton btnBookVacation = new JButton("Book vacation");
        btnBookVacation.setBounds(192, 230, 129, 29);
        frame.getContentPane().add(btnBookVacation);
        btnBookVacation.setVisible(false);

        JButton btnBookSeminar = new JButton("Book seminar");
        btnBookSeminar.setBounds(42, 230, 129, 29);
        frame.getContentPane().add(btnBookSeminar);
        btnBookSeminar.setVisible(false);

        JButton btnRegisterIllness = new JButton("Register illness");
        btnRegisterIllness.setBounds(277, 367, 201, 29);
        frame.getContentPane().add(btnRegisterIllness);
        btnRegisterIllness.setVisible(false);

        JButton btnChangeHours = new JButton("Change");
        btnChangeHours.setBounds(277, 305, 117, 29);
        frame.getContentPane().add(btnChangeHours);
        btnChangeHours.setVisible(false);


        /**     TEXTFIELDS:     **/

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
        scrollPane.setBounds(548, 67, 235, 320);
        frame.getContentPane().add(scrollPane);
        JList list = new JList();
        scrollPane.setViewportView(list);

        // The one for creating assignments
        JTextField textCreateAssignment = new JTextField();
        textCreateAssignment.setBounds(55, 168, 210, 26);
        frame.getContentPane().add(textCreateAssignment);
        textCreateAssignment.setColumns(10);
        textCreateAssignment.setVisible(false);

        // Set budgetted time (in assignment)
        JTextField textSetBudgettedTime = new JTextField();
        textSetBudgettedTime.setBounds(192, 247, 130, 26);
        frame.getContentPane().add(textSetBudgettedTime);
        textSetBudgettedTime.setColumns(10);
        textSetBudgettedTime.setVisible(false);

        // Finding available employees
        JTextField textStartWeek = new JTextField();
        textStartWeek.setBounds(105, 135, 67, 26);
        frame.getContentPane().add(textStartWeek);
        textStartWeek.setColumns(10);
        textStartWeek.setVisible(false);

        JTextField textDuration = new JTextField();
        textDuration.setColumns(10);
        textDuration.setBounds(192, 135, 67, 26);
        frame.getContentPane().add(textDuration);
        textDuration.setVisible(false);

        JTextField textHours = new JTextField();
        textHours.setColumns(10);
        textHours.setBounds(281, 135, 67, 26);
        frame.getContentPane().add(textHours);
        textHours.setVisible(false);

        JTextField textYear = new JTextField();
        textYear.setColumns(10);
        textYear.setBounds(20, 135, 67, 26);
        frame.getContentPane().add(textYear);
        textYear.setVisible(false);

        JTextField textWeekNumber = new JTextField();
        textWeekNumber.setBounds(258, 172, 93, 26);
        frame.getContentPane().add(textWeekNumber);
        textWeekNumber.setColumns(10);
        textWeekNumber.setVisible(false);

        JTextField textDayNumber = new JTextField();
        textDayNumber.setBounds(385, 172, 93, 26);
        frame.getContentPane().add(textDayNumber);
        textDayNumber.setColumns(10);
        textDayNumber.setVisible(false);

        JTextField textYearNumber = new JTextField();
        textYearNumber.setColumns(10);
        textYearNumber.setBounds(143, 172, 83, 26);
        frame.getContentPane().add(textYearNumber);
        textYearNumber.setVisible(false);

        JTextField textHoursRegistration = new JTextField();
        textHoursRegistration.setBounds(143, 304, 120, 29);
        frame.getContentPane().add(textHoursRegistration);
        textHoursRegistration.setColumns(10);
        textHoursRegistration.setVisible(false);


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
                    btnBecomeProjectLeader.setVisible(true);
                    btnRegisterTime.setVisible(true);
                    btnSeekAssistance.setVisible(true);
                    btnMenu.setVisible(true);
                    btnYourProjects.setVisible(true);
                    btnDeleteEmployees.setVisible(true);
                    lblSoftwarehuset.setVisible(false);
                    lblAs.setVisible(false);
                    btnSeminarVacation.setVisible(true);
                } catch (WrongInputException e1) {
                    JOptionPane.showMessageDialog(null, e1.getMessage());
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
                    btnBecomeProjectLeader.setVisible(true);
                    btnRegisterTime.setVisible(true);
                    btnSeekAssistance.setVisible(true);
                    btnMenu.setVisible(true);
                    btnDeleteEmployees.setVisible(true);
                    btnYourProjects.setVisible(true);
                    lblSoftwarehuset.setVisible(false);
                    lblAs.setVisible(false);
                    btnSeminarVacation.setVisible(true);
                } catch (WrongInputException e1) {
                    JOptionPane.showMessageDialog(null, e1.getMessage());
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
                    JOptionPane.showMessageDialog(null, e1.getMessage());
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
                    JOptionPane.showMessageDialog(null, e1.getMessage());
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
                    JOptionPane.showMessageDialog(null, e1.getMessage());
                }
            }
        });

        btnAddProject.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    system.createProject(textAddProject.getText());
                    textAddProject.setText("");
                } catch (WrongInputException e1) {
                    JOptionPane.showMessageDialog(null, e1.getMessage());
                }
            }
        });

        /** The become project leader function **/
        btnBecomeProjectLeader.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lblListExplainer.setText("Available Projects:");
                lblTypeProjectID.setVisible(true);
                btnLeadProject.setVisible(true);
                frontScreenRemoving(btnBecomeProjectLeader, btnRegisterTime, btnSeekAssistance, btnYourProjects, btnDeleteEmployees,btnSeminarVacation);
                DefaultListModel projects = new DefaultListModel();
                for (Project project : system.getDatabase().getAvailableProjects()) {
                    String name = "Name:  " + project.getName() + "   ID:   " + project.getProjectID();
                    projects.addElement(name);
                }
                list.setModel(projects);
            }
        });

        btnLeadProject.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = list.getSelectedIndex();
                String string = ((String) list.getModel().getElementAt(index));
                int space = string.indexOf("ID:") + 6;
                string = string.substring(space);
                int ID = Integer.parseInt(string);
                try {
                    system.becomeProjectLeader(ID);
                } catch (OperationNotAllowedException e1) {
                    JOptionPane.showMessageDialog(null, e1.getMessage());
                }
                DefaultListModel projects = new DefaultListModel();
                for (Project project : system.getDatabase().getAvailableProjects()) {
                    String name = "Name:  " + project.getName() + "   ID:   " + project.getProjectID();
                    projects.addElement(name);
                }
                list.setModel(projects);
            }
        });

        /** Leading your projects function **/
        btnYourProjects.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lblListExplainer.setText("Your projects:");
                lblChooseProject.setVisible(true);
                btnChoose.setVisible(true);
                lblDeleteProject.setVisible(true);
                btnDeleteProject.setVisible(true);
                frontScreenRemoving(btnBecomeProjectLeader, btnRegisterTime, btnSeekAssistance, btnYourProjects, btnDeleteEmployees,btnSeminarVacation);
                DefaultListModel projects = new DefaultListModel();
                for (Project project : system.getDatabase().getProjectLeaderList(system.getCurrentEmployee())) {
                    String name = "Name:  " + project.getName() + "   ID:   " + project.getProjectID();
                    projects.addElement(name);
                }
                list.setModel(projects);
            }
        });

        btnChoose.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = list.getSelectedIndex();
                String string = ((String) list.getModel().getElementAt(index));
                int space = string.indexOf("ID:") + 6;
                string = string.substring(space);
                currentProjectID = Integer.parseInt(string);
                lblChooseProject.setVisible(false);
                btnChoose.setVisible(false);
                lblListExplainer.setText("");
                lblWorkingWith.setVisible(true);
                lblDeleteProject.setVisible(false);
                btnDeleteProject.setVisible(false);
                lblProjectName.setText(system.getDatabase().getProject(currentProjectID).getProjectName());
                DefaultListModel emptyModel = new DefaultListModel();
                list.setModel(emptyModel);
                textCreateAssignment.setVisible(true);
                lblCreateAssignment.setVisible(true);
                lblChooseAssignmentFrom.setVisible(true);
                btnChooseAssignment.setVisible(true);
                btnCreateAssignment.setVisible(true);
                btnDeleteAssignment.setVisible(true);
                lblDeleteAssignmentFrom.setVisible(true);
                lblListExplainer.setText("Assignments in " + system.getDatabase().getProject(currentProjectID).getProjectName() + ":");
                DefaultListModel assignmentList = new DefaultListModel();
                for (Assignment assignment : system.getDatabase().getProject(currentProjectID).getAssignmentList()) {
                    assignmentList.addElement(assignment.getName());
                }
                list.setModel(assignmentList);

            }
        });

        btnDeleteProject.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = list.getSelectedIndex();
                String string = ((String) list.getModel().getElementAt(index));
                int space = string.indexOf("ID:") + 6;
                string = string.substring(space);
                int deletedProjectID = Integer.parseInt(string);
                try {
                    system.removeProject(deletedProjectID);
                } catch (WrongInputException e1) {
                    JOptionPane.showMessageDialog(null,e1.getMessage());
                }
                DefaultListModel projects = new DefaultListModel();
                for (Project project : system.getDatabase().getProjectLeaderList(system.getCurrentEmployee())) {
                    String name = "Name:  " + project.getName() + "   ID:   " + project.getProjectID();
                    projects.addElement(name);
                }
                list.setModel(projects);
            }
        });

        /** Creating and choosing assignments in projects **/
        textCreateAssignment.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    system.getDatabase().getProject(currentProjectID).createAssignment(textCreateAssignment.getText());
                } catch (WrongInputException e1) {
                    JOptionPane.showMessageDialog(null, e1.getMessage());
                }
                DefaultListModel assignmentList = new DefaultListModel();
                for (Assignment assignment : system.getDatabase().getProject(currentProjectID).getAssignmentList()) {
                    assignmentList.addElement(assignment.getName());
                }
                list.setModel(assignmentList);
                textCreateAssignment.setText("");

            }
        });

        btnDeleteAssignment.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    system.removeAssignment((String) list.getModel().getElementAt(list.getSelectedIndex()));
                } catch (WrongInputException e1) {
                    JOptionPane.showMessageDialog(null,e1.getMessage());
                }
                DefaultListModel assignmentList = new DefaultListModel();
                for (Assignment assignment : system.getDatabase().getProject(currentProjectID).getAssignmentList()) {
                    assignmentList.addElement(assignment.getName());
                }
                list.setModel(assignmentList);

            }
        });

        btnCreateAssignment.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    system.getDatabase().getProject(currentProjectID).createAssignment(textCreateAssignment.getText());
                } catch (WrongInputException e1) {
                    JOptionPane.showMessageDialog(null, e1.getMessage());
                }
                DefaultListModel assignmentList = new DefaultListModel();
                for (Assignment assignment : system.getDatabase().getProject(currentProjectID).getAssignmentList()) {
                    assignmentList.addElement(assignment.getName());
                }
                list.setModel(assignmentList);
                textCreateAssignment.setText("");
            }
        });

        btnChooseAssignment.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = list.getSelectedIndex();
                String assignmentName = ((String) list.getModel().getElementAt(index));
                currentAssignmentName = assignmentName;
                lblChooseAssignmentFrom.setVisible(false);
                lblCreateAssignment.setVisible(false);
                textCreateAssignment.setVisible(false);
                btnChooseAssignment.setVisible(false);
                btnCreateAssignment.setVisible(false);
                lblProjectName.setText(assignmentName + " in " + system.getDatabase().getProject(currentProjectID).getProjectName());
                lblListExplainer.setText("");
                DefaultListModel empty = new DefaultListModel();
                list.setModel(empty);
                lblStartWeek.setVisible(true);
                lblDuration.setVisible(true);
                lblNumberOfHours.setVisible(true);
                lblSetBudgettedTime.setVisible(true);
                textSetBudgettedTime.setVisible(true);
                btnSetBudgettedTime.setVisible(true);
                textStartWeek.setVisible(true);
                textDuration.setVisible(true);
                textDuration.setText("");
                textHours.setVisible(true);
                textHours.setText("");
                textYear.setVisible(true);
                lblYear.setVisible(true);
                try {
                    textYear.setText("" + system.getThisDay().getWeekCalendar().getYear());
                } catch (Exception e1) {
                    JOptionPane.showMessageDialog(null,e1.getMessage());
                }
                try {
                    textStartWeek.setText("" + system.getThisDay().getWeekCalendar().getWeekNumber());
                } catch (Exception e1) {
                    JOptionPane.showMessageDialog(null,e1.getMessage());
                }
                btnDeleteAssignment.setVisible(false);
                lblDeleteAssignmentFrom.setVisible(false);
                btnGetAvailableEmployees.setVisible(true);
                try {
                    lblBudgettedTime.setText("Budgetted time:  " + ((double) system.getDatabase().getProject(currentProjectID).getAssignmentByName(currentAssignmentName).getBudgetedTime()) / 2.0 + " hours");
                } catch (WrongInputException e1) {
                    JOptionPane.showMessageDialog(null,e1.getMessage());
                }
                try {
                    lblBookedTime.setText("Booked time:      " + ((double)system.getDatabase().getProject(currentProjectID).getAssignmentByName(currentAssignmentName).getBookedTime())/2.0 + " hours");
                } catch (WrongInputException e1) {
                    JOptionPane.showMessageDialog(null,e1.getMessage());
                }


            }
        });

        btnGetAvailableEmployees.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                WeekCalendar startWeek = null;
                try {
                    startWeek = new WeekCalendar(Integer.parseInt(textYear.getText()), Integer.parseInt(textStartWeek.getText()));
                } catch (WrongInputException e1) {
                }
                DefaultListModel employees = new DefaultListModel();
                for (Employee employee : system.getDatabase().getAvailableEmployees(startWeek, Integer.parseInt(textDuration.getText()), system.convertToHalfHours(Double.parseDouble(textHours.getText())))) {
                    employees.addElement(employee.getEmployeeID());
                }
                list.setModel(employees);
                lblListExplainer.setText("Available employees:");
                lblChooseAvailableEmployee.setVisible(true);
                btnManAssignment.setVisible(true);
            }
        });

        btnSetBudgettedTime.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    system.getDatabase().getProject(currentProjectID).getAssignmentByName(currentAssignmentName).setBudgetedTime(system.convertToHalfHours(Double.parseDouble(textSetBudgettedTime.getText())));
                } catch (WrongInputException e1) {
                    JOptionPane.showMessageDialog(null,e1.getMessage());
                }
                textSetBudgettedTime.setText("");
                try {
                    lblBudgettedTime.setText("Budgetted time:  " + ((double) system.getDatabase().getProject(currentProjectID).getAssignmentByName(currentAssignmentName).getBudgetedTime()) / 2.0 + " hours");
                } catch (WrongInputException e1) {
                    JOptionPane.showMessageDialog(null,e1.getMessage());
                }
            }
        });

        textSetBudgettedTime.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    system.getDatabase().getProject(currentProjectID).getAssignmentByName(currentAssignmentName).setBudgetedTime(system.convertToHalfHours(Double.parseDouble(textSetBudgettedTime.getText())));
                } catch (WrongInputException e1) {
                }
                textSetBudgettedTime.setText("");
                try {
                    lblBudgettedTime.setText("Budgetted time:  " + ((double) system.getDatabase().getProject(currentProjectID).getAssignmentByName(currentAssignmentName).getBudgetedTime()) / 2.0 + " hours");
                } catch (WrongInputException e1) {
                    JOptionPane.showMessageDialog(null,e1.getMessage());
                }
            }
        });

        btnManAssignment.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = (String) list.getModel().getElementAt(list.getSelectedIndex());
                WeekCalendar weekCalendar = null;
                try {
                    weekCalendar = new WeekCalendar(Integer.parseInt(textYear.getText()), Integer.parseInt(textStartWeek.getText()));
                } catch (WrongInputException e1) {
                }
                int duration = Integer.parseInt(textDuration.getText());
                int hours = system.convertToHalfHours(Double.parseDouble(textHours.getText()));
                try {
                    system.getDatabase().getProject(currentProjectID).getAssignmentByName(currentAssignmentName).manAssignment(system.getDatabase().getEmployee(name), weekCalendar, duration,hours);
                } catch (Exception e1) {
                    JOptionPane.showMessageDialog(null, e1.getMessage());

                }
                DefaultListModel employees = new DefaultListModel();
                for (Employee employee : system.getDatabase().getAvailableEmployees(weekCalendar, duration, hours)) {
                    employees.addElement(employee.getEmployeeID());
                }
                list.setModel(employees);
                try {
                    lblBookedTime.setText("Booked time:      " + ((double)system.getDatabase().getProject(currentProjectID).getAssignmentByName(currentAssignmentName).getBookedTime())/2.0 + " hours");
                } catch (WrongInputException e1) {
                    JOptionPane.showMessageDialog(null,e1.getMessage());
                }
                textHours.setText("");
                textDuration.setText("");
            }
        });


        /** The register time function **/
        btnRegisterTime.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frontScreenRemoving(btnBecomeProjectLeader, btnRegisterTime, btnSeekAssistance, btnYourProjects, btnDeleteEmployees,btnSeminarVacation);
                lblListExplainer.setText("Your assignments:");
                btnRegisterTime2.setVisible(true);
                btnToday.setVisible(true);
                lblNewRegistration.setVisible(true);
                btnOldRegistrations.setVisible(true);
                textYearNumber.setVisible(true);
                lblYearNumber.setVisible(true);
                textHoursRegistration.setVisible(true);
                lblHours.setVisible(true);
                DefaultListModel assignments = new DefaultListModel();
                for (AssignmentEmployee assignment : system.getDatabase().getAssignmentEmployeeListWork(system.getCurrentEmployee().getEmployeeID())) {
                    assignments.addElement(assignment.getAssignment().getName());
                }
                list.setModel(assignments);
                textDayNumber.setVisible(true);
                textWeekNumber.setVisible(true);
                lblDayNumber.setVisible(true);
                lblWeekNumber.setVisible(true);
                lblTypeWeekNumber.setVisible(true);
                btnRegisterIllness.setVisible(true);
            }
        });

        btnToday.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DayCalendar dayCalendar = null;
                try {
                    dayCalendar = system.getThisDay();
                } catch (Exception e1) {
                    JOptionPane.showMessageDialog(null,e1.getMessage());
                }
                textWeekNumber.setText("" + dayCalendar.getWeekCalendar().getWeekNumber());
                textDayNumber.setText("" + dayCalendar.getDayNumber());
                textYearNumber.setText("" + dayCalendar.getWeekCalendar().getYear());
            }
        });

        btnRegisterTime2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String assignmentName = (String) list.getModel().getElementAt(list.getSelectedIndex());
                WeekCalendar weekCalendar = null;
                try {
                    weekCalendar = new WeekCalendar(Integer.parseInt(textYearNumber.getText()),Integer.parseInt(textWeekNumber.getText()));
                } catch (WrongInputException e1) {
                    JOptionPane.showMessageDialog(null,e1.getMessage());
                }
                DayCalendar dayCalendar = null;
                try {
                    dayCalendar = new DayCalendar(weekCalendar,Integer.parseInt(textDayNumber.getText()));
                } catch (WrongInputException e1) {
                    JOptionPane.showMessageDialog(null,e1.getMessage());
                }
                AssignmentEmployee currentAssignmentEmployee = system.getDatabase().getAssignmentEmployeeByNameAndEmployee(assignmentName,system.getCurrentEmployee());
                try {
                    currentAssignmentEmployee.registerTime(dayCalendar,system.convertToHalfHours(Double.parseDouble(textHoursRegistration.getText())));
                } catch (Exception e1) {
                    JOptionPane.showMessageDialog(null,e1.getMessage());
                }
                textHoursRegistration.setText("");
            }
        });

        btnRegisterIllness.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    WeekCalendar weekCalendar = new WeekCalendar(Integer.parseInt(textYearNumber.getText()),Integer.parseInt(textWeekNumber.getText()));
                    DayCalendar dayCalendar = new DayCalendar(weekCalendar,Integer.parseInt(textDayNumber.getText()));
                    system.getCurrentEmployee().registerIllness(dayCalendar,system.convertToHalfHours(Double.parseDouble(textHoursRegistration.getText())));
                    textHoursRegistration.setText("");
                } catch (WrongInputException e1) {
                    JOptionPane.showMessageDialog(null,e1.getMessage());
                } catch (TooManyHoursException e1) {
                    JOptionPane.showMessageDialog(null,e1.getMessage());
                }
            }
        });

        btnOldRegistrations.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textDayNumber.setVisible(false);
                textWeekNumber.setVisible(false);
                btnRegisterTime2.setVisible(false);
                btnToday.setVisible(false);
                lblDayNumber.setVisible(false);
                lblWeekNumber.setVisible(false);
                lblTypeWeekNumber.setVisible(false);
                textDayNumber.setText("");
                textWeekNumber.setText("");
                textYearNumber.setText("");
                lblNewRegistration.setVisible(false);
                btnOldRegistrations.setVisible(false);
                textYearNumber.setVisible(false);
                lblYearNumber.setVisible(false);
                textHoursRegistration.setVisible(false);
                lblHours.setVisible(false);
                btnRegisterIllness.setVisible(false);
                btnBookVacation.setVisible(false);
                btnBookSeminar.setVisible(false);
                lblListExplainer.setText("Your time registrations:");
                DefaultListModel oldRegistrations = new DefaultListModel();
                for (AssignmentEmployee assignmentEmployee : system.getDatabase().getAssignmentEmployeeList(system.getCurrentEmployee().employeeID)) {
                    for (DayRegistration dayRegistration : assignmentEmployee.getDayRegistrationList()) {
                        oldRegistrations.addElement(assignmentEmployee.getAssignment().getName() + " on " +
                                dayRegistration.getDayCalendar().getWeekCalendar().getYear() + "/" + dayRegistration.getDayCalendar().getWeekCalendar().getWeekNumber() +
                                "/" + dayRegistration.getDayCalendar().getDayNumber() + "  Hours: " + ((double) dayRegistration.getRegisteredHalfHours()) / 2);
                    }
                }
                list.setModel(oldRegistrations);
                textHoursRegistration.setVisible(true);
                textHoursRegistration.setText("");
                btnChangeHours.setVisible(true);
                lblHours.setVisible(true);
                lblChooseARegistration.setVisible(true);
            }
        });

        btnChangeHours.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String registration = (String) list.getModel().getElementAt(list.getSelectedIndex());
                int index = registration.indexOf("  Hours: ");
                int day = Integer.parseInt(registration.substring(index-1,index));
                String newString = registration.substring(0,index-2);
                int lastIndex = newString.lastIndexOf('/');
                int week = Integer.parseInt(newString.substring(lastIndex+1));
                int year = Integer.parseInt(newString.substring(lastIndex-4,lastIndex));
                String assignmentName = newString.substring(0,lastIndex-8);
                AssignmentEmployee assignmentEmployee = system.getDatabase().getAssignmentEmployeeByNameAndEmployee(assignmentName,system.getCurrentEmployee());
                if (assignmentEmployee == null) {JOptionPane.showMessageDialog(null,"HEj");}
                try {
                    WeekCalendar weekCalendar = new WeekCalendar(year,week);
                    DayCalendar dayCalendar = new DayCalendar(weekCalendar,day);
                    assignmentEmployee.changeRegistration(dayCalendar,system.convertToHalfHours(Double.parseDouble(textHoursRegistration.getText())));
                } catch (WrongInputException e1) {
                    JOptionPane.showMessageDialog(null,e1.getMessage());
                } catch (TooManyHoursException e1) {
                    JOptionPane.showMessageDialog(null,e1.getMessage());
                }
                DefaultListModel oldRegistrations = new DefaultListModel();
                for (AssignmentEmployee assignmentEmployee1 : system.getDatabase().getAssignmentEmployeeList(system.getCurrentEmployee().employeeID)) {
                    for (DayRegistration dayRegistration : assignmentEmployee1.getDayRegistrationList()) {
                        oldRegistrations.addElement(assignmentEmployee1.getAssignment().getName() + " on " +
                                dayRegistration.getDayCalendar().getWeekCalendar().getYear() + "/" + dayRegistration.getDayCalendar().getWeekCalendar().getWeekNumber() +
                                "/" + dayRegistration.getDayCalendar().getDayNumber() + "  Hours: " + ((double) dayRegistration.getRegisteredHalfHours()) / 2);
                    }
                }
                list.setModel(oldRegistrations);
            }
        });

        /** The booking seminar or vacation function **/
        btnSeminarVacation.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frontScreenRemoving(btnBecomeProjectLeader, btnRegisterTime, btnSeekAssistance, btnYourProjects, btnDeleteEmployees,btnSeminarVacation);
                textHours.setVisible(true);
                textHours.setText("");
                textYear.setVisible(true);
                try {
                    textYear.setText(String.valueOf(system.getThisDay().getWeekCalendar().getYear()));
                } catch (Exception e1) {
                    JOptionPane.showMessageDialog(null,e1.getMessage());
                }
                textDuration.setVisible(true);
                textDuration.setText("");
                textStartWeek.setVisible(true);
                try {
                    textStartWeek.setText(String.valueOf(system.getThisDay().getWeekCalendar().getWeekNumber()));
                } catch (Exception e1) {
                    JOptionPane.showMessageDialog(null,e1.getMessage());
                }
                lblYear.setVisible(true);
                lblNumberOfHours.setVisible(true);
                lblDuration.setVisible(true);
                lblStartWeek.setVisible(true);
                btnBookVacation.setVisible(true);
                btnBookSeminar.setVisible(true);

            }
        });

        btnBookSeminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    WeekCalendar weekCalendar = new WeekCalendar(Integer.parseInt(textYear.getText()),Integer.parseInt(textStartWeek.getText()));
                    system.getCurrentEmployee().bookSeminar(weekCalendar,Integer.parseInt(textDuration.getText()),system.convertToHalfHours(Double.parseDouble(textHours.getText())));
                    textDuration.setText("");
                    textHours.setText("");
                } catch (WrongInputException e1) {
                    JOptionPane.showMessageDialog(null,e1.getMessage());
                } catch (Exception e1) {
                    JOptionPane.showMessageDialog(null,e1.getMessage());
                }

            }
        });

        btnBookVacation.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                WeekCalendar weekCalendar = null;
                try {
                    weekCalendar = new WeekCalendar(Integer.parseInt(textYear.getText()),Integer.parseInt(textStartWeek.getText()));
                    system.getCurrentEmployee().bookVacation(weekCalendar,Integer.parseInt(textDuration.getText()),system.convertToHalfHours(Double.parseDouble(textHours.getText())));
                    textDuration.setText("");
                    textHours.setText("");
                } catch (WrongInputException e1) {
                    JOptionPane.showMessageDialog(null,e1.getMessage());
                } catch (Exception e1) {
                    JOptionPane.showMessageDialog(null,e1.getMessage());
                }
            }
        });

        /** The seek assistance function **/
        btnSeekAssistance.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frontScreenRemoving(btnBecomeProjectLeader,btnRegisterTime,btnSeekAssistance,btnYourProjects,btnDeleteEmployees,btnSeminarVacation);
                DefaultListModel assignments = new DefaultListModel();
                for (AssignmentEmployee assignment : system.getDatabase().getAssignmentEmployeeListWork(system.getCurrentEmployee().getEmployeeID())) {
                    assignments.addElement(assignment.getAssignment().getName());
                }
                list.setModel(assignments);
                lblListExplainer.setText("Your assignments:");
                btnChooseAssignmentSeekAssistance.setVisible(true);
                lblChooseAnAssignmentSeekAssistance.setVisible(true);
            }
        });

        btnChooseAssignmentSeekAssistance.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentAssignmentName = (String) list.getModel().getElementAt(list.getSelectedIndex());
                btnChooseAssignmentSeekAssistance.setVisible(false);
                lblChooseAnAssignmentSeekAssistance.setVisible(false);
                textHours.setVisible(true);
                textHours.setText("");
                textDuration.setVisible(true);
                textDuration.setText("");
                textYear.setVisible(true);
                textStartWeek.setVisible(true);
                try {
                    textYear.setText("" + system.getThisDay().getWeekCalendar().getYear());
                } catch (Exception e1) {
                    JOptionPane.showMessageDialog(null,e1.getMessage());
                }
                try {
                    textStartWeek.setText("" + system.getThisDay().getWeekCalendar().getWeekNumber());
                } catch (Exception e1) {
                    JOptionPane.showMessageDialog(null,e1.getMessage());
                }
                lblNumberOfHours.setVisible(true);
                lblYear.setVisible(true);
                lblStartWeek.setVisible(true);
                lblDuration.setVisible(true);
                btnGetAvailableEmployees2.setVisible(true);
                lblListExplainer.setText("");
                setListEmpty(list);
            }
        });

        btnGetAvailableEmployees2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                WeekCalendar startWeek = null;
                try {
                    startWeek = new WeekCalendar(Integer.parseInt(textYear.getText()), Integer.parseInt(textStartWeek.getText()));
                } catch (WrongInputException e1) {
                }
                DefaultListModel employees = new DefaultListModel();
                for (Employee employee : system.getDatabase().getAvailableEmployees(startWeek, Integer.parseInt(textDuration.getText()),
                        system.convertToHalfHours(Double.parseDouble(textHours.getText())))) {
                    employees.addElement(employee.getEmployeeID());
                }
                list.setModel(employees);
                lblListExplainer.setText("Available employees:");
                lblChooseAvailableEmployee.setVisible(true);
                btnSeekAssistance2.setVisible(true);
            }
        });

        btnSeekAssistance2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    system.seekAssistance((String)list.getModel().getElementAt(list.getSelectedIndex()),currentAssignmentName,
                            Integer.parseInt(textYear.getText()),Integer.parseInt(textStartWeek.getText()),
                            system.convertToHalfHours(Double.parseDouble(textHours.getText())));
                } catch (WrongInputException e1) {
                    JOptionPane.showMessageDialog(null,e1.getMessage());
                }
                textHours.setText("");
                textDuration.setText("");
            }
        });

        /** The delete employees function **/
        btnDeleteEmployees.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frontScreenRemoving(btnBecomeProjectLeader, btnRegisterTime, btnSeekAssistance, btnYourProjects, btnDeleteEmployees,btnSeminarVacation);
                lblListExplainer.setText("All employees;");
                lblChooseAnEmployee.setVisible(true);
                btnDeleteEmployee2.setVisible(true);
                DefaultListModel employees = new DefaultListModel();
                for (Employee employee : system.getEmployees()) {
                    if (!system.getCurrentEmployee().equals(employee)) {
                        employees.addElement(employee.getEmployeeID());
                    }
                }
                list.setModel(employees);
            }
        });

        btnDeleteEmployee2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    system.removeEmployee((String) list.getModel().getElementAt(list.getSelectedIndex()));
                } catch (WrongInputException e1) {
                    JOptionPane.showMessageDialog(null, e1.getMessage());
                }
                DefaultListModel employees = new DefaultListModel();
                for (Employee employee : system.getEmployees()) {
                    if (!system.getCurrentEmployee().equals(employee)) {
                        employees.addElement(employee.getEmployeeID());
                    }
                }
                list.setModel(employees);
            }
        });

        /** MENU button **/
        btnMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnBecomeProjectLeader.setVisible(true);
                btnRegisterTime.setVisible(true);
                btnSeekAssistance.setVisible(true);
                btnMenu.setVisible(true);
                btnYourProjects.setVisible(true);
                btnDeleteEmployees.setVisible(true);
                btnSeminarVacation.setVisible(true);
                settingInvisible(lblTypeProjectID, btnLeadProject, lblListExplainer, list, lblChooseProject, btnChoose, lblWorkingWith, lblProjectName, textCreateAssignment, lblCreateAssignment, lblChooseAssignmentFrom, btnChooseAssignment, btnCreateAssignment, lblStartWeek, lblDuration, lblNumberOfHours, lblSetBudgettedTime, textSetBudgettedTime, btnSetBudgettedTime, textStartWeek, textDuration, textHours, btnGetAvailableEmployees, textYear, lblYear, lblChooseAvailableEmployee, btnManAssignment, lblBudgettedTime, textDayNumber, textWeekNumber, btnRegisterTime2, btnToday, lblDayNumber, lblWeekNumber, lblTypeWeekNumber, textYearNumber, lblNewRegistration, btnOldRegistrations, lblYearNumber, textHoursRegistration, lblHours, lblChooseAnEmployee, btnDeleteEmployee2, lblDeleteProject, btnDeleteProject, btnDeleteAssignment, lblDeleteAssignmentFrom, btnChooseAssignmentSeekAssistance, lblChooseAnAssignmentSeekAssistance, btnGetAvailableEmployees2, btnSeekAssistance2, btnRegisterIllness, btnBookVacation, btnBookSeminar, btnChangeHours, lblChooseARegistration,lblBookedTime);

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
                frontScreenRemoving(btnBecomeProjectLeader, btnRegisterTime, btnSeekAssistance, btnYourProjects, btnDeleteEmployees,btnSeminarVacation);
                lblLoggedInAs2.setText("");
                btnMenu.setVisible(false);
                lblSoftwarehuset.setVisible(true);
                lblAs.setVisible(true);
                settingInvisible(lblTypeProjectID, btnLeadProject, lblListExplainer, list, lblChooseProject, btnChoose, lblWorkingWith, lblProjectName, textCreateAssignment, lblCreateAssignment, lblChooseAssignmentFrom, btnChooseAssignment, btnCreateAssignment, lblStartWeek, lblDuration, lblNumberOfHours, lblSetBudgettedTime, textSetBudgettedTime, btnSetBudgettedTime, textStartWeek, textDuration, textHours, btnGetAvailableEmployees, textYear, lblYear, lblChooseAvailableEmployee, btnManAssignment, lblBudgettedTime, textDayNumber, textWeekNumber, btnRegisterTime2, btnToday, lblDayNumber, lblWeekNumber, lblTypeWeekNumber, textYearNumber, lblNewRegistration, btnOldRegistrations, lblYearNumber, textHoursRegistration, lblHours, lblChooseAnEmployee, btnDeleteEmployee2, lblDeleteProject, btnDeleteProject, btnDeleteAssignment, lblDeleteAssignmentFrom, btnChooseAssignmentSeekAssistance, lblChooseAnAssignmentSeekAssistance, btnGetAvailableEmployees2, btnSeekAssistance2, btnRegisterIllness, btnBookVacation, btnBookSeminar, btnChangeHours, lblChooseARegistration,lblBookedTime);
            }
        });

    }

    private void settingInvisible(JLabel lblTypeProjectID, JButton btnLeadProject, JLabel lblListExplainer, JList list, JLabel lblChooseProject, JButton btnChoose, JLabel lblWorkingWith, JLabel lblProjectName, JTextField textCreateAssignment, JLabel lblCreateAssignment, JLabel lblChooseAssignmentFrom, JButton btnChooseAssignment, JButton btnCreateAssignment, JLabel lblStartWeek, JLabel lblDuration, JLabel lblNumberOfHours, JLabel lblSetBudgettedTime, JTextField textSetBudgettedTime, JButton btnSetBudgettedTime, JTextField textStartWeek, JTextField textDuration, JTextField textHours, JButton btnGetAvailableEmployees, JTextField textYear, JLabel lblYear, JLabel lblChooseAvailableEmployee, JButton btnManAssignment, JLabel lblBudgettedTime, JTextField textDayNumber, JTextField textWeekNumber, JButton btnRegisterTime2, JButton btnToday, JLabel lblDayNumber, JLabel lblWeekNumber, JLabel lblTypeWeekNumber, JTextField textYearNumber, JLabel lblNewRegistration, JButton btnOldRegistrations, JLabel lblYearNumber, JTextField textHoursRegistration, JLabel lblHours, JLabel lblChooseAnEmployee, JButton btnDeleteEmployee2, JLabel lblDeleteProject, JButton btnDeleteProject, JButton btnDeleteAssignment, JLabel lblDeleteAssignmentFrom, JButton btnChooseAssignmentSeekAssistance, JLabel lblChooseAnAssignmentSeekAssistance, JButton btnGetAvailableEmployees2, JButton btnSeekAssistance2, JButton btnRegisterIllness, JButton btnBookVacation, JButton btnBookSeminar, JButton btnChangeHours, JLabel lblChooseARegistration, JLabel lblBookedTime) {
        lblTypeProjectID.setVisible(false);
        btnLeadProject.setVisible(false);
        lblListExplainer.setText("");
        setListEmpty(list);
        lblChooseProject.setVisible(false);
        btnChoose.setVisible(false);
        lblWorkingWith.setVisible(false);
        lblProjectName.setText("");
        lblWorkingWith.setVisible(false);
        textCreateAssignment.setVisible(false);
        lblCreateAssignment.setVisible(false);
        lblChooseAssignmentFrom.setVisible(false);
        btnChooseAssignment.setVisible(false);
        btnCreateAssignment.setVisible(false);
        lblStartWeek.setVisible(false);
        lblDuration.setVisible(false);
        lblNumberOfHours.setVisible(false);
        lblSetBudgettedTime.setVisible(false);
        textSetBudgettedTime.setVisible(false);
        btnSetBudgettedTime.setVisible(false);
        textStartWeek.setVisible(false);
        textDuration.setVisible(false);
        textHours.setVisible(false);
        btnGetAvailableEmployees.setVisible(false);
        textYear.setVisible(false);
        lblYear.setVisible(false);
        lblChooseAvailableEmployee.setVisible(false);
        btnManAssignment.setVisible(false);
        lblBudgettedTime.setText("");
        textDayNumber.setVisible(false);
        textWeekNumber.setVisible(false);
        btnRegisterTime2.setVisible(false);
        btnToday.setVisible(false);
        lblDayNumber.setVisible(false);
        lblWeekNumber.setVisible(false);
        lblTypeWeekNumber.setVisible(false);
        textDayNumber.setText("");
        textWeekNumber.setText("");
        textYearNumber.setText("");
        lblNewRegistration.setVisible(false);
        btnOldRegistrations.setVisible(false);
        textYearNumber.setVisible(false);
        lblYearNumber.setVisible(false);
        textHoursRegistration.setVisible(false);
        lblHours.setVisible(false);
        lblChooseAnEmployee.setVisible(false);
        btnDeleteEmployee2.setVisible(false);
        lblDeleteProject.setVisible(false);
        btnDeleteProject.setVisible(false);
        btnDeleteAssignment.setVisible(false);
        lblDeleteAssignmentFrom.setVisible(false);
        btnChooseAssignmentSeekAssistance.setVisible(false);
        lblChooseAnAssignmentSeekAssistance.setVisible(false);
        btnGetAvailableEmployees2.setVisible(false);
        btnSeekAssistance2.setVisible(false);
        btnRegisterIllness.setVisible(false);
        btnBookVacation.setVisible(false);
        btnBookSeminar.setVisible(false);
        btnChangeHours.setVisible(false);
        lblChooseARegistration.setVisible(false);
        lblBookedTime.setText("");
    }

    private void setListEmpty(JList list) {
        DefaultListModel emptymodel = new DefaultListModel();
        list.setModel(emptymodel);
    }

    private void frontScreenRemoving(JButton btnBecomeProjectLeader, JButton btnRegisterTime, JButton btnSeekAssistance, JButton btnYourProjects, JButton btnDeleteEmployees,JButton btnSeminarVacation) {
        btnBecomeProjectLeader.setVisible(false);
        btnRegisterTime.setVisible(false);
        btnSeekAssistance.setVisible(false);
        btnYourProjects.setVisible(false);
        btnSeminarVacation.setVisible(false);
        btnDeleteEmployees.setVisible(false);
    }
}