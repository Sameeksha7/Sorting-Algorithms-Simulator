/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniproject;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.Timer;

/**
 *
 * @author User
 */
public class InsertionSort extends Sort {

    private Timer timer;
    private final int DELAY = 5;
    private int flag = 0;
    private int complete = 0;
    private Integer x;

    InsertionSort(ArrayList<Integer> numbers, ArrayList<JButton> buttons) {
        super((ArrayList<Integer>) numbers.clone(), (ArrayList<JButton>) buttons.clone());

    }

    public void sort2() {
        ArrayList<Integer> arr = new ArrayList<>(getNumarray());
        for (int i = 1; i < arr.size(); i++) {
            int j;
            int x = arr.get(i);
            for (j = i - 1; j >= 0; j--) {
                if (arr.get(i) > arr.get(j)) {
                    break;
                }
                arr.set(j + 1, arr.get(j));

            }
            arr.set(j + 1, x);
        }

    }

    public void sort() {
        JButton B1 = null, B2 = null;
        int sI = 0, sJ = 0;
        int r = 0, j;

        timer = new Timer(DELAY, new ISListener(sI, sJ));
        timer.start();

    }

    Timer getISTimer() {
        return this.timer;
    }

    private class ISListener implements ActionListener {

        private JButton B1;
        private JButton B2;
        private int k = 1, m = 1, j = 0, f = 0;
        private Integer x;

        ISListener(int i, int j) {

        }

        public void actionPerformed(ActionEvent event) {

            f = 0;
            for (int i = 1; i < getNumarray().size(); i++) {

                x = getNumarray().get(i);
                for (j = i - 1; j >= 0; j--) {

                    if (getNumarray().get(i) <= getNumarray().get(j)) {

                        Thread t = Thread.currentThread();
                        try {
                            t.sleep(700);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(InsertionSort.class.getName()).log(Level.SEVERE, null, ex);
                        }

                        getButtonArr().get(j + 1).setText(getNumarray().get(j).toString());
                        getNumarray().set(j + 1, getNumarray().get(j));

                    } else {
                        break;
                    }

                }
                getButtonArr().get(j + 1).setText(x.toString());
                getNumarray().set(j + 1, x);

            }

        }
    }

}
