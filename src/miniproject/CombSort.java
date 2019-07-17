
package miniproject;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.lang.Integer.max;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.Timer;

/**
 *
 * @author User
 */
public class CombSort extends Sort{
    private Timer timer;
    private final int DELAY = 15;
    private int flag=0;
    private int complete=0;
    private ArrayList<Integer> num;
    private JButton nb[];

    CombSort(ArrayList<Integer> numbers, ArrayList<JButton> buttons) {
        super((ArrayList<Integer>)numbers.clone(), (ArrayList<JButton>)buttons.clone());

    }
    void sort2(){
       
        ArrayList<Integer>arr=new ArrayList<>(getNumarray());
        
        int flag=1;
        int gap=arr.size();
        while(gap!=1||flag==1){
            System.out.println(gap);
            gap=max(1,(int)(gap/1.3));
            
            flag=0;
            for(int i=0;i<arr.size()-gap;i++){
                if(arr.get(i)>arr.get(i+gap)){
                    int temp=arr.get(i);
                    arr.set(i,arr.get(i+gap));
                    arr.set(i+gap,temp);
                    flag=1;
                }
            }
            
        }
     
    }
    public void sort()  {
        JButton B1 = null, B2 = null;
        int sI=0,sJ=0;
        int r=0;
        int gap=getNumarray().size();
        int flag=1,f=0;
        while(gap!=1 || flag==1){
            gap=max(1,(int)(gap/1.3));
            flag=0;
            for(int i=0;i<getNumarray().size()-gap;i++){
                if(getNumarray().get(i)>getNumarray().get(i+gap)){
                swap(getButtonArr().get(i),getButtonArr().get(i+gap));

                                JButton b = getButtonArr().get(i);
                                getButtonArr().set(i, getButtonArr().get(i+gap));
                                getButtonArr().set(i+gap, b);


                                int aa = getNumarray().get(i);
                                getNumarray().set(i, getNumarray().get(i+gap));
                                getNumarray().set(i+gap, aa);
                                f=1;
                                break;}
            }
            if(f==1) break;
        }
       
        timer = new Timer(DELAY, new BSListener(gap,flag));
        timer.start();



    }

    Timer getBSTimer(){
        return this.timer;
    }
    private class BSListener implements ActionListener {

        private JButton B1;
        private JButton B2;
        private int k=1,m=0;
        private int gap,flag,x=0;
        BSListener(int gap,int flag){
            this.gap=gap;
            this.flag=flag;
        }
        public void actionPerformed(ActionEvent event) {
            if (getTimer() != null && getTimerUp() != null && getTimerDn() != null) {
                if (!getTimer().isRunning() && !getTimerUp().isRunning() && !getTimerDn().isRunning()) {

                    while(gap!=1||flag==1){
                      
                        if(x==1){
                            gap=max(1,(int)(gap/1.3));
                        }
                        x=0;
                        flag=0;
                        for(int i=0;i<getNumarray().size()-gap;i++){
                            if(i==getNumarray().size()-gap-1) x=1;
                            if(getNumarray().get(i)>getNumarray().get(i+gap)){
                                flag=1;
                                swap(getButtonArr().get(i),getButtonArr().get(i+gap));

                                JButton b = getButtonArr().get(i);
                                getButtonArr().set(i, getButtonArr().get(i+gap));
                                getButtonArr().set(i+gap, b);


                                int aa = getNumarray().get(i);
                                getNumarray().set(i, getNumarray().get(i+gap));
                                getNumarray().set(i+gap, aa);
                                
                            }
                         if (getTimer().isRunning() || getTimerUp().isRunning() || getTimerDn().isRunning()) break;
                             
                    }
                        if (getTimer().isRunning() || getTimerUp().isRunning() || getTimerDn().isRunning()) break;
                          
                }
            }
            }
        }
        
    }
}
