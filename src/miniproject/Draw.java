/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniproject;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import static java.lang.Integer.min;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author User
 */
public class Draw extends JPanel {

    private ArrayList<Long> tc = new ArrayList<>();

    Draw(ArrayList<Long> tc) {
        this.tc = tc;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); //To change body of generated methods, choose Tools | Templates.
        int m = 0;
        for (int i = 0; i < tc.size(); i++) {
            m = min(m, tc.get(i).intValue());
        }

        for (int i = 0; i < tc.size(); i++) {
            g.setFont(new Font("Arial", Font.PLAIN, 17));
            g.setColor(new Color(0, 200, 200));
            g.fillRect(50, (i + 1) * 70, (tc.get(i).intValue() - m) / 7000, 20);
            if (i == 0) {
                g.drawString("selection sort" + " " + tc.get(i) + "ns", 100, (i + 1) * 65);
            } else if (i == 1) {
                g.drawString("bubble sort" + " " + tc.get(i) + "ns", 100, (i + 1) * 65);
            } else if (i == 2) {
                g.drawString("quick sort" + " " + tc.get(i) + "ns", 100, (i + 1) * 65);
            } else if (i == 3) {
                g.drawString("comb sort" + " " + tc.get(i) + "ns", 100, (i + 1) * 65);
            } else if (i == 4) {
                g.drawString("insertion sort" + " " + tc.get(i) + "ns", 100, (i + 1) * 65);
            } else if (i == 5) {
                g.drawString("exchange sort" + " " + tc.get(i) + "ns", 100, (i + 1) * 65);
            }

        }

    }

}
