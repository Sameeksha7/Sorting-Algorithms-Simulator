/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniproject;

/**
 *
 * @author User
 */
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class QuickSort extends Sort {

    private Timer timer, timer1;
    private final int DELAY = 20;
    private int flag = 0;
    private int complete = 0;
    private ArrayList<Integer> num;
    private JButton nb[];
    private int part;

    QuickSort(ArrayList<Integer> numbers, ArrayList<JButton> ButtonArr) {
        super(numbers, ButtonArr);
    }

    void sort2() {
        ArrayList<Integer> arr = new ArrayList<>(getNumarray());
        sorting(0, arr.size() - 1, arr);
        for (int i : arr) {
            System.out.println("hi " + i);
        }
    }

    void sorting(int l, int h, ArrayList<Integer> arr) {
        if (l < h) {
            int x = partition2(l, h, arr);
            sorting(l, x - 1, arr);
            sorting(x + 1, h, arr);
        }
    }

    int partition2(int l, int h, ArrayList<Integer> arr) {
        for (int j = l; j < h; j++) {
            if (arr.get(j) < arr.get(h)) {
                int temp = arr.get(l);
                arr.set(l, arr.get(j));
                arr.set(j, temp);
                l++;
            }
        }
        int temp = arr.get(l);
        arr.set(l, arr.get(h));
        arr.set(h, temp);
        return l;
    }

    public void swapNo(int i, int j) {

        int a = this.getNumarray().get(i);
        this.getNumarray().set(i, this.getNumarray().get(j));
        this.getNumarray().set(j, a);

        JButton jb = this.getButtonArr().get(i);
        this.getButtonArr().set(i, this.getButtonArr().get(j));
        this.getButtonArr().set(j, jb);
    }

    public void partition(int low, int high) {

        ActionListener QS = new QSListener(low, high);
        timer = new Timer(5, QS);

        timer.start();

    }

    Timer getQSTimer() {
        return timer1;
    }

    public void sort(int low, int high) {
        if (low < high) {

            partition(low, high);

            timer1 = new Timer(5, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    if (!timer.isRunning() && !getTimer().isRunning() && !getTimerUp().isRunning() && !getTimerDn().isRunning()) {

                        timer.stop();
                        sort(low, part - 1);
                        sort(part + 1, high);
                    }
                }
            });
            timer1.start();

        }

    }

    public class QSListener implements ActionListener {

        private int low;
        private int high;
        private int returnValue;
        private int i, j;
        private int flag = 0;
        private int piv;

        QSListener(int low, int high) {
            this.low = low;
            this.high = high;
            i = low - 1;
            j = low;
            piv = getNumarray().get(high);
        }

        @Override
        public void actionPerformed(ActionEvent actionEvent) {

            if (j <= high - 1) {

                if (!getTimer().isRunning() && !getTimerUp().isRunning() && !getTimerDn().isRunning()) {

                    if (getNumarray().get(j) <= piv) {
                        i++;

                        if (i != j) {

                            swap(getButtonArr().get(i), getButtonArr().get(j));
                        }

                        swapNo(i, j);

                    }
                    low = j + 1;
                    j = j + 1;

//                    break;
                }
            }

            if (!getTimer().isRunning() && !getTimerUp().isRunning() && !getTimerDn().isRunning() && low == high) {

                if (i + 1 != high && getButtonArr().get(high) != getButtonArr().get(i + 1)) {
                    swap(getButtonArr().get(i + 1), getButtonArr().get(high));
                }
                swapNo(high, i + 1);
                flag = 1;
                timer.stop();
                part = i + 1;
            }

        }

        public int getReturnValue() {
            return returnValue;
        }

        public int getFlagValue() {
            return flag;
        }
    }

}
