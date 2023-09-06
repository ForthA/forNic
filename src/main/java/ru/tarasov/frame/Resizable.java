package ru.tarasov.frame;

import javax.swing.*;
import javax.swing.event.MouseInputAdapter;
import javax.swing.event.MouseInputListener;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.Set;

public class Resizable extends JComponent {

    Set<Integer> directions;
    public Resizable(Component comp) {
        this(comp, new ResizableBorder(8));
    }

    public Resizable(Component comp, ResizableBorder border) {
        setLayout(new BorderLayout());
        add(comp);
        addMouseListener(resizeListener);
        addMouseMotionListener(resizeListener);
        setBorder(border);
    }

    public void setAvailableDirections(Set<Integer> directions){
        this.directions = directions;
    }

    public void resize() {
        if (getParent() != null) {
            ((JComponent)getParent()).revalidate();
        }
    }
    MouseInputListener resizeListener = new MouseInputAdapter() {
        public void mouseMoved(MouseEvent me) {
            if (hasFocus()) {
                ResizableBorder border = (ResizableBorder)getBorder();
                setCursor(Cursor.getPredefinedCursor(border.getCursor(me)));
            }
        }
        public void mouseExited(MouseEvent mouseEvent) {
            setCursor(Cursor.getDefaultCursor());
        }
        private int cursor;
        private Point startPos = null;
        public void mousePressed(MouseEvent me) {
            ResizableBorder border = (ResizableBorder)getBorder();
            cursor = border.getCursor(me);
            startPos = me.getPoint();
            requestFocus();
            repaint();
        }
        public void mouseDragged(MouseEvent me) {
            if (startPos != null) {
                int x = getX();
                int y = getY();
                int w = getWidth();
                int h = getHeight();
                int dx = me.getX() - startPos.x;
                int dy = me.getY() - startPos.y;

                switch (cursor) {
                    case Cursor.N_RESIZE_CURSOR:
                        if (!(h - dy < 50) && directions.contains(Cursor.N_RESIZE_CURSOR)) {
                            setBounds(x, y + dy, w, h - dy);
                            resize();
                        }
                        break;
                    case Cursor.S_RESIZE_CURSOR:
                        if (!(h + dy < 50)  && directions.contains(Cursor.S_RESIZE_CURSOR)) {
                            setBounds(x, y, w, h + dy);
                            startPos = me.getPoint();
                            resize();
                        }
                        break;
                    case Cursor.W_RESIZE_CURSOR:
                        if (!(w - dx < 50)  && directions.contains(Cursor.W_RESIZE_CURSOR)) {
                            setBounds(x + dx, y, w - dx, h);
                            resize();
                        }
                        break;
                    case Cursor.E_RESIZE_CURSOR:
                        if (!(w + dx < 50)  && directions.contains(Cursor.E_RESIZE_CURSOR)) {
                            setBounds(x, y, w + dx, h);
                            startPos = me.getPoint();
                            resize();
                        }
                        break;
                    case Cursor.NW_RESIZE_CURSOR:
                        if (!(w - dx < 50) && !(h - dy < 50)  && directions.contains(Cursor.NW_RESIZE_CURSOR)) {
                            setBounds(x + dx, y + dy, w - dx, h - dy);
                            resize();
                        }
                        break;
                    case Cursor.NE_RESIZE_CURSOR:
                        if (!(w + dx < 50) && !(h - dy < 50)  && directions.contains(Cursor.NE_RESIZE_CURSOR)) {
                            setBounds(x, y + dy, w + dx, h - dy);
                            startPos = new Point(me.getX(), startPos.y);
                            resize();
                        }
                        break;
                    case Cursor.SW_RESIZE_CURSOR:
                        if (!(w - dx < 50) && !(h + dy < 50)  && directions.contains(Cursor.SW_RESIZE_CURSOR)) {
                            setBounds(x + dx, y, w - dx, h + dy);
                            startPos = new Point(startPos.x, me.getY());
                            resize();
                        }
                        break;
                    case Cursor.SE_RESIZE_CURSOR:
                        if (!(w + dx < 50) && !(h + dy < 50)  && directions.contains(Cursor.SE_RESIZE_CURSOR)) {
                            if (dx < dy)
                                dy = dx;
                            else
                                dx = dy;
                            setBounds(x, y, w + dx, h + dy);
                            startPos = me.getPoint();
                            resize();
                        }
                        break;
                }
                setCursor(Cursor.getPredefinedCursor(cursor));
            }
        }
        public void mouseReleased(MouseEvent mouseEvent) {
            startPos = null;
        }
    };
}


