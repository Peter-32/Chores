import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.text.html.HTMLDocument;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import java.sql.*;

public class BasicsTabPanel extends JPanel {

    public static Object[][] databaseInfo;
    public static Object[] columns = {"firstname", "upstair", "bath_num", "uncom", "bathr", "outside", "c_area", "trash", "kitch"};
    //firstname, ' ' AS next_chore, ' '  pct_kitchen, ' ' pct_common_area, ' ' pct_trash, ' ' pct_outside, ' ' pct_bathrooms from member where state = 'ACTIVE'";
    static ResultSet rows;
    static ResultSetMetaData metaData;

    static DefaultTableModel dTableModel = new DefaultTableModel(databaseInfo,columns){
        public Class getColumnClass(int column){
            Class returnValue;

            if((column >= 0) && (column < getColumnCount())){
                returnValue = getValueAt(0, column).getClass();
            } else {
                returnValue = Object.class;
            }
            return returnValue;
        }
    };







    JButton buttonLogin, buttonJIRAUpdated, buttonJIRAFinished, buttonReplace, buttonRInput, buttonRColumns, buttonMakeIntCSV, buttonMakeStrCSV, buttonSQLOptimizations,
            buttonDimJoins, buttonRegexpExtract, buttonColumnListSum, buttonParseSplunk, buttonInsertionOrders, buttonLockingAF, buttonImpOldPerformance, buttonFlexibleMSAIF, buttonFailingAndNonFailingClickPaths;
    JTextField accountID, campaignID, reportID, startDate, endDate;
    public BasicsTabPanel() {
        setupPanel();
    }


    private void setupPanel() {
        JLabel labelAccount, labelCampaign, labelReport, labelStartDate, labelEndDate, labelJIRAAndTesting, labelClipboardMapping, labelIRAM, labelOther, labelPerformance,
                labelMembers;

        setLayout(new GridBagLayout());
        BTPListenForButton lForButton = new BTPListenForButton();

        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/database1?autoReconnect=true&useSSL=false","root","");
            Statement sqlState = conn.createStatement();
            String selectStuff = "select b.firstname, upstairs AS upstair, bathroom_num AS bath_num,\n" +
                    "SUM(IF(chore_dim_id IN (2,3,4,5),1,0)) / max(d.total_chores) AS uncom,\n" +
                    "SUM(IF(chore_dim_id=5,1,0)) / max(d.total_chores) AS bathr,\n" +
                    "SUM(IF(chore_dim_id=4,1,0)) / max(d.total_chores) AS outside,\n" +
                    "SUM(IF(chore_dim_id=2,1,0)) / max(d.total_chores) AS c_area,\n" +
                    "SUM(IF(chore_dim_id=3,1,0)) / max(d.total_chores) AS trash,\n" +
                    "SUM(IF(chore_dim_id=1,1,0)) / max(d.total_chores) AS kitch,\n" +
                    " max(d.total_chores) AS months\n" +
                    "from monthly_chore a\n" +
                    "INNER JOIN member b on b.id = a.member_id\n" +
                    "INNER JOIN chore_dim c on c.id = a.chore_dim_id\n" +
                    "INNER JOIN (select member_id, count(*) total_chores from monthly_chore group by 1) d on d.member_id = a.member_id\n" +
                    "group by 1,2,3\n" +
                    "order by uncom asc, bathr asc, outside asc, c_area asc";
            rows = sqlState.executeQuery(selectStuff);
            int numOfCol;
            metaData = rows.getMetaData();
            numOfCol = metaData.getColumnCount();
            columns = new String[numOfCol];
            System.out.println(numOfCol);
            for (int i = 0; i < numOfCol; i++) {
                columns[i] = metaData.getColumnName(i+1);
            }
            Object[] tempRow;
            int row = 1;
            while(rows.next()) {
                String newChore;
                if (row==1) {

                }
                tempRow = new Object[]{rows.getString(1), rows.getString(2),
                        rows.getString(3),rows.getString(4),rows.getString(5),rows.getString(6),
                        rows.getString(7), rows.getString(8), rows.getString(9)};
                dTableModel.addRow(tempRow);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        System.out.println(dTableModel.getColumnCount());
        JTable table = new JTable(dTableModel);
        table.setFont(new Font("Serif", Font.PLAIN, 14));
        table.setRowHeight(table.getRowHeight()+10);
        table.setAutoCreateRowSorter(true);

        /*
        TableColumn tc = table.getColumn("TTRC");
        RightTableCellRenderer rightRenderer = new RightTableCellRenderer();
        tc.setCellRenderer(rightRenderer);
        */

        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        TableColumn col1 = table.getColumnModel().getColumn(0);
        col1.setPreferredWidth(75);
        TableColumn col2 = table.getColumnModel().getColumn(1);
        col2.setPreferredWidth(50);
        TableColumn col3 = table.getColumnModel().getColumn(2);
        col3.setPreferredWidth(50);
        TableColumn col4 = table.getColumnModel().getColumn(3);
        col4.setPreferredWidth(50);
        TableColumn col5 = table.getColumnModel().getColumn(4);
        col5.setPreferredWidth(50);
        TableColumn col6 = table.getColumnModel().getColumn(5);
        col6.setPreferredWidth(50);
        TableColumn col7 = table.getColumnModel().getColumn(6);
        col7.setPreferredWidth(50);
        TableColumn col8 = table.getColumnModel().getColumn(7);
        col8.setPreferredWidth(50);
        TableColumn col9 = table.getColumnModel().getColumn(8);
        col8.setPreferredWidth(50);

        JScrollPane scrollPane = new JScrollPane(table);
        this.add(scrollPane);

//
//        buttonLogin = new JButton("Login Link");
//        SwingUtils.addComp(this, buttonLogin, 1, 5, 1, 1, GridBagConstraints.WEST, GridBagConstraints.BOTH);
//        buttonLogin.addActionListener(lForButton);







    }

    private class BTPListenForButton implements ActionListener {

        private StringSelection select;
        private Clipboard clipboard;

        BTPListenForButton() {

            clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            //Object eventSource = ;

            if (e.getSource() == buttonLogin) {

            }






        }
    }
}