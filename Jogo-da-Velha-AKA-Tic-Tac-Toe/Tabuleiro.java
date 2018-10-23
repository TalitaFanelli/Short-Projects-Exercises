public class Tabuleiro implements Cloneable
{
    // a principio, toda igual a null
    protected Marca matriz [][] = new Marca [3][3];

    public boolean haMarcaNaPosicao (int lin, int col) throws Exception
    {
        // verifico se em this.matriz[lin][col] tem null, retornando false em caso afirmativo, ou true em caso negativo
    	
    	if(this.matriz[lin][col] == null) {
    		return false;
    	}
    	
    	return true;
    }

    public Marca getMarcaNaPosicao (int lin, int col) throws Exception //lin e col já foram validadas nas classes Jogador Humano e Automatico 
    {
        // retornar a marca que tem em this.matriz[lin][col], validando
    	
    	return this.matriz[lin][col];
    }

    public void setMarcaNaPosicao (Marca mrc, int lin, int col) throws Exception //marca, lin e col já foram validadas nas classes Jogador Humano e Automatico
    {
        // colocar mrc em this.matriz[lin][col], validando
  
    	this.matriz[lin][col] = mrc;    
    }

    public String toString ()
    {
        String saida = "   0   1   2  \n +---+---+---+";

        for (int lin=0; lin<3; lin++)
        {
            saida = saida + '\n' + lin;

            for (int col=0; col<3; col++)
               saida = saida + "| " +
                       (this.matriz[lin][col]!=null?
                        this.matriz[lin][col].getSimbolo():' ') + ' ';

            saida = saida + "|\n +---+---+---+";
        }

        return saida;
    }

    public boolean equals (Object obj)
    {
        // verificar se this e obj sao iguais em conteudo, retornando true ou false, conforme o caso
    	
        	if(this == obj){
        		return true;
        	}
        	
        	if(obj == null){
        		return false;
        	}
        	
    		if (this.getClass() != obj.getClass()){
    			return false;
    		}
    		
    		Tabuleiro tabObj = (Tabuleiro) obj;

    		if(this.matriz.length != tabObj.matriz.length) { //se a quantidade de linhas são diferentes
    			return false;
    		}
    		
    		if(this.matriz[0].length != tabObj.matriz[0].length) { //se a quantidade de colunas são diferentes
    			return false;
    		}
    		
    		for(int x = 0; x < this.matriz.length; x++){
        		for(int y = 0; y < this.matriz[0].length; y++){
        			if(this.matriz[x][y] != tabObj.matriz[x][y]){
        				return false;
        			}
        		}
    		}
    		
    		return true;
    }
}