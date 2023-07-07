package TRAB;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Pokedex {
    Scanner scanner = new Scanner(System.in);
    List<Pokemon> pokemons = new ArrayList<Pokemon>();
    List<PokemonLendario> pokemonsLendarios = new ArrayList<PokemonLendario>();

    // Método para exibir o menu principal da Pokédex
    public void menu() {
        System.out.println("=============== M E N U =============== ");
        System.out.println("[ 1 ] Adicionar Pokemon ");
        System.out.println("[ 2 ] Exibir Pokedex ");
        System.out.println("[ 3 ] Pesquisar Pokemon");
        System.out.println("[ 4 ] Remover Pokemon lendário");
        System.out.println("[ 5 ] Modificar Pokemon lendário");
        System.out.println("[ 8 ] Sair da Pokedex");
        System.out.println("=======================================");
    }
    // Método para exibir o menu de seleção de tipo de Pokémon (normal ou lendário)
    public void selecionarPokemonMenu() {
    	
    	
        System.out.println("================== T I P O ======================");
        System.out.println("[ 1 ] pokemon normal");
        System.out.println("[ 2 ] pokemon lendário");
        System.out.println("[ 8 ] Voltar ao menu");
        System.out.println("================================================");
      
        
    }
    // Método para executar as funções do menu principal
    public void executar() {
    	
        try {
            Scanner scanner = new Scanner(System.in);
            int opcao = 0;

           menu();
            opcao = scanner.nextInt();
            int tipoPokemon;
            tipoPokemon = 0;
            while (opcao != 8) {
                switch (opcao) {
                               
                    case 1:
                    	selecionarPokemonMenu(); 
                    	tipoPokemon = scanner.nextInt();
                    	
                        adicionarPokemon(tipoPokemon);
                                 
                        break;
                    case 2:
                    	 selecionarPokemonMenu(); 
                    	 tipoPokemon = scanner.nextInt();
                    	 
                        if (tipoPokemon == 1) {
                            exibirPokemons(pokemons);
                            System.out.println("Para descobrir mais informações sobre algum Pokémon específico, recomendamos pesquisar pelo nome do Pokémon desejado.");
                        } else if (tipoPokemon == 2) {
                            exibirPokemonsLendarios(pokemonsLendarios);
                            System.out.println("Para descobrir mais informações sobre algum Pokémon específico, recomendamos pesquisar pelo nome do Pokémon desejado.");
                        }
                        
                        break;
                    case 3:
                    	selecionarPokemonMenu();
                    	tipoPokemon = scanner.nextInt();
                        
                        if (tipoPokemon == 1) {                         
                                System.out.println("Digite o nome do Pokémon:");
                                String nomePokemonNormal = scanner.next();
                                BuscaPorNomePokemonNormal(nomePokemonNormal, pokemons);
                        }
                        else if( tipoPokemon == 2) {
                                System.out.println("Digite o nome do Pokémon lendário:");
                                String nomePokemonLendario = scanner.next();
                                BuscaPorNomePokemonLendario(nomePokemonLendario, pokemonsLendarios);                         
                        }                       
                        break;
                        
                    case 4:
                    	int decisao = 0;
                    	selecionarPokemonMenu();
                        
                       tipoPokemon = scanner.nextInt();
                    	if(tipoPokemon == 1	) {
                        System.out.println("Digite o nome do Pokémon que deseja remover:");                  
                        
                        String nomePokemonRemover = scanner.next();
                        System.out.println("Certeza que deseja remover o pokemon?");
                        System.out.println("[ 1 ] SIM ");
                        System.out.println("[ 2 ] NAO ");
                        System.out.println("============================");
                        decisao = scanner.nextInt();
                        removerPorNome(nomePokemonRemover, pokemons,decisao);
                    	}
                    	 if(tipoPokemon == 2) {
                    		System.out.println("Digite o nome do Pokémon lendário que deseja remover:");                  		
                            String nomePokemonRemover = scanner.next();
                           System.out.println("Certeza que deseja remover o pokemon?");
                           System.out.println("[ 1 ] SIM ");
                           System.out.println("[ 2 ] NAO ");
                           System.out.println("============================");
                            decisao = scanner.nextInt();
                            removerPorNomeL(nomePokemonRemover, pokemonsLendarios, decisao);
                    	}
                       break;
                    case 5:
                    	selecionarPokemonMenu();
                    	tipoPokemon = scanner.nextInt();
                    	if(tipoPokemon == 1) {
                    		System.out.println("Digite o nome do Pokémon que deseja modificar");
                    		String nomePokemonModificar = scanner.next();
                    		modificarPorNomeP(nomePokemonModificar, pokemons);
                    	}
                    	else if(tipoPokemon == 2) {
                        System.out.println("Digite o nome do Pokémon Léndario que deseja modificar:");
                        String nomePokemonLendarioModificar = scanner.next();
                        modificarPorNomePL(nomePokemonLendarioModificar, pokemonsLendarios);
                    	}
                        break;
                    default:
                        System.out.println("Opção inválida, tente novamente");
                        break;
                }

                menu();
                opcao = scanner.nextInt();
            }
        } catch (Exception e) {
            System.out.println("Ocorreu um erro, reinicie o programa e tente novamente");
        }
    }
    
    
    //Método auxiliar que certificar que uma Variavel String em "AdicionarPokemon" possua apenas Letras para evitar erros
    private boolean contemApenasLetras(String texto) {
	    for (char c : texto.toCharArray()) {
	        if (!Character.isLetter(c)) {
	            return false;
	        }
	    }
	    return true;
	} 
    
    //Método auxiliar que certifica que uma Variavel Integer em "AdicionarPokemon" possua apenas numeros para evitar erros
    private int apenasNumeros() {
	    while (true) {
	        try {
	            String input = scanner.nextLine();
	            int valor = Integer.parseInt(input);
	            return valor;
	        } catch (NumberFormatException e) {
	            System.out.println("Valor inválido. Digite novamente: ");
	        }

	    }
	 }	
    
    //Método para adicionar um novo pokemon a pokedex
    public void adicionarPokemon(int tipoPoke) {
        try {          
        	
        
            System.out.println("Digite o nome do Pokémon:");
             
            String nome = scanner.next();
            while (!contemApenasLetras(nome)) {
    	        System.out.println("Texto inválido. Digite novamente: ");
    	        nome = scanner.next();
    	        scanner.nextLine();
    	    }
            System.out.println("Digite o número da Pokédex:");
            
            scanner.nextLine();
            int numeroPokedex = apenasNumeros();
            
            System.out.println("Digite o tipo do Pokémon:");
            String tipo = scanner.next();
            while (!contemApenasLetras(tipo)) {
    	        System.out.println("Texto inválido. Digite novamente: ");
    	        tipo = scanner.next();
    	        scanner.nextLine();
    	    }
            System.out.println("Digite a descrição do Pokémon:");
            String descricao = scanner.next();
            while (!contemApenasLetras(descricao)) {
    	        System.out.println("Texto inválido. Digite novamente: ");
    	        descricao = scanner.next();
    	        scanner.nextLine();
    	    }
            System.out.println("Digite o sexo do Pokémon");
            String sexo = scanner.next();
            while (!contemApenasLetras(sexo)) {
    	        System.out.println("Texto inválido. Digite novamente: ");
    	        sexo = scanner.next();
    	        scanner.nextLine();
    	    }
            
            
            boolean isLendario = true;
            
            if(tipoPoke == 2) {
            	isLendario = true;
            }
            else {
            	isLendario = false;
            }

            if (isLendario == true) {
                System.out.println("Digite a habilidade especial do Pokémon lendário:");
                String habilidadeEspecial = scanner.next();
                while (!contemApenasLetras(habilidadeEspecial)) {
        	        System.out.println("Texto inválido. Digite novamente: ");
        	        habilidadeEspecial  = scanner.next();
        	        scanner.nextLine();
        	    }
                System.out.println("Digite a região de origem do Pokémon lendário:");
                String regiaoOrigem = scanner.next();
                while (!contemApenasLetras(regiaoOrigem)) {
        	        System.out.println("Texto inválido. Digite novamente: ");
        	        regiaoOrigem = scanner.next();
        	        scanner.nextLine();
        	    }
                PokemonLendario pokemonLendario = new PokemonLendario(nome, numeroPokedex, tipo, descricao, habilidadeEspecial, regiaoOrigem, sexo);
                pokemonsLendarios.add(pokemonLendario);
            } else if (isLendario ==false){
           	
                Pokemon pokemon = new Pokemon(nome, numeroPokedex, tipo, descricao, sexo);
                pokemons.add(pokemon);
            }

            System.out.println("Pokemon adicionado com sucesso!");

        } catch (Exception e) {
            System.out.println("Ocorreu um erro, tente novamente.");
        }
    }
	

    {

		Pokemon p1 = new Pokemon("Chamader", 3, "Fogo", "Baiano","Masculino" );
        Pokemon p2 = new Pokemon("Charmelon", 4,"Fogo", "Sulista","Masculino");
        Pokemon p3 = new Pokemon("Charizard", 5, "Fogo", "Carioca", "Masculino");
        Pokemon p4 = new Pokemon("Pikachu", 1, "Elétrico", "Ratobrabo", "Masculino");
        Pokemon p5 = new Pokemon("Caterpie", 9,"Inseto", "Burrao", "Feminino");
        Pokemon p6 = new Pokemon("Metapod", 10, "Inseto", "Comuna","Feminino");
        Pokemon p7 = new Pokemon("Butterfree",11,"Inseto", "Tupi", "Feminino");
        PokemonLendario p8 = new PokemonLendario("MewTwo", 3 , "RJ", "psiquico" , null , "Genetic pokemon", "Feminino");
        PokemonLendario p9 = new PokemonLendario("Articuno", 7 , "Montanhas Geladas", "Gelo", "Voador", "Legendary Bird", "Masculino");     
        PokemonLendario p10 = new PokemonLendario("Zapdos", 23,  "Planalto", "Elétrico", "Voador", "Legendary Bird", "Masculino");
        PokemonLendario p11 = new PokemonLendario("Moltres", 15, "Vulcão", "Fogo", "Voador", "Legendary Bird", "Masculino");
        
		
		pokemons.add(p1);
		pokemons.add(p2);
		pokemons.add(p3);
		pokemons.add(p4);
		pokemons.add(p5);
		pokemons.add(p6);
		pokemons.add(p7);
		pokemonsLendarios.add(p8);
		pokemonsLendarios.add(p9);
		pokemonsLendarios.add(p10);
		pokemonsLendarios.add(p11);
		
	}
  //Método para modificar o nome dos pokemons 
  	 public void modificarPorNomeP(String nome, List<Pokemon> listaPokemons) {
  	        boolean encontrado = false;
  	        Scanner scanner = new Scanner(System.in);

  	        for (Pokemon pokemon : listaPokemons) {
  	            if (pokemon.getNome().equalsIgnoreCase(nome)) {
  	                System.out.println("=========== R E S U L T A D O ===========");
  	                System.out.println("Nome: " + pokemon.getNome());
  	                System.out.println("Número da Pokédex: " + pokemon.getNumeroPokedex());
  	                System.out.println("Tipo: " + pokemon.getTipo());
  	                System.out.println("Descrição: " + pokemon.getDescricao());	  
  	                System.out.println("Sexo: " + pokemon.getSexo());
  	                System.out.println("-----------------------------------------");
  	                System.out.println("Digite o novo nome do Pokémon lendário:");
  	                String novoNome = scanner.nextLine();
  	              while (!contemApenasLetras(novoNome)) {
          	        System.out.println("Texto inválido. Digite novamente: ");
          	        novoNome = scanner.next();
          	        scanner.nextLine();
          	    }
  	                System.out.println("Digite o novo número da Pokédex:");
  	                int novoNumeroPokedex = apenasNumeros();

  	                System.out.println("Digite o novo tipo do Pokémon:");
  	                String novoTipo = scanner.next();
  	                while (!contemApenasLetras(novoTipo)) {
  	        	        System.out.println("Texto inválido. Digite novamente: ");
  	        	        novoTipo = scanner.next();
  	        	        scanner.nextLine();
  	        	    }
  	                System.out.println("Digite a nova descrição do Pokémon:");
  	                String novaDescricao = scanner.next();
  	                while (!contemApenasLetras(novaDescricao)) {
  	        	        System.out.println("Texto inválido. Digite novamente: ");
  	        	        novaDescricao = scanner.next();
  	        	        scanner.nextLine();
  	        	    }
  	                System.out.println("Digite o novo sexo do Pokémon:");
  	                String sexo = scanner.next();
  	                while (!contemApenasLetras(sexo)) {
  	        	        System.out.println("Texto inválido. Digite novamente: ");
  	        	        novaDescricao = scanner.next();
  	        	        scanner.nextLine();
  	        	    }
  	                
  	                pokemon.setNome(novoNome);
  	                pokemon.setNumeroPokedex(novoNumeroPokedex);
  	                pokemon.setTipo(novoTipo);
  	                pokemon.setDescricao(novaDescricao);
  	                pokemon.setSexo(sexo);
  	                
  	                System.out.println("Pokémon modificado com sucesso!");
  	                encontrado = true;
  	                break;
  	            }
  	        }
  	        if (!encontrado) {
  	            System.out.println("Pokémon não encontrado.");
  	        }
  	    }
        
    
    //Método para modificar o nome dos pokemons lendarios
    public void modificarPorNomePL(String nome, List<PokemonLendario> listaPokemonsLendarios) {
        boolean encontrado = false;
        Scanner scanner = new Scanner(System.in);

        for (PokemonLendario pokemonLendario : listaPokemonsLendarios) {
            if (pokemonLendario.getNome().equalsIgnoreCase(nome)) {
                System.out.println("=========== R E S U L T A D O ===========");
                System.out.println("Nome: " + pokemonLendario.getNome());
                System.out.println("Número da Pokédex: " + pokemonLendario.getNumeroPokedex());
                System.out.println("Tipo: " + pokemonLendario.getTipo());
                System.out.println("Descrição: " + pokemonLendario.getDescricao());
                System.out.println("Sexo: " + pokemonLendario.getSexo());
                System.out.println("Habilidade Especial: " + pokemonLendario.getHabilidadeEspecial());
                System.out.println("Região de Origem: " + pokemonLendario.getRegiaoOrigem());
                System.out.println("-----------------------------------------");
                System.out.println("Digite o novo nome do Pokémon lendário:");
                String novoNome = scanner.nextLine();
                while (!contemApenasLetras(novoNome)) {
        	        System.out.println("Texto inválido. Digite novamente: ");
        	        novoNome = scanner.next();
        	        scanner.nextLine();
        	    }
                System.out.println("Digite o novo número da Pokédex:");
                int novoNumeroPokedex = apenasNumeros();

                System.out.println("Digite o novo tipo do Pokémon:");
                String novoTipo = scanner.next();
                while (!contemApenasLetras(novoTipo)) {
        	        System.out.println("Texto inválido. Digite novamente: ");
        	        novoTipo = scanner.next();
        	        scanner.nextLine();
        	    }
                System.out.println("Digite a nova descrição do Pokémon:");
                String novaDescricao = scanner.next();
                while (!contemApenasLetras(novaDescricao)) {
        	        System.out.println("Texto inválido. Digite novamente: ");
        	        novaDescricao = scanner.next();
        	        scanner.nextLine();
        	    }
                System.out.println("Digite a nova habilidade especial do Pokémon lendário:");
                String novaHabilidadeEspecial = scanner.next();
                while (!contemApenasLetras(novaDescricao)) {
        	        System.out.println("Texto inválido. Digite novamente: ");
        	        novaDescricao = scanner.next();
        	        scanner.nextLine();
        	    }
                System.out.println("Digite a nova região de origem do Pokémon lendário:");
                String novaRegiaoOrigem = scanner.next();
                while (!contemApenasLetras(novaRegiaoOrigem)) {
        	        System.out.println("Texto inválido. Digite novamente: ");
        	        novaRegiaoOrigem = scanner.next();
        	        scanner.nextLine();
        	    }
                System.out.println("Digite o novo sexo do Pokémon");
                String novoSexo = scanner.next();
                while (!contemApenasLetras(novoSexo)) {
        	        System.out.println("Texto inválido. Digite novamente: ");
        	        novoSexo = scanner.next();
        	        scanner.nextLine();
        	    }
                pokemonLendario.setNome(novoNome);
                pokemonLendario.setNumeroPokedex(novoNumeroPokedex);
                pokemonLendario.setTipo(novoTipo);
                pokemonLendario.setDescricao(novaDescricao);
                pokemonLendario.setHabilidadeEspecial(novaHabilidadeEspecial);
                pokemonLendario.setRegiaoOrigem(novaRegiaoOrigem);
                pokemonLendario.setSexo(novoSexo);

                System.out.println("Pokémon lendário modificado com sucesso!");
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            System.out.println("Pokémon lendário não encontrado.");
        }
    }
	
	
    //Método para bucar nome de Pokemons normais
	 public void BuscaPorNomePokemonNormal(String nome, List<Pokemon> listaPokemons) {
	        boolean encontrado = false;
	        for (Pokemon pokemon : listaPokemons) {
	            if (pokemon.getNome().equalsIgnoreCase(nome)) {
	                System.out.println("=========== R E S U L T A D O ===========");
	                System.out.println("Nome: " + pokemon.getNome());
	                System.out.println("Número da Pokédex: " + pokemon.getNumeroPokedex());
	                System.out.println("Tipo: " + pokemon.getTipo());
	                System.out.println("Descrição: " + pokemon.getDescricao());
	                System.out.println("Sexo: " + pokemon.getSexo());
	                System.out.println("-----------------------------------------");
	                encontrado = true;
	                break;
	            }
	        }
	        if (!encontrado) {
	            System.out.println("Pokémon não encontrado.");
	        }
	    }
	 
	 //Método para buscar nome de Pokemons Lendarios
	 public void BuscaPorNomePokemonLendario(String nome, List<PokemonLendario> listaPokemonsLendarios) {
	        boolean encontrado = false;
	        for (PokemonLendario pokemonLendario : listaPokemonsLendarios) {
	            if (pokemonLendario.getNome().equalsIgnoreCase(nome)) {
	                System.out.println("=========== R E S U L T A D O ===========");
	                System.out.println("Nome: " + pokemonLendario.getNome());
	                System.out.println("Número da Pokédex: " + pokemonLendario.getNumeroPokedex());
	                System.out.println("Tipo: " + pokemonLendario.getTipo());
	                System.out.println("Descrição: " + pokemonLendario.getDescricao());
	                System.out.println("Sexo: " + pokemonLendario.getSexo());
	                System.out.println("Habilidade Especial: " + pokemonLendario.getHabilidadeEspecial());
	                System.out.println("Região de Origem: " + pokemonLendario.getRegiaoOrigem());
	                System.out.println("-----------------------------------------");
	                encontrado = true;
	                break;
	            }
	        }
	        if (!encontrado) {
	            System.out.println("Pokémon lendário não encontrado.");
	        }
	    }
	 
	 
	 //Método para remover nome de Pokemon Lendario
	  public static void removerPorNomeL(String nome, List<PokemonLendario> listaPL, int decisao ) {
	        String nomeFormatado = nome.trim().toLowerCase();
	     	        
	        Iterator<PokemonLendario> iterator = listaPL.iterator();
	        boolean removido = false;

	        while (iterator.hasNext()) {
	            PokemonLendario pokemonL = iterator.next();
           
                	 if (decisao == 1 && pokemonL.getNome().toLowerCase().equals(nomeFormatado)) {
                         iterator.remove();
                         System.out.println("Pokemon lendário removido: " + pokemonL.getNome());
                         removido = true;
                         break;
                     }
	           
             }               	            
	        

	        if (!removido) {
	        	if(decisao == 2) {	            	
	            	System.out.println("Remoção cancelada");
	            }else {
	            System.out.println("Pokemon não encontrado");
	            }
	        }
	    }
	 //Método para remover nome de Pokemon normal
	  public static void removerPorNome(String nome, List<Pokemon> listaP,int decisao) {
	        String nomeFormatado = nome.trim().toLowerCase();

	        Iterator<Pokemon> iterator = listaP.iterator();
	        boolean removido = false;

	        while (iterator.hasNext()) {
	            Pokemon pokemon = iterator.next();
	            if (decisao == 1 && pokemon.getNome().toLowerCase().equals(nomeFormatado)) {
                    iterator.remove();
                    System.out.println("Pokemon lendário removido: " + pokemon.getNome());
                    removido = true;
                    break;
                }         
        }               	                   
       if (!removido) {
       	if(decisao == 2) {	            	
           	System.out.println("Remoção cancelada");
           }else {
           System.out.println("Pokemon não encontrado");
           }
       }
   }
	 	 		
		
		
	//Método para exibir Pokemons
		public void exibirPokemons(List<Pokemon> listaPokemons) {
		    Collections.sort(listaPokemons, Comparator.comparing(Pokemon::getNumeroPokedex));

		    System.out.println("=============== P O K É M O N S ===============");
		    for (Pokemon pokemon : listaPokemons) {
		        System.out.println("Nome: " + pokemon.getNome());
		        System.out.println("Número da Pokédex: " + pokemon.getNumeroPokedex());
		        System.out.println("Tipo: " + pokemon.getTipo());
		        System.out.println("-----------------------------------------------");
		    }
		    System.out.println("===============================================");
		}
	//Método para exibir Pokemons Lendarios
		public void exibirPokemonsLendarios(List<PokemonLendario> listaPokemonsLendarios) {
		    Collections.sort(listaPokemonsLendarios, Comparator.comparing(Pokemon::getNumeroPokedex));

		    System.out.println("========== P O K É M O N S   L E N D Á R I O S ==========");
		    for (PokemonLendario pokemonLendario : listaPokemonsLendarios) {
		        System.out.println("Nome: " + pokemonLendario.getNome());
		        System.out.println("Número da Pokédex: " + pokemonLendario.getNumeroPokedex());
		        System.out.println("Tipo: " + pokemonLendario.getTipo());
		        System.out.println("-----------------------------------------------");
		    }
		    System.out.println("=====================================================");
		}
	
	
}
