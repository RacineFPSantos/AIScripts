package astar;

public class NodeInfo {
	Node no;
	int peso;
	
	NodeInfo(Node _no, int _peso){
		no = _no;
		peso = _peso;
	}
	
	public Node getNo() {
		return no;
	}
	
	public int getPeso() {
		return peso;
	}
}
