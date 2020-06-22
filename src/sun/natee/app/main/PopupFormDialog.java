package sun.natee.app.main;

import java.sql.SQLException;
import java.util.List;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import org.apache.log4j.Logger;
import sun.natee.app.AppConstants;
import sun.natee.app.bean.PopupDesc;
import sun.natee.app.dao.impl.PopupDescDaoImpl;
import sun.natee.app.main.util.MsgUtil;
import sun.natee.app.main.util.StringUtil;
import sun.natee.app.main.util.SwingUtil;
import sun.natee.app.main.util.UXUtil;

public class PopupFormDialog extends javax.swing.JDialog {

    private static final Logger logger = Logger.getLogger(PopupFormDialog.class);
    private DefaultTableModel model = null;
    private final PopupDescDaoImpl popImpl = new PopupDescDaoImpl();
    private boolean isSave = true;
    private final PopupDesc pdBean = new PopupDesc();

    public PopupFormDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        initTable();

        txtId.setText(AppConstants.FIX_ID_WORD);
        txtItemDesc.requestFocus();

        loadData();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tableData = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        txtItemDesc = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnAdd = new javax.swing.JButton();
        cbItemType = new javax.swing.JComboBox<>();
        btnAdd1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("ฟอร์มประเภทรายการ");
        setResizable(false);

        tableData.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "รหัส", "รายการ", "ประเภท"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
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
            tableData.getColumnModel().getColumn(1).setPreferredWidth(250);
        }

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("รหัส :");

        txtId.setEditable(false);
        txtId.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtId.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txtItemDesc.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("รายการ :");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("ประเภท :");

        btnAdd.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/plus.gif"))); // NOI18N
        btnAdd.setText("เพิ่ม");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        cbItemType.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cbItemType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "รายละเอียด", "สถานที่" }));

        btnAdd1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnAdd1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/remove.png"))); // NOI18N
        btnAdd1.setText("ลบ");
        btnAdd1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdd1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(cbItemType, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAdd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAdd1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(txtItemDesc, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtItemDesc, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel3)
                    .addComponent(cbItemType, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAdd1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 369, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tableDataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableDataMouseClicked
        if (evt.getClickCount() == 2) {
            int iSel = tableData.getSelectedRow();
            if (iSel != -1) {
                isSave = false;
                txtId.setText("" + tableData.getValueAt(iSel, 0));
                txtItemDesc.setText("" + tableData.getValueAt(iSel, 1));
                String type = "" + tableData.getValueAt(iSel, 2);
                if (type.equals("DESC")) {
                    cbItemType.setSelectedIndex(0);
                } else {
                    cbItemType.setSelectedIndex(1);
                }
            }
        }
    }//GEN-LAST:event_tableDataMouseClicked

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        addItem();
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnAdd1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdd1ActionPerformed
        deleteItem();
    }//GEN-LAST:event_btnAdd1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnAdd1;
    private javax.swing.JComboBox<String> cbItemType;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableData;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtItemDesc;
    // End of variables declaration//GEN-END:variables

    private void addItem() {
        if(StringUtil.isEmpty(txtItemDesc.getText())){
            txtItemDesc.requestFocus();
            return;
        }
        
        pdBean.setItemDesc(txtItemDesc.getText());
        pdBean.setItemType(cbItemType.getSelectedIndex() == 0 ? "DESC" : "PLACE");
        try {
            if (isSave) {
                // add data            
                popImpl.save(pdBean);
            } else {
                PopupDesc popupDesc = popImpl.findById(Integer.parseInt(txtId.getText()));
                popupDesc.setItemDesc(pdBean.getItemDesc());
                popupDesc.setItemType(pdBean.getItemType());
                popImpl.update(popupDesc);
            }

            loadData();
            clearForm();
        } catch (SQLException ex) {
            MsgUtil.showMsg(ex.getMessage(), null);
        }

    }

    private void deleteItem() {
        try {
            popImpl.delete(Integer.parseInt(txtId.getText()));
            loadData();
            clearForm();
        } catch (SQLException ex) {
            MsgUtil.showMsg(ex.getMessage(), null);
        }
    }

    private void loadData() {
        try {
            SwingUtil.clearModel(model);
            List<PopupDesc> listPopup = popImpl.findAll();
            for (PopupDesc bean : listPopup) {
                model.addRow(new Object[]{bean.getId(), bean.getItemDesc(), bean.getItemType()});
            }
        } catch (SQLException e) {
            MsgUtil.showMsg(e.getMessage(), null);
        }

    }

    private void clearForm() {
        txtId.setText(AppConstants.FIX_ID_WORD);
        txtItemDesc.setText("");
        cbItemType.setSelectedIndex(0);
        txtItemDesc.requestFocus();
    }

    private void initTable() {
        model = (DefaultTableModel) tableData.getModel();
        UXUtil.initTable(tableData);
        
        UXUtil.alignTable(tableData, 0, SwingConstants.CENTER);
        UXUtil.alignTable(tableData, 2, SwingConstants.CENTER);
    }
}
