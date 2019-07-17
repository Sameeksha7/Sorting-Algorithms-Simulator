package miniproject;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;
import static java.lang.Thread.sleep;

public class SelectionSort extends Sort {

    private Timer timer;
    private final int DELAY = 5;
    private int flag = 0;
    private int complete = 0;
    private ArrayList<Integer> num;
    private JButton nb[];

    SelectionSort(ArrayList<Integer> numbers, ArrayList<JButton> buttons) {
        super((ArrayList<Integer>) numbers.clone(), (ArrayList<JButton>) buttons.clone());

    }

    public int min(int m, int n) {
        int min = 100000;
        int ind = 0;
        for (int i = m; i < n; i++) {
            if (getNumarray().get(i) < min) {
                min = getNumarray().get(i);
                ind = i;
            }
        }
        return ind;
    }

    public void sort2() {
        ArrayList<Integer> arr = new ArrayList<>(getNumarray());
        int min;
        for (int i = 0; i < arr.size(); i++) {
            min = i;
            for (int j = i; j < arr.size(); j++) {
                if (arr.get(min) > arr.get(j)) {
                    min = j;

                }
            }
            int temp = arr.get(i);
            arr.set(i, arr.get(min));
            arr.set(min, temp);
        }
    }

    public void sort() {

        JButton B1 = null, B2 = null;
        int sI = 0, sJ = 0;

        timer = new Timer(DELAY, new BSListener(sI, sJ));
        timer.start();

    }

    Timer getSSTimer() {
        return this.timer;
    }

    private class BSListener implements ActionListener {

        private JButton B1;
        private JButton B2;
        private JButton B3 = getButtonArr().get(0);
        private int k = 1, m = 0, j, p = getNumarray().get(0), i = 0;

        BSListener(int i, int j) {

            m = 0;
            k = m + 1;
        }

        public void actionPerformed(ActionEvent event) {
            if (getTimer() == null || getTimerUp() == null || getTimerDn() == null) {
                timer.stop();
            }
            if (getTimer() != null && getTimerUp() != null && getTimerDn() != null) {
                if (!getTimer().isRunning() && !getTimerUp().isRunning() && !getTimerDn().isRunning()) {

                    if (i < getNumarray().size()) {

                        if (i == getNumarray().size()) {

                            timer.stop();
                            complete = 1;

                        }

                        for (j = i; j < getNumarray().size(); j++) {

                            if (getNumarray().get(i) > getNumarray().get(j)) {
                                int ind = min(j, getNumarray().size());
                                swap(getButtonArr().get(i), getButtonArr().get(ind));
                                swapNo(ind, i);
                            }

                        }

                        if (!getTimer().isRunning() && !getTimerUp().isRunning() && !getTimerDn().isRunning()) {
                            i++;
                        }
                    }
                    k = 0;
                }
            }

        }

    }

    public int getComplete() {
        return complete;
    }

}
