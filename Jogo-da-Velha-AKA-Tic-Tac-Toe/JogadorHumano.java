import java.io.*;

public class JogadorHumano
{
	protected Marca          marca     = null;
	protected Tabuleiro      tabDoJogo = null;
	protected BufferedReader entrada   = new BufferedReader
			(new InputStreamReader
					(System.in));
	protected AnalistaSituacional analista = null;

	public JogadorHumano (Tabuleiro tab) throws Exception
	{
		// atribuir tab para this.tabDoJogo pedir para o jogador escolher sua marca e permitir digitacao instanciando this.marca

		this.tabDoJogo = tab;

		String letra = null;
		int tentativa = 0;

		try {
			System.out.println("Você começa a partida! Escolha a letra X ou O:");
			letra = entrada.readLine();

			while(letra.isEmpty() || (letra.charAt(0) != 'X' && letra.charAt(0) != 'O' && letra.charAt(0) != 'x' && letra.charAt(0) != 'o')) {
				System.out.println("Valor inválido! Escolha a letra X ou O:");
				letra = entrada.readLine();
				tentativa++;

				if(tentativa == 2 && (letra.isEmpty() || (letra.charAt(0) != 'X' && letra.charAt(0) != 'O' && letra.charAt(0) != 'x' && letra.charAt(0) != 'o'))) {
					System.out.println("Sua última tentativa! Escolha a letra X ou O:");
					letra = entrada.readLine();
					break;
				}
			}
			
			if(letra == null || letra.isEmpty() || (letra.charAt(0) != 'X' && letra.charAt(0) != 'O' && letra.charAt(0) != 'x' && letra.charAt(0) != 'o')) {
				System.out.println("Partida encerrada! Você perdeu por WO!");
				System.exit(-1);
			}

			this.marca = new Marca(letra.toUpperCase().charAt(0));	
		}
		
		catch(Exception e)
		{} //sei que não vai entrar aqui
	}

	public JogadorHumano (Tabuleiro tab, Marca mrc) throws Exception
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
		// pergunta para o jogador onde ele querMaisUmaPartida jogar, permitindo digitacao e chamando os métodos apropriados de this.tabDoJogo

		System.out.println("Sua vez " + toString() + ", aqui está o tabuleiro:\n");
		
		System.out.println(this.tabDoJogo.toString() + "\n");

		String lin = null, col = null;
		int tentativa = 0;

		try {
			
			System.out.println("Escolha a linha que deseja marcar:");
			lin = entrada.readLine();
			
			while(lin.isEmpty() || !(lin.charAt(0) >= '0' && lin.charAt(0) <= '2')) {
				System.out.println("Valor inválido! Escolha um número de 0 até 2:");
				lin = entrada.readLine();
				tentativa++;

				if(tentativa == 2 && (lin.isEmpty() || !(lin.charAt(0) >= '0' && lin.charAt(0) <= '2'))) {
					System.out.println("Sua última tentativa! Escolha um número de 0 até 2:");
					lin = entrada.readLine();
					break;
				}
			}
			
			if(lin == null || lin.isEmpty() || !(lin.charAt(0) >= '0' && lin.charAt(0) <= '2')) {
				System.out.println("Partida encerrada! Você perdeu por WO!");
				System.exit(-1);
			}
			
			tentativa = 0;
			
			System.out.println("Escolha a coluna que deseja marcar:");
			col = entrada.readLine();
			
			while(col.isEmpty() || !(col.charAt(0) >= '0' && col.charAt(0) <= '2')) {
				System.out.println("Valor inválido! Escolha um número de 0 até 2:");
				col = entrada.readLine();
				tentativa++;

				if(tentativa == 2 && (col.isEmpty() || !(col.charAt(0) >= '0' && col.charAt(0) <= '2'))) {
					System.out.println("Sua última tentativa! Escolha um número de 0 até 2:");
					col = entrada.readLine();
					break;
				}
			}
			
			if(col == null || col.isEmpty() || !(col.charAt(0) >= '0' && col.charAt(0) <= '2')) {
				System.out.println("Partida encerrada! Você perdeu por WO!");
				System.exit(-1);
			}

			this.tabDoJogo.setMarcaNaPosicao(this.marca, Integer.parseInt(lin), Integer.parseInt(col));
		}

		catch(Exception e) 
		{} //sei que não vai entrar aqui porque já tratei as possibilidades antes	
	}

	public void vcGanhou ()
	{
		// mostra mensagem indicando vitoria
		System.out.println("FIM DE JOGO: Parabéns! Você ganhou!\n");
		System.out.println(this.tabDoJogo.toString() + "\n");
	}

	public void vcPerdeu ()
	{
		// mostra mensagem indicando derrota
		System.out.println("FIM DE JOGO: Não foi dessa vez, você perdeu!\n");
		System.out.println(this.tabDoJogo.toString() + "\n");
	}

	public void deuVelha ()
	{
		// mostra mensagem indicando empate
		System.out.println("FIM DE JOGO: Bela partida! Deu velha!\n");
		System.out.println(this.tabDoJogo.toString() + "\n");
	}

	public boolean querMaisUmaPartida ()
	{
		// perguntar se deseja jogar de novo permitindo digitacao e retornando true ou false, conforme a resposta
		int resposta = 0;

		try {
			System.out.println("Deseja jogar novamente? Digite 1 para continuar ou aperte qualquer tecla para sair...");
			resposta = Integer.parseInt(entrada.readLine());
		}

		catch(Exception e) 
		{	
			System.out.println("Até mais! Foi divertido jogar com você!");
			return false;
		}

		if(resposta == 1) { 
			return true;
		}
		
		System.out.println("Até mais! Foi divertido jogar com você!");
		return false;
	}

	public String toString ()
	{
		// retorna o String "Jogador Humano" seguido pela marca do jogador entre parenteses
		
		return "Jogador Humano (" + this.marca + ")";
	}

	public boolean equals (Object obj)
	{
		// verificar se o conteudo de this e obj sao iguais, retornando true em caso afirmativo, ou false em caso negativo
    	if (obj == null)
            return false;

    	if (this == obj)
            return true;

    	if (this.getClass() !=  obj.getClass())
            return false;
        
    	JogadorHumano jh = (JogadorHumano) obj;
        
        if (this.marca != jh.marca)
            return false;
        
        if (this.tabDoJogo.equals(jh.tabDoJogo) == false)
            return false;
        
        return true;
	}
}