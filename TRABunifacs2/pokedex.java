package k2;

import java.util.ArrayList;
import java.util.Scanner;



public class pokedex {
	Scanner scanner = new Scanner(System.in);
    ArrayList<Pokemons> pokemons = new ArrayList<Pokemons>();

    public void menu() {
        System.out.println("=============== M E N U =============== ");
        System.out.println("[ 1 ] Adicionar Pokemon ");
        System.out.println("[ 2 ] Exibir Pokedex ");
        System.out.println("[ 3 ] Pesquisar Pokemon");
        System.out.println("[ 8 ] Sair da Pokedex");
        System.out.println("=======================================");
    
    }
    public void funcoes(){
   
        pokedex opcoes = new pokedex();
        try {
            Scanner scanner = new Scanner(System.in);
            int opcao = 0;

            opcoes.menu();
            opcao = scanner.nextInt();

            while (opcao != 8) {
                switch (opcao) {
                    case 1:
                        scanner.nextLine();
                        opcoes.adicionarPokemon(pokemons);
                        break;
                    case 2:
                        opcoes.exibirPokemons(pokemons);
                        System.out.println("Para descobrir mais informações sobre algum Pokemon especifico, recomendamos pesquisar pelo nome do Pokemon desejado.");
                        break;
                    case 3:
                        System.out.println("Digite o nome do pokemon que deseja buscar: ");
                        String nomeP = scanner.next();
                        opcoes.buscarPokemon(pokemons, nomeP);
                        break;
                    default:
                        System.out.println("Opcao invalida, tente novamente");
                        break;
                }

                opcoes.menu();
                opcao = scanner.nextInt();
            }

            scanner.close();
        } catch (Exception ex) {
            System.out.println("Opcao invalida, programa encerrando...");
        }
    }

    public void adicionarPokemon(ArrayList<Pokemons> pokemons) {
        System.out.println("Digite o nome do Pokémon que deseja adicionar: ");
        String nome = scanner.nextLine().trim();

        while (nome.isEmpty()) {
            System.out.println("Nome inválido. Digite novamente: ");
            nome = scanner.nextLine().trim();
        }

        System.out.println("Digite a altura do Pokémon: ");
        double altura = lerDouble();

        System.out.println("Digite o peso do Pokémon: ");
        double peso = lerDouble();

        System.out.println("Digite a região do Pokémon: ");
        String regiao = scanner.nextLine().trim();

        while (!contemApenasLetras(regiao)) {
            System.out.println("Texto inválido. Digite novamente: ");
            regiao = scanner.nextLine().trim();
        }

        System.out.println("Digite o tipo do Pokémon: ");
        String tipo = scanner.nextLine().trim();

        while (!contemApenasLetras(tipo)) {
            System.out.println("Texto inválido. Digite novamente: ");
            tipo = scanner.nextLine().trim();
        }

        System.out.println("Digite o segundo tipo do Pokémon: ");
        String tipo2 = scanner.nextLine().trim();

        while (!contemApenasLetras(tipo2)) {
            System.out.println("Texto inválido. Digite novamente: ");
            tipo2 = scanner.nextLine().trim();
        }

        Pokemons pokemon = new Pokemons(nome, altura, peso, regiao, tipo, tipo2);
        pokemons.add(pokemon);
    }

    public void exibirPokemons(ArrayList<Pokemons> pokemons) {
        for (Pokemons pokemon : pokemons) {
            System.out.println("================== Dados do Pokémon =================");
            System.out.println("Nome: " + pokemon.getNome());
            System.out.println("Altura: " + pokemon.getAltura());
            System.out.println("Peso: " + pokemon.getPeso());
            System.out.println("Região: " + pokemon.getRegiao());
            System.out.println("Tipo 1: " + pokemon.getTipo());
            System.out.println("Tipo 2: " + pokemon.getTipo2());
            System.out.println("=====================================================");
        }
    }

    public boolean buscarPokemon(ArrayList<Pokemons> pokemons, String nome) {
        String nomeFormatado = nome.trim().toLowerCase();
        for (Pokemons pokemon : pokemons) {
            if (pokemon.getNome().trim().toLowerCase().equals(nomeFormatado)) {
                System.out.println("================== Dados do Pokémon =================");
                System.out.println("Nome: " + pokemon.getNome());
                System.out.println("Altura: " + pokemon.getAltura());
                System.out.println("Peso: " + pokemon.getPeso());
                System.out.println("Região: " + pokemon.getRegiao());
                System.out.println("Tipo 1: " + pokemon.getTipo());
                System.out.println("Tipo 2: " + pokemon.getTipo2());
                System.out.println("=====================================================");
                return true;
            }
        }
        System.out.println("Pokémon não encontrado na Pokédex.");
        return false;
    }

    private boolean contemApenasLetras(String texto) {
        for (char c : texto.toCharArray()) {
            if (!Character.isLetter(c)) {
                return false;
            }
        }
        return true;
    }

    private double lerDouble() {
        while (true) {
            try {
                String input = scanner.nextLine();
                double valor = Double.parseDouble(input);
                return valor;
            } catch (NumberFormatException e) {
                System.out.println("Valor inválido. Digite novamente: ");
            }
        }
    }

  
}