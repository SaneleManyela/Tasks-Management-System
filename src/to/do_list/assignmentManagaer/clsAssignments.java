/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package to.do_list.assignmentManagaer;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import javax.swing.border.*;

/**
 *
 * @author Sanele
 */
public class clsAssignments extends JFrame{
    public clsAssignments() {
        this.setTitle("Assignments");
        this.setSize(800, 600);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        mCreateSyDevWindow();
        this.setVisible(true);
    }
    
    private void mCreateSyDevWindow() {
        JPanel jpPanel = new JPanel(new BorderLayout(10, 20));
        jpPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        jpPanel.setOpaque(true);
        jpPanel.setBackground(new Color(0, 204, 204));
        jpPanel.add(mCreateWindow());
        this.add(jpPanel);
    }
        private JLabel mCreateLabel(String strText, int intWidth, int intHeight,
            Color clrFg, Color clrBg) {
        JLabel lblLabel = new JLabel(strText);
        lblLabel.setHorizontalAlignment(JLabel.CENTER);
        lblLabel.setOpaque(true);
        lblLabel.setBackground(clrBg);
        lblLabel.setForeground(clrFg);
        lblLabel.setPreferredSize(new Dimension(intWidth, intHeight));
        return lblLabel;
    }
    
    private JButton mCreateButton(int intWidth, int intHeight,
            ImageIcon imgIcon, ActionListener listener) {
        JButton btnButton = new JButton(imgIcon);
        btnButton.addActionListener(listener);
        btnButton.setPreferredSize(new Dimension(intWidth, intHeight));
        return btnButton;
    }
    
    private JPanel mCreateWindow() {
        JPanel jpPanel = new JPanel(new GridBagLayout());
        jpPanel.setBorder(new EmptyBorder(20, 20, 40, 20));
        jpPanel.setOpaque(true);
        jpPanel.setBackground(new Color(255, 255, 255));
        clsMainWindow.mAddComponent(jpPanel, mCreateButton(87, 104, new ImageIcon(this.getClass().getResource("assignmentIcon.PNG")), 
                this::mOpenFirstYearAssignmentWindow), 0, 0, 2, 2, 0, 0, 
                GridBagConstraints.NONE, GridBagConstraints.LINE_START, 
                new Insets(10, 0, 10, 10));
        clsMainWindow.mAddComponent(jpPanel, mCreateLabel("1st Yr SyDev", 80, 20, Color.BLACK, 
                Color.WHITE), 0, 2, 2, 1, 0, 0, GridBagConstraints.NONE, 
                GridBagConstraints.LINE_START, new Insets(10, 0, 10, 10));
        
        clsMainWindow.mAddComponent(jpPanel, mCreateButton(87, 104, new ImageIcon(this.getClass().getResource("assignmentIcon.PNG")), 
                this::mOpenSecondYearAssignmentWindow), 6, 0, 2, 2, 0, 0, 
                GridBagConstraints.NONE, GridBagConstraints.LINE_START, 
                new Insets(10, 0, 10, 10));
        clsMainWindow.mAddComponent(jpPanel, mCreateLabel("2nd Yr SyDev", 80, 20, Color.BLACK, 
                Color.WHITE), 6, 2, 2, 1, 0, 0, GridBagConstraints.NONE, 
                GridBagConstraints.LINE_START, new Insets(10, 10, 10, 10));
        
        clsMainWindow.mAddComponent(jpPanel, mCreateButton(87, 104, new ImageIcon(this.getClass().getResource("assignmentIcon.PNG")), 
                this::mOpenThirdYearAssignmentWindow),
                12, 0, 2, 2, 0, 0, GridBagConstraints.NONE, GridBagConstraints.LINE_START, new Insets(10, 0, 10, 10));
        clsMainWindow.mAddComponent(jpPanel, mCreateLabel("3rd Yr SyDev", 80, 20, Color.BLACK, Color.WHITE), 12, 2, 2, 2, 0, 0, 
                GridBagConstraints.NONE, GridBagConstraints.LINE_START, new Insets(10, 10, 10, 10));
        
        clsMainWindow.mAddComponent(jpPanel, mCreateButton(87, 104, new ImageIcon(this.getClass().getResource("assignmentIcon.PNG")),
                this::mOpenNetAssignments),
                16, 0, 2, 2, 0, 0,  GridBagConstraints.NONE, GridBagConstraints.LINE_START, new Insets(10, 0, 10, 10));
        clsMainWindow.mAddComponent(jpPanel, mCreateLabel("Networking", 80, 20, Color.BLACK, Color.WHITE), 16, 2, 2, 2, 0, 0, 
                GridBagConstraints.NONE, GridBagConstraints.LINE_START, new Insets(10, 10, 10, 10));
        
        clsMainWindow.mAddComponent(jpPanel, mCreateButton(87, 104, new ImageIcon(this.getClass().getResource("assignmentIcon.PNG")),
                this::mOpenUFHAssignments),
                18, 0, 2, 2, 0, 0, GridBagConstraints.NONE, GridBagConstraints.LINE_START, new Insets(10, 10, 10, 10));
        clsMainWindow.mAddComponent(jpPanel, mCreateLabel("UFH", 80, 20, Color.BLACK, Color.WHITE), 18, 2, 2, 1, 0, 0,
                GridBagConstraints.NONE, GridBagConstraints.LINE_START, new Insets(10, 10, 10, 10));
        return jpPanel;
    }
    
    private void mOpenFirstYearAssignmentWindow(ActionEvent e) {
        clsFirstYear clsFirstYr = new clsFirstYear();
    }
    
    private void mOpenSecondYearAssignmentWindow(ActionEvent e) {
        clsSecondYearAssignments cls2ndYr = new clsSecondYearAssignments();
    }
    
    private void mOpenThirdYearAssignmentWindow(ActionEvent e) {
        clsThirdYearAssignments cls3rdYr = new clsThirdYearAssignments();
    }
    
    private void mOpenNetAssignments(ActionEvent e) {
        clsNetAssignments clsNetworking = new clsNetAssignments();
    }
    
    private void mOpenUFHAssignments(ActionEvent e) {
        clsUFH ufh = new clsUFH();
    }
    
    class clsFirstYear extends JDialog {
        public clsFirstYear() {
            super(null, "First Year Assignments", Dialog.ModalityType.APPLICATION_MODAL);
            this.setSize(400, 400);
            this.setLocationRelativeTo(null);
            this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            mCreateFrstYrWindow();
            this.setVisible(true);
        }
        
        private void mCreateFrstYrWindow() {
            JPanel jpPanel = new JPanel(new BorderLayout(10, 20));
            jpPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
            jpPanel.setOpaque(true);
            jpPanel.setBackground(new Color(0, 204, 204));
            jpPanel.add(mCreateFirstYearAssignmentWindow());
            this.add(jpPanel);
        }        
        
        private JPanel mCreateFirstYearAssignmentWindow() {
            JPanel jpPanel = new JPanel(new GridBagLayout());
            jpPanel.setBorder(new EmptyBorder(20, 20, 40, 20));
            jpPanel.setOpaque(true);
            jpPanel.setBackground(new Color(255, 255, 255));
            clsMainWindow.mAddComponent(jpPanel, new clsMainWindow().mCreateButton(87, 104, new ImageIcon(this.getClass().getResource("assignmentIcon.PNG")), 
                    this::mOpenAssgnmt),
                0, 0, 2, 2, 0, 0, GridBagConstraints.NONE, GridBagConstraints.LINE_START, 
                new Insets(10, 0, 10, 10));
            clsMainWindow.mAddComponent(jpPanel, new clsMainWindow().mCreateLabel("HPRXS1.pdf", 100, 20, Color.BLACK, 
                Color.WHITE), 0, 2, 2, 1, 0, 0, GridBagConstraints.NONE, 
                GridBagConstraints.LINE_START, new Insets(0, 0, 0, 0));
            clsMainWindow.mAddComponent(jpPanel, new clsMainWindow().mTable(new File("C:\\Users\\Sanele\\Documents\\Information Technology\\Java OOP\\Java 2_Programs With GUI\\Assignments\\assignments\\First Year Assignment\\Dates.txt").getAbsoluteFile()),
                4, 0, 4, 4, 0, 0, GridBagConstraints.NONE, GridBagConstraints.LINE_START, new Insets(10, 10, 10, 10));
            return jpPanel;
        }
        
