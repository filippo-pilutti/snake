package main.java.com.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.Map;

import main.java.com.utility.Pos;
import main.java.com.utility.Position;

/**
 * This class is the view for the apple game entity. The apple is represented as
 * a {@link Rectangle}.
 */
public class AppleViewImpl implements AppleView {

    private final Rectangle apple;
    private final Map<Position, Position> cells;

    public AppleViewImpl(final Rectangle a, final Map<Position, Position> c) {
        apple = a;
        cells = c;
    }

    /** {@inheritDoc} */
    public Rectangle getRect() {
        return new Rectangle(cells.get(getLocation()).getX(), cells.get(getLocation()).getY(),
                             (int) apple.getSize().getWidth() + 1, (int) apple.getSize().getHeight() + 1);

    }

    /** {@inheritDoc} */
    public void setPosition(final Position p) {
        apple.setLocation(new Point(p.getX(), p.getY()));
    }

    /** {@inheritDoc} */
    public void draw(final Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(cells.get(getLocation()).getX(), cells.get(getLocation()).getY(),
                  (int) apple.getSize().getWidth() + 1, (int) apple.getSize().getHeight() + 1);
    }

    private Position getLocation() {
        return new Pos((int) apple.getX(), (int) apple.getY());
    }
}
