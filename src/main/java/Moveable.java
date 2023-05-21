/**
 * This is the Moveable interface.
 * By definition all classes that implement this interface need to implement each method
 * defined in this interface
 */
public interface Moveable {
    public void setPos(int x, int y);

    public void setX(int x);

    public void setY(int y);

    public int getX();

    public int getY();

    public int getWidth();

    public int getHeight();

    public void setWidth(int w);

    public void setHeight(int h);
}
