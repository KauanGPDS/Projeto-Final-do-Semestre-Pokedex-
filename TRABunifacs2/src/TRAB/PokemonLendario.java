package TRAB;


//PokemonLendario é uma sub classe da classe Pokemon
public class PokemonLendario extends Pokemon {
    private String habilidadeEspecial;
    private String regiaoOrigem;

    
    //Construtor com os atributos da classe Pokemon + atributos unicos dos Pokemons Lendarios
    public PokemonLendario(String nome, int numeroPokedex, String tipo, String descricao,String sexo, String habilidadeEspecial, String regiaoOrigem) {
        super(nome, numeroPokedex, tipo, descricao,sexo );
        this.habilidadeEspecial = habilidadeEspecial;
        this.regiaoOrigem = regiaoOrigem;
    }
    
    //getters e setters da subclasse PokemonLendario
	public String getHabilidadeEspecial() {
		return habilidadeEspecial;
	}

	public void setHabilidadeEspecial(String habilidadeEspecial) {
		this.habilidadeEspecial = habilidadeEspecial;
	}

	public String getRegiaoOrigem() {
		return regiaoOrigem;
	}

	public void setRegiaoOrigem(String regiaoOrigem) {
		this.regiaoOrigem = regiaoOrigem;
	}

    
}