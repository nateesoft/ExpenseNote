package sun.natee.app.main;

import com.sun.glass.events.KeyEvent;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;
import org.apache.log4j.Logger;
import sun.natee.app.AppConstants;
import sun.natee.app.bean.Expense;
import sun.natee.app.bean.PopupDesc;
import sun.natee.app.dao.impl.ExpenseDaoImpl;
import sun.natee.app.dao.impl.PopupDescDaoImpl;
import sun.natee.app.main.util.CalendarPopup;
import sun.natee.app.main.util.MsgUtil;
import sun.natee.app.main.util.StringUtil;

public class AddItemDialog extends javax.swing.JDialog {

    private static final Logger logger = Logger.getLogger(AddItemDialog.class);
    private final ExpenseDaoImpl expImpl = new ExpenseDaoImpl();
    private final PopupDescDaoImpl popImpl = new PopupDescDaoImpl();
    private final Expense expense;    

    public AddItemDialog(java.awt.Frame parent, boolean modal, Expense expense) {
        super(parent, modal);
        initComponents();

        this.expense = expense;
        if (expense != null) {
            loadExpense();
            btnDelete.setEnabled(true);
        } else {
            txtId.setText(AppConstants.FIX_ID_WORD);
            txtDate.setText(StringUtil.getCurrentDate());
            txtTime.setText(StringUtil.getCurrentTime());
        }
        txtAreaDesc.requestFocus();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txtOutcomeAmount = new javax.swing.JTextField();
        txtTime = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtDate = new javax.swing.JTextField();
        txtTotalAmount = new javax.swing.JTextField();
        txtId = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtPlace = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtIncomeAmount = new javax.swing.JTextField();
        txtUsername = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAreaDesc = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnDate = new javax.swing.JButton();
        btnFindDesc = new javax.swing.JButton();
        btnFindPlace = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("เพิ่มค่าใช้จ่าย");
        setResizable(false);

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/save.png"))); // NOI18N
        jButton1.setText("บันทึกข้อมูล");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnDelete.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/close_icon.png"))); // NOI18N
        btnDelete.setText("ลบข้อมูล");
        btnDelete.setEnabled(false);
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(5, 2, 1, 2, new java.awt.Color(153, 153, 153)));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("รายรับ");

