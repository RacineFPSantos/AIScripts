package astar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;



public class AStar {
	Scanner sc = new Scanner(System.in);
	Node grafo[][];
	
	ArrayList<Node> aberta = new ArrayList<>();
	ArrayList<Node> fechada = new ArrayList<>();
	
	int velMedia;

	public AStar(Node noInicial, Node noObjetivo, Node[][] _grafo, int _velMedia) {
		grafo = _grafo;
		velMedia = _velMedia;
		
		if(noInicial.getId() == noObjetivo.getId()) {
			System.out.println("Você já se encontra no objetivo");
			return;
		}else {
			AStarBusca(noInicial, noObjetivo);
		}
	}
	
	private void AStarBusca(Node noInicial, Node noObjetivo) {
		Node atual = noInicial;
		aberta.add(noInicial);
		
		while(aberta.size() > 0) {
			if(atual.getId() == noObjetivo.getId()) {
				System.out.println("O final encontrado");				
				mostraCaminho(atual);				
				break;
			}
			
			//H =  inicio até no e G = no até objetivo (Distancia manhattam)
			for (NodeInfo vizinho : atual.getVizinhos()) {					
				if(vizinho.getNo().getIsOpen() && !aberta.contains(vizinho.getNo())) {	
					
					if(vizinho.getNo().getCorLinha() != atual.getCorLinha()) {
						vizinho.getNo().setTrocaTrem();
					}
					
					vizinho.getNo().setParente(atual);
					vizinho.getNo().setHCost(getDistancia(vizinho.getNo(), noInicial));
					vizinho.getNo().setGCost(getDistancia(vizinho.getNo(), noObjetivo));
					vizinho.getNo().setTempo(vizinho.getPeso());
					aberta.add(vizinho.getNo());
				}		
			}
			
			atual.setIsOpen(false);
			aberta.remove(atual);
			fechada.add(atual);
			
			//TODO - Dev Tool 
			//printLista("A ", aberta);			
			//printLista("F ", fechada);
			
			atual = MelhorPossibilidade();
		}		
	}
	
	private Node MelhorPossibilidade() {		
		Node temp = aberta.get(0);
		
		for (Node node : aberta) {
			if(temp.getFCost() > node.getFCost()) {
				temp = node;
			}
		}
		
		return temp;
	}
	
	private int  getDistancia(Node no, Node outroNo) {		
		int x;
		int y;
				
		if(no.getLinha() > outroNo.getLinha()) {
			 y = no.getLinha() - outroNo.getLinha();
		}else {
			y = outroNo.getLinha() - no.getLinha();
		}
		
		if(no.getColuna() > outroNo.getColuna()) {
			 x = no.getColuna() - outroNo.getColuna();
		}else {
			x = outroNo.getColuna() - no.getColuna();
		}
		
		int dist = Math.abs(x) + Math.abs(y);
		return Math.abs(x) + Math.abs(y);		
	}
	
	private void mostraCaminho(Node no) {
		Node atual = no;
		int tempo = 0;
				
		ArrayList<Integer> temp = new ArrayList<>();
		temp.add(atual.getId());
		
		while(atual.getParente() != null) {	
			tempo += atual.getTempo();
			atual = atual.getParente();	
			temp.add(atual.getId());				
		}
				
		Collections.reverse(temp);
		
		for (Integer inte : temp) {
			System.out.print(inte + " ");
		}

		tempo /= (velMedia * 100) / 6;
		System.out.println("Tempo estimado: " + tempo + " Minutos");
	}
	
	//TODO - Dev Tool  
	private int printLista(String msg, ArrayList<Node> list) {	
		for (Node node : list) {
			System.out.print(node.getId() + msg);
		}
		System.out.println("");
		return 0;
	}
}
