package Jogo;

public class Jogo {
	Tabuleiro tabuleiro = new Tabuleiro();
	pecas pecaAtiva = new pecaT7(12, 10);
	
	public void imprime() {
		tabuleiro.imprime(pecaAtiva);
	}
	
	public boolean ciclo() {
		pecaAtiva.moveY();
		if(tabuleiro.verificaColisao(pecaAtiva))
		{
			tabuleiro.copiaParaTabuleiro(pecaAtiva);
			pecaAtiva = new pecaT1(0, 10);
		}
		tabuleiro.imprime(pecaAtiva);
		return true;
	}
}

class pecaT1 extends pecas{
	pecaT1(int iniX, int iniY){
		this.posX = iniX;
		this.posY = iniY;
		char[][] spritet1 = {{'#','#'},{'#', '#'}};
		this.sprite = spritet1;
	}
}

class pecaT2 extends pecas{
	
	pecaT2(int iniX, int iniY){
		this.posX = iniX;
		this.posY = iniY;
		char[][] spritet2 = {{'#'},{'#'},{'#'}, {'#'}};
		this.sprite = spritet2;
	}
}

class pecaT3 extends pecas{
	pecaT3(int iniX, int iniY){
		this.posX = iniX;
		this.posY = iniY;
		char[][] spritet3 = {{' ', 'z','z'},{'z', 'z', ' '}};
		this.sprite = spritet3;
	}
}

class pecaT7 extends pecas{
	pecaT7(int iniX, int iniY){
		this.posX = iniX;
		this.posY = iniY;
		char[][] spritet7 = {{' ','u', ' '},{'u','u', 'u'}};
		this.sprite = spritet7;
	}
}