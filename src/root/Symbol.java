package root;

import javax.swing.*;

/**
 * Created by ShimaK on 30-Nov-16.
 */
public class Symbol implements ISymbol {
    private int value;
    private ImageIcon image;

    @Override
    public void setImage(ImageIcon image) {
        this.image = image;
    }

    @Override
    public ImageIcon getImage() {
        return image;
    }

    @Override
    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Symbol{" +
                "value=" + value +
                ", image=" + image.getClass() +
                '}';
    }
}
