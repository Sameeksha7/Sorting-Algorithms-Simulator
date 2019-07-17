/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniproject;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

public class ExchangeSort extends Sort {

    private Timer timer;
    private final int DELAY = 5;
    private int flag = 0;
    private int complete = 0;
    private ArrayList<Integer> num;
    private JButton nb[];

    ExchangeSort(ArrayList<Integer> numbers, ArrayList<JButton> buttons) {
        super((ArrayList<Integer>) numbers.clone(), (ArrayList<JButton>) buttons.clone());

    }

    public void sort2() {
        ArrayList<Integer> arr = new ArrayList<>(getNumarray());

        for (int i = 0; i < arr.size(); i++) {
            for (int j = i; j < arr.size(); j++) {
                if (arr.get(i) > arr.get(j)) {
                    int temp = arr.get(i);
                    arr.set(i, arr.get(j));
                    arr.set(j, temp);
                }
            }
        }
    }

    public void sort() {

        timer = new Timer(DELAY, new BSListener());
        timer.start();

    }

    Timer getSSTimer() {
        return this.timer;
    }

    private class BSListener implements ActionListener {

        private JButton B1;
        private JButton B2;

        public void actionPerformed(ActionEvent event) {
            if (getTimer() == null || getTimerUp() == null || getTimerDn() == null) {
                timer.stop();
            }
            if (getTimer() != null && getTimerUp() != null && getTimerDn() != null) {
                if (!getTimer().isRunning() && !getTimerUp().isRunning() && !getTimerDn().isRunning()) {

                    for (int i = 0; i < getNumarray().size(); i++) {

                        for (int j = i; j < getNumarray().size(); j++) {
                            if (i == getNumarray().size() - 1) {

                                timer.stop();
                                complete = 1;
                                break;

                            }

                            if (getNumarray().get(i) > getNumarray().get(j)) {

                                swap(getButtonArr().get(i), getButtonArr().get(j));
                                JButton b = getButtonArr().get(i);
                                getButtonArr().set(i, getButtonArr().get(j));
                                getButtonArr().set(j, b);

                                int aa = getNumarray().get(i);
                                getNumarray().set(i, getNumarray().get(j));
                                getNumarray().set(j, aa);

                            }

                            if (getTimer().isRunning() || getTimerUp().isRunning() || getTimerDn().isRunning()) {
                                break;
                            }

                        }
                        if (i == getNumarray().size() - 1) {
                            break;
                        }
                        if (getTimer().isRunning() || getTimerUp().isRunning() || getTimerDn().isRunning()) {
                            break;
                        }
                    }
                }

            }
        }
    }

    public int getComplete() {
        return complete;
    }

}
