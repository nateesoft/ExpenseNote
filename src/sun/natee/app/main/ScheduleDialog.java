package sun.natee.app.main;

import java.sql.SQLException;
import java.util.List;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import sun.natee.app.AppConstants;
import sun.natee.app.bean.Schedule;
import sun.natee.app.dao.impl.ScheduleDaoImpl;
import sun.natee.app.main.util.MsgUtil;
import sun.natee.app.main.util.StringUtil;
import sun.natee.app.main.util.SwingUtil;
import sun.natee.app.main.util.UXUtil;

public class ScheduleDialog extends javax.swing.JDialog {

    private DefaultTableModel model;
    private ScheduleDaoImpl schImpl = new ScheduleDaoImpl();
    private boolean isSave = true;

    public ScheduleDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        initTable();
        loadData();

        txtId.setText(AppConstants.FIX_ID_WORD);
        txtItemDesc.requestFocus();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        txtItemDesc = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        rdBeforeHoliday = new javax.swing.JRadioButton();
        txtDate1 = new javax.swing.JTextField();
        rdSkipHoliday = new javax.swing.JRadioButton();
        rdMonthly = new javax.swing.JRadioButton();
        cbEndMonth = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        txtDate2 = new javax.swing.JTextField();
        rdYearly = new javax.swing.JRadioButton();
        cbMonthAt = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        chkBeforeLine = new javax.swing.JCheckBox();
        btnSave = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        chkSuccess = new javax.swing.JCheckBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableData = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("บันทึกข้อมูลรายจ่ายประจำ");
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("บันทึกข้อมูลรายจ่ายประจำ");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("รหัส :");

        txtId.setEditable(false);
        txtId.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtId.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txtItemDesc.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("รายการ :");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("ประเภท :");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        rdBeforeHoliday.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup2.add(rdBeforeHoliday);
        rdBeforeHoliday.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rdBeforeHoliday.setText("ก่อนเสาร์-อาทิตย์");

        txtDate1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        rdSkipHoliday.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup2.add(rdSkipHoliday);
        rdSkipHoliday.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rdSkipHoliday.setSelected(true);
        rdSkipHoliday.setText("ข้ามเสาร์-อาทิตย์");

        rdMonthly.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(rdMonthly);
        rdMonthly.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rdMonthly.setSelected(true);
        rdMonthly.setText("ประจำเดือน");

        cbEndMonth.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cbEndMonth.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ทุกสิ้นเดือน", "ต้นเดือน" }));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("หรือ");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("ทุกวันที่");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtDate1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbEndMonth, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rdSkipHoliday)
                            .addComponent(rdBeforeHoliday)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(rdMonthly)))
                .addGap(6, 6, 6))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rdMonthly)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDate1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cbEndMonth, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rdSkipHoliday))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rdBeforeHoliday)
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txtDate2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        rdYearly.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(rdYearly);
        rdYearly.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rdYearly.setText("ประจำปี");

        cbMonthAt.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cbMonthAt.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("หรือวันที่");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("ทุกเดือนที่");

        chkBeforeLine.setBackground(new java.awt.Color(255, 255, 255));
        chkBeforeLine.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        chkBeforeLine.setText("ก่อนวันที่กำหนดได้");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(rdYearly))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbMonthAt, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(chkBeforeLine)
                                    .addComponent(txtDate2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rdYearly)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(cbMonthAt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtDate2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 3, Short.MAX_VALUE)
                .addComponent(chkBeforeLine))
        );

        btnSave.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/save.png"))); // NOI18N
        btnSave.setText("บันทึก");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnDelete.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/remove.png"))); // NOI18N
        btnDelete.setText("ลบข้อมูล");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        chkSuccess.setBackground(new java.awt.Color(255, 255, 255));
        chkSuccess.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        chkSuccess.setText("ทำรายการไปแล้ว");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtItemDesc)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(chkSuccess))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnDelete)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSave)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chkSuccess))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtItemDesc, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tableData.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "รหัส", "รายการ", "ประเภท", "เดือน วันที่", "ปี วันที่", "สิ้นเดือน", "ข้าม/ก่อน เสาร์-อาทิตย์", "ทุกเดือนที่", "ก่อนวันที่กำหนด"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableData.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tableData.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableDataMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableData);
        if (tableData.getColumnModel().getColumnCount() > 0) {
            tableData.getColumnModel().getColumn(1).setPreferredWidth(300);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 443, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tableDataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableDataMouseClicked
        if (evt.getClickCount() == 2) {
            loadEdit();
        }
    }//GEN-LAST:event_tableDataMouseClicked

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        deleteData();
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        saveData();
    }//GEN-LAST:event_btnSaveActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnSave;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JComboBox<String> cbEndMonth;
    private javax.swing.JComboBox<String> cbMonthAt;
    private javax.swing.JCheckBox chkBeforeLine;
    private javax.swing.JCheckBox chkSuccess;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rdBeforeHoliday;
    private javax.swing.JRadioButton rdMonthly;
    private javax.swing.JRadioButton rdSkipHoliday;
    private javax.swing.JRadioButton rdYearly;
    private javax.swing.JTable tableData;
    private javax.swing.JTextField txtDate1;
    private javax.swing.JTextField txtDate2;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtItemDesc;
    // End of variables declaration//GEN-END:variables

    private void initTable() {
        model = (DefaultTableModel) tableData.getModel();
        UXUtil.initTable(tableData);

        for (int i = 0; i < tableData.getColumnCount(); i++) {
            UXUtil.alignTable(tableData, i, SwingConstants.CENTER);
        }

        UXUtil.alignTable(tableData, 1, SwingConstants.LEFT);
    }

    private void loadData() {
        SwingUtil.clearModel(model);
        try {
            List<Schedule> listSch = schImpl.findAll();
            for (Schedule bean : listSch) {
                model.addRow(new Object[]{
                    bean.getId(),
                    bean.getItem_desc(),
                    bean.getItem_type(),
                    bean.getMonth_date(),
                    bean.getYear_date(),
                    bean.getEnd_month(),
                    bean.getHolidy_skip(),
                    bean.getMonth_at(),
                    bean.getBefore_deadline(),
                    bean.getChkSuccess()
                });
            }
        } catch (SQLException e) {
            MsgUtil.showMsg(e.getMessage(), null);
        }

    }

    private void loadEdit() {
        int iSel = tableData.getSelectedRow();
        if (iSel != -1) {
            Integer id = StringUtil.strToInt(tableData.getValueAt(iSel, 0).toString());
            try {
                Schedule bean = schImpl.findById(id);
                if (bean != null) {
                    txtId.setText("" + bean.getId());
                    txtItemDesc.setText(bean.getItem_desc());
                    if (bean.getItem_type().equals("MONTHLY")) {
                        rdMonthly.setSelected(true);
                    } else {
                        rdYearly.setSelected(true);
                    }
                    txtDate1.setText(bean.getMonth_date());
                    txtDate2.setText(bean.getYear_date());
                    cbEndMonth.setSelectedItem(bean.getEnd_month());
                    if (bean.getHolidy_skip().equals("SKIP")) {
                        rdSkipHoliday.setSelected(true);
                    } else {
                        rdBeforeHoliday.setSelected(true);
                    }
                    cbMonthAt.setSelectedItem("" + bean.getMonth_at());
                    chkBeforeLine.setSelected(bean.getBefore_deadline().equals("Y"));
                    chkSuccess.setSelected(bean.getChkSuccess().equals("Y"));

                    isSave = false;
                }
            } catch (SQLException e) {
                MsgUtil.showMsg(e.getMessage(), null);
            }

        }
    }

    private void deleteData() {
        int iSel = tableData.getSelectedRow();
        if (iSel != -1) {
            Integer id = StringUtil.strToInt(tableData.getValueAt(iSel, 0).toString());
            try {
                schImpl.delete(id);
                clearForm();
                loadData();
            } catch (SQLException e) {
                MsgUtil.showMsg(e.getMessage(), null);
            }
        }
    }

    private void saveData() {
        if (StringUtil.isEmpty(txtItemDesc.getText())) {
            txtItemDesc.requestFocus();
            return;
        }
        Schedule bean = new Schedule();
        bean.setItem_desc(txtItemDesc.getText());
        bean.setItem_type(rdMonthly.isSelected() ? "MONTHLY" : "YEARLY");
        bean.setMonth_date(txtDate1.getText());
        bean.setYear_date(txtDate2.getText());
        bean.setEnd_month(cbEndMonth.getSelectedItem().toString());
        bean.setHolidy_skip(rdSkipHoliday.isSelected() ? "SKIP" : "BEFORE");
        bean.setMonth_at(StringUtil.strToInt(cbMonthAt.getSelectedItem().toString()));
        bean.setBefore_deadline(chkBeforeLine.isSelected() ? "Y" : "N");
        bean.setChkSuccess(chkSuccess.isSelected() ? "Y" : "N");

        try {
            if (isSave) {
                schImpl.save(bean);
            } else {
                Schedule beanTmp = schImpl.findById(StringUtil.strToInt(txtId.getText()));
                bean.setId(beanTmp.getId());
                schImpl.update(bean);
            }
            clearForm();
            loadData();
        } catch (SQLException e) {
            MsgUtil.showMsg(e.getMessage(), null);
        }

    }

    private void clearForm() {
        txtId.setText(AppConstants.FIX_ID_WORD);
        txtItemDesc.setText("");
        rdMonthly.setSelected(true);
        txtDate1.setText("");
        txtDate2.setText("");
        cbEndMonth.setSelectedIndex(0);
        rdSkipHoliday.setSelected(true);
        cbMonthAt.setSelectedIndex(0);
        chkBeforeLine.setSelected(false);
        chkSuccess.setSelected(false);
        txtItemDesc.requestFocus();

        isSave = true;
    }
}
