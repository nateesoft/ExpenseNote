package sun.natee.app.main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import org.apache.log4j.Logger;
import sun.natee.app.bean.Expense;
import sun.natee.app.bean.Schedule;
import sun.natee.app.dao.impl.ExpenseDaoImpl;
import sun.natee.app.dao.impl.ScheduleDaoImpl;
import sun.natee.app.main.util.CalendarPopup;
import sun.natee.app.main.util.MsgUtil;
import sun.natee.app.main.util.StringUtil;
import sun.natee.app.main.util.SwingUtil;
import sun.natee.app.main.util.UXUtil;

public class Main extends javax.swing.JDialog {

    private static final Logger logger = Logger.getLogger(Main.class);
    private final ExpenseDaoImpl expImpl = new ExpenseDaoImpl();
    private final ScheduleDaoImpl schImpl = new ScheduleDaoImpl();
    private DefaultTableModel model;
    private Timer time;

    public Main(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        model = (DefaultTableModel) tableData.getModel();
        initTable();
        loadData(null, null);

        txtDate1.setText(StringUtil.getCurrentDate());
        txtDate2.setText(StringUtil.getCurrentDate());

        time = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lbMsg.setText("ขณะนี้เวลา :" + StringUtil.showSystem());
            }
        });
        time.start();

        loadTimeFuture();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        btnExport = new javax.swing.JButton();
        txtDate1 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtDate2 = new javax.swing.JTextField();
        btnCal1 = new javax.swing.JButton();
        btnProcess = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtAllIncomeAmt = new javax.swing.JTextField();
        txtAllOutcomeAmt = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtAllBalanceAmt = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        btnAdd = new javax.swing.JButton();
        btnCal = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableData = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        lbMsg = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        lbAlert = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem7 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("ข้อมูลรายรับ-จ่าย ประจำวัน");
        setResizable(false);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 153, 0)));

        btnExport.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnExport.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/chart.png"))); // NOI18N
        btnExport.setText("Export เป็น Excel File");
        btnExport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportActionPerformed(evt);
            }
        });

        txtDate1.setEditable(false);
        txtDate1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtDate1.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("ถึง");

        txtDate2.setEditable(false);
        txtDate2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtDate2.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        btnCal1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnCal1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/calendar.png"))); // NOI18N
        btnCal1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCal1ActionPerformed(evt);
            }
        });

        btnProcess.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnProcess.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/play.png"))); // NOI18N
        btnProcess.setText("ค้นหาข้อมูล");
        btnProcess.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProcessActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 204, 153));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 102, 0)));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("รายรับทั้งหมด");

        txtAllIncomeAmt.setEditable(false);
        txtAllIncomeAmt.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtAllIncomeAmt.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtAllIncomeAmt.setText("0.00");

        txtAllOutcomeAmt.setEditable(false);
        txtAllOutcomeAmt.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtAllOutcomeAmt.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtAllOutcomeAmt.setText("0.00");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("รายจ่ายทั้งหมด");

        txtAllBalanceAmt.setEditable(false);
        txtAllBalanceAmt.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtAllBalanceAmt.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtAllBalanceAmt.setText("0.00");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("สรุปรวม");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtAllBalanceAmt, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtAllOutcomeAmt, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtAllIncomeAmt, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtAllIncomeAmt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtAllOutcomeAmt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtAllBalanceAmt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnAdd.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/plus.gif"))); // NOI18N
        btnAdd.setText("เพิ่มรายการ");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnCal.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnCal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/calendar.png"))); // NOI18N
        btnCal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pig_save.png"))); // NOI18N
        jLabel1.setText("ข้อมูลรายรับ-จ่าย ประจำวัน");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("เลือกช่วงวันที่");

        tableData.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "รหัส", "วันที่", "เวลา", "รายการ", "รายรับ", "รายจ่าย", "รวมเงิน", "ผู้บันทึก", "สถานที่"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableData.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableDataMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableData);
        if (tableData.getColumnModel().getColumnCount() > 0) {
            tableData.getColumnModel().getColumn(0).setPreferredWidth(50);
            tableData.getColumnModel().getColumn(1).setPreferredWidth(100);
            tableData.getColumnModel().getColumn(2).setPreferredWidth(70);
            tableData.getColumnModel().getColumn(3).setPreferredWidth(200);
            tableData.getColumnModel().getColumn(4).setPreferredWidth(80);
            tableData.getColumnModel().getColumn(5).setPreferredWidth(80);
            tableData.getColumnModel().getColumn(6).setPreferredWidth(100);
            tableData.getColumnModel().getColumn(7).setPreferredWidth(80);
            tableData.getColumnModel().getColumn(8).setPreferredWidth(200);
        }

        lbMsg.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbMsg.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbMsg.setText("ขณะนี้เวลา :");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbMsg, javax.swing.GroupLayout.DEFAULT_SIZE, 590, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbMsg)
                .addContainerGap())
        );

        lbAlert.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbAlert.setForeground(new java.awt.Color(0, 0, 102));
        lbAlert.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbAlert.setText("รายการประจำใกล้จะถึง : (ยังไม่มี)");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbAlert, javax.swing.GroupLayout.DEFAULT_SIZE, 590, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbAlert)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnExport)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAdd))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtDate1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnCal, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtDate2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnCal1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnProcess))
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 195, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnExport, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 401, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel5)
                                .addComponent(txtDate1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel6)
                                .addComponent(txtDate2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnCal, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCal1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnProcess, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jMenu1.setText("แฟ้มข้อมูล");
        jMenu1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jMenuItem4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jMenuItem4.setText("เพิ่มข้อมูลประจำ");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem4);

        jMenuItem6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jMenuItem6.setText("เพิ่มประเภทรายการ");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem6);
        jMenu1.add(jSeparator2);

        jMenuItem2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jMenuItem2.setText("ออกจากระบบ");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("รายงาน");
        jMenu2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jMenu2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu2ActionPerformed(evt);
            }
        });

        jMenuItem5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jMenuItem5.setText("ความเคลื่อนไหว ค่าใช้จ่าย");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem5);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("ผู้พัฒนา");
        jMenu3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jMenuItem7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jMenuItem7.setText("เกี่ยวกับ");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem7);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnExportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportActionPerformed
        exportFile();
    }//GEN-LAST:event_btnExportActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        addItem();
    }//GEN-LAST:event_btnAddActionPerformed

    private void tableDataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableDataMouseClicked
        if (evt.getClickCount() == 2) {
            int sel = tableData.getSelectedRow();
            if (sel != -1) {
                try {
                    int id = Integer.parseInt("" + tableData.getValueAt(sel, 0));
                    AddItemDialog item = new AddItemDialog(null, true, expImpl.findById(id));
                    item.setVisible(true);

                    loadData(null, null);
                } catch (NumberFormatException | SQLException e) {
                    MsgUtil.showMsg(e.getMessage(), null);
                }
            }
        }
    }//GEN-LAST:event_tableDataMouseClicked

    private void btnCalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalActionPerformed
        CalendarPopup cal = new CalendarPopup(null, true);
        cal.setVisible(true);

        if (StringUtil.isNotEmpty(cal.getDateString())) {
            txtDate1.setText(cal.getDateString());
        }
    }//GEN-LAST:event_btnCalActionPerformed

    private void btnCal1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCal1ActionPerformed
        CalendarPopup cal = new CalendarPopup(null, true);
        cal.setVisible(true);

        if (StringUtil.isNotEmpty(cal.getDateString())) {
            txtDate2.setText(cal.getDateString());
        }
    }//GEN-LAST:event_btnCal1ActionPerformed

    private void btnProcessActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProcessActionPerformed
        searchData();
    }//GEN-LAST:event_btnProcessActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenu2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu2ActionPerformed
        exportFile();
    }//GEN-LAST:event_jMenu2ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        reportGraph();
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        addSchedule();
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        PopupFormDialog pf = new PopupFormDialog(null, true);
        pf.setVisible(true);
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        AboutDialog about = new AboutDialog(null, true);
        about.setVisible(true);
    }//GEN-LAST:event_jMenuItem7ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnCal;
    private javax.swing.JButton btnCal1;
    private javax.swing.JButton btnExport;
    private javax.swing.JButton btnProcess;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JLabel lbAlert;
    private javax.swing.JLabel lbMsg;
    private javax.swing.JTable tableData;
    private javax.swing.JTextField txtAllBalanceAmt;
    private javax.swing.JTextField txtAllIncomeAmt;
    private javax.swing.JTextField txtAllOutcomeAmt;
    private javax.swing.JTextField txtDate1;
    private javax.swing.JTextField txtDate2;
    // End of variables declaration//GEN-END:variables

    private void loadData(Date date1, Date date2) {
        SwingUtil.clearModel(model);
        try {
            List<Expense> listExpense;
            if (date1 == null && date2 == null) {
                listExpense = expImpl.findAll(new Date());
            } else {
                listExpense = expImpl.findAll(date1, date2);
            }
            BigDecimal incomeAmt = BigDecimal.ZERO;
            BigDecimal outcomeAmt = BigDecimal.ZERO;
            BigDecimal totalAmt = BigDecimal.ZERO;
            for (Expense bean : listExpense) {
                model.addRow(new Object[]{
                    bean.getId(),
                    StringUtil.dateStr(bean.getDate()),
                    bean.getTime(),
                    bean.getDesc(),
                    StringUtil.bahtFormat(bean.getIncomeAmt()),
                    StringUtil.bahtFormat(bean.getOutcomeAmt()),
                    StringUtil.bahtFormat(bean.getTotalAmt()),
                    bean.getUser(),
                    bean.getPlace()
                });
                incomeAmt = incomeAmt.add(bean.getIncomeAmt());
                outcomeAmt = outcomeAmt.add(bean.getOutcomeAmt());
                totalAmt = totalAmt.add(bean.getTotalAmt());
            }
            txtAllIncomeAmt.setText(StringUtil.bahtFormat(incomeAmt));
            txtAllOutcomeAmt.setText(StringUtil.bahtFormat(outcomeAmt));
            txtAllBalanceAmt.setText(StringUtil.bahtFormat(totalAmt));
        } catch (SQLException ex) {
            MsgUtil.showMsg(ex.getMessage(), null);
        }
    }

    private void initTable() {
        UXUtil.initTable(tableData);
        UXUtil.alignTable(tableData, 0, SwingConstants.CENTER);
        UXUtil.alignTable(tableData, 1, SwingConstants.CENTER);
        UXUtil.alignTable(tableData, 2, SwingConstants.CENTER);

        UXUtil.alignTable(tableData, 4, SwingConstants.RIGHT);
        UXUtil.alignTable(tableData, 5, SwingConstants.RIGHT);
        UXUtil.alignTable(tableData, 6, SwingConstants.RIGHT);

        UXUtil.alignTable(tableData, 7, SwingConstants.CENTER);
    }

    private void addItem() {
        AddItemDialog item = new AddItemDialog(null, true, null);
        item.setVisible(true);

        loadData(StringUtil.strToDate(txtDate1.getText()), StringUtil.strToDate(txtDate2.getText()));
    }

    private void exportFile() {
        if (MsgUtil.confirmMsg("ท่านต้องการ Export ข้อมูลใช่หรือไม่ ?")) {
            UXUtil.exportData(tableData, this);
        }
    }

    private void searchData() {
        loadData(StringUtil.strToDate(txtDate1.getText()), StringUtil.strToDate(txtDate2.getText()));
    }

    private void reportGraph() {
        ChartReportDialog report = new ChartReportDialog(null, true);
        report.setVisible(true);
    }

    private void addSchedule() {
        ScheduleDialog s = new ScheduleDialog(null, true);
        s.setVisible(true);
    }

    private void loadTimeFuture() {
        try {
            List<Schedule> listSch = schImpl.findAll();
            lbAlert.setText("รายการประจำใกล้จะถึง : (ยังไม่มี)");
            for (Schedule bean : listSch) {
                if (bean.getChkSuccess().equals("N")) {
                    if (bean.getItem_type().equals("MONTHLY")) {
                        lbAlert.setText("รายการที่จะถึง : " + bean.getItem_desc() + " (วันที่ " + bean.getMonth_date() + ")");
                    } else {
                        lbAlert.setText("รายการที่จะถึง : " + bean.getItem_desc() + " (วันที่ " + bean.getYear_date() + " เดือน " + bean.getMonth_at() + ")");
                    }
                }
            }
        } catch (SQLException e) {
            MsgUtil.showMsg(e.getMessage(), null);
        }
    }
}
