package TRAB;

//Classe Pokemon que representa um Pokemon com atributos basicos 

public class Pokemon {
    private String nome;
    private int numeroPokedex;
    private String tipo;  
	private String descricao;
	private String sexo;

	
	//Construtor da classe Pokemon com os respectivos atributos citados acima
    public Pokemon(String nome, int numeroPokedex, String tipo, String descricao, String sexo) {
        this.nome = nome;
        this.numeroPokedex = numeroPokedex;
        this.tipo = tipo;
        this.descricao = descricao;
        this.sexo = sexo;
    }
 // Getters e Setters
    
    public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getNumeroPokedex() {
		return numeroPokedex;
	}

	public void setNumeroPokedex(int numeroPokedex) {
		this.numeroPokedex = numeroPokedex;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

    
}