/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.company.panel;

import dao.inter.CountryDaoInter;
import entity.Country;
import entity.User;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import main.Config;
import main.Context;

/**
 *
 * @author Yasin
 */
public class DetailsPanel extends javax.swing.JPanel {

    /**
     * Creates new form DetailsPanel2
     */
      private CountryDaoInter countryDao= Context.instanceCountryDao();
    public DetailsPanel() {
        initComponents();
        fillWindow();
        fillUserComponents();
    }
     private void fillWindow(){
     List<Country> countries=countryDao.getAllCountry();
        for(Country c:countries){
           cbCountry.addItem(c);
           cbnationality.addItem(c);
        }
     }
     
      private SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd");
      
      
         private void fillUserComponents(){
        User loggedInUser=Config.loggedInUser;
        txtAdress.setText(loggedInUser.getAdress());
        txtPhone.setText(loggedInUser.getPhone());
        txtEmail.setText(loggedInUser.getEmail());
        Date dt=loggedInUser.getBirtDate();
        String sdfStr=sdf.format(dt);
        txtbirthDate.setText(sdfStr);
        cbCountry.setSelectedItem(loggedInUser.getBirthPlace());
        cbnationality.setSelectedItem(loggedInUser.getNationality());
    }
         public void fillUser(User user){
             
           
        try {
            String email=txtEmail.getText();
            String adress=txtAdress.getText();
            String phone =txtPhone.getText();
            String birthDate=txtbirthDate.getText();
            Country country=(Country) cbCountry.getSelectedItem();
            Country nationality=(Country) cbnationality.getSelectedItem();
            
            
            Date db=new Date(sdf.parse(birthDate).getTime());
            
            user.setPhone(phone);
            user.setAdress(adress);
            user.setEmail(email);
            user.setBirtDate((java.sql.Date) db);
            user.setBirthPlace(country);
            user.setNationality(nationality);
        } catch (ParseException ex) {
           ex.printStackTrace();
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

        panelDetails = new javax.swing.JPanel();
        lblAdress = new javax.swing.JLabel();
        txtAdress = new javax.swing.JTextField();
        lblPhone = new javax.swing.JLabel();
        txtPhone = new javax.swing.JTextField();
        lblEmail = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        lblbirthDate = new javax.swing.JLabel();
        txtbirthDate = new javax.swing.JTextField();
        lblbirthPlace = new javax.swing.JLabel();
        cbCountry = new javax.swing.JComboBox<>();
        lblnationality = new javax.swing.JLabel();
        cbnationality = new javax.swing.JComboBox<>();

        lblAdress.setText("Adress");

        lblPhone.setText("Phone");

        lblEmail.setText("Email");

        txtEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmailActionPerformed(evt);
            }
        });

        lblbirthDate.setText("BirthDate");

        txtbirthDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtbirthDateActionPerformed(evt);
            }
        });

        lblbirthPlace.setText("BirthPlace");

        cbCountry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbCountryActionPerformed(evt);
            }
        });

        lblnationality.setText("Nationality");

        javax.swing.GroupLayout panelDetailsLayout = new javax.swing.GroupLayout(panelDetails);
        panelDetails.setLayout(panelDetailsLayout);
        panelDetailsLayout.setHorizontalGroup(
            panelDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDetailsLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(panelDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblPhone, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblAdress, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblbirthDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblbirthPlace, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblnationality, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtPhone, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
                    .addComponent(txtAdress)
                    .addComponent(txtEmail)
                    .addComponent(txtbirthDate)
                    .addComponent(cbCountry, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbnationality, 0, 133, Short.MAX_VALUE))
                .addContainerGap(613, Short.MAX_VALUE))
        );
        panelDetailsLayout.setVerticalGroup(
            panelDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDetailsLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(panelDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAdress)
                    .addComponent(txtAdress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblPhone, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtPhone))
                .addGap(18, 18, 18)
                .addGroup(panelDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEmail)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblbirthDate)
                    .addComponent(txtbirthDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblbirthPlace)
                    .addComponent(cbCountry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblnationality)
                    .addComponent(cbnationality, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelDetails, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelDetails, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 27, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmailActionPerformed

    private void txtbirthDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtbirthDateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtbirthDateActionPerformed

    private void cbCountryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbCountryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbCountryActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<Country> cbCountry;
    private javax.swing.JComboBox<Country> cbnationality;
    private javax.swing.JLabel lblAdress;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblPhone;
    private javax.swing.JLabel lblbirthDate;
    private javax.swing.JLabel lblbirthPlace;
    private javax.swing.JLabel lblnationality;
    private javax.swing.JPanel panelDetails;
    private javax.swing.JTextField txtAdress;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtPhone;
    private javax.swing.JTextField txtbirthDate;
    // End of variables declaration//GEN-END:variables
}