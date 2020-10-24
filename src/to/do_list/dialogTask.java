/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package to.do_list;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

/**
 *
 * @author Sanele
 */
public class dialogTask extends JDialog {

    /**
     * Creates new form dialogTask
     */
    public dialogTask() {
        super(null, "Manage Tasks", JDialog.ModalityType.APPLICATION_MODAL);
        initComponents();
        new frmToDoList().mPrepareLabel(lblDialogHeading);
        new frmToDoList().mPrepareLabel(lblDialogFooter);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
    }
    
    private int intTaskId;
    
    private int mGetWeekOfTheYear() {
        Calendar c = Calendar.getInstance();//Get a calendar instance
        return c.get(Calendar.WEEK_OF_YEAR);
    }
    
    private String mGetTaskDescription() {
        return cboDays.getSelectedItem().toString()+" "+cboTaskNumber.getSelectedItem().toString()
                +" of week "+mGetWeekOfTheYear();
    }
    
    class clsUpdateTasks extends JDialog {
        
        public clsUpdateTasks() {
            super(null, "Update Tasks", JDialog.ModalityType.APPLICATION_MODAL);
            this.setSize(400, 400);
            this.setLocationRelativeTo(null);
            this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            mCreateWindow();
            this.setResizable(false);
            this.setVisible(true);
        }
        
        DefaultListModel model = new DefaultListModel();
        
