import java.io.IOException;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.lang.Thread;
import Jogo.Jogo;

public class Tetris {
	//InputThread background = new InputThread(this).start();
	
	
	public static void main(final String... args) throws IOException
	{
        Jogo test = new Jogo();   
        
        JFrame f = new JFrame("Tetris");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(12*26+10, 26*23+25);
		f.setVisible(true);
		
         
        while(true) {

        	test.ciclo();
        	try { Thread.sleep(500); } catch (InterruptedException ex) {}
        }
    }
	
	public static void print(int text) {
        System.out.println(text);
	}
	
	private static Runnable read = new Runnable() {
        public void run() {
            try {
				print(System.in.read());
			} catch (IOException e) {
				e.printStackTrace();
			}
        }
    };
}