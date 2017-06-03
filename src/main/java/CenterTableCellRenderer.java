import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;

/**
 * Created by peterjmyers on 6/3/17.
 */
public class CenterTableCellRenderer extends DefaultTableCellRenderer {
    public CenterTableCellRenderer() {
        setHorizontalAlignment(JLabel.CENTER);
    }
}
