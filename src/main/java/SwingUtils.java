import javax.swing.*;
import java.awt.*;

/**
 * Created by peterjmyers on 4/30/17.
 */
public class SwingUtils {

    static void addComp(JPanel thePanel, JComponent comp, int xPos, int yPos, int compWidth, int compHeight, int place, int stretch) {

        GridBagConstraints gridBagConstraints = new GridBagConstraints();

        gridBagConstraints.gridx = xPos;
        gridBagConstraints.gridy = yPos;
        gridBagConstraints.gridwidth = compWidth;
        gridBagConstraints.gridheight = compHeight;
        gridBagConstraints.weightx = 0;
        gridBagConstraints.weighty = 0;
        gridBagConstraints.insets = new Insets(5,5,5,5);
        gridBagConstraints.anchor = place;
        gridBagConstraints.fill = stretch;

        thePanel.add(comp, gridBagConstraints);

    } // END OF addComp METHOD
}
