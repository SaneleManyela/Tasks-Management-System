/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package to.do_list.assignmentManagaer;

import java.awt.*;
import java.awt.event.*;
import java.awt.Dimension;
import java.io.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Sanele
 */
public class clsMainWindow extends JFrame{
    public clsMainWindow() {
        this.setTitle("Assignment Ordering");
        this.setSize(800, 700);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        mCreateMainWindow();
    }
    
    private void mCreateMainWindow() {
        JPanel jpPanel = new JPanel(new BorderLayout(10, 20));
        jpPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
        jpPanel.setOpaque(true);
        jpPanel.setBackground(new Color(0, 204, 204));
        jpPanel.add(mCreateLabel("Assignments", 0, 30, Color.BLACK, 
                new Color(204, 204, 255)), BorderLayout.NORTH);
        jpPanel.add(mCreateLabel("", 500, 40, Color.BLACK,
                new Color(204, 204, 255)), BorderLayout.SOUTH);
        jpPanel.add(mCreateCenter());
        this.add(jpPanel);
    }   
    
    private JPanel mCreateCenter() {
        JPanel jpPanel = new JPanel(new GridBagLayout());
        jpPanel.setBorder(new EmptyBorder(20, 20, 40, 20));
        jpPanel.setOpaque(true);
        jpPanel.setBackground(new Color(255, 255, 255));
        mAddComponent(jpPanel, mCreateButton(180, 101, new ImageIcon(this.getClass().getResource("pickBook.jpg")), this::mOpenFile),
                0, 0, 3, 3, 0, 0, GridBagConstraints.NONE, GridBagConstraints.LINE_START, 
                new Insets(0, 0, 0, 0));
        mAddComponent(jpPanel, mCreateLabel("Open File", 180, 20, Color.BLACK, 
                Color.WHITE), 0, 4, 2, 1, 0, 0, GridBagConstraints.NONE, 
                GridBagConstraints.LINE_START, new Insets(0, 0, 0, 0));
        mAddComponent(jpPanel, mCreateButton(180, 101, new ImageIcon(this.getClass().getResource("SyDev.jpeg")), this::mOpenSyDevAssignments),
                4, 0, 3, 3, 0, 0, 
                GridBagConstraints.NONE, GridBagConstraints.LINE_START, 
                new Insets(20, 20, 20, 20));
        mAddComponent(jpPanel, mCreateLabel("Assignments", 180, 20, Color.BLACK, 
                Color.WHITE), 4, 4, 2, 1, 0, 0, GridBagConstraints.NONE, 
                GridBagConstraints.LINE_START, new Insets(20, 20, 20, 20));
        return jpPanel;
    }
    
    public static void mAddComponent(Container container, Component component,
        int intGridX, int intGridY, int intGridWidth, int intGridHeight, 
        double dblWeightX, double dblWeightY, int intFill, int intAnchor, 
        Insets insets) {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = intGridX;
        constraints.gridy = intGridY;
        constraints .gridwidth = intGridWidth;
        constraints.gridheight = intGridHeight;
        constraints.weightx = dblWeightX;
        constraints.weighty = dblWeightY;
        constraints.fill = intFill;
        constraints.anchor = intAnchor;
        constraints.insets = insets;
        container.add(component, constraints);
    }
    
    public JLabel mCreateLabel(String strText, int intWidth, int intHeight,
            Color clrFg, Color clrBg) {
        JLabel lblLabel = new JLabel(strText);
        lblLabel.setHorizontalAlignment(JLabel.CENTER);
        lblLabel.setOpaque(true);
        lblLabel.setBackground(clrBg);
        lblLabel.setForeground(clrFg);
        lblLabel.setPreferredSize(new Dimension(intWidth, intHeight));
        return lblLabel;
    }
    
    public JButton mCreateButton(int intWidth, int intHeight,
            ImageIcon imgIcon, ActionListener listener) {
        JButton btnButton = new JButton(imgIcon);
        btnButton.addActionListener(listener);
        btnButton.setPreferredSize(new Dimension(intWidth, intHeight));
        return btnButton;
    }
    
    public JPanel mTable(File fl)
    {
        JPanel jpPanel = new JPanel(new BorderLayout());
        JTable tblAssignmentDates = new JTable();
        tblAssignmentDates.setGridColor(new Color(99, 66, 33));
        tblAssignmentDates.setForeground(Color.BLACK);
        try {
            BufferedReader br = new BufferedReader(new FileReader(fl));
            String strFirstLine = br.readLine().trim();
            String[] arrColumnsName = strFirstLine.split(",");
            DefaultTableModel dmModel = (DefaultTableModel)tblAssignmentDates.getModel();
            dmModel.setColumnIdentifiers(arrColumnsName);
        } catch(IOException io) {
            
        }
        jpPanel.setOpaque(true);
        jpPanel.setBackground(new Color(255, 255, 255));
        jpPanel.add(tblAssignmentDates);
        return jpPanel;
    }
    
    
    private void mOpenSyDevAssignments(ActionEvent e) {
        clsAssignments clsAssgnmnts = new clsAssignments();
    }
        
    private void mOpenFile(ActionEvent e) {
        final JFileChooser fc = new JFileChooser(".");
        fc.setCurrentDirectory(new File("C:\\Users\\Sanele\\Documents\\Systems Development\\Extra Work"));
        int status = fc.showOpenDialog(null);
        fc.setDialogTitle("Open PDF File");
        if(status == JFileChooser.APPROVE_OPTION) {
            new clsPdfViewer(fc.getSelectedFile());
        } else if(status == JFileChooser.CANCEL_OPTION) {
            fc.cancelSelection();
        }
    }
}
