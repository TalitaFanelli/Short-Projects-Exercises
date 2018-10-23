public class AnalistaSituacional
{
	protected Tabuleiro tabDoJogo;

	public AnalistaSituacional (Tabuleiro tab) throws Exception
	{
		// colocar tab em this.tabDoJogo

		this.tabDoJogo = tab;
	}

	public Marca getMarcaDoVencedor ()
	{
		// descobrir se ha um vencedor e retornar a marca dele; retornara null, quando nao houver vencedor
		
		try {	
			
			//Se na linha 0 todas as colunas estão marcadas -> Vitória na linha
			
			if(this.tabDoJogo.haMarcaNaPosicao(0, 0) == true && this.tabDoJogo.haMarcaNaPosicao(0, 1) == true && this.tabDoJogo.haMarcaNaPosicao(0, 2) == true) {
				//Se todas as marcações são iguais
				if( this.tabDoJogo.getMarcaNaPosicao(0, 0).equals(this.tabDoJogo.getMarcaNaPosicao(0, 1)) &&
					this.tabDoJogo.getMarcaNaPosicao(0, 0).equals(this.tabDoJogo.getMarcaNaPosicao(0, 2))){
					return this.tabDoJogo.getMarcaNaPosicao(0, 0);
				}
			}
			
			//Se na coluna 0 todas as linhas estão marcadas -> Vitória na coluna
			if(this.tabDoJogo.haMarcaNaPosicao(0, 0) == true && this.tabDoJogo.haMarcaNaPosicao(1, 0) == true && this.tabDoJogo.haMarcaNaPosicao(2, 0) == true) {
				//Se todas as marcações são iguais
				if( this.tabDoJogo.getMarcaNaPosicao(0, 0).equals(this.tabDoJogo.getMarcaNaPosicao(1, 0)) &&
					this.tabDoJogo.getMarcaNaPosicao(0, 0).equals(this.tabDoJogo.getMarcaNaPosicao(2, 0))){
					return this.tabDoJogo.getMarcaNaPosicao(0, 0);
				}
			}
			
			//Se na coluna 0 todas as linhas estão marcadas -> Vitória na diagonal
			if(this.tabDoJogo.haMarcaNaPosicao(0, 0) == true && this.tabDoJogo.haMarcaNaPosicao(1, 1) == true && this.tabDoJogo.haMarcaNaPosicao(2, 2) == true) {
				//Se todas as marcações são iguais
				if( this.tabDoJogo.getMarcaNaPosicao(0, 0).equals(this.tabDoJogo.getMarcaNaPosicao(1, 1)) &&
					this.tabDoJogo.getMarcaNaPosicao(0, 0).equals(this.tabDoJogo.getMarcaNaPosicao(2, 2))){
					return this.tabDoJogo.getMarcaNaPosicao(0, 0);
				}
			}

			//Se na linha 1 todas as colunas estão marcadas -> Vitória na linha
			if(this.tabDoJogo.haMarcaNaPosicao(1, 0) == true && this.tabDoJogo.haMarcaNaPosicao(1, 1) == true && this.tabDoJogo.haMarcaNaPosicao(1, 2) == true) {
				//Se todas as marcações são iguais
				if( this.tabDoJogo.getMarcaNaPosicao(1, 0).equals(this.tabDoJogo.getMarcaNaPosicao(1, 1)) &&
					this.tabDoJogo.getMarcaNaPosicao(1, 0).equals(this.tabDoJogo.getMarcaNaPosicao(1, 2))){
					return this.tabDoJogo.getMarcaNaPosicao(1, 0);
				}
			}
			
			//Se na coluna 1 todas as linhas estão marcadas -> Vitória na coluna
			if(this.tabDoJogo.haMarcaNaPosicao(0, 1) == true && this.tabDoJogo.haMarcaNaPosicao(1, 1) == true && this.tabDoJogo.haMarcaNaPosicao(2, 1) == true) {
				//Se todas as marcações são iguais
				if( this.tabDoJogo.getMarcaNaPosicao(0, 1).equals(this.tabDoJogo.getMarcaNaPosicao(1, 1)) &&
					this.tabDoJogo.getMarcaNaPosicao(0, 1).equals(this.tabDoJogo.getMarcaNaPosicao(2, 1))){
					return this.tabDoJogo.getMarcaNaPosicao(0, 1);
				}
			}
			
			//Se na linha 2 todas as colunas estão marcadas -> Vitória na linha
			if(this.tabDoJogo.haMarcaNaPosicao(2, 0) == true && this.tabDoJogo.haMarcaNaPosicao(2, 1) == true && this.tabDoJogo.haMarcaNaPosicao(2, 2) == true) {
				//Se todas as marcações são iguais
				if( this.tabDoJogo.getMarcaNaPosicao(2, 0).equals(this.tabDoJogo.getMarcaNaPosicao(2, 1)) &&
					this.tabDoJogo.getMarcaNaPosicao(2, 0).equals(this.tabDoJogo.getMarcaNaPosicao(2, 2))){
					return this.tabDoJogo.getMarcaNaPosicao(2, 0);
				}
			}
			
			//Se na coluna 2 todas as linhas estão marcadas -> Vitória na coluna
			if(this.tabDoJogo.haMarcaNaPosicao(0, 2) == true && this.tabDoJogo.haMarcaNaPosicao(1, 2) == true && this.tabDoJogo.haMarcaNaPosicao(2, 2) == true) {
				//Se todas as marcações são iguais
				if( this.tabDoJogo.getMarcaNaPosicao(0, 2).equals(this.tabDoJogo.getMarcaNaPosicao(1, 2)) &&
					this.tabDoJogo.getMarcaNaPosicao(0, 2).equals(this.tabDoJogo.getMarcaNaPosicao(2, 2))){
					return this.tabDoJogo.getMarcaNaPosicao(0, 2);
				}
			}
			
			//Se na coluna 2 todas as linhas estão marcadas -> Vitória na diagonal
			if(this.tabDoJogo.haMarcaNaPosicao(0, 2) == true && this.tabDoJogo.haMarcaNaPosicao(1, 1) == true && this.tabDoJogo.haMarcaNaPosicao(2, 0) == true) {
				//Se todas as marcações são iguais
				if( this.tabDoJogo.getMarcaNaPosicao(0, 2).equals(this.tabDoJogo.getMarcaNaPosicao(1, 1)) &&
					this.tabDoJogo.getMarcaNaPosicao(0, 2).equals(this.tabDoJogo.getMarcaNaPosicao(2, 0))){
					return this.tabDoJogo.getMarcaNaPosicao(0, 2);
				}
			}
		} 
		catch (Exception e) 
		{} //sei que não vai ter erro

		return null;
	}

	private boolean tabuleiroCheio ()
	{
		// verificar se todas as posicoes do tabuleiro estao preenchidas (!=null) retornando true em caso afirmativo, ou false em caso negativo

		try {
			for(int x = 0; x < this.tabDoJogo.matriz.length; x++) {
				for(int y = 0; y < this.tabDoJogo.matriz[0].length; y++) {
					if(this.tabDoJogo.getMarcaNaPosicao(x, y) == null) {
						return false;
					}
				}
			}
		}

		catch(Exception e) 
		{} //sei que não vai ter erro

		return true;
	}

	public boolean fimDeJogo ()
	{
		// se getMarcaDoVencedor != null, retorna true se tabuleiroCheio == true, retorna true caso contrario, retorna false
		
		System.out.println(toString());
		
		if(getMarcaDoVencedor() != null) {
			return true;
		}
		
		if(tabuleiroCheio() == true) {
			return true;
		}
		
		else {
			return false;
		}
	}

	public String toString ()
	{
		// produzir e retornar um String contendo o tabuleiro seguido de uma menção do seu estado do tabuleiro (jogo encerrado com vencedor, jogo encerrado sem vencedor ou
		// jogo que pode ser continuado
		
		if(tabuleiroCheio() == true) {			
			return "SITUAÇÃO: Jogo encerrado sem vencedor!\n";
		}
		
		else if(getMarcaDoVencedor() != null) {
			return "SITUAÇÃO: Jogo encerrado com vencedor!\n";
		}
		
		else {
			return "SITUAÇÃO: Jogo pode ser continuado!\n";
		}
	}

	public boolean equals (Object obj)
	{
		// verificar se o conteudo de this e obj sao
		// iguais, retornando true em caso afirmativo,
		// ou false em caso negativo
		
    	if (this==obj)
			return true;
		
		if (obj==null)
			return false;
		
		if (this.getClass() != obj.getClass())
			return false;
		
		AnalistaSituacional as = (AnalistaSituacional) obj;
        
        if (this.tabDoJogo.equals(as.tabDoJogo) == false)
            return false;
		
		return true;
	}
}