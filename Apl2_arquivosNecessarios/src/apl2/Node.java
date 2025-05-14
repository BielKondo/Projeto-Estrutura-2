// arquivo: src/apl2/Node.java

// Eduardo Kenji Hernandes Ikematu - 10439924; Gabriel Hideaquy Kondo - 10436238; João Pedro Sinzato Bocchini - 10440034

package apl2;

// -- A classe Node (que pertence ao pacote apl2) deve conter os atributos que
// representam a nova versão dos dados de uma pessoa, conforme descrito no
// enunciado da atividade Apl2.
// -- A classe deve conter os construtores apropriados, assim como os métodos
// getters e setters.
// -- A classe também representa um nó que é usado na implementação da lista
// duplamente encadeada (classe DLinkedList).
// -- A classe deve sobrescrever (override) o método public String toString()
// {...}, retornando uma string com os valores dos atributos da classe.

public class Node {
	
	private String ID;
	private String nome;
	private float nota;
	private Node anterior;
	private Node prox;

	public Node() {
		this.ID = null;
		this.nome = null;
		this.nota = 0.0f;
		this.anterior = null;
		this.prox = null;

	}

	public Node(String ID, String nome, float nota, Node anterior, Node prox) {
		this.ID = ID;
		this.nome = nome;
		this.nota = nota;
		this.anterior = anterior;
		this.prox = prox;
	}

	public String getID() {
		return ID;
	}

	public void setID(String ID) {
		this.ID = ID;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public float getNota() {
		return nota;
	}

	public void setNota(float nota) {
		this.nota = nota;
	}

	public Node getAnterior() {
		return anterior;
	}

	public void setAnterior(Node anterior) {
		this.anterior = anterior;
	}

	public Node getProx() {
		return prox;
	}

	public void setProx(Node prox) {
		this.prox = prox;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();

		String IDAnterior;
        String IDProx;

		if (anterior != null) {
    		IDAnterior = anterior.getID();
		} else {
    		IDAnterior = "null";
		}

		if (prox != null) {
    		IDProx = prox.getID();
		} else {
    		IDProx = "null";
		}

		sb.append(IDAnterior)
		  .append(" <- (")
		  .append(ID)
		  .append("; ")
		  .append(nome)
		  .append("; ")
		  .append(nota)
		  .append(") -> ")
		  .append(IDProx);




        return sb.toString();

		// String IDanterior = "null";
		// String IDprox = "null";

		// Node node = this;

		// if (anterior == null) {
		// 	//IDanterior = anterior.getID();
		// 	sb.append(IDanterior);
		// 	IDanterior = node.getID();
		// 	node = node.getProx();
		// 	IDprox = prox.getProx().getID();
		// }

		// if (prox != null) {
		// 	if (prox.getProx() == null) {
		// 		IDprox = "null";
		// 	}
		// 	//sb.append(IDprox);
		// 	IDanterior = node.getID();
		// 	node = node.getProx();
		// 	IDprox = prox.getProx().getID();
		// }

		// while (node != null) {
		// 	sb.append(IDanterior)
		//   	  .append(" <- (")
		//   	  .append(ID)
		//   	  .append("; ")
		//   	  .append(nome)
		//   	  .append("; ")
		//   	  .append(nota)
		//   	  .append(") -> ")
		//   	  .append(IDprox);
		// 	  IDanterior = node.getID();
		// 	  node = node.getProx();
		// 	  IDprox = prox.getProx().getID();
		// }

		//return sb.toString();
	}
}