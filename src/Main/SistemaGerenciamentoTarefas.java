package Main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Tarefa {
	private String descricao;
	private boolean concluida;

	public Tarefa(String descricao) {
		this.descricao = descricao;
		this.concluida = false;
	}

	public void marcarComoConcluida() {
		this.concluida = true;
	}


	public void desmarcarComoConcluida() {
		this.concluida = false;
	}


	public String getDescricao() {
		return descricao;
	}


	public boolean isConcluida() {
		return concluida;
	}

	@Override
	public String toString() {
		return (concluida ? "[X] " : "[ ] ") + descricao;
	}
}


class ListaTarefas {
	private List<Tarefa> tarefas;


	public ListaTarefas() {
		this.tarefas = new ArrayList<>();
	}


	public void adicionarTarefa(String descricao) {
		Tarefa tarefa = new Tarefa(descricao);
		tarefas.add(tarefa);
	}


	public void removerTarefa(int indice) {
		if (indice >= 0 && indice < tarefas.size()) {
			tarefas.remove(indice);
		} else {
			System.out.println("Índice inválido!");
		}
	}


	public void marcarTarefaComoConcluida(int indice) {
		if (indice >= 0 && indice < tarefas.size()) {
			tarefas.get(indice).marcarComoConcluida();
		} else {
			System.out.println("Índice inválido!");
		}
	}


	public void exibirTarefas() {
		if (tarefas.isEmpty()) {
			System.out.println("Nenhuma tarefa adicionada ainda.");
		} else {
			for (int i = 0; i < tarefas.size(); i++) {
				System.out.println(i + ": " + tarefas.get(i));
			}
		}
	}
}

//Classe principal SistemaGerenciamentoTarefas - Ponto de entrada do sistema
public class SistemaGerenciamentoTarefas {
	public static void main(String[] args) {
		ListaTarefas listaTarefas = new ListaTarefas(); 
		Scanner sc = new Scanner(System.in);
		int opcao;

		do {
			// Menu do sistema
			System.out.println("\nSistema de Gerenciamento de Tarefas");
			System.out.println("1. Adicionar Tarefa");
			System.out.println("2. Remover Tarefa");
			System.out.println("3. Marcar Tarefa como Concluída");
			System.out.println("4. Exibir Tarefas");
			System.out.println("0. Sair");
			System.out.print("Escolha uma opção: ");
			opcao = sc.nextInt();
			sc.nextLine(); // Consumir a nova linha após nextInt()

			switch (opcao) {
			case 1:
				System.out.print("Digite a descrição da tarefa: ");
				String descricao = sc.nextLine();
				listaTarefas.adicionarTarefa(descricao);
				break;
			case 2:
				listaTarefas.exibirTarefas();
				System.out.print("Digite o índice da tarefa para remover: ");
				int indiceRemover = sc.nextInt();
				listaTarefas.removerTarefa(indiceRemover);
				break;
			case 3:
				listaTarefas.exibirTarefas();
				System.out.print("Digite o índice da tarefa para marcar como concluída: ");
				int indiceConcluir = sc.nextInt();
				listaTarefas.marcarTarefaComoConcluida(indiceConcluir);
				break;
			case 4:
				listaTarefas.exibirTarefas();
				break;
			case 0:
				System.out.println("Saindo do sistema...");
				break;
			default:
				System.out.println("Opção inválida, tente novamente.");
			}
		} while (opcao != 0);

		sc.close(); 
	}
}