        private void mOpenAssgnmt(ActionEvent e) {
            File flPath = new File("C:\\Users\\Sanele\\Documents\\Systems Development\\Extra Work\\Praxis Y1 2020\\Oriana\\Praxis SA1\\HPX100-1-SA1-Jul-Dec2020-CZ-V2-27052020.pdf");
            this.hide();
            new clsPdfViewer(flPath.getAbsoluteFile());
        }
    }
    
    class clsSecondYearAssignments extends JDialog{
        public clsSecondYearAssignments() {
            super(null, "Second Year Assignments", Dialog.ModalityType.APPLICATION_MODAL);
            this.setSize(600, 400);
            this.setLocationRelativeTo(null);
            this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            mCreate2ndYrWindow();
            this.setVisible(true);
        }
        
        private void mCreate2ndYrWindow() {
            JPanel jpPanel = new JPanel(new BorderLayout(10, 20));
            jpPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
            jpPanel.setOpaque(true);
            jpPanel.setBackground(new Color(0, 204, 204));
            jpPanel.add(mCreateSecondYearAssignmentWindow());
            this.add(jpPanel);
        }
        
        private JPanel mCreateSecondYearAssignmentWindow() {
            JPanel jpPanel = new JPanel(new GridBagLayout());
            jpPanel.setBorder(new EmptyBorder(20, 20, 40, 20));
            jpPanel.setOpaque(true);
            jpPanel.setBackground(new Color(255, 255, 255));
            clsMainWindow.mAddComponent(jpPanel, new clsMainWindow().mCreateButton(87, 104, new ImageIcon(this.getClass().getResource("assignmentIcon.PNG")), 
                    this::mOpenAssgnmt),
                0, 0, 2, 2, 0, 0, GridBagConstraints.NONE, GridBagConstraints.LINE_START, 
                new Insets(10, 0, 10, 10));
            clsMainWindow.mAddComponent(jpPanel, new clsMainWindow().mCreateLabel("HSYD2A.pdf", 100, 20, Color.BLACK, 
                Color.WHITE), 0, 2, 2, 1, 0, 0, GridBagConstraints.NONE, 
                GridBagConstraints.LINE_START, new Insets(0, 0, 0, 0));
            clsMainWindow.mAddComponent(jpPanel, new clsMainWindow().mTable(new File("C:\\Users\\Sanele\\Documents\\Information Technology\\Java OOP\\Java 2_Programs With GUI\\Assignments\\assignments\\Second Year Assignment\\Dates.txt").getAbsoluteFile()),
                4, 0, 4, 4, 0, 0, GridBagConstraints.NONE, GridBagConstraints.LINE_START, new Insets(10, 10, 10, 10));
            return jpPanel;
        }
        
        private void mOpenAssgnmt(ActionEvent e) {
            File flPath = new File("C:\\Users\\Sanele\\Documents\\Systems Development\\Extra Work\\Nokubonga\\Netbeans Project\\HSYD201-1-Jul-Dec2020-SA1-OD-V2-05032020 NetBeans project.pdf");
            this.hide();
            new clsPdfViewer(flPath.getAbsoluteFile());
        }
    }
    
    class clsThirdYearAssignments extends JDialog {
        public clsThirdYearAssignments() {
            super(null, "Third Year Assignments", Dialog.ModalityType.APPLICATION_MODAL);
            this.setSize(500, 400);
            this.setLocationRelativeTo(null);
            this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            mCreate3rdYrWindow();
            this.setVisible(true);
        }
        