        private void mSetListModel() {
            model = mGetModel("SELECT Description FROM tblTasks WHERE TaskDay LIKE '%of week "+mGetWeekOfTheYear()+"%' "
                    + "AND TaskDate LIKE '%"+new SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date()).substring(0, 
                            new SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date()).indexOf("-"))+"%'");
        }
        
        private void mCreateWindow() {
            JPanel jpDialogPanel = new JPanel(new BorderLayout(10, 20));  
            jpDialogPanel.setOpaque(true);
            jpDialogPanel.setBackground(new Color(0,204,204));
            jpDialogPanel.setBorder(new EmptyBorder(10, 20, 10, 20));
            
            JPanel jpWindowPane = new JPanel();
            jpWindowPane.setOpaque(true);
            jpWindowPane.setBackground(new Color(255, 255, 255));
            jpWindowPane.add(mCreateList(), BorderLayout.CENTER);
            
            jpDialogPanel.add(jpWindowPane);
            this.add(jpDialogPanel);
        }
        
        private JScrollPane mCreateList() {
            mSetListModel();
            JList list = new JList(model);
            list.addMouseListener(new clsListDoubleClicked());
            list.setOpaque(true);
            list.setBackground(Color.WHITE);
            list.setBorder(new LineBorder(new Color(0,204,204), 3, true));
            JScrollPane scroll = new JScrollPane(list);
            scroll.setPreferredSize(new Dimension(300, 340));
            return scroll;
        }
        
        private DefaultListModel mGetModel(String strQuery) {
            DefaultListModel dmModel = new DefaultListModel();
            Statement stStatement = null;
            ResultSet rs = null;
            try{
                stStatement = new ToDo_List().mConnectToDatabase().prepareStatement(strQuery);
                rs = stStatement.executeQuery(strQuery);
                    while(rs.next()) {
                        dmModel.addElement(rs.getString(1));
                    }
                } catch(SQLException | NullPointerException ex) {
                    JOptionPane.showMessageDialog(this, ex.getMessage(),
                            "Error while getting tasks descriptions", JOptionPane.ERROR_MESSAGE);
                } finally {
                    try{
                        stStatement.close();
                        rs.close();
                    } catch(SQLException | NullPointerException ex) {
                }
            }
            return dmModel;
        }
        
        private void mClose() {
            this.dispose();
        }
        
        class clsListDoubleClicked extends MouseAdapter {
            @Override
            public void mouseClicked(MouseEvent e) {
                JList lst = (JList)e.getComponent();
                if(e.getClickCount() == 2) {
                    String strDay = new ToDo_List().mGetTextField("SELECT TaskDay FROM tblTasks WHERE Description ='"+lst.getSelectedValue().toString()+"'").substring(0, 
                            new ToDo_List().mGetTextField("SELECT TaskDay FROM tblTasks WHERE Description ='"+lst.getSelectedValue().toString()+"'").indexOf(" "));
                    
                    intTaskId = new ToDo_List().mGetNumericField("SELECT TaskID FROM tblTasks WHERE Description ='"+lst.getSelectedValue().toString()+"' AND TaskDay ='"+
                            new ToDo_List().mGetTextField("SELECT TaskDay FROM tblTasks WHERE Description ='"+lst.getSelectedValue().toString()+"'")+"'");
                    txtDescription.setText(lst.getSelectedValue().toString());
                    mClose();
                }
            }
            
        }
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpDialogPanel = new javax.swing.JPanel();
        jpWindowPane = new javax.swing.JPanel();
        lblDialogHeading = new javax.swing.JLabel();
        lblDialogFooter = new javax.swing.JLabel();
        lblDescription = new javax.swing.JLabel();
        spDescriptionPane = new javax.swing.JScrollPane();
        txtDescription = new javax.swing.JTextArea();
        lblDay = new javax.swing.JLabel();
        btnUpdateTask = new javax.swing.JButton();
        btnCreateTask = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        cboTaskNumber = new javax.swing.JComboBox<>();
        lblTaskNo = new javax.swing.JLabel();
        cboDays = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jpDialogPanel.setBackground(new java.awt.Color(0, 204, 204));

        jpWindowPane.setBackground(new java.awt.Color(255, 255, 255));

        lblDialogHeading.setBackground(new java.awt.Color(204, 204, 255));
        lblDialogHeading.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblDialogHeading.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDialogHeading.setText("Manage Task");

        lblDialogFooter.setBackground(new java.awt.Color(204, 204, 255));
        lblDialogFooter.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblDialogFooter.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        lblDescription.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblDescription.setText("Description");

        txtDescription.setColumns(20);
        txtDescription.setRows(5);
        txtDescription.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 204, 204), 3, true));
        spDescriptionPane.setViewportView(txtDescription);

        lblDay.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblDay.setText("Day");

        btnUpdateTask.setBackground(new java.awt.Color(255, 255, 255));
        btnUpdateTask.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnUpdateTask.setText("Update");
        btnUpdateTask.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 204, 204), 3, true));
        btnUpdateTask.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateTaskActionPerformed(evt);
            }
        });

        btnCreateTask.setBackground(new java.awt.Color(255, 255, 255));
        btnCreateTask.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnCreateTask.setText("Create");
        btnCreateTask.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 204, 204), 3, true));
        btnCreateTask.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateTaskActionPerformed(evt);
            }
        });

        btnClear.setBackground(new java.awt.Color(255, 255, 255));
        btnClear.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnClear.setText("Clear");
        btnClear.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 204, 204), 3, true));
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        cboTaskNumber.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Task 1", "Task 2", "Task 3", "Task 4", "Task 5", "Task 6" }));
        cboTaskNumber.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 204, 204), 3, true));

        lblTaskNo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTaskNo.setText("Task No.");

        cboDays.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday" }));
        cboDays.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 204, 204), 3, true));

        javax.swing.GroupLayout jpWindowPaneLayout = new javax.swing.GroupLayout(jpWindowPane);
        jpWindowPane.setLayout(jpWindowPaneLayout);
        jpWindowPaneLayout.setHorizontalGroup(
            jpWindowPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpWindowPaneLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jpWindowPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jpWindowPaneLayout.createSequentialGroup()
                        .addGroup(jpWindowPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnCreateTask, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cboDays, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25)
                        .addComponent(btnUpdateTask, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                        .addGroup(jpWindowPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jpWindowPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblTaskNo)
                                .addComponent(cboTaskNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(spDescriptionPane, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jpWindowPaneLayout.createSequentialGroup()
                        .addGroup(jpWindowPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblDay, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblDescription, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(35, 35, 35))
            .addGroup(jpWindowPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblDialogHeading, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jpWindowPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblDialogFooter, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jpWindowPaneLayout.setVerticalGroup(
            jpWindowPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpWindowPaneLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(lblDialogHeading, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(lblDescription)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(spDescriptionPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addGroup(jpWindowPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDay)
                    .addComponent(lblTaskNo))
                .addGap(25, 25, 25)
                .addGroup(jpWindowPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cboTaskNumber, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboDays, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(66, 66, 66)
                .addGroup(jpWindowPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpWindowPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnUpdateTask, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnCreateTask, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addComponent(lblDialogFooter, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );

        javax.swing.GroupLayout jpDialogPanelLayout = new javax.swing.GroupLayout(jpDialogPanel);
        jpDialogPanel.setLayout(jpDialogPanelLayout);
        jpDialogPanelLayout.setHorizontalGroup(
            jpDialogPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpDialogPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpWindowPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jpDialogPanelLayout.setVerticalGroup(
            jpDialogPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpDialogPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jpWindowPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpDialogPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpDialogPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnUpdateTaskActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateTaskActionPerformed
        if(btnUpdateTask.getText().equals("Update")) {
            clsUpdateTasks update = new clsUpdateTasks();
            btnUpdateTask.setText("Save");
        } else if(btnUpdateTask.getText().equals("Save")) {
            if(!txtDescription.getText().equals("")){
                if(new ToDo_List().mUpdateTaskDetails("UPDATE tblTasks SET Description ='"+txtDescription.getText()+"' WHERE TaskID ='"
                    +intTaskId+"'")) {
                    JOptionPane.showMessageDialog(this, "The task has been updated.");
                    txtDescription.setText("");
                }
            }else {
                JOptionPane.showMessageDialog(this, "It is mandatory that a task must have a description");
                txtDescription.requestFocusInWindow();
            }
            btnUpdateTask.setText("Update");
        }
    }//GEN-LAST:event_btnUpdateTaskActionPerformed

    private void btnCreateTaskActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateTaskActionPerformed
        if(!txtDescription.getText().equals("")) {
            if(new ToDo_List().mCreateTask("INSERT INTO tblTasks(Description, TaskDay, TaskDate, TaskStatus)"
                    + "VALUES('"+txtDescription.getText().trim()+"','"+mGetTaskDescription()+"','"+
                    new SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date())+"',0)")) {
                JOptionPane.showMessageDialog(this, "The task has been created.");
                txtDescription.setText("");
            }
        } else {
            JOptionPane.showMessageDialog(this, "It is mandatory that a task must have a description");
            txtDescription.requestFocusInWindow();
        }
    }//GEN-LAST:event_btnCreateTaskActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        txtDescription.setText("");
    }//GEN-LAST:event_btnClearActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(dialogTask.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(dialogTask.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(dialogTask.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(dialogTask.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                dialogTask dialog = new dialogTask();
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnCreateTask;
    private javax.swing.JButton btnUpdateTask;
    private javax.swing.JComboBox<String> cboDays;
    private javax.swing.JComboBox<String> cboTaskNumber;
    private javax.swing.JPanel jpDialogPanel;
    private javax.swing.JPanel jpWindowPane;
    private javax.swing.JLabel lblDay;
    private javax.swing.JLabel lblDescription;
    private javax.swing.JLabel lblDialogFooter;
    private javax.swing.JLabel lblDialogHeading;
    private javax.swing.JLabel lblTaskNo;
    private javax.swing.JScrollPane spDescriptionPane;
    private javax.swing.JTextArea txtDescription;
    // End of variables declaration//GEN-END:variables
}
