// arquivo: src/apl2/DLinkedList.java

// Eduardo Kenji Hernandes Ikematu - 10439924; Gabriel Hideaquy Kondo - 10436238; João Pedro Sinzato Bocchini - 10440034

package apl2;

// -- A classe DLinkedList (que pertence ao pacote apl2) deve implementar uma
// lista duplamente encadeada. Os nós dessa lista são do tipo [da classe] Node.
// -- A classe deve possuir dois nós especiais, head e tail, que são
// referências para o primeiro e último nó da lista, respectivamente.
// -- A classe deve possuir um contador de quantos nós existem na lista.
// -- A classe deve sobrescrever (override) o método public String toString()
// {...}, retornando uma string com o conteúdo da lista.
// -- A classe deve implementar as operações a seguir, respeitando o
// comportamento descrito em cada operação.

public class DLinkedList {
	
	private Node head;
	private Node tail;
	private int cont;


// OPERAÇÃO:		Método construtor
// COMPORTAMENTO:	Cria uma lista vazia.
	public DLinkedList() {
		this.head = null;
		this.tail = null;
		cont = 0;
	}


// OPERAÇÃO:		insert(<dados da pessoa>)
// COMPORTAMENTO:	Aloca um Node que contém os <dados da pessoa> e insere o
//					novo nó no início da lista.
	public void insert(String ID, String nome, float nota) {
		Node novoNo = new Node(ID, nome, nota);
		novoNo.setProx(head);
		head = novoNo;
		cont++;
	}


// OPERAÇÃO:		append(<dados da pessoa>)
// COMPORTAMENTO:	Aloca um Node que contém os <dados da pessoa> e insere o
//					novo nó no final da lista.
	public void append(String ID, String nome, float nota) {
		Node novoNo = new Node(ID, nome, nota);
		novoNo.setProx(null);

		if (head == null) { // Se a lista estiver vazia
			head = tail = novoNo;
		} else {
			tail.setProx(novoNo);
			tail = novoNo;
		}
		cont++;
	}


// OPERAÇÃO: 		removeHead()
// COMPORTAMENTO:	Remove o nó do início da lista e retorna a referência do
//					nó removido.
//					Ou retorna null caso a lista esteja vazia.
	public Node removeHead() {
		if (head == null) {
			return null;
		} else {
			Node aux = head;
			head = head.getProx();
			return aux;
		}
	}


// OPERAÇÃO:		removeTail()
// COMPORTAMENTO:	Remove o nó do final da lista e retorna a referência do
//					nó removido.
//					Ou retorna null caso a lista esteja vazia.
	public Node removeTail() {
		if (head == null) {
			return null;
		}
		
		if (head == tail) {
			Node aux = tail;
			head = tail = null;
			return aux;
		}
		
		// Percorre até o penúltimo nó
		Node atual = head;
		while (atual.getProx() != tail) {
			atual = atual.getProx();
		}
	
		Node aux = tail;
		tail = atual;
		tail.setProx(null);
		return aux;
	}


// OPERAÇÃO:		removeNode(<ID da pessoa>)
// COMPORTAMENTO:	Remove o nó que contém o <ID da pessoa> da lista e retorna
//					a referência do nó removido.
//					Ou retorna null caso não exista um nó com <ID da pessoa>.
	public Node removeNode(String id) {

		if (head == null) {
			return null;
		}

		if (head.getID().equals(id)) {
			Node aux = head;
			head = head.getProx();
			cont--;
			return aux;
		}
		
		Node atual = head;
    	Node prox = head.getProx();

		while (prox != null && !prox.getID().equals(id)) {
			atual = prox;
			prox.getProx();
		}

    	if (prox == null) { // Chegou no último nó e não encontrou o ID
        	return null;
    	}

    	atual.setProx(prox.getProx()); // Caso atual.getID() == id
    	cont--;
    	return prox;
	}
	


// OPERAÇÃO:		getHead()
// COMPORTAMENTO:	Retorna uma referência para o nó do início da lista.
//					Ou retorna null caso a lista esteja vazia.
	public Node getHead() {
		return head;
	}


// OPERAÇÃO:		getTail()
// COMPORTAMENTO:	Retorna uma referência para o nó do final da lista.
//					Ou retorna null caso a lista esteja vazia.
	public Node getTail() {
		return tail;
	}


// OPERAÇÃO:		getNode(<ID da pessoa>)
// COMPORTAMENTO:	Retorna uma referência para o nó que contém o <ID da pessoa>
//					da lista.
//					Ou retorna null caso não exista um nó com <ID da pessoa>.
	public Node getNode(String id) {

		if (head == null) {
			return null;
		}

		if (head.getID().equals(id)) {
			return head;
		}

		Node atual = head;
    	Node prox = atual.getProx();

		while (prox != null && !prox.getID().equals(id)) {
			atual = prox;
			prox = prox.getProx();
		}

		if (prox == null) { // Chegou no último nó e não encontrou o ID
			return null;
		}

		return prox; // Caso atual.getID() == id
	}


// OPERAÇÃO:		count()
// COMPORTAMENTO:	Retorna a quantidade de nós da lista.
	public int count() {
		return cont;
	}


// OPERAÇÃO:		isEmpty()
// COMPORTAMENTO:	Retorna true se a lista estiver vazia ou false, caso contrário.
	public boolean isEmpty() {
		return head == null;
	}


// OPERAÇÃO:		clear()
// COMPORTAMENTO:	Esvazia a lista, liberando a memória de todos os nós da lista.
	public void clear() {
		head = null;
		tail = null;
		cont = 0;
	}


// OPERAÇÃO:		toString()
// COMPORTAMENTO:	Retorna uma string com o conteúdo da lista (caso queira, use o
//					exemplo do método toString() da classe LinkedListOriginal).
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		sb.append("(" + cont + ") \n");

		Node node = head;
		Node anterior = node;
		int cont = 0;
		int nos = count();

		sb.append("null");
		 
		while (node != null) {
			if (cont == 0) {
				sb.append(" <- (")
				  .append(node.getID())
				  .append("; ")
				  .append(node.getNome())
				  .append("; ")
				  .append(node.getNota())
				  .append(") -> ");
				  node = node.getProx();
				  sb.append(node.getID())
				    .append("\n");

				cont++;
			} else {
				sb.append(anterior.getID())
				  .append(" <- (")
				  .append(node.getID())
				  .append("; ")
				  .append(node.getNome())
				  .append("; ")
				  .append(node.getNota())
				  .append(") -> ");
				  node = node.getProx();
				  anterior = anterior.getProx();
				  if (node != null) {
					  sb.append(node.getID())
					    .append("\n");
				  }
				  cont++;
			}

			if (cont == nos) {
				cont = 0;
			}
		}
		
		sb.append("null.");
		
		return sb.toString();
	}

}