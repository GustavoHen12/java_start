package Jogo;

import java.util.Arrays;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Tabuleiro {
    private final int rows = 15;
    private final int collumn = 17;

    private char [][]  screen = new char[rows][collumn];
    
	JFrame frame = new JFrame("Tetris");    
    
	Tabuleiro() {

		final JLabel label = new JLabel(screen.toString());
		frame.getContentPane().add(label);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
		
    	for(int i = 0; i < rows; i++)
    		Arrays.fill(this.screen[i], ' ');
    }

    public void imprime(pecas pecaImprime){
    	
    	char [][] sprite = pecaImprime.getSprite();
    	int[] pos = pecaImprime.getPosition();
  
    	int tamX = sprite.length, tamY=sprite[0].length;
    	
    	int k = 0, l = 0;
    	//limpa terminal
    	System.out.print("\033[H\033[2J");
    	System.out.flush();
    	
        for(int i = 0; i <= collumn+1; i++) System.out.print("~");
        System.out.println();
        for(int i = 0; i < rows; i++){
            System.out.printf("!");
            for(int j = 0; j<collumn; j++){
            	if(i>=pos[0] && i<(pos[0]+tamX)){
            		if(j>=pos[1] && j<(pos[1]+tamY)) {
            			System.out.print(sprite[k][l]);
            			l++;
            			if(l >= tamY) {
            				l = 0;
            				k++;
            			}
            		}
            		else {
                        System.out.print(screen[i][j]);
            		}
            	}
            	else {
                System.out.print(screen[i][j]);
            	}
            }
            System.out.printf("!\n");
        }
        for(int i = 0; i <= collumn+1; i++) System.out.print("~");
        System.out.println();
    }    

    public void copiaParaTabuleiro(pecas pecaCopia) {
    	int[] pos = pecaCopia.getPosition();
    	char[][] sprite = pecaCopia.getSprite();
    	int k = 0, l = 0;
    	for(int i = pos[0]; i <= (pos[0] + sprite.length - 1); i++) {
    		l = 0;
    		for(int j = pos[1]; j <= (pos[1] + sprite[0].length - 1); j++) {
    			this.screen[i][j] = sprite[k][l];
    			l++;
    		}
    		k++;
    	}
    }
    
    public boolean verificaColisao(pecas pecaVerifica) {
		int[] pos = pecaVerifica.getPosition();
		int sizeX = (pecaVerifica.getSprite()).length;
    	int sizeY = (pecaVerifica.getSprite())[0].length;
    	
		//verifica se chegou no fundo
    	if(pos[0] + (sizeX - 1) >= rows - 1)
    		return true;
    	
    	//verifica se a parte de baixo esta encostando em
    	//alguma peca
    	for(int i = pos[0]; i < pos[0] + sizeX; i++) {
    		for (int j = pos[1]; j < pos[1] + sizeY ; j++) {
    			if(i < rows)
    				if(this.screen[i+1][j] != ' ')
    					return true;
    		}
    	}
    	
    	return false;
    }
    
    public int verificaLinhas() {
    	return 0;
    }
}
