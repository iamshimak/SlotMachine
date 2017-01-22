package root;

import javax.swing.*;
import java.io.File;

/**
 * Created by ShimaK on 30-Nov-16.
 */
public interface ISymbol {
    void setImage(ImageIcon image);

    ImageIcon getImage();

    void setValue(int value);

    int getValue();
}