        txtOutcomeAmount.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtOutcomeAmount.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtOutcomeAmount.setText("0.00");
        txtOutcomeAmount.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtOutcomeAmountFocusGained(evt);
            }
        });
        txtOutcomeAmount.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtOutcomeAmountKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtOutcomeAmountKeyReleased(evt);
            }
        });

        txtTime.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtTime.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtTime.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtTimeFocusGained(evt);
            }
        });
        txtTime.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtTimeKeyPressed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("รวมรับจ่าย");

        txtDate.setEditable(false);
        txtDate.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtDate.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txtTotalAmount.setEditable(false);
        txtTotalAmount.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        txtTotalAmount.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtTotalAmount.setText("0.00");

        txtId.setEditable(false);
        txtId.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtId.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("เวลาข้อมูล");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("ผู้บันทึก");

        txtPlace.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtPlace.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtPlaceFocusGained(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("วันที่รายการ");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("รหัสข้อมูล");

        txtIncomeAmount.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtIncomeAmount.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtIncomeAmount.setText("0.00");
        txtIncomeAmount.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtIncomeAmountFocusGained(evt);
            }
        });
        txtIncomeAmount.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtIncomeAmountKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtIncomeAmountKeyReleased(evt);
            }
        });

        txtUsername.setEditable(false);
        txtUsername.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtUsername.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtUsername.setText("admin");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("สถานที่");

        txtAreaDesc.setColumns(20);
        txtAreaDesc.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtAreaDesc.setRows(5);
        txtAreaDesc.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtAreaDescFocusGained(evt);
            }
        });
        jScrollPane1.setViewportView(txtAreaDesc);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("รายจ่าย");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("รายละเอียด");

        btnDate.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnDate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/calendar.png"))); // NOI18N
        btnDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDateActionPerformed(evt);
            }
        });

        btnFindDesc.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnFindDesc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/search.png"))); // NOI18N
        btnFindDesc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFindDescActionPerformed(evt);
            }
        });

        btnFindPlace.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnFindPlace.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/search.png"))); // NOI18N
        btnFindPlace.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFindPlaceActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtIncomeAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtOutcomeAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel7)
                                .addGap(17, 17, 17)
                                .addComponent(txtTotalAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 434, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(btnFindDesc, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(btnDate, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jLabel3)
                                            .addGap(18, 18, 18)
                                            .addComponent(txtTime, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(269, 269, 269))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(498, 498, 498))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addGap(29, 29, 29)
                .addComponent(txtPlace, javax.swing.GroupLayout.PREFERRED_SIZE, 435, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnFindPlace, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addGap(268, 268, 268))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDate, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(jLabel2)))
                        .addGap(6, 6, 6)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtTime, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnFindDesc, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jLabel3)))
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtIncomeAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel7))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(jLabel5)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(jLabel6))
                            .addComponent(txtOutcomeAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(txtTotalAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jLabel8)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtPlace, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel9))
                    .addComponent(btnFindPlace, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDelete)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 573, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        if (MsgUtil.confirmMsg("ท่านต้องการลบข้อมูลนี้ใช่หรือไม่ ")) {
            deleteData();
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        saveData();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtIncomeAmountKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIncomeAmountKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtOutcomeAmount.requestFocus();
        }
    }//GEN-LAST:event_txtIncomeAmountKeyPressed

    private void txtIncomeAmountFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtIncomeAmountFocusGained
        txtIncomeAmount.selectAll();
    }//GEN-LAST:event_txtIncomeAmountFocusGained

    private void txtOutcomeAmountFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtOutcomeAmountFocusGained
        txtOutcomeAmount.selectAll();
    }//GEN-LAST:event_txtOutcomeAmountFocusGained

    private void txtOutcomeAmountKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtOutcomeAmountKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtPlace.requestFocus();
        }
    }//GEN-LAST:event_txtOutcomeAmountKeyPressed

    private void txtPlaceFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPlaceFocusGained
        txtPlace.selectAll();
    }//GEN-LAST:event_txtPlaceFocusGained

    private void txtAreaDescFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtAreaDescFocusGained
        txtAreaDesc.selectAll();
    }//GEN-LAST:event_txtAreaDescFocusGained

    private void txtIncomeAmountKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIncomeAmountKeyReleased
        compute();
    }//GEN-LAST:event_txtIncomeAmountKeyReleased

    private void txtOutcomeAmountKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtOutcomeAmountKeyReleased
        compute();
    }//GEN-LAST:event_txtOutcomeAmountKeyReleased

    private void txtTimeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimeKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtAreaDesc.requestFocus();
        }
    }//GEN-LAST:event_txtTimeKeyPressed

    private void txtTimeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTimeFocusGained
        txtTime.selectAll();
    }//GEN-LAST:event_txtTimeFocusGained

    private void btnDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDateActionPerformed
        CalendarPopup cal = new CalendarPopup(null, true);
        cal.setVisible(true);

        if (StringUtil.isNotEmpty(cal.getDateString())) {
            txtDate.setText(cal.getDateString());
        }
    }//GEN-LAST:event_btnDateActionPerformed

    private void btnFindDescActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFindDescActionPerformed
        findDesc();
    }//GEN-LAST:event_btnFindDescActionPerformed

    private void btnFindPlaceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFindPlaceActionPerformed
        findPlace();
    }//GEN-LAST:event_btnFindPlaceActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDate;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnFindDesc;
    private javax.swing.JButton btnFindPlace;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txtAreaDesc;
    private javax.swing.JTextField txtDate;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtIncomeAmount;
    private javax.swing.JTextField txtOutcomeAmount;
    private javax.swing.JTextField txtPlace;
    private javax.swing.JTextField txtTime;
    private javax.swing.JTextField txtTotalAmount;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables

    private void saveData() {
        if(StringUtil.isEmpty(txtAreaDesc.getText())){
            txtAreaDesc.requestFocus();
            return;
        }
        if(StringUtil.isEmpty(txtTime.getText())){
            txtTime.requestFocus();
            return;
        }
        if(StringUtil.isEmpty(txtPlace.getText())){
            txtPlace.requestFocus();
            return;
        }
        Expense bean = new Expense();
        if (!AppConstants.FIX_ID_WORD.equals(txtId.getText())) {
            bean.setId(StringUtil.strToInt(txtId.getText()));
        }
        bean.setDate(StringUtil.strToDate(txtDate.getText()));
        bean.setTime(txtTime.getText());
        bean.setDesc(txtAreaDesc.getText());
        bean.setIncomeAmt(StringUtil.strToBig(txtIncomeAmount.getText()));
        bean.setOutcomeAmt(StringUtil.strToBig(txtOutcomeAmount.getText()));
        bean.setTotalAmt(StringUtil.strToBig(txtTotalAmount.getText()));
        bean.setUser(txtUsername.getText());
        bean.setPlace(txtPlace.getText());

        try {
            expImpl.save(bean);
            dispose();
        } catch (SQLException e) {
            MsgUtil.showMsg(e.getMessage(), null);
        }
    }

    private void compute() {
        if (StringUtil.isNotEmpty(txtIncomeAmount.getText()) || StringUtil.isNotEmpty(txtOutcomeAmount.getText())) {
            BigDecimal inAmt = StringUtil.strToBig(txtIncomeAmount.getText());
            BigDecimal outAmt = StringUtil.strToBig(txtOutcomeAmount.getText());
            BigDecimal totalAmt = inAmt.subtract(outAmt);
            txtTotalAmount.setText(totalAmt.toString());
        }
    }

    private void loadExpense() {
        txtId.setText("" + expense.getId());
        txtDate.setText(StringUtil.dateStr(expense.getDate()));
        txtTime.setText(expense.getTime());
        txtAreaDesc.setText(expense.getDesc());
        txtIncomeAmount.setText(expense.getIncomeAmt().toString());
        txtOutcomeAmount.setText(expense.getOutcomeAmt().toString());
        txtTotalAmount.setText(expense.getTotalAmt().toString());
        txtUsername.setText(expense.getUser());
        txtPlace.setText(expense.getPlace());
    }

    private void deleteData() {
        if (!AppConstants.FIX_ID_WORD.equals(txtId.getText())) {
            try {
                expImpl.delete(StringUtil.strToInt(txtId.getText()));
                dispose();
            } catch (SQLException e) {
            }
        }
    }

    private void findDesc() {
        try {
            List<PopupDesc> listPopup = popImpl.findAll("DESC");
            PopupListDialog popup = new PopupListDialog(null, true, listPopup);
            popup.setVisible(true);

            if (popup.getDesc() != null) {
                txtAreaDesc.setText(popup.getDesc());
            }
        } catch (SQLException ex) {
            MsgUtil.showMsg(ex.getMessage(), null);            
        }
    }

    private void findPlace() {
        try {
            List<PopupDesc> listPopup = popImpl.findAll("PLACE");
            PopupListDialog popup = new PopupListDialog(null, true, listPopup);
            popup.setVisible(true);

            if (popup.getDesc() != null) {
                txtPlace.setText(popup.getDesc());
            }
        } catch (SQLException ex) {
            MsgUtil.showMsg(ex.getMessage(), null);
        }
    }
}
