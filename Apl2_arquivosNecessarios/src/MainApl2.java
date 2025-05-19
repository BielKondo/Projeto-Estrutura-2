package src;
//*************************** ATENÇÃO! ****************************
// O método main() deve ser alterado somente nos comentários TODO.
// Todas as outras instruções devem permanecer intactas e o código
// deve funcionar conforme descrito no enunciado da atividade.
//*************************** ATENÇÃO! ****************************
// arquivo: src/MainApl2.java

// Eduardo Kenji Hernandes Ikematu - 10439924; Gabriel Hideaquy Kondo - 10436238; João Pedro Sinzato Bocchini - 10440034
// Referências: https://pt.stackoverflow.com/questions/374001/lista-duplamente-encadeada-java, https://erinaldosn.wordpress.com/wp-content/uploads/2013/05/aula-12-lista-duplamente-encadeada.pdf, https://takeuforward-org.translate.goog/data-structure/doubly-linked-list-in-java/?_x_tr_sl=en&_x_tr_tl=pt&_x_tr_hl=pt&_x_tr_pto=tc, 

import apl2.Data;

import java.io.IOException;

import apl2.DLinkedList;
import apl2.LinkedListOriginal;
import apl2.Node;
import apl2.Operation;

import java.util.Scanner;

public class MainApl2 {
	
	public static void main(String[] args) {

		//------------------------------ Menu ------------------------------

		LinkedListOriginal lista = new LinkedListOriginal();
		DLinkedList novaLista = null;
		DLinkedList listaNotasFiltradasVálidas = null;
		DLinkedList listaNotaFiltradasInválidas = null;
		float media = 0;
		DLinkedList acimaDaMédia = null;
		String dadosMapeados = "";

		Scanner sc = new Scanner(System.in);
		int menu = 0;
		String conteudo = "";

		while (menu != 8) {	
			System.out.println("----- MENU -----\n1 - Dados originais\n2 - Dados convertidos\n3 - Lista notas filtradas válidas\n4 - Lista notas filtradas inválidas\n5 - Média de notas válidas\n6 - Notas acima da média\n7 - Lista mapeada para uma única string\n8 - Finaliza sistema");

			menu = sc.nextInt();
			
			if (menu == 1) { //lê arquivo dados.txt e apresenta todos os dados do Sistema de Notas Legado;

				try {
					conteudo = Data.loadTextFileToString("dados.txt");
					System.out.println("Conteúdo do arquivo:");
            		System.out.println(conteudo);

					String s1[] = conteudo.split("\\r?\\n|\\r"); // Separa pela quebra de linha \n
				
					for (int i = 0; i < s1.length; ++i) {
						String dados[] = s1[i].split("#");

						int id = Integer.parseInt(dados[0]);
						String nome = dados[1];
						int inteiro = Integer.parseInt(dados[2]);
						int decimal = Integer.parseInt(dados[3]);

						lista.append(id, nome, inteiro, decimal);
					}

					novaLista = Operation.map(lista);
            		listaNotasFiltradasVálidas = Operation.filterRemoveNonGraded(novaLista);
            		listaNotaFiltradasInválidas = Operation.filterRemoveGraded(novaLista);
            		media = Operation.reduce(listaNotasFiltradasVálidas);
            		acimaDaMédia = Operation.filterRemoveBelowAverage(listaNotasFiltradasVálidas, media);
            		dadosMapeados = Operation.mapToString(novaLista);

				} catch (IOException e) {
 					System.err.println("Arquivo não encontrado!");
 					e.printStackTrace();
 					System.exit(-1); // Caso queira encerrar o programa.
				}

			} else if (menu == 2) { // gera arquivo dados.csv e apresenta todos os dados do Sistema de Notas Atualizado;
				try {
    				Data.saveStringToTextFile("dados.csv", conteudo);
					System.out.println("\nArquivo dados.csv gerado com sucesso.\n");
				} catch (IOException e) {
    				System.err.println("Erro ao gravar arquivo!");
    				e.printStackTrace();
				}

			} else if (menu == 3) { // apresenta os dados somente das notas válidas filtradas
				System.out.println("Lista das Notas Filtradas Válidas");
				System.out.println(listaNotasFiltradasVálidas);

			} else if (menu == 4) { //  apresenta os dados somente das notas filtradas pela “ausência de notas”
				System.out.println("Lista das Notas Filtradas Inválidas");
				System.out.println(listaNotaFiltradasInválidas);

			} else if (menu == 5) { // apresenta a média das notas válidas filtradas
				System.out.println("Media das notas validas");
				System.out.println(media);

			} else if (menu == 6) { // apresenta os dados para as notas acima da média
				System.out.println("Notas acima da media");
				System.out.println(acimaDaMédia);

			} else if (menu == 7) { // apresenta a String contendo os dados mapeados
				System.out.println(dadosMapeados);

			} else if (menu == 8) {
				System.exit(0);;

			} else {
				System.out.println("Opcao invalida.");
			}
		}
		sc.close();



		// LinkedListOriginal list = new LinkedListOriginal();

		
		// 	try {
		// 		String conteudo = Data.loadTextFileToString("dados.txt");
	
		// 		String s1[] = conteudo.split("\\r?\\n|\\r"); // Separa pela quebra de linha \n
				
		// 		for (int i = 0; i < s1.length; ++i) {
		// 			String dados[] = s1[i].split("#");

		// 			int id = Integer.parseInt(dados[0]);
		// 			String nome = dados[1];
		// 			int inteiro = Integer.parseInt(dados[2]);
		// 			int decimal = Integer.parseInt(dados[3]);

		// 			list.append(id, nome, inteiro, decimal);
		// 		}
		// 	} catch (IOException e) {
 		// 		System.err.println("Arquivo não encontrado!");
 		// 		e.printStackTrace();
 		// 		System.exit(-1); // Caso queira encerrar o programa.
		// 	}
		
		// System.out.println(">>>>>>>>>> Dados originais (sistema legado) >>>>>>>>>>");
		// System.out.println(list);
		// System.out.println("<<<<<<<<<< Dados originais (sistema legado) <<<<<<<<<<\n");
		
		// DLinkedList fixedList = Operation.map(list);
		// System.out.println(">>>>>>>>>> Dados convertidos para a nova representação dos dados >>>>>>>>>>");
		// System.out.println(fixedList);
		// System.out.println("<<<<<<<<<< Dados convertidos para a nova representação dos dados <<<<<<<<<<\n");
		
		// DLinkedList filteredGradedList = Operation.filterRemoveNonGraded(fixedList);
		// System.out.println(">>>>>>>>>> Lista filtrada (somente notas válidas) >>>>>>>>>>");
		// System.out.println(filteredGradedList);
		// System.out.println("<<<<<<<<<< Lista filtrada (somente notas válidas) <<<<<<<<<<\n");
		
		// DLinkedList filteredNonGradedList = Operation.filterRemoveGraded(fixedList);
		// System.out.println(">>>>>>>>>> Lista filtrada (somente 'ausência de nota') >>>>>>>>>>");
		// System.out.println(filteredNonGradedList);
		// System.out.println("<<<<<<<<<< Lista filtrada (somente 'ausência de nota') <<<<<<<<<<\n");

		// float average = Operation.reduce(filteredGradedList);
		// System.out.println(">>>>>>>>>> Média das notas válidas >>>>>>>>>>");
		// System.out.println(average);
		// System.out.println("<<<<<<<<<< Média das notas válidas <<<<<<<<<<\n");
		
		// DLinkedList aboveAverageList = Operation.filterRemoveBelowAverage(filteredGradedList, average);
		// System.out.println(">>>>>>>>>> Lista com notas acima da média >>>>>>>>>>");
		// System.out.println(aboveAverageList);
		// System.out.println("<<<<<<<<<< Lista com notas acima da média <<<<<<<<<<\n");
		
		// String contents = Operation.mapToString(fixedList);
		// System.out.println(">>>>>>>>>> Lista mapeada para uma única string >>>>>>>>>>");
		// System.out.println(contents);
		// System.out.println("<<<<<<<<<< Lista mapeada para uma única string <<<<<<<<<<\n");
		
		

		
		// Node test1 = fixedList.getNode("23.S1-999");
		// System.out.println(">>>>>>>>>> test1 >>>>>>>>>>\n" + test1 + "\n<<<<<<<<<< test1 <<<<<<<<<<\n");

		// Node test2 = fixedList.removeNode("23.S1-999");
		// System.out.println(">>>>>>>>>> test2 >>>>>>>>>>\n" + test2 + "\n<<<<<<<<<< test2 <<<<<<<<<<\n");

		// Node test3 = fixedList.getNode("23.S1-999");
		// System.out.println(">>>>>>>>>> test3 >>>>>>>>>>\n" + test3 + "\n<<<<<<<<<< test3 <<<<<<<<<<\n");

		// aboveAverageList.clear();
		// System.out.println(">>>>>>>>>> aboveAverageList.clear() >>>>>>>>>>\n" + aboveAverageList + "\n<<<<<<<<<< aboveAverageList.clear() <<<<<<<<<<\n");

		// DLinkedList testList = new DLinkedList();

		// testList.insert("ABC", "John Doe", 4.7f);  // (321, Test, 2.3) ; (ABC, John Doe, 4.7) 
		// testList.append("XYZ", "Jane Doe", 9.9f);	// (XYZ, Jane Doe, 9.9) ; (Nothing, Yada yada yada, 99.9)
		// testList.insert("321", "Test", 2.3f);
		// testList.append("Nothing", "Yada yada yada", 99.9f);

		// System.out.println(">>>>>>>>>> testList >>>>>>>>>>\n" + testList  + "\n<<<<<<<<<< testList <<<<<<<<<<\n");
		// System.out.println("testList.getHead(): " + testList.getHead());
		// System.out.println("testList.getTail(): " + testList.getTail());
		// System.out.println("testList.removeHead(): " + testList.removeHead());
		// System.out.println("testList.removeTail(): " + testList.removeTail() + '\n');
		// System.out.println(">>>>>>>>>> testList >>>>>>>>>>\n" + testList  + "\n<<<<<<<<<< testList <<<<<<<<<<\n");
		// System.out.println("testList.getHead(): " + testList.getHead());
		// System.out.println("testList.getTail(): " + testList.getTail());
		// System.out.println("testList.removeNode(\"ABC\"): " + testList.removeNode("ABC") + '\n');
		// System.out.println(">>>>>>>>>> testList >>>>>>>>>>\n" + testList  + "\n<<<<<<<<<< testList <<<<<<<<<<\n");
		// System.out.println("testList.getHead(): " + testList.getHead());
		// System.out.println("testList.getTail(): " + testList.getTail() + '\n');
		
		// testList.insert("qwerty", "QWERTY", 1.2f);
		// testList.append("WASD", "wasd", 3.4f);
		// testList.insert("ijkl", "IJKL", 5.6f);
		// testList.append("1234", "Um Dois Tres Quatro", 7.8f);

		// System.out.println(">>>>>>>>>> testList >>>>>>>>>>\n" + testList  + "\n<<<<<<<<<< testList <<<<<<<<<<\n");
		// testList.clear();
		// System.out.println(">>>>>>>>>> testList.clear() >>>>>>>>>>\n" + testList  + "\n<<<<<<<<<< testList.clear() <<<<<<<<<<\n");
	}

}
