/**
 * Launcher.java
 * Copyright (C) 2011  Kevin Wang and Shan Shi
 * 
 * This file is part of Minecarft.
 * 
 * Minecarft is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * Minecarft is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with Minecarft.  If not, see <http://www.gnu.org/licenses/>.
 */

package minecarft;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

/**
 *
 * @author kevin
 */
public class Launcher extends javax.swing.JFrame {
    private static Launcher instance;
    
    public static Launcher getInstance() {
        if (instance == null) {
            instance = new Launcher();
        }
        return instance;
    }

    /** Creates new form Launcher */
    private Launcher() {
        initComponents();
        
        DisplayMode[] modes;
        try {
            modes = Display.getAvailableDisplayModes();
        } catch (LWJGLException e) {
            modes = new DisplayMode[0];
        }
        for (int i = 0; i < modes.length; i++) {
            displaySizeComboBox.addItem(modes[i]);
        }
    }
    
    public void incrementProgressBar() {
        progressBar.setValue(progressBar.getValue() + 1);
    }
    
    public void setProgressLabel(String str) {
        progressLabel.setText(str);
    }
    
    public void close() {
        dispose();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        displaySizeLabel = new javax.swing.JLabel();
        displaySizeComboBox = new javax.swing.JComboBox();
        fullscreenModeCheckBox = new javax.swing.JCheckBox();
        startMinecarftButton = new javax.swing.JButton();
        progressLabel = new javax.swing.JLabel();
        progressBar = new javax.swing.JProgressBar();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Minecarft Launcher");
        setResizable(false);

        displaySizeLabel.setText("Display size");

        fullscreenModeCheckBox.setText("Fullscreen mode");

        startMinecarftButton.setText("Start Minecarft");
        startMinecarftButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                startMinecarftButtonMouseReleased(evt);
            }
        });

        progressLabel.setText("Loading...");

        progressBar.setMaximum(25);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(displaySizeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(displaySizeLabel)
                    .addComponent(fullscreenModeCheckBox)
                    .addComponent(startMinecarftButton)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 376, Short.MAX_VALUE)
                    .addComponent(progressLabel)
                    .addComponent(progressBar, javax.swing.GroupLayout.DEFAULT_SIZE, 376, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(displaySizeLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(displaySizeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(fullscreenModeCheckBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(startMinecarftButton)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(progressLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(progressBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void startMinecarftButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_startMinecarftButtonMouseReleased
        if (startMinecarftButton.isEnabled()) {
            startMinecarftButton.setEnabled(false);
            Thread thread = new Thread(new Runnable() {

                public void run() {
                    Minecarft m = new Minecarft((DisplayMode) displaySizeComboBox.getSelectedItem(), fullscreenModeCheckBox.isSelected());
                    m.start();
                }
            });
            thread.start();
        }
    }//GEN-LAST:event_startMinecarftButtonMouseReleased

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox displaySizeComboBox;
    private javax.swing.JLabel displaySizeLabel;
    private javax.swing.JCheckBox fullscreenModeCheckBox;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JProgressBar progressBar;
    private javax.swing.JLabel progressLabel;
    private javax.swing.JButton startMinecarftButton;
    // End of variables declaration//GEN-END:variables
}