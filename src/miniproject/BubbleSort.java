package miniproject;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

public class BubbleSort extends Sort {

    private Timer timer;
    private final int DELAY = 20;
    private int flag = 0;

    BubbleSort(ArrayList<Integer> numbers, ArrayList<JButton> buttons) {
        super(new ArrayList<>(numbers), new ArrayList<>(buttons));

    }

    public void sort2() {
        ArrayList<Integer> arr = new ArrayList<>(getNumarray());
        int flag = 0;
        for (int i = 0; i < arr.size() - 1; i++) {
            flag = 0;
            for (int j = 0; j < arr.size() - i - 1; j++) {
                if (arr.get(j) > arr.get(j + 1)) {
                    flag = 1;
                    int temp = arr.get(i);
                    arr.set(i, arr.get(j));
                    arr.set(j, temp);
                }
            }
            if (flag == 0) {
                break;
            }
        }
    }

    public void sort() {
        timer = new Timer(DELAY, new BSListener());
        timer.start();
    }

    Timer getBSTimer() {
        return this.timer;
    }

    private class BSListener implements ActionListener {

        private JButton B1;
        private JButton B2;
        private int k = 0, m = 0;

        public void actionPerformed(ActionEvent event) {
            if (getTimer() != null && getTimerUp() != null && getTimerDn() != null) {
                if (!getTimer().isRunning() && !getTimerUp().isRunning() && !getTimerDn().isRunning()) {

                    for (int i = m; i < getNumarray().size() - 1; i++) {

                        for (int j = k; j < getNumarray().size() - i - 1; j++) {

                            if (getNumarray().get(j) > getNumarray().get(j + 1)) {

                                swap(getButtonArr().get(j), getButtonArr().get(j + 1));

                                JButton b = getButtonArr().get(j);
                                getButtonArr().set(j, getButtonArr().get(j + 1));
                                getButtonArr().set(j + 1, b);

                                int aa = getNumarray().get(j);
                                getNumarray().set(j, getNumarray().get(j + 1));
                                getNumarray().set(j + 1, aa);

                            }

                            if (k == getNumarray().size() - i - 2) {
                                m++;
                                k = 0;
                            } else {
                                k++;
                            }

                            if (i == getNumarray().size() - 2) {
                                timer.stop();
                            }

                            if (getTimer().isRunning() || getTimerUp().isRunning() || getTimerDn().isRunning()) {
                                break;
                            }
                        }

                        if (getTimer().isRunning() || getTimerUp().isRunning() || getTimerDn().isRunning()) {
                            break;
                        }

                    }
                }

            }
        }
    }
}
