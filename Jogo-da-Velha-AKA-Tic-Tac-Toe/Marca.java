public class Marca
{
    protected char simbolo;

    public Marca (char smb) throws Exception
    {
        if (smb!='X' && smb!='O')
            throw new Exception ("Marca invalida");

        this.simbolo = smb;
    }

    public char getSimbolo ()
    {
        return this.simbolo;
    }

    public String toString ()
    {
        return "" + this.simbolo;
    }

    public boolean equals (Object obj)
    {
        if (this == obj)
            return true;

        if (obj == null)
            return false;

        if (this.getClass() != obj.getClass())
            return false;

        Marca marca = (Marca)obj;

        if (this.simbolo != marca.simbolo)
            return false;

        return true;
    }

    public int hashCode ()
    {
        final int PRIMO = 31;
        int resultado   =  1;

        resultado = PRIMO*resultado +
                    (int)this.simbolo;

        return resultado;
    }
}