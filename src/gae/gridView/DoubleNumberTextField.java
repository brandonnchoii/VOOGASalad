package gae.gridView;

import javafx.scene.control.TextField;


/**
 * TextField that only allows the entry of doubles
 * 
 * @author Kei
 *
 */

public class DoubleNumberTextField extends TextField {

    @Override
    public void replaceText (int start, int end, String text) {
        if (validate(text)) {
            super.replaceText(start, end, text);
        }
    }

    @Override
    public void replaceSelection (String text) {
        if (validate(text)) {
            super.replaceSelection(text);
        }
    }

    private boolean validate (String text) {
        return ("".equals(text) || text.matches("[0-9]+(\\.[0-9][0-9]?)?") || text.matches("\\."));
    }
}