        private void mCreate3rdYrWindow() {
            JPanel jpPanel = new JPanel(new BorderLayout(10, 20));
            jpPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
            jpPanel.setOpaque(true);
            jpPanel.setBackground(new Color(0, 204, 204));
            jpPanel.add(mCreateThirdYearAssignmentWindow());
            this.add(jpPanel);
        }
        
        private JPanel mCreateThirdYearAssignmentWindow() {
            JPanel jpPanel = new JPanel(new GridBagLayout());
            jpPanel.setBorder(new EmptyBorder(10, 10, 20, 10));
            jpPanel.setOpaque(true);
            jpPanel.setBackground(new Color(255, 255, 255));
            clsMainWindow.mAddComponent(jpPanel, new clsMainWindow().mCreateButton(87, 104, new ImageIcon(this.getClass().getResource("assignmentIcon.PNG")), 
                    this::mOpenPRXSAssgnmt), 0, 0, 2, 2, 0, 0, GridBagConstraints.NONE, GridBagConstraints.LINE_START, 
                new Insets(0, 0, 10, 0));
            clsMainWindow.mAddComponent(jpPanel, new clsMainWindow().mCreateLabel("HPRXS3B161.pdf", 100, 20, Color.BLACK, 
                Color.WHITE), 0, 2, 2, 1, 0, 0, GridBagConstraints.NONE, 
                GridBagConstraints.LINE_START, new Insets(0, 0, 40, 0));
            clsMainWindow.mAddComponent(jpPanel, new clsMainWindow().mCreateButton(87, 104, new ImageIcon(this.getClass().getResource("assignmentIcon.PNG")), 
                    this::mOpenSYDAssgnmt), 4, 0, 2, 2, 0, 0, GridBagConstraints.NONE, GridBagConstraints.LINE_START, 
                new Insets(0, 0, 10, 0));
            clsMainWindow.mAddComponent(jpPanel, new clsMainWindow().mCreateLabel("HSYD3161.pdf", 100, 20, Color.BLACK, 
                Color.WHITE), 4, 2, 2, 1, 0, 0, GridBagConstraints.NONE, 
                GridBagConstraints.LINE_START, new Insets(0, 0, 40, 0));
            return jpPanel;
        }
        
        private void mOpenPRXSAssgnmt(ActionEvent e) {
            File flPath = new File("C:\\Users\\Sanele\\Documents\\Systems Development\\Extra Work\\Praxis Y3 2020\\Second Semester\\HPRXS3B.pdf");
            this.hide();
            new clsPdfViewer(flPath.getAbsoluteFile());
        }                                                                              
        
        private void mOpenSYDAssgnmt(ActionEvent e) {
            File flPath = new File("C:\\Users\\Sanele\\Documents\\Systems Development\\Extra Work\\Praxis Y3 2020\\Second Semester\\HSYD3.pdf");
            this.hide();
            new clsPdfViewer(flPath.getAbsoluteFile());
        } 
    }
    
    class clsNetAssignments extends JDialog {
        public clsNetAssignments() {
            super(null, "Networking Assignments", Dialog.ModalityType.APPLICATION_MODAL);
            this.setSize(600, 400);
            this.setLocationRelativeTo(null);
            this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            mCreateNetWindow();
            this.setVisible(true);    
        }   
    
        private void mCreateNetWindow() {
            JPanel jpPanel = new JPanel(new BorderLayout(10, 20));
            jpPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
            jpPanel.setOpaque(true);
            jpPanel.setBackground(new Color(0, 204, 204));
            jpPanel.add(mCreateWindow());
            this.add(jpPanel);
        }
    
        private JPanel mCreateWindow() {
            JPanel jpPanel = new JPanel(new GridBagLayout());
            jpPanel.setBorder(new EmptyBorder(20, 20, 40, 20));
            jpPanel.setOpaque(true);
            jpPanel.setBackground(new Color(255, 255, 255));
            clsMainWindow.mAddComponent(jpPanel, new clsMainWindow().mCreateButton(
                    87, 104, new ImageIcon(this.getClass().getResource("assignmentIcon.PNG")), this::mOpenAssgnmt),
                    0, 0, 2, 2, 0, 0, GridBagConstraints.NONE, GridBagConstraints.LINE_START, new Insets(0, 0, 0, 0));
            clsMainWindow.mAddComponent(jpPanel, new clsMainWindow().mCreateLabel("HPRXN3B161.pdf", 100, 20, Color.BLACK, 
                    Color.WHITE), 0, 2, 2, 1, 0, 0, GridBagConstraints.NONE, GridBagConstraints.LINE_START, new Insets(0, 0, 0, 0));
            clsMainWindow.mAddComponent(jpPanel, new clsMainWindow().mCreateButton(87, 104, new ImageIcon(this.getClass().getResource("assignmentIcon.PNG")), 
                    this::mOpenHPRXN3B161Temp), 4, 0, 2, 1, 0, 0, GridBagConstraints.NONE, GridBagConstraints.LINE_START, 
                    new Insets(10, 10, 10, 40));
            clsMainWindow.mAddComponent(jpPanel, new clsMainWindow().mCreateLabel("HPRXN-Temp", 100, 20, Color.BLACK, 
                Color.WHITE), 4, 2, 2, 1, 0, 0, GridBagConstraints.NONE, 
                GridBagConstraints.LINE_START, new Insets(10, 10, 10, 10));
            return jpPanel;
        }
    
        private void mOpenAssgnmt(ActionEvent e) {
            File flPath = new File("C:\\Users\\Sanele\\Documents\\Information Technology\\Java OOP\\Java 2_Programs With GUI\\Assignments\\assignments\\Third Year Assignment\\HPRXN3B161_SA-July-Dec2020-SA-TSS-V.2-17072020.pdf");
            this.hide();
            new clsPdfViewer(flPath.getAbsoluteFile()).toFront();
        }
    
        private void mOpenHPRXN3B161Temp(ActionEvent e) {
            try {
                File fl = new File("C:\\Users\\Sanele\\Documents\\Information Technology\\Java OOP\\Java 2_Programs With GUI\\Assignments\\assignments\\Third Year Assignment\\WrittenReport_Template-HPRXN3B161_SA-July-Dec2020-SA-TSS-V.2-17072020.docx");
                Runtime.getRuntime().exec("cmd.exe /c start soffice.exe \""+fl.getAbsoluteFile());
            } catch(IOException eX) {
                JOptionPane.showMessageDialog(null, eX);
            }
        }
    }
    
    class clsUFH extends JDialog {
        public clsUFH() {
            super(null, "UFH Faculty of Education Assignments", Dialog.ModalityType.APPLICATION_MODAL);
            this.setSize(800, 400);
            this.setLocationRelativeTo(null);
            this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            mCreateUFHWindow();
            this.setVisible(true);    
        }
        
        private void mCreateUFHWindow() {
            JPanel jpPanel = new JPanel(new BorderLayout(10, 20));
            jpPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
            jpPanel.setOpaque(true);
            jpPanel.setBackground(new Color(0, 204, 204));
            jpPanel.add(mCreateWindow());
            this.add(jpPanel);
        }
    
