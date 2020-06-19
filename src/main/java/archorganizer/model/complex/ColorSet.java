package archorganizer.model.complex;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ColorSet {

    private String name;

    @Column(columnDefinition = "integer default 0")
    private int red;

    @Column(columnDefinition = "integer default 0")
    private int green;

    @Column(columnDefinition = "integer default 0")
    private int blue;

    public ColorSet() {
        this(0,0,0);
    }

    public ColorSet(int r, int g, int b) {
        setRed(r);
        setGreen(g);
        setBlue(b);
    }

    public ColorSet(String name) {
        setName(name);
    }

    public String getHex()
    {
        return "#" + Integer.toHexString(red) + Integer.toHexString(green) + Integer.toHexString(blue);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRed() {
        return red;
    }

    public void setRed(int red) {
        this.red = red;
    }

    public int getGreen() {
        return green;
    }

    public void setGreen(int green) {
        this.green = green;
    }

    public int getBlue() {
        return blue;
    }

    public void setBlue(int blue) {
        this.blue = blue;
    }
}
