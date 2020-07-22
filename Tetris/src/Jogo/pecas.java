package Jogo;

import java.awt.event.KeyEvent;

public abstract class pecas {
	//posicao do canto superior esquerdo
	protected int posX, posY;
	
	protected char[][] sprite;
	
	protected boolean inGame;
	
	//retorna o sprite da peca
	public char[][] getSprite(){
		return this.sprite;
	}
	
	//retorna posicao da peca
	public int[] getPosition() {
		int[] pos = new int[2];
		pos[0] = this.posX;
		pos[1] = this.posY;
		return pos;
	}
	
	//verifica se e a peca que esta no jogo (em movimento)
	public boolean isInGame() {
		return this.inGame;
	}
	
	//avanca uma posicao eixo Y
	public void moveY() {
		this.posX += 1;
	}
	
	//+1 -> vai para direita
	//-1 -> vai para esquerda
	public void moveX(int direcao) {
		if(direcao < 0)
			this.posY = this.posY == 0 ? this.posY : (this.posY+direcao);
		else
			this.posY += direcao;
	}
	
	public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            moveX(-1);
        }

        if (key == KeyEvent.VK_RIGHT) {
            moveX(1);
        }

        if (key == KeyEvent.VK_UP) {
            System.out.print("gira");
        }

        if (key == KeyEvent.VK_DOWN) {
            moveY();
        }
    }
//	gira {}
//	
}
