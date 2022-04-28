package jogo;

import java.util.Random;
public class Tabuleiro {
	// tabuleiro
		Random random = new Random(); // função random
		 
		private int linhas=9;
		private int colunas=9;
		public Tabuleiro() {
		}
		
		private int[][] tabuleiro = new int[linhas][colunas];
		 
		
		public int[][] getTabuleiro() {
			return tabuleiro;
		}

		public void setTabuleiro(int[][] tabuleiro) {
			this.tabuleiro = tabuleiro;
		}

		
		public void TabuleiroLimpo() {
			for(int i=0;i<linhas;i++) {
				for(int j=0;j<colunas;j++) {
					tabuleiro[i][j] = 0;
				}
			}
		}
		
		public void randomTabuleiro() {
			for(int i=0;i<linhas;i++) {
				for(int j=0;j<colunas;j++) {
					tabuleiro[i][j] = random.nextInt(9)+1;
					
					for(int erroLinha=0;erroLinha<j;erroLinha++) { // checkar se há numero igual na linha
						if(tabuleiro[i][erroLinha]==tabuleiro[i][j]) j--;
					} 
					
				}
				
				for(int j=0;j<colunas;j++) { //checkar se há numero igual na coluna
					for(int erroColuna=0;erroColuna<i;erroColuna++) {
						if(tabuleiro[erroColuna][j]==tabuleiro[i][j]) i--;
					}
				}
				
				//ainda falta deixar as submatrizes randomicas
				//for(int linha_x= i-(i%3);linha_x<3) 
				
				
			}
		}
		
		
		
		public boolean numeroRepetidoLinha(int x, int y, int n) {
			tabuleiro[x][y] = n;
			int repete=0;
			boolean r=false;
			for(int i=0; i<linhas; i++) {
				if(i!=x) {
					if(tabuleiro[i][y]==tabuleiro[x][y]) {
						repete++;
						System.out.println("igual na linha");
					}
				}
			}
			if(repete>0) r= true;
			return r;
		}
		
		public boolean numeroRepetidoColuna(int x, int y, int n) {
			tabuleiro[x][y] = n;
			boolean r=false;
			for(int i=0; i<linhas; i++) {
				if(i!=y) {
					if(tabuleiro[x][i]==tabuleiro[x][y]) {
						r=true;
						System.out.println("igual na coluna");
					}
				}
			}
			return r;
		}
		
		// criar um metodo para checkar se o numero é repetido na submatriz
		
		
		public void mostrarTabuleiro() {
			TabuleiroLimpo();
			randomTabuleiro();
			for(int i=0;i<linhas;i++) {
				for(int j=0;j<colunas;j++) {
					System.out.print(tabuleiro[i][j]);
					
				}
				System.out.println();
			}
			
		}
}
