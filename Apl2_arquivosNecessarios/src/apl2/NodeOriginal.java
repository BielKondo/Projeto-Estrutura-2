//******************** ATENÇÃO! *********************
// O conteúdo deste arquivo não deve ser modificado!
//******************** ATENÇÃO! *********************
// arquivo: src/apl2/NodeOriginal.java

package apl2;

public class NodeOriginal {
	
	private int id;
	private String nome;
	private int inteiro;
	private int decimal;
	private NodeOriginal next;
	
	public NodeOriginal() {
		this(-1, "", 0, 0, null);
	}
	
	public NodeOriginal(int id, String nome, int inteiro, int decimal, NodeOriginal next) {
		this.id = id;
		this.nome = nome;
		this.inteiro = inteiro;
		this.decimal = decimal;
		this.next = next;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public int getInteiro() {
		return inteiro;
	}
	
	public void setInteiro(int inteiro) {
		this.inteiro = inteiro;
	}
	
	public int getDecimal() {
		return decimal;
	}
	
	public void setDecimal(int decimal) {
		this.decimal = decimal;
	}

	public NodeOriginal getNext() {
		return next;
	}
	
	public void setNext(NodeOriginal next) {
		this.next = next;
	}
	
	@Override
	public String toString() {
		return "[dados: (" + id + ";" + nome + ";" + inteiro + ";" + decimal + ") | next: " + next + "]";
	}

}