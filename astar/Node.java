package astar;

import java.util.ArrayList;

import interfaces.CorLinha;

public class Node {

	private int id;
	
	private int linha;
	private int coluna;
	
	private int gCost;
	private int hCost;
	private int tempo;
	
	private Node parente = null;
	
	private boolean isOpen = true;
	
	private CorLinha corLinha = CorLinha.AZUL;
	
	ArrayList<NodeInfo> vizinhos = new ArrayList<>();
	
	public Node(int _id, int _linha, int _coluna) {
		id = _id;
		linha = _linha;
		coluna = _coluna;
	}
	
	public Node getParente() { return parente; }
	
	public ArrayList<NodeInfo> getVizinhos() { return vizinhos;	}
	
	public void setNodeInfo(NodeInfo nodeInfo) { vizinhos.add(nodeInfo); }	
	
	public void setParente(Node _parente) {	parente = _parente;	}
	
	public void setGCost(int _g) { gCost = _g; }
	
	public void setHCost(int _h) { hCost = _h; }
	
	public void setTrocaTrem() { tempo += 4; }
	
	public void setTempo(int peso) { tempo += peso;  }
	
	public void setIsOpen(boolean _opcao) {	isOpen = _opcao; }	
	
	public int getId() { return id;	}	
	
	public int getLinha() {	return linha; }
	
	public int getColuna() { return coluna; }
	
	public int getFCost() {	return gCost + hCost; }
	
	public int getCorLinha() { return corLinha.getIdLinha(); }	
	
	public int getTempo() { return tempo;}
	
	public boolean getIsOpen() { return isOpen;	}



}
