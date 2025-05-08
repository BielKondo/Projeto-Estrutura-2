//*************************** ATENÇÃO! ****************************
// O método main() deve ser alterado somente nos comentários TODO.
// Todas as outras instruções devem permanecer intactas e o código
// deve funcionar conforme descrito no enunciado da atividade.
//*************************** ATENÇÃO! ****************************
// arquivo: src/MainApl2.java

// Eduardo Kenji Hernandes Ikematu - 10439924; Gabriel Hideaquy Kondo - 10436238; João Pedro Sinzato Bocchini - 10440034
// TODO: Listar todas as referências consultadas para solucionar a atividade.

import apl2.DLinkedList;
import apl2.LinkedListOriginal;
import apl2.Node;
import apl2.Operation;

public class MainApl2 {
	
	public static void main(String[] args) {
		LinkedListOriginal list = new LinkedListOriginal();

		list.insert(680, "Zacarias", -1, 0);
		list.insert(579, "Yasmin", 9, 3);
		list.insert(468, "Xavier", 8, 2);
		list.insert(357, "Wilma", 5, -1);
		list.insert(246, "Vanderlei", 10, 0);
		list.insert(135, "Ursula", 9, 1);
		list.insert(505, "Thales", -1, 0);
		list.insert(464, "Samanta", 8, 3);
		list.insert(373, "Ronildo", -1, -1);
		list.insert(282, "Quiteroa", 3, 9);
		list.insert(191, "Plinio", 0, 3);
		list.insert(987, "Odete", 4, 7);
		list.insert(654, "Nivaldo", 2, 1);
		list.insert(321, "Matilda", 6, 3);
		list.insert(789, "Leonidas", 5, 2);
		list.insert(456, "Karen", 9, 9);
		list.insert(123, "Jorge", 7, 5);
		list.insert(999, "Ivone", -1, -1);
		list.insert(888, "Hector", 0, 1);
		list.insert(777, "Gertrudes", 0, -1);
		list.insert(666, "Felix", 2, 3);
		list.insert(555, "Edna", 4, 5);
		list.insert(444, "Denis", -1, 0);
		list.insert(333, "Cida", 6, 7);
		list.insert(222, "Breno", 8, 9);
		list.insert(111, "Allana", 10, 0);
		
		System.out.println(">>>>>>>>>> Dados originais (sistema legado) >>>>>>>>>>");
		System.out.println(list);
		System.out.println("<<<<<<<<<< Dados originais (sistema legado) <<<<<<<<<<\n");
		
		DLinkedList fixedList = Operation.map(list);
		System.out.println(">>>>>>>>>> Dados convertidos para a nova representação dos dados >>>>>>>>>>");
		System.out.println(fixedList);
		System.out.println("<<<<<<<<<< Dados convertidos para a nova representação dos dados <<<<<<<<<<\n");
		
		DLinkedList filteredGradedList = Operation.filterRemoveNonGraded(fixedList);
		System.out.println(">>>>>>>>>> Lista filtrada (somente notas válidas) >>>>>>>>>>");
		System.out.println(filteredGradedList);
		System.out.println("<<<<<<<<<< Lista filtrada (somente notas válidas) <<<<<<<<<<\n");
		
		DLinkedList filteredNonGradedList = Operation.filterRemoveGraded(fixedList);
		System.out.println(">>>>>>>>>> Lista filtrada (somente 'ausência de nota') >>>>>>>>>>");
		System.out.println(filteredNonGradedList);
		System.out.println("<<<<<<<<<< Lista filtrada (somente 'ausência de nota') <<<<<<<<<<\n");

		float average = Operation.reduce(filteredGradedList);
		System.out.println(">>>>>>>>>> Média das notas válidas >>>>>>>>>>");
		System.out.println(average);
		System.out.println("<<<<<<<<<< Média das notas válidas <<<<<<<<<<\n");
		
		DLinkedList aboveAverageList = Operation.filterRemoveBelowAverage(filteredGradedList, average);
		System.out.println(">>>>>>>>>> Lista com notas acima da média >>>>>>>>>>");
		System.out.println(aboveAverageList);
		System.out.println("<<<<<<<<<< Lista com notas acima da média <<<<<<<<<<\n");
		
		String contents = Operation.mapToString(fixedList);
		System.out.println(">>>>>>>>>> Lista mapeada para uma única string >>>>>>>>>>");
		System.out.println(contents);
		System.out.println("<<<<<<<<<< Lista mapeada para uma única string <<<<<<<<<<\n");
		
		
		// TODO: Salvar o conteúdo da String contents em um arquivo chamado "dados.csv".

		
		Node test1 = fixedList.getNode("23.S1-999");
		System.out.println(">>>>>>>>>> test1 >>>>>>>>>>\n" + test1 + "\n<<<<<<<<<< test1 <<<<<<<<<<\n");

		Node test2 = fixedList.removeNode("23.S1-999");
		System.out.println(">>>>>>>>>> test2 >>>>>>>>>>\n" + test2 + "\n<<<<<<<<<< test2 <<<<<<<<<<\n");

		Node test3 = fixedList.getNode("23.S1-999");
		System.out.println(">>>>>>>>>> test3 >>>>>>>>>>\n" + test3 + "\n<<<<<<<<<< test3 <<<<<<<<<<\n");

		aboveAverageList.clear();
		System.out.println(">>>>>>>>>> aboveAverageList.clear() >>>>>>>>>>\n" + aboveAverageList + "\n<<<<<<<<<< aboveAverageList.clear() <<<<<<<<<<\n");

		DLinkedList testList = new DLinkedList();
		// TODO: Inserir um nó no início da lista testList com os dados ("ABC", "John Doe", 4.7f).
		// TODO: Inserir um nó no final da lista testList com os dados ("XYZ", "Jane Doe", 9.9f).
		// TODO: Inserir um nó no início da lista testList com os dados ("321", "Test", 2.3f).
		// TODO: Inserir um nó no final da lista testList com os dados ("Nothing", "Yada yada yada", 99.9f).
		System.out.println(">>>>>>>>>> testList >>>>>>>>>>\n" + testList  + "\n<<<<<<<<<< testList <<<<<<<<<<\n");
		System.out.println("testList.getHead(): " + testList.getHead());
		System.out.println("testList.getTail(): " + testList.getTail());
		System.out.println("testList.removeHead(): " + testList.removeHead());
		System.out.println("testList.removeTail(): " + testList.removeTail() + '\n');
		System.out.println(">>>>>>>>>> testList >>>>>>>>>>\n" + testList  + "\n<<<<<<<<<< testList <<<<<<<<<<\n");
		System.out.println("testList.getHead(): " + testList.getHead());
		System.out.println("testList.getTail(): " + testList.getTail());
		System.out.println("testList.removeNode(\"ABC\"): " + testList.removeNode("ABC") + '\n');
		System.out.println(">>>>>>>>>> testList >>>>>>>>>>\n" + testList  + "\n<<<<<<<<<< testList <<<<<<<<<<\n");
		System.out.println("testList.getHead(): " + testList.getHead());
		System.out.println("testList.getTail(): " + testList.getTail() + '\n');
		// TODO: Inserir um nó no início da lista testList com os dados ("qwerty", "QWERTY", 1.2f).
		// TODO: Inserir um nó no final da lista testList com os dados ("WASD", "wasd", 3.4f).
		// TODO: Inserir um nó no início da lista testList com os dados ("ijkl", "IJKL", 5.6f).
		// TODO: Inserir um nó no final da lista testList com os dados ("1234", "Um Dois Tres Quatro", 7.8f).
		System.out.println(">>>>>>>>>> testList >>>>>>>>>>\n" + testList  + "\n<<<<<<<<<< testList <<<<<<<<<<\n");
		testList.clear();
		System.out.println(">>>>>>>>>> testList.clear() >>>>>>>>>>\n" + testList  + "\n<<<<<<<<<< testList.clear() <<<<<<<<<<\n");
	}

}
