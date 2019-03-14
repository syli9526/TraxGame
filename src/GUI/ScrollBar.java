package GUI;

import javax.swing.*;
import java.awt.*;

class ScrollBar {
    private Point CAMERA_POS = new Point(2600, 2585);
    private JScrollPane scrollBar;

    ScrollBar(){
        scrollBar = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
    }
    void setScrollBar(JFrame frame, JPanel panel){
        /**
         * @ set scroll bar at panel and add at frame
         * @ param: frame (JFrame) paenl (JPanel)
         * @ return: none
         */
        scrollBar.setViewportView(panel);
        scrollBar.getViewport().setViewPosition(CAMERA_POS);

        frame.add(scrollBar, BorderLayout.CENTER);
    }
}
