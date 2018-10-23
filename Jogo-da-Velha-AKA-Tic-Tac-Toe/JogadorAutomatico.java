
public class JogadorAutomatico
{
    protected Marca     marca     = null;
    protected Tabuleiro tabDoJogo = null;

    public JogadorAutomatico (Tabuleiro tab) throws Exception
    {
        // atribuir tab para this.tabDoJogo fazer o jogador escolher via sorteio de numeros aleatorio
    	this.tabDoJogo = tab;
    	
    	if((int)(Math.random()*2) == 0) {
    		this.marca = new Marca('X');
    	}
    	
    	else {
    		this.marca = new Marca('O');
    	}
    }

    public JogadorAutomatico (Tabuleiro tab, Marca mrc) throws Exception
    {
        // atribuir tab para this.tabDoJogo e mrc para this.marca
    	
    	this.tabDoJogo = tab;
    	this.marca = mrc;
    }

    public Marca getMarca ()
    {
        // retorna a marca do jogador
    	return this.marca;
    }

    public void facaSuaJogada ()
    {
    	System.out.println("Sua vez " + toString() + ", aqui está o tabuleiro:\n");
    	
    	System.out.println(this.tabDoJogo.toString() + "\n");
    	
        try
        {
            // tentando ganhar na linha 0
            if (this.tabDoJogo.matriz[0][0]==null &&
                this.tabDoJogo.matriz[0][1]!=null && this.tabDoJogo.matriz[0][1].equals(this.marca) &&
                this.tabDoJogo.matriz[0][2]!=null && this.tabDoJogo.matriz[0][2].equals(this.marca))
                this.tabDoJogo.setMarcaNaPosicao(this.marca, 0,0);
            else
            if (this.tabDoJogo.matriz[0][0]!=null && this.tabDoJogo.matriz[0][0].equals(this.marca) &&
                this.tabDoJogo.matriz[0][1]==null &&
                this.tabDoJogo.matriz[0][2]!=null && this.tabDoJogo.matriz[0][2].equals(this.marca))
                this.tabDoJogo.setMarcaNaPosicao(this.marca, 0,1);
            else
            if (this.tabDoJogo.matriz[0][0]!=null && this.tabDoJogo.matriz[0][0].equals(this.marca) &&
                this.tabDoJogo.matriz[0][1]!=null && this.tabDoJogo.matriz[0][1].equals(this.marca) &&
                this.tabDoJogo.matriz[0][2]==null)
                this.tabDoJogo.setMarcaNaPosicao(this.marca, 0,2);
            else
            // tentando ganhar na linha 1
            if (this.tabDoJogo.matriz[1][0]==null &&
                this.tabDoJogo.matriz[1][1]!=null && this.tabDoJogo.matriz[1][1].equals(this.marca) &&
                this.tabDoJogo.matriz[1][2]!=null && this.tabDoJogo.matriz[1][2].equals(this.marca))
                this.tabDoJogo.setMarcaNaPosicao(this.marca, 1,0);
            else
            if (this.tabDoJogo.matriz[1][0]!=null && this.tabDoJogo.matriz[1][0].equals(this.marca) &&
                this.tabDoJogo.matriz[1][1]==null &&
                this.tabDoJogo.matriz[1][2]!=null && this.tabDoJogo.matriz[1][2].equals(this.marca))
                this.tabDoJogo.setMarcaNaPosicao(this.marca, 1,1);
            else
            if (this.tabDoJogo.matriz[1][0]!=null && this.tabDoJogo.matriz[1][0].equals(this.marca) &&
                this.tabDoJogo.matriz[1][1]!=null && this.tabDoJogo.matriz[1][1].equals(this.marca) &&
                this.tabDoJogo.matriz[1][2]==null)
                this.tabDoJogo.setMarcaNaPosicao(this.marca, 1,2);
            else
            // tentando ganhar na linha 2
            if (this.tabDoJogo.matriz[2][0]==null &&
                this.tabDoJogo.matriz[2][1]!=null && this.tabDoJogo.matriz[2][1].equals(this.marca) &&
                this.tabDoJogo.matriz[2][2]!=null && this.tabDoJogo.matriz[2][2].equals(this.marca))
                this.tabDoJogo.setMarcaNaPosicao(this.marca, 2,0);
            else
            if (this.tabDoJogo.matriz[2][0]!=null && this.tabDoJogo.matriz[2][0].equals(this.marca) &&
                this.tabDoJogo.matriz[2][1]==null &&
                this.tabDoJogo.matriz[2][2]!=null && this.tabDoJogo.matriz[2][2].equals(this.marca))
                this.tabDoJogo.setMarcaNaPosicao(this.marca, 2,1);
            else
            if (this.tabDoJogo.matriz[2][0]!=null && this.tabDoJogo.matriz[2][0].equals(this.marca) &&
                this.tabDoJogo.matriz[2][1]!=null && this.tabDoJogo.matriz[2][1].equals(this.marca) &&
                this.tabDoJogo.matriz[2][2]==null)
                this.tabDoJogo.setMarcaNaPosicao(this.marca, 2,2);
            else
            // tentando ganhar na coluna 0
            if (this.tabDoJogo.matriz[0][0]==null &&
                this.tabDoJogo.matriz[1][0]!=null && this.tabDoJogo.matriz[1][0].equals(this.marca) &&
                this.tabDoJogo.matriz[2][0]!=null && this.tabDoJogo.matriz[2][0].equals(this.marca))
                this.tabDoJogo.setMarcaNaPosicao(this.marca, 0,0);
            else
            if (this.tabDoJogo.matriz[0][0]!=null && this.tabDoJogo.matriz[0][0].equals(this.marca) &&
                this.tabDoJogo.matriz[1][0]==null &&
                this.tabDoJogo.matriz[2][0]!=null && this.tabDoJogo.matriz[2][0].equals(this.marca))
                this.tabDoJogo.setMarcaNaPosicao(this.marca, 1,0);
            else
            if (this.tabDoJogo.matriz[0][0]!=null && this.tabDoJogo.matriz[0][0].equals(this.marca) &&
                this.tabDoJogo.matriz[1][0]!=null && this.tabDoJogo.matriz[1][0].equals(this.marca) &&
                this.tabDoJogo.matriz[2][0]==null)
                this.tabDoJogo.setMarcaNaPosicao(this.marca, 2,0);
            else
            // tentando ganhar na coluna 1
            if (this.tabDoJogo.matriz[0][1]==null &&
                this.tabDoJogo.matriz[1][1]!=null && this.tabDoJogo.matriz[1][1].equals(this.marca) &&
                this.tabDoJogo.matriz[2][1]!=null && this.tabDoJogo.matriz[2][1].equals(this.marca))
                this.tabDoJogo.setMarcaNaPosicao(this.marca, 0,1);
            else
            if (this.tabDoJogo.matriz[0][1]!=null && this.tabDoJogo.matriz[0][1].equals(this.marca) &&
                this.tabDoJogo.matriz[1][1]==null &&
                this.tabDoJogo.matriz[2][1]!=null && this.tabDoJogo.matriz[2][1].equals(this.marca))
                this.tabDoJogo.setMarcaNaPosicao(this.marca, 1,1);
            else
            if (this.tabDoJogo.matriz[0][1]!=null && this.tabDoJogo.matriz[0][1].equals(this.marca) &&
                this.tabDoJogo.matriz[1][1]!=null && this.tabDoJogo.matriz[1][1].equals(this.marca) &&
                this.tabDoJogo.matriz[2][1]==null)
                this.tabDoJogo.setMarcaNaPosicao(this.marca, 2,1);
            else
            // tentando ganhar na coluna 2
            if (this.tabDoJogo.matriz[0][2]==null &&
                this.tabDoJogo.matriz[1][2]!=null && this.tabDoJogo.matriz[1][2].equals(this.marca) &&
                this.tabDoJogo.matriz[2][2]!=null && this.tabDoJogo.matriz[2][2].equals(this.marca))
                this.tabDoJogo.setMarcaNaPosicao(this.marca, 0,2);
            else
            if (this.tabDoJogo.matriz[0][2]!=null && this.tabDoJogo.matriz[0][2].equals(this.marca) &&
                this.tabDoJogo.matriz[1][2]==null &&
                this.tabDoJogo.matriz[2][2]!=null && this.tabDoJogo.matriz[2][2].equals(this.marca))
                this.tabDoJogo.setMarcaNaPosicao(this.marca, 1,2);
            else
            if (this.tabDoJogo.matriz[0][2]!=null && this.tabDoJogo.matriz[0][2].equals(this.marca) &&
                this.tabDoJogo.matriz[1][2]!=null && this.tabDoJogo.matriz[1][2].equals(this.marca) &&
                this.tabDoJogo.matriz[2][2]==null)
                this.tabDoJogo.setMarcaNaPosicao(this.marca, 2,2);
            else
            // tentando ganhar na diagonal principal
            if (this.tabDoJogo.matriz[0][0]==null &&
                this.tabDoJogo.matriz[1][1]!=null && this.tabDoJogo.matriz[1][1].equals(this.marca) &&
                this.tabDoJogo.matriz[2][2]!=null && this.tabDoJogo.matriz[2][2].equals(this.marca))
                this.tabDoJogo.setMarcaNaPosicao(this.marca, 0,0);
            else
            if (this.tabDoJogo.matriz[0][0]!=null && this.tabDoJogo.matriz[0][0].equals(this.marca) &&
                this.tabDoJogo.matriz[1][1]==null &&
                this.tabDoJogo.matriz[2][2]!=null && this.tabDoJogo.matriz[2][2].equals(this.marca))
                this.tabDoJogo.setMarcaNaPosicao(this.marca, 1,1);
            else
            if (this.tabDoJogo.matriz[0][0]!=null && this.tabDoJogo.matriz[0][0].equals(this.marca) &&
                this.tabDoJogo.matriz[1][1]!=null && this.tabDoJogo.matriz[1][1].equals(this.marca) &&
                this.tabDoJogo.matriz[2][2]==null)
                this.tabDoJogo.setMarcaNaPosicao(this.marca, 2,2);
            else
            // tentando ganhar na diagonal secundaria
            if (this.tabDoJogo.matriz[0][2]==null &&
                this.tabDoJogo.matriz[1][1]!=null && this.tabDoJogo.matriz[1][1].equals(this.marca) &&
                this.tabDoJogo.matriz[2][0]!=null && this.tabDoJogo.matriz[2][0].equals(this.marca))
                this.tabDoJogo.setMarcaNaPosicao(this.marca, 0,2);
            else
            if (this.tabDoJogo.matriz[0][2]!=null && this.tabDoJogo.matriz[0][2].equals(this.marca) &&
                this.tabDoJogo.matriz[1][1]==null &&
                this.tabDoJogo.matriz[2][0]!=null && this.tabDoJogo.matriz[2][0].equals(this.marca))
                this.tabDoJogo.setMarcaNaPosicao(this.marca, 1,1);
            else
            if (this.tabDoJogo.matriz[0][2]!=null && this.tabDoJogo.matriz[0][2].equals(this.marca) &&
                this.tabDoJogo.matriz[1][1]!=null && this.tabDoJogo.matriz[1][1].equals(this.marca) &&
                this.tabDoJogo.matriz[2][0]==null)
                this.tabDoJogo.setMarcaNaPosicao(this.marca, 2,0);
            else
            // tentando atrapalhar vitoria na linha 0
            if (this.tabDoJogo.matriz[0][0]==null &&
                this.tabDoJogo.matriz[0][1]!=null && !this.tabDoJogo.matriz[0][1].equals(this.marca) &&
                this.tabDoJogo.matriz[0][2]!=null && !this.tabDoJogo.matriz[0][2].equals(this.marca))
                this.tabDoJogo.setMarcaNaPosicao(this.marca, 0,0);
            else
            if (this.tabDoJogo.matriz[0][0]!=null && !this.tabDoJogo.matriz[0][0].equals(this.marca) &&
                this.tabDoJogo.matriz[0][1]==null &&
                this.tabDoJogo.matriz[0][2]!=null && !this.tabDoJogo.matriz[0][2].equals(this.marca))
                this.tabDoJogo.setMarcaNaPosicao(this.marca, 0,1);
            else
            if (this.tabDoJogo.matriz[0][0]!=null && !this.tabDoJogo.matriz[0][0].equals(this.marca) &&
                this.tabDoJogo.matriz[0][1]!=null && !this.tabDoJogo.matriz[0][1].equals(this.marca) &&
                this.tabDoJogo.matriz[0][2]==null)
                this.tabDoJogo.setMarcaNaPosicao(this.marca, 0,2);
            else
            // tentando atrapalhar vitoria na linha 1
            if (this.tabDoJogo.matriz[1][0]==null &&
                this.tabDoJogo.matriz[1][1]!=null && !this.tabDoJogo.matriz[1][1].equals(this.marca) &&
                this.tabDoJogo.matriz[1][2]!=null && !this.tabDoJogo.matriz[1][2].equals(this.marca))
                this.tabDoJogo.setMarcaNaPosicao(this.marca, 1,0);
            else
            if (this.tabDoJogo.matriz[1][0]!=null && !this.tabDoJogo.matriz[1][0].equals(this.marca) &&
                this.tabDoJogo.matriz[1][1]==null &&
                this.tabDoJogo.matriz[1][2]!=null && !this.tabDoJogo.matriz[1][2].equals(this.marca))
                this.tabDoJogo.setMarcaNaPosicao(this.marca, 1,1);
            else
            if (this.tabDoJogo.matriz[1][0]!=null && !this.tabDoJogo.matriz[1][0].equals(this.marca) &&
                this.tabDoJogo.matriz[1][1]!=null && !this.tabDoJogo.matriz[1][1].equals(this.marca) &&
                this.tabDoJogo.matriz[1][2]==null)
                this.tabDoJogo.setMarcaNaPosicao(this.marca, 1,2);
            else
            // tentando atrapalhar vitoria na linha 2
            if (this.tabDoJogo.matriz[2][0]==null &&
                this.tabDoJogo.matriz[2][1]!=null && !this.tabDoJogo.matriz[2][1].equals(this.marca) &&
                this.tabDoJogo.matriz[2][2]!=null && !this.tabDoJogo.matriz[2][2].equals(this.marca))
                this.tabDoJogo.setMarcaNaPosicao(this.marca, 2,0);
            else
            if (this.tabDoJogo.matriz[2][0]!=null && !this.tabDoJogo.matriz[2][0].equals(this.marca) &&
                this.tabDoJogo.matriz[2][1]==null &&
                this.tabDoJogo.matriz[2][2]!=null && !this.tabDoJogo.matriz[2][2].equals(this.marca))
                this.tabDoJogo.setMarcaNaPosicao(this.marca, 2,1);
            else
            if (this.tabDoJogo.matriz[2][0]!=null && !this.tabDoJogo.matriz[2][0].equals(this.marca) &&
                this.tabDoJogo.matriz[2][1]!=null && !this.tabDoJogo.matriz[2][1].equals(this.marca) &&
                this.tabDoJogo.matriz[2][2]==null)
                this.tabDoJogo.setMarcaNaPosicao(this.marca, 2,2);
            else
            // tentando atrapalhar vitoria na coluna 0
            if (this.tabDoJogo.matriz[0][0]==null &&
                this.tabDoJogo.matriz[1][0]!=null && !this.tabDoJogo.matriz[1][0].equals(this.marca) &&
                this.tabDoJogo.matriz[2][0]!=null && !this.tabDoJogo.matriz[2][0].equals(this.marca))
                this.tabDoJogo.setMarcaNaPosicao(this.marca, 0,0);
            else
            if (this.tabDoJogo.matriz[0][0]!=null && !this.tabDoJogo.matriz[0][0].equals(this.marca) &&
                this.tabDoJogo.matriz[1][0]==null &&
                this.tabDoJogo.matriz[2][0]!=null && !this.tabDoJogo.matriz[2][0].equals(this.marca))
                this.tabDoJogo.setMarcaNaPosicao(this.marca, 1,0);
            else
            if (this.tabDoJogo.matriz[0][0]!=null && !this.tabDoJogo.matriz[0][0].equals(this.marca) &&
                this.tabDoJogo.matriz[1][0]!=null && !this.tabDoJogo.matriz[1][0].equals(this.marca) &&
                this.tabDoJogo.matriz[2][0]==null)
                this.tabDoJogo.setMarcaNaPosicao(this.marca, 2,0);
            else
            // tentando atrapalhar vitoria na coluna 1
            if (this.tabDoJogo.matriz[0][1]==null &&
                this.tabDoJogo.matriz[1][1]!=null && !this.tabDoJogo.matriz[1][1].equals(this.marca) &&
                this.tabDoJogo.matriz[2][1]!=null && !this.tabDoJogo.matriz[2][1].equals(this.marca))
                this.tabDoJogo.setMarcaNaPosicao(this.marca, 0,1);
            else
            if (this.tabDoJogo.matriz[0][1]!=null && !this.tabDoJogo.matriz[0][1].equals(this.marca) &&
                this.tabDoJogo.matriz[1][1]==null &&
                this.tabDoJogo.matriz[2][1]!=null && !this.tabDoJogo.matriz[2][1].equals(this.marca))
                this.tabDoJogo.setMarcaNaPosicao(this.marca, 1,1);
            else
            if (this.tabDoJogo.matriz[0][1]!=null && !this.tabDoJogo.matriz[0][1].equals(this.marca) &&
                this.tabDoJogo.matriz[1][1]!=null && !this.tabDoJogo.matriz[1][1].equals(this.marca) &&
                this.tabDoJogo.matriz[2][1]==null)
                this.tabDoJogo.setMarcaNaPosicao(this.marca, 2,1);
            else
            // tentando atrapalhar vitoria na coluna 2
            if (this.tabDoJogo.matriz[0][2]==null &&
                this.tabDoJogo.matriz[1][2]!=null && !this.tabDoJogo.matriz[1][2].equals(this.marca) &&
                this.tabDoJogo.matriz[2][2]!=null && !this.tabDoJogo.matriz[2][2].equals(this.marca))
                this.tabDoJogo.setMarcaNaPosicao(this.marca, 0,2);
            else
            if (this.tabDoJogo.matriz[0][2]!=null && !this.tabDoJogo.matriz[0][2].equals(this.marca) &&
                this.tabDoJogo.matriz[1][2]==null &&
                this.tabDoJogo.matriz[2][2]!=null && !this.tabDoJogo.matriz[2][2].equals(this.marca))
                this.tabDoJogo.setMarcaNaPosicao(this.marca, 1,2);
            else
            if (this.tabDoJogo.matriz[0][2]!=null && !this.tabDoJogo.matriz[0][2].equals(this.marca) &&
                this.tabDoJogo.matriz[1][2]!=null && !this.tabDoJogo.matriz[1][2].equals(this.marca) &&
                this.tabDoJogo.matriz[2][2]==null)
                this.tabDoJogo.setMarcaNaPosicao(this.marca, 2,2);
            else
            // tentando atrapalhar vitoria na diagonal principal
            if (this.tabDoJogo.matriz[0][0]==null &&
                this.tabDoJogo.matriz[1][1]!=null && !this.tabDoJogo.matriz[1][1].equals(this.marca) &&
                this.tabDoJogo.matriz[2][2]!=null && !this.tabDoJogo.matriz[2][2].equals(this.marca))
                this.tabDoJogo.setMarcaNaPosicao(this.marca, 0,0);
            else
            if (this.tabDoJogo.matriz[0][0]!=null && !this.tabDoJogo.matriz[0][0].equals(this.marca) &&
                this.tabDoJogo.matriz[1][1]==null &&
                this.tabDoJogo.matriz[2][2]!=null && !this.tabDoJogo.matriz[2][2].equals(this.marca))
                this.tabDoJogo.setMarcaNaPosicao(this.marca, 1,1);
            else
            if (this.tabDoJogo.matriz[0][0]!=null && !this.tabDoJogo.matriz[0][0].equals(this.marca) &&
                this.tabDoJogo.matriz[1][1]!=null && !this.tabDoJogo.matriz[1][1].equals(this.marca) &&
                this.tabDoJogo.matriz[2][2]==null)
                this.tabDoJogo.setMarcaNaPosicao(this.marca, 2,2);
            else
            // tentando atrapalhar vitoria na diagonal secundaria
            if (this.tabDoJogo.matriz[0][2]==null &&
                this.tabDoJogo.matriz[1][1]!=null && !this.tabDoJogo.matriz[1][1].equals(this.marca) &&
                this.tabDoJogo.matriz[2][0]!=null && !this.tabDoJogo.matriz[2][0].equals(this.marca))
                this.tabDoJogo.setMarcaNaPosicao(this.marca, 0,2);
            else
            if (this.tabDoJogo.matriz[0][2]!=null && !this.tabDoJogo.matriz[0][2].equals(this.marca) &&
                this.tabDoJogo.matriz[1][1]==null &&
                this.tabDoJogo.matriz[2][0]!=null && !this.tabDoJogo.matriz[2][0].equals(this.marca))
                this.tabDoJogo.setMarcaNaPosicao(this.marca, 1,1);
            else
            if (this.tabDoJogo.matriz[0][2]!=null && !this.tabDoJogo.matriz[0][2].equals(this.marca) &&
                this.tabDoJogo.matriz[1][1]!=null && !this.tabDoJogo.matriz[1][1].equals(this.marca) &&
                this.tabDoJogo.matriz[2][0]==null)
                this.tabDoJogo.setMarcaNaPosicao(this.marca, 2,0);
            else
            // tentando jogada de futuro na linha 0
            if (this.tabDoJogo.matriz[0][0]==null &&
                this.tabDoJogo.matriz[0][1]==null &&
                this.tabDoJogo.matriz[0][2]!=null && this.tabDoJogo.matriz[0][2].equals(this.marca))
                this.tabDoJogo.setMarcaNaPosicao(this.marca, 0,0); // podia ser 0,1
            else
            if (this.tabDoJogo.matriz[0][0]==null &&
                this.tabDoJogo.matriz[0][1]!=null && this.tabDoJogo.matriz[0][1].equals(this.marca) &&
                this.tabDoJogo.matriz[0][2]==null)
                this.tabDoJogo.setMarcaNaPosicao(this.marca, 0,0); // podia ser 0,2
            else
            if (this.tabDoJogo.matriz[0][0]!=null && this.tabDoJogo.matriz[0][0].equals(this.marca) &&
                this.tabDoJogo.matriz[0][1]==null &&
                this.tabDoJogo.matriz[0][2]==null)
                this.tabDoJogo.setMarcaNaPosicao(this.marca, 0,1); // podia ser 0,2
            // tentando jogada de futuro na linha 1
            // continue para as outras linhas, colunas e diagonais
            else
            if (this.tabDoJogo.matriz[1][0]==null &&
                this.tabDoJogo.matriz[1][1]==null &&
                this.tabDoJogo.matriz[1][2]!=null && this.tabDoJogo.matriz[1][2].equals(this.marca))
                this.tabDoJogo.setMarcaNaPosicao(this.marca, 1,0); // podia ser 0,1
            else
            if (this.tabDoJogo.matriz[1][0]==null &&
                this.tabDoJogo.matriz[1][1]!=null && this.tabDoJogo.matriz[1][1].equals(this.marca) &&
                this.tabDoJogo.matriz[1][2]==null)
                this.tabDoJogo.setMarcaNaPosicao(this.marca, 1,0); // podia ser 0,2
            else
            if (this.tabDoJogo.matriz[1][0]!=null && this.tabDoJogo.matriz[1][0].equals(this.marca) &&
                this.tabDoJogo.matriz[1][1]==null &&
                this.tabDoJogo.matriz[1][2]==null)
                this.tabDoJogo.setMarcaNaPosicao(this.marca, 1,1); // podia ser 0,2
            // tentando jogada de futuro na linha 2
            // continue para as outras linhas, colunas e diagonais
            else
            if (this.tabDoJogo.matriz[2][0]==null &&
                this.tabDoJogo.matriz[2][1]==null &&
                this.tabDoJogo.matriz[2][2]!=null && this.tabDoJogo.matriz[2][2].equals(this.marca))
                this.tabDoJogo.setMarcaNaPosicao(this.marca, 2,0); // podia ser 0,1
            else
            if (this.tabDoJogo.matriz[2][0]==null &&
                this.tabDoJogo.matriz[2][1]!=null && this.tabDoJogo.matriz[2][1].equals(this.marca) &&
                this.tabDoJogo.matriz[2][2]==null)
                this.tabDoJogo.setMarcaNaPosicao(this.marca, 2,0); // podia ser 0,2
            else
            if (this.tabDoJogo.matriz[2][0]!=null && this.tabDoJogo.matriz[2][0].equals(this.marca) &&
                this.tabDoJogo.matriz[2][1]==null &&
                this.tabDoJogo.matriz[2][2]==null)
                this.tabDoJogo.setMarcaNaPosicao(this.marca, 2,1); // podia ser 0,2 
            else
            // tentando jogada de futuro na coluna 0
            if (this.tabDoJogo.matriz[0][0]==null &&
                this.tabDoJogo.matriz[1][0]==null &&
                this.tabDoJogo.matriz[2][0]!=null && this.tabDoJogo.matriz[2][0].equals(this.marca))
                this.tabDoJogo.setMarcaNaPosicao(this.marca, 0,0); // podia ser 0,1
            else
            if (this.tabDoJogo.matriz[0][0]==null &&
                this.tabDoJogo.matriz[1][0]!=null && this.tabDoJogo.matriz[1][0].equals(this.marca) &&
                this.tabDoJogo.matriz[2][0]==null)
                this.tabDoJogo.setMarcaNaPosicao(this.marca, 0,0); // podia ser 0,2
            else
            if (this.tabDoJogo.matriz[0][0]!=null && this.tabDoJogo.matriz[0][0].equals(this.marca) &&
                this.tabDoJogo.matriz[1][0]==null &&
                this.tabDoJogo.matriz[2][0]==null)
                this.tabDoJogo.setMarcaNaPosicao(this.marca, 1,0); // podia ser 0,2
            // tentando jogada de futuro na coluna 1
            // continue para as outras linhas, colunas e diagonais
            else
            if (this.tabDoJogo.matriz[0][1]==null &&
                this.tabDoJogo.matriz[1][1]==null &&
                this.tabDoJogo.matriz[2][1]!=null && this.tabDoJogo.matriz[2][1].equals(this.marca))
                this.tabDoJogo.setMarcaNaPosicao(this.marca, 0,1); // podia ser 0,1
            else
            if (this.tabDoJogo.matriz[0][1]==null &&
                this.tabDoJogo.matriz[1][1]!=null && this.tabDoJogo.matriz[1][1].equals(this.marca) &&
                this.tabDoJogo.matriz[2][1]==null)
                this.tabDoJogo.setMarcaNaPosicao(this.marca, 0,1); // podia ser 0,2
            else
            if (this.tabDoJogo.matriz[0][1]!=null && this.tabDoJogo.matriz[0][1].equals(this.marca) &&
                this.tabDoJogo.matriz[1][1]==null &&
                this.tabDoJogo.matriz[2][1]==null)
                this.tabDoJogo.setMarcaNaPosicao(this.marca, 1,1); // podia ser 0,2
            // tentando jogada de futuro na coulna 2
            // continue para as outras linhas, colunas e diagonais
            else
            if (this.tabDoJogo.matriz[0][2]==null &&
                this.tabDoJogo.matriz[1][2]==null &&
                this.tabDoJogo.matriz[2][2]!=null && this.tabDoJogo.matriz[2][2].equals(this.marca))
                this.tabDoJogo.setMarcaNaPosicao(this.marca, 0,2); // podia ser 0,1
            else
            if (this.tabDoJogo.matriz[0][2]==null &&
                this.tabDoJogo.matriz[1][2]!=null && this.tabDoJogo.matriz[1][2].equals(this.marca) &&
                this.tabDoJogo.matriz[2][2]==null)
                this.tabDoJogo.setMarcaNaPosicao(this.marca, 2,2); // podia ser 0,2
            else
            if (this.tabDoJogo.matriz[0][2]!=null && this.tabDoJogo.matriz[0][2].equals(this.marca) &&
                this.tabDoJogo.matriz[1][2]==null &&
                this.tabDoJogo.matriz[2][2]==null)
                this.tabDoJogo.setMarcaNaPosicao(this.marca, 2,2); // podia ser 0,2  	
            // tentando jogada de futuro na diagonal 0
            // continue para as outras linhas, colunas e diagonais
            else
            if (this.tabDoJogo.matriz[0][0]==null &&
                this.tabDoJogo.matriz[1][1]==null &&
                this.tabDoJogo.matriz[2][2]!=null && this.tabDoJogo.matriz[2][2].equals(this.marca))
                this.tabDoJogo.setMarcaNaPosicao(this.marca, 0,0); // podia ser 0,1
            else
            if (this.tabDoJogo.matriz[0][0]==null &&
                this.tabDoJogo.matriz[1][1]!=null && this.tabDoJogo.matriz[1][1].equals(this.marca) &&
                this.tabDoJogo.matriz[2][2]==null)
                this.tabDoJogo.setMarcaNaPosicao(this.marca, 2,2); // podia ser 0,2
            else
            if (this.tabDoJogo.matriz[0][0]!=null && this.tabDoJogo.matriz[0][0].equals(this.marca) &&
                this.tabDoJogo.matriz[1][1]==null &&
                this.tabDoJogo.matriz[2][2]==null)
                this.tabDoJogo.setMarcaNaPosicao(this.marca, 2,2); // podia ser 0,2   		
            // tentando jogada de futuro na diagonal 2
            // continue para as outras linhas, colunas e diagonais
            else
            if (this.tabDoJogo.matriz[0][2]==null &&
                this.tabDoJogo.matriz[1][1]==null &&
                this.tabDoJogo.matriz[2][0]!=null && this.tabDoJogo.matriz[2][0].equals(this.marca))
                this.tabDoJogo.setMarcaNaPosicao(this.marca, 0,2); // podia ser 0,1
            else
            if (this.tabDoJogo.matriz[0][2]==null &&
                this.tabDoJogo.matriz[1][1]!=null && this.tabDoJogo.matriz[1][1].equals(this.marca) &&
                this.tabDoJogo.matriz[2][0]==null)
                this.tabDoJogo.setMarcaNaPosicao(this.marca, 0,2); // podia ser 0,2
            else
            if (this.tabDoJogo.matriz[0][2]!=null && this.tabDoJogo.matriz[0][2].equals(this.marca) &&
                this.tabDoJogo.matriz[1][1]==null &&
                this.tabDoJogo.matriz[2][0]==null)
                this.tabDoJogo.setMarcaNaPosicao(this.marca, 2,0); // podia ser 0,2	            
            else {
            // termine jogando num lugar qualquer que esteja livre
                   
            	int x = (int)(Math.random()*3);
            	int y = (int)(Math.random()*3);
            	
            	if(this.tabDoJogo.haMarcaNaPosicao(x, y) == false){
    				this.tabDoJogo.setMarcaNaPosicao(this.marca, x, y);
            	}
            	
            	else {
            		for(x = 0; x < this.tabDoJogo.matriz.length; x++){
            			for(y = 0; y < this.tabDoJogo.matriz[0].length; y++){
            				if(this.tabDoJogo.haMarcaNaPosicao(x, y) == false){
            					this.tabDoJogo.setMarcaNaPosicao(this.marca, x, y);
            					x = 3;
            					y = 3;
            				}
            			}
            		}
            	}
            }
        }
        catch (Exception erro)
        {} // ignorando pois sei que não estou usando posicao invalida nem comparando com equals um null
    }

    public String toString ()
    {
        // retorna o String "Jogador Automatico" seguido pela marca do jogador entre parenteses
    	
    	return "Jogador Automatico (" + this.marca + ")";
    }

    public boolean equals (Object obj)
    {
        // verificar se o conteudo de this e obj sao iguais, retornando true em caso afirmativo, false em caso negativo
    	
        // verificar se o conteudo de this e obj sao
        // iguais, retornando true em caso afirmativo,
        // ou false em caso negativo
    	if (obj == null)
            return false;

    	if (this == obj)
            return true;

    	if (this.getClass() !=  obj.getClass())
            return false;
        
        JogadorAutomatico ja = (JogadorAutomatico) obj;
        
        if (this.marca != ja.marca)
            return false;
        
        if (this.tabDoJogo.equals(ja.tabDoJogo) == false)
            return false;
        
        return true;
    }
}