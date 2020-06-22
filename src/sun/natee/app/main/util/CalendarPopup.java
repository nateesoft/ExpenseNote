package sun.natee.app.main.util;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import javax.swing.JButton;
import org.apache.log4j.Logger;

public class CalendarPopup extends javax.swing.JDialog {

    private final Logger logger = Logger.getLogger(CalendarPopup.class);
    private final JButton[] btn = new JButton[42];
    private final Calendar currentCalendar;
    private final Calendar backMonth;
    private final String currentDay = new SimpleDateFormat("dd", Locale.ENGLISH).format(new Date());
    private String dateString = "";
    private Date dateTime;

    public CalendarPopup(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        currentCalendar = Calendar.getInstance(Locale.ENGLISH);
        backMonth = Calendar.getInstance(Locale.ENGLISH);
        backMonth.add(Calendar.MONTH, -1);
        initUI();
    }

    public String getDateString() {
        return dateString;
    }
    
    public Date getDate(){
        return dateTime;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        pnTop = new javax.swing.JPanel();
        nextMonth = new javax.swing.JButton();
        btnShowMonth = new javax.swing.JButton();
        pnMain = new javax.swing.JPanel();
        btn0 = new javax.swing.JButton();
        btn1 = new javax.swing.JButton();
        btn2 = new javax.swing.JButton();
        btn3 = new javax.swing.JButton();
        btn4 = new javax.swing.JButton();
        btn5 = new javax.swing.JButton();
        btn6 = new javax.swing.JButton();
        btn7 = new javax.swing.JButton();
        btn8 = new javax.swing.JButton();
        btn9 = new javax.swing.JButton();
        btn10 = new javax.swing.JButton();
        btn11 = new javax.swing.JButton();
        btn12 = new javax.swing.JButton();
        btn13 = new javax.swing.JButton();
        btn14 = new javax.swing.JButton();
        btn15 = new javax.swing.JButton();
        btn16 = new javax.swing.JButton();
        btn17 = new javax.swing.JButton();
        btn18 = new javax.swing.JButton();
        btn19 = new javax.swing.JButton();
        btn20 = new javax.swing.JButton();
        btn21 = new javax.swing.JButton();
        btn22 = new javax.swing.JButton();
        btn23 = new javax.swing.JButton();
        btn24 = new javax.swing.JButton();
        btn25 = new javax.swing.JButton();
        btn26 = new javax.swing.JButton();
        btn27 = new javax.swing.JButton();
        btn28 = new javax.swing.JButton();
        btn29 = new javax.swing.JButton();
        btn30 = new javax.swing.JButton();
        btn31 = new javax.swing.JButton();
        btn32 = new javax.swing.JButton();
        btn33 = new javax.swing.JButton();
        btn34 = new javax.swing.JButton();
        btn35 = new javax.swing.JButton();
        btn36 = new javax.swing.JButton();
        btn37 = new javax.swing.JButton();
        btn38 = new javax.swing.JButton();
        btn39 = new javax.swing.JButton();
        btn40 = new javax.swing.JButton();
        btn41 = new javax.swing.JButton();
        btn42 = new javax.swing.JButton();
        btn43 = new javax.swing.JButton();
        btn44 = new javax.swing.JButton();
        btn45 = new javax.swing.JButton();
        btn46 = new javax.swing.JButton();
        btn47 = new javax.swing.JButton();
        btn48 = new javax.swing.JButton();
        btnBackMonth = new javax.swing.JButton();

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Show Calendar");
        setResizable(false);

        nextMonth.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        nextMonth.setText(">");
        nextMonth.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        nextMonth.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextMonthActionPerformed(evt);
            }
        });

        btnShowMonth.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnShowMonth.setText("October, 2018");
        btnShowMonth.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        pnMain.setLayout(new java.awt.GridLayout(7, 7));

        btn0.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btn0.setText("Sun");
        pnMain.add(btn0);

        btn1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btn1.setText("Mon");
        pnMain.add(btn1);

        btn2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btn2.setText("Tue");
        pnMain.add(btn2);

        btn3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btn3.setText("Wed");
        pnMain.add(btn3);

        btn4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btn4.setText("Thu");
        pnMain.add(btn4);

        btn5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btn5.setText("Fri");
        pnMain.add(btn5);

        btn6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btn6.setText("Sat");
        pnMain.add(btn6);

        btn7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        pnMain.add(btn7);

        btn8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        pnMain.add(btn8);

        btn9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        pnMain.add(btn9);

        btn10.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        pnMain.add(btn10);

        btn11.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        pnMain.add(btn11);

        btn12.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        pnMain.add(btn12);

        btn13.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        pnMain.add(btn13);

        btn14.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        pnMain.add(btn14);

        btn15.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        pnMain.add(btn15);

        btn16.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        pnMain.add(btn16);

        btn17.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        pnMain.add(btn17);

        btn18.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        pnMain.add(btn18);

        btn19.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        pnMain.add(btn19);

        btn20.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        pnMain.add(btn20);

        btn21.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        pnMain.add(btn21);

        btn22.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        pnMain.add(btn22);

        btn23.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        pnMain.add(btn23);

        btn24.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        pnMain.add(btn24);

        btn25.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        pnMain.add(btn25);

        btn26.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        pnMain.add(btn26);

        btn27.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        pnMain.add(btn27);

        btn28.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        pnMain.add(btn28);

        btn29.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        pnMain.add(btn29);

        btn30.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        pnMain.add(btn30);

        btn31.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        pnMain.add(btn31);

        btn32.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        pnMain.add(btn32);

        btn33.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        pnMain.add(btn33);

        btn34.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        pnMain.add(btn34);

        btn35.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        pnMain.add(btn35);

        btn36.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        pnMain.add(btn36);

        btn37.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        pnMain.add(btn37);

        btn38.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        pnMain.add(btn38);

        btn39.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        pnMain.add(btn39);

        btn40.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        pnMain.add(btn40);

        btn41.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        pnMain.add(btn41);

        btn42.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        pnMain.add(btn42);

        btn43.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        pnMain.add(btn43);

        btn44.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        pnMain.add(btn44);

        btn45.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        pnMain.add(btn45);

        btn46.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        pnMain.add(btn46);

        btn47.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        pnMain.add(btn47);

        btn48.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        pnMain.add(btn48);

        btnBackMonth.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnBackMonth.setText("<");
        btnBackMonth.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnBackMonth.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackMonthActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnTopLayout = new javax.swing.GroupLayout(pnTop);
        pnTop.setLayout(pnTopLayout);
        pnTopLayout.setHorizontalGroup(
            pnTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnTopLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnTopLayout.createSequentialGroup()
                        .addComponent(btnBackMonth, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnShowMonth, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nextMonth, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(pnMain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        pnTopLayout.setVerticalGroup(
            pnTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnTopLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBackMonth, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nextMonth, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnShowMonth, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnMain, javax.swing.GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnTop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnTop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackMonthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackMonthActionPerformed
        loadBackMonth();
    }//GEN-LAST:event_btnBackMonthActionPerformed

    private void nextMonthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextMonthActionPerformed
        loadNextMonth();
    }//GEN-LAST:event_nextMonthActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn0;
    private javax.swing.JButton btn1;
    private javax.swing.JButton btn10;
    private javax.swing.JButton btn11;
    private javax.swing.JButton btn12;
    private javax.swing.JButton btn13;
    private javax.swing.JButton btn14;
    private javax.swing.JButton btn15;
    private javax.swing.JButton btn16;
    private javax.swing.JButton btn17;
    private javax.swing.JButton btn18;
    private javax.swing.JButton btn19;
    private javax.swing.JButton btn2;
    private javax.swing.JButton btn20;
    private javax.swing.JButton btn21;
    private javax.swing.JButton btn22;
    private javax.swing.JButton btn23;
    private javax.swing.JButton btn24;
    private javax.swing.JButton btn25;
    private javax.swing.JButton btn26;
    private javax.swing.JButton btn27;
    private javax.swing.JButton btn28;
    private javax.swing.JButton btn29;
    private javax.swing.JButton btn3;
    private javax.swing.JButton btn30;
    private javax.swing.JButton btn31;
    private javax.swing.JButton btn32;
    private javax.swing.JButton btn33;
    private javax.swing.JButton btn34;
    private javax.swing.JButton btn35;
    private javax.swing.JButton btn36;
    private javax.swing.JButton btn37;
    private javax.swing.JButton btn38;
    private javax.swing.JButton btn39;
    private javax.swing.JButton btn4;
    private javax.swing.JButton btn40;
    private javax.swing.JButton btn41;
    private javax.swing.JButton btn42;
    private javax.swing.JButton btn43;
    private javax.swing.JButton btn44;
    private javax.swing.JButton btn45;
    private javax.swing.JButton btn46;
    private javax.swing.JButton btn47;
    private javax.swing.JButton btn48;
    private javax.swing.JButton btn5;
    private javax.swing.JButton btn6;
    private javax.swing.JButton btn7;
    private javax.swing.JButton btn8;
    private javax.swing.JButton btn9;
    private javax.swing.JButton btnBackMonth;
    private javax.swing.JButton btnShowMonth;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JButton nextMonth;
    private javax.swing.JPanel pnMain;
    private javax.swing.JPanel pnTop;
    // End of variables declaration//GEN-END:variables

    private void initUI() {
        int i = 0;
        btn[i++] = btn7;
        btn[i++] = btn8;
        btn[i++] = btn9;
        btn[i++] = btn10;
        btn[i++] = btn11;
        btn[i++] = btn12;
        btn[i++] = btn13;
        btn[i++] = btn14;
        btn[i++] = btn15;
        btn[i++] = btn16;
        btn[i++] = btn17;
        btn[i++] = btn18;
        btn[i++] = btn19;
        btn[i++] = btn20;
        btn[i++] = btn21;
        btn[i++] = btn22;
        btn[i++] = btn23;
        btn[i++] = btn24;
        btn[i++] = btn25;
        btn[i++] = btn26;
        btn[i++] = btn27;
        btn[i++] = btn28;
        btn[i++] = btn29;
        btn[i++] = btn30;
        btn[i++] = btn31;
        btn[i++] = btn32;
        btn[i++] = btn33;
        btn[i++] = btn34;
        btn[i++] = btn35;
        btn[i++] = btn36;
        btn[i++] = btn37;
        btn[i++] = btn38;
        btn[i++] = btn39;
        btn[i++] = btn40;
        btn[i++] = btn41;
        btn[i++] = btn42;
        btn[i++] = btn43;
        btn[i++] = btn44;
        btn[i++] = btn45;
        btn[i++] = btn46;
        btn[i++] = btn47;
        btn[i++] = btn48;

        resetButton(btn);

        currentCalendar.set(
                Integer.parseInt(new SimpleDateFormat("yyyy", Locale.ENGLISH).format(currentCalendar.getTime())),
                Integer.parseInt(new SimpleDateFormat("MM", Locale.ENGLISH).format(currentCalendar.getTime())) - 1,
                Integer.parseInt("1")
        );
        String[] days = new String[]{"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
        int count = 1;
        boolean isOver = false;
        for (int a = 0; a < 42; a++) {
            String dayStr = new SimpleDateFormat("EEE", Locale.ENGLISH).format(currentCalendar.getTime());
            if (a == 0) {
                if (dayStr.equals(days[0])) {
                    a = 0;
                } else if (dayStr.equals(days[1])) {
                    a = 1;
                } else if (dayStr.equals(days[2])) {
                    a = 2;
                } else if (dayStr.equals(days[3])) {
                    a = 3;
                } else if (dayStr.equals(days[4])) {
                    a = 4;
                } else if (dayStr.equals(days[5])) {
                    a = 5;
                } else if (dayStr.equals(days[6])) {
                    a = 6;
                }
            }

            btn[a].setText("" + (count));
            int actualMax = currentCalendar.getActualMaximum(Calendar.DAY_OF_MONTH);
            if (count > actualMax) {
                isOver = true;
                btn[a].setText("1");
                count = 1;
            }
            count++;

            String day = ""+Integer.parseInt(currentDay);
            String btnDay = btn[a].getText();
            if (btn[a].getText().equals(day)) {
                btn[a].setForeground(Color.BLUE);
            } else {
                btn[a].setForeground(Color.BLACK);
            }

            if (isOver) {
                btn[a].setForeground(Color.GREEN);
            }
        }

        int maxDaysOfMonth = backMonth.getActualMaximum(Calendar.DAY_OF_MONTH);
        for (int z = 6; z >= 0; z--) {
            if (btn[z].getText().equals("") || Integer.parseInt(btn[z].getText()) > 7) {
                btn[z].setText("" + (maxDaysOfMonth--));
                btn[z].setForeground(Color.GRAY);
            }
        }

        for (final JButton btnAct : btn) {
            btnAct.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    SimpleDateFormat simp = new SimpleDateFormat("dd MMM, yyyy", Locale.ENGLISH);
                    SimpleDateFormat simp1 = new SimpleDateFormat("MMM, yyyy", Locale.ENGLISH);
                    SimpleDateFormat simp2 = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
                    try {                        
                        Date dateMonth = simp1.parse(btnShowMonth.getText());
                        if (btnAct.getForeground() == Color.GRAY) {
                            Calendar c = Calendar.getInstance();
                            c.setTime(dateMonth);
                            c.add(Calendar.MONTH, -1);
                            dateMonth = c.getTime();
                        } else if (btnAct.getForeground() == Color.GREEN) {
                            Calendar c = Calendar.getInstance();
                            c.setTime(dateMonth);
                            c.add(Calendar.MONTH, 1);
                            dateMonth = c.getTime();
                        }
                        
                        String strDate = btnAct.getText() + " " + simp1.format(dateMonth);
                        Date date = simp.parse(strDate);
                        dateString = simp2.format(date);
                        dateTime = date;

                        dispose();
                    } catch (ParseException ee) {
                        ee.printStackTrace();
                    }

                }
            });
        }

        btnShowMonth.setText(new SimpleDateFormat("MMMM, yyyy", Locale.ENGLISH).format(currentCalendar.getTime()));
    }

    private void loadBackMonth() {
        currentCalendar.add(Calendar.MONTH, -1);
        backMonth.add(Calendar.MONTH, -1);

        initUI();
    }

    private void loadNextMonth() {
        currentCalendar.add(Calendar.MONTH, 1);
        backMonth.add(Calendar.MONTH, 1);

        initUI();
    }

    private void resetButton(JButton[] btn) {
        for (JButton button : btn) {
            button.setEnabled(true);
            button.setText("");
        }
    }
}