        private JPanel mCreateWindow() {
            JPanel jpPanel = new JPanel(new GridBagLayout());
            jpPanel.setBorder(new EmptyBorder(20, 20, 40, 20));
            jpPanel.setOpaque(true);
            jpPanel.setBackground(new Color(255, 255, 255));
            clsMainWindow.mAddComponent(jpPanel, new clsMainWindow().mCreateButton(
                    87, 104, new ImageIcon(this.getClass().getResource("assignmentIcon.PNG")), this::mOpenCV),
                    0, 0, 2, 2, 0, 0, GridBagConstraints.NONE, GridBagConstraints.LINE_START, new Insets(0, 0, 0, 0));
            clsMainWindow.mAddComponent(jpPanel, new clsMainWindow().mCreateLabel("Curr.Vitae", 120, 20, Color.BLACK, 
                    Color.WHITE), 0, 2, 2, 1, 0, 0, GridBagConstraints.NONE, GridBagConstraints.LINE_START, new Insets(0, 0, 0, 0));
            clsMainWindow.mAddComponent(jpPanel, new clsMainWindow().mCreateButton(87, 104, new ImageIcon(this.getClass().getResource("assignmentIcon.PNG")), 
                    this::mOpenTeachingPhilosophy), 4, 0, 2, 1, 0, 0, GridBagConstraints.NONE, GridBagConstraints.LINE_START, 
                    new Insets(10, 10, 10, 40));
            clsMainWindow.mAddComponent(jpPanel, new clsMainWindow().mCreateLabel("Teaching Philosophy", 120, 20, Color.BLACK, 
                Color.WHITE), 4, 2, 2, 1, 0, 0, GridBagConstraints.NONE, 
                GridBagConstraints.LINE_START, new Insets(10, 10, 10, 10));
            clsMainWindow.mAddComponent(jpPanel, new clsMainWindow().mCreateButton(
                    87, 104, new ImageIcon(this.getClass().getResource("assignmentIcon.PNG")), this::mOpenMySelf),
                    6, 0, 2, 2, 0, 0, GridBagConstraints.NONE, GridBagConstraints.LINE_START, new Insets(10, 10, 10, 10));
            clsMainWindow.mAddComponent(jpPanel, new clsMainWindow().mCreateLabel("My Self", 120, 20, Color.BLACK, 
                    Color.WHITE), 6, 2, 2, 1, 0, 0, GridBagConstraints.NONE, GridBagConstraints.LINE_START, new Insets(10, 10, 10, 10));
            clsMainWindow.mAddComponent(jpPanel, new clsMainWindow().mCreateButton(87, 104, new ImageIcon(this.getClass().getResource("assignmentIcon.PNG")), 
                    this::mOpenCAPS), 8, 0, 2, 1, 0, 0, GridBagConstraints.NONE, GridBagConstraints.LINE_START, 
                    new Insets(10, 10, 10, 40));
            clsMainWindow.mAddComponent(jpPanel, new clsMainWindow().mCreateLabel("CAPS", 120, 20, Color.BLACK, 
                Color.WHITE), 8, 2, 2, 1, 0, 0, GridBagConstraints.NONE, 
                GridBagConstraints.LINE_START, new Insets(10, 10, 10, 10));
            return jpPanel;
        }
        
        private void mOpenCV(ActionEvent e) {
            try {
                File fl = new File("C:\\Users\\Sanele\\Documents\\Systems Development\\Extra Work\\Teaching UFH\\CURRICULUM VITAE.docx");
                Runtime.getRuntime().exec("cmd.exe /c start soffice.exe \""+fl.getAbsoluteFile());
            } catch(IOException eX) {
                JOptionPane.showMessageDialog(null, eX);
            }
        }
        
        private void mOpenMySelf(ActionEvent e) {
            try {
                File fl = new File("C:\\Users\\Sanele\\Documents\\Systems Development\\Extra Work\\Teaching UFH\\MY SELF.docx");
                Runtime.getRuntime().exec("cmd.exe /c start soffice.exe \""+fl.getAbsoluteFile());
            } catch(IOException eX) {
                JOptionPane.showMessageDialog(null, eX);
            }
        }
        
        private void mOpenTeachingPhilosophy(ActionEvent e) {
            try {
                File fl = new File("C:\\Users\\Sanele\\Documents\\Systems Development\\Extra Work\\Teaching UFH\\MY TEACHING PHILOSOPHY.docx");
                Runtime.getRuntime().exec("cmd.exe /c start soffice.exe \""+fl.getAbsoluteFile());
            } catch(IOException eX) {
                JOptionPane.showMessageDialog(null, eX);
            }
        }
        
        private void mOpenCAPS(ActionEvent e) {
            try {
                File fl = new File("C:\\Users\\Sanele\\Documents\\Systems Development\\Extra Work\\Teaching UFH\\CAPS.docx");
                Runtime.getRuntime().exec("cmd.exe /c start soffice.exe \""+fl.getAbsoluteFile());
            } catch(IOException eX) {
                JOptionPane.showMessageDialog(null, eX);
            }
        }
    }
}
