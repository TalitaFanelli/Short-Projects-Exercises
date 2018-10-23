public class Velha
{
    public static void main (String args [])
    {
        Tabuleiro           tabDoJogo;
        JogadorHumano       jogadorH = null;
        JogadorAutomatico   jogadorA = null;

        AnalistaSituacional analista;

        boolean jogadorHumanoComeca  = (int)(Math.random()*2) == 0;

        do
        {
            try
            {
                tabDoJogo = new Tabuleiro ();

                if (jogadorHumanoComeca)
                {
                    jogadorH = new JogadorHumano (tabDoJogo);
                    jogadorA = new JogadorAutomatico
                              (tabDoJogo,
                               new Marca(jogadorH.getMarca().getSimbolo()=='X'?'O':'X'));
                }
                else
                {
                    jogadorA = new JogadorAutomatico (tabDoJogo);
                    jogadorH = new JogadorHumano
                              (tabDoJogo,
                               new Marca(jogadorA.getMarca().getSimbolo()=='X'?'O':'X'));

                }

                analista = new AnalistaSituacional (tabDoJogo);
                boolean ehVezDoJogadorHumano = jogadorHumanoComeca;

                do
                {
                    if (ehVezDoJogadorHumano)
                        jogadorH.facaSuaJogada();
                    else
                        jogadorA.facaSuaJogada();

                    ehVezDoJogadorHumano=!ehVezDoJogadorHumano;
                }
                while (!analista.fimDeJogo());        

                if (analista.getMarcaDoVencedor().equals(jogadorH.getMarca()))
                    jogadorH.vcGanhou ();
                
                if (analista.getMarcaDoVencedor().equals(jogadorA.getMarca()))
                        jogadorH.vcPerdeu ();
                
                jogadorHumanoComeca = !jogadorHumanoComeca;
            }
            catch (Exception NullPointerException)//Se analista.getMarcaDoVencedor() é null o método equals gera uma exceção de NullPointerException a qual é tratada aqui 
            {
            	jogadorH.deuVelha ();
            }
        }
        while (jogadorH.querMaisUmaPartida());
    }
}