package dominio;

public enum TipoPessoa {
	sindico,
	morador;
	
	public static TipoPessoa fromInteger(int x) {
        switch(x) {
        case 0:
            return sindico;
        case 1:
            return morador;
        }
        return null;
    }
}
