/*
 * PicPanel.java
 *
 * Created on February 8, 2007, 10:02 PM
 */

package gui;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.imageio.*;
import javax.swing.*;

/**
 *
 * @author  Data Virtue
 */
public class PicPanel extends javax.swing.JPanel {
    
    /** Creates new form PicPanel */
    public PicPanel() {
        initComponents();
        
    }
    
    /* override */
    public void paintComponent (Graphics g){
        
        super.paintComponent(g);
        
        if (image == null) return;
        
                
        PANEL_WIDTH = this.getWidth();
        PANEL_HEIGHT = this.getHeight();
        
        
        
        if (fit){
            
            //this.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));           
            g.drawImage(image, 0, 0, PANEL_WIDTH, PANEL_HEIGHT, this);
            
            
        }else {
            
            
            this.setPreferredSize(new Dimension(IMAGE_WIDTH, IMAGE_HEIGHT));
            g.drawImage(image, 0, 0, this);
                        
        }
        
        
    }
    
    public boolean isFit () {
        
        return fit;
         
    }
    
    public Dimension getImageSize () {
        
        return new Dimension (IMAGE_WIDTH, IMAGE_HEIGHT);
        
    }
    
    public void setFit (boolean val) {
        
        fit = val;
        
    }

       
    public void setPrefSize (int x, int y){
        
        this.setSize(x, y);
        
    }
    
    public boolean setImage (String file, boolean fit){
        
        this.fit = fit;
        
        image = Toolkit.getDefaultToolkit().getImage(file);
        
        IMAGE_HEIGHT = image.getHeight(null);
        IMAGE_WIDTH = image.getWidth(null);
        
        MediaTracker tracker = new MediaTracker(this);
        
        tracker.addImage(image, 0);
        
        
        try {
                        
            tracker.waitForID(0);
            
        } catch (InterruptedException ex) {
            return false;
            //ex.printStackTrace();
        }
        
        try {
                        
            image = ImageIO.read(new File (file));
            
        } catch (IOException ex) {
            return false;
            //ex.printStackTrace();
        }
        
        return true;
        
    }
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {

        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                formComponentResized(evt);
            }
        });

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentResized
        
       // if (!fit) this.setPreferredSize(this.getImageSize());
        
        
    }//GEN-LAST:event_formComponentResized
    
    protected boolean fit = false;
    
    protected int IMAGE_WIDTH;
    protected int IMAGE_HEIGHT;
    
    protected int PANEL_WIDTH;
    protected int PANEL_HEIGHT;
    
    protected java.awt.Image image;
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
    
}