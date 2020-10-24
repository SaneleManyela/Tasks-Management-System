/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package to.do_list;

import java.sql.*;
import java.util.Calendar;
import javax.swing.JOptionPane;

/**
 *
 * @author Sanele
 */
public class ToDo_List {
    
    private dialogActivities activities;
    
    public ToDo_List(dialogActivities dialog) {
        this.activities = dialog;
    }
    
    public ToDo_List() {
        
    }
    
    public Connection mConnectToDatabase() {
        String strDBConnectionString = "jdbc:mysql://localhost:3306/TODO_Database";
        String strUser = "root";
        String strPassword = "password";
        Connection conMySQLConnectionString = null;
        try {
            return conMySQLConnectionString = DriverManager.getConnection(strDBConnectionString, 
                    strUser, strPassword);
        } catch(SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage() ,
                    "Error Message", JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }
    
    public boolean mCreateTask(String strQuery) {
        Statement stStatement = null;
        try{
            stStatement = mConnectToDatabase().prepareStatement(strQuery);
            stStatement.execute(strQuery);
            stStatement.close();
            return true;
        } catch(SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(),
                    "Error while creating new bug details", JOptionPane.ERROR_MESSAGE);
        } finally {
            try{
                stStatement.close();
            } catch(SQLException | NullPointerException ex){
            }
        }
        return false;
    }
    
    public int mGetNumericField(String strQuery) {
        Statement stStatement = null;
        ResultSet rs = null;
        try{
            stStatement = mConnectToDatabase().prepareStatement(strQuery);
            rs = stStatement.executeQuery(strQuery);
            while(rs.next()){
                return rs.getInt(1);
            }
            stStatement.close();
            rs.close();
        } catch(SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(),
                    "Error while getting numeric field", JOptionPane.ERROR_MESSAGE);
        }   finally {
             try{
                    stStatement.close();
                    rs.close();
                } catch(SQLException | NullPointerException ex) {
                }
            }
        return 0;
    }
    
    public String mGetTextField(String strQuery) {
        Statement stStatement = null;
        ResultSet rs = null;
        try {
            stStatement = mConnectToDatabase().prepareStatement(strQuery);
            rs = stStatement.executeQuery(strQuery);
            while(rs.next()){
                return rs.getString(1);
            }
            stStatement.close();
            rs.close();
        } catch(SQLException | NullPointerException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(),
                    "Error while gettting text field", JOptionPane.ERROR_MESSAGE);
        } finally {
            try{
                stStatement.close();
                rs.close();
            } catch(SQLException | NullPointerException ex) {
            }
        }
        return "";
    }
    
    public void mSetToGUI() {
        Calendar c = Calendar.getInstance();//Get a calendar instance
        int intWeekOfYear = c.get(Calendar.WEEK_OF_YEAR);
        activities.mSetValuesToGUI(mGetTextField("SELECT Description FROM tblTasks WHERE TaskDay ='"+activities.mGetDay()+" Task 1 of Week "+intWeekOfYear+"'"), 
                mGetTextField("SELECT Description FROM tblTasks WHERE TaskDay ='"+activities.mGetDay()+" Task 2 of Week "+intWeekOfYear+"'"), 
                mGetTextField("SELECT Description FROM tblTasks WHERE TaskDay ='"+activities.mGetDay()+" Task 3 of Week "+intWeekOfYear+"'"),
                mGetTextField("SELECT Description FROM tblTasks WHERE TaskDay ='"+activities.mGetDay()+" Task 4 of Week "+intWeekOfYear+"'"),
                mGetTextField("SELECT Description FROM tblTasks WHERE TaskDay ='"+activities.mGetDay()+" Task 5 of Week "+intWeekOfYear+"'"), 
                mGetTextField("SELECT Description FROM tblTasks WHERE TaskDay ='"+activities.mGetDay()+" Task 6 of Week "+intWeekOfYear+"'"));
    }
    
    public boolean mUpdateTaskDetails(String strQuery) {
        Statement stStatement = null;
         try {
             stStatement = mConnectToDatabase().prepareStatement(strQuery);
             stStatement.executeUpdate(strQuery);
             stStatement.close();
             return true;
         } catch(SQLException ex) {
             JOptionPane.showMessageDialog(null, ex.getMessage(), 
                     "Error while updating bug details", JOptionPane.ERROR_MESSAGE);
         } finally {
             try{
                 stStatement.close();
             }catch(SQLException | NullPointerException ex){
             }
         }
        return false;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        frmToDoList todo_list = new frmToDoList();
        todo_list.setResizable(false);
        todo_list.setVisible(true);
    }
    
}
