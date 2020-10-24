/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package to.do_list.assignmentManagaer;

import java.awt.*;
import java.io.File;
import javax.swing.*;
import org.icepdf.ri.common.*;
/**
 *
 * @author Sanele
 */
public class clsPdfViewer extends JFrame {
    public clsPdfViewer(File fl) {
        this.setSize(800, 700);
        this.setTitle(fl.getName());
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        mOpenPDF(fl);
        this.setVisible(true);
    }
    
    private void mOpenPDF(File file) {
        try {
            SwingController control = new SwingController();
            SwingViewBuilder factry = new SwingViewBuilder(control);
            JPanel viewerCompntpnl = factry.buildViewerPanel();
            ComponentKeyBinding.install(control, viewerCompntpnl);
            control.getDocumentViewController().setAnnotationCallback(
            new org.icepdf.ri.common.MyAnnotationCallback(control.getDocumentViewController()));
            JPanel jpPanel = new JPanel(new BorderLayout(10, 20));
            JScrollPane jsPane = new JScrollPane();
            jsPane.setVisible(true);
            jsPane.setViewportView(viewerCompntpnl);
            control.openDocument(file.toString());
            jpPanel.add(jsPane);
            this.add(jpPanel);
        } catch(Exception eX) {
            JOptionPane.showMessageDialog(null, "An error occured while trying to open the file");
        }
    }
}
