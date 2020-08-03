package astar;

import java.util.Scanner;

public class AStarControladora {
	Scanner sc = new Scanner(System.in);
	
	Node stations[] = new Node[14];
	
	Node matriz[][] = new Node[5][6];
	AStar as;

	public AStarControladora() {	
		GerandoDados();				
		MainMenu();	
	}
	
	public void MainMenu() {
		int start = 0, goal = 0, velMedia = 40;
		
		try {
			
			System.out.println("As estações vão de E1 a E14");
			System.out.println("por favor digite o nome da estação (EX: E1)");		
			
			System.out.println("Escolha qual a estação Inicial");
			String leitor = sc.next();	
			leitor = leitor.substring(1);
			start = Integer.parseInt(leitor);
		
			System.out.println("Escolha qual a estação Objetivo");
			leitor = sc.next();	
			leitor = leitor.substring(1);
			goal = Integer.parseInt(leitor);
			
			System.out.println("Digite a velocidade media do Trem");
			System.out.println("O trem de Paris tem velocidade Media de 40Km/h");
			System.out.println("Digite o valor sem o Km, somente os números");
			
			velMedia = sc.nextInt();	
		
		}catch(NumberFormatException e) {
			System.out.println("Digite o nome da estação corretamente EX: E1");
		}
		
		EncontraEstacao(start, goal);		
	}
	
	private void EncontraEstacao(int _start, int _goal){
		Node start = null;				
		Node goal = null;
		
		for (Node station : stations) {
			if(station.getId() == _start) {
				start = station;
			}
			
			if(station.getId() == _goal) {
				goal = station;
			}
		}
		
		if(goal != null && start != null) {
			PrintMatriz();
			System.out.println("");
			as = new AStar(start, goal, matriz, 40);
		}
		else 
		{
			System.out.println("Uma das estações não está correta, tenta novamente");
		}
	}
	
	private void GerandoDados(){
		
		stations[0] = new Node(1, 2, 0);
		matriz[2][0] = stations[0];
		
		stations[1] = new Node(2, 2, 1);		
		matriz[2][1] = stations[1];
		
		stations[2] = new Node(3, 2, 2);
		matriz[2][2] = 	stations[2];

		stations[3] = new Node(4, 2, 3);
		matriz[2][3] = 	stations[3];

		stations[4] = new Node(5, 2, 4);
		matriz[2][4] = 	stations[4];

		stations[5] = new Node(6, 2, 5);
		matriz[2][5] = 	stations[5];

		stations[6] = new Node(7, 3, 5);
		matriz[3][5] = 	stations[6];

		stations[7] = new Node(8, 1, 4);
		matriz[1][4] = stations[7];	

		stations[8] = new Node(9, 1, 1);
		matriz[1][1] = stations[8];

		stations[9] = new Node(10, 3, 1);
		matriz[3][1] = stations[9];

		stations[10] = new Node(11, 0, 1);	
		matriz[0][1] = stations[10];

		stations[11] = new Node(12, 0, 4);	
		matriz[0][4] = stations[11];

		stations[12] = new Node(13, 3, 3);	
		matriz[3][3] = stations[12];

		stations[13] = new Node(14, 4, 3);
		matriz[4][3] = stations[13];
		
		//No1
		matriz[2][0].setNodeInfo(new NodeInfo(matriz[2][1], 4580));		
		
		//No2
		matriz[2][1].setNodeInfo(new NodeInfo(matriz[2][0], 4580));
		matriz[2][1].setNodeInfo(new NodeInfo(matriz[2][2], 2300));
		matriz[2][1].setNodeInfo(new NodeInfo(matriz[1][1], 2760));
		matriz[2][1].setNodeInfo(new NodeInfo(matriz[3][1], 790));	
		
		//No3
		matriz[2][2].setNodeInfo(new NodeInfo(matriz[2][1], 2300));
		matriz[2][2].setNodeInfo(new NodeInfo(matriz[2][3], 2000));
		matriz[2][2].setNodeInfo(new NodeInfo(matriz[3][3], 3200));
		
		//No4
		matriz[2][3].setNodeInfo(new NodeInfo(matriz[2][2], 2000));	
		matriz[2][3].setNodeInfo(new NodeInfo(matriz[2][4], 3590));	
		matriz[2][3].setNodeInfo(new NodeInfo(matriz[3][3], 3120));	
		
		//No5
		matriz[2][4].setNodeInfo(new NodeInfo(matriz[2][3], 3590));
		matriz[2][4].setNodeInfo(new NodeInfo(matriz[2][5], 680));
		matriz[2][4].setNodeInfo(new NodeInfo(matriz[1][4], 5380));	
		
		//No6
		matriz[2][5].setNodeInfo(new NodeInfo(matriz[2][4], 680));	
		matriz[2][5].setNodeInfo(new NodeInfo(matriz[3][5], 2000));	
		
		//No7
		matriz[3][5].setNodeInfo(new NodeInfo(matriz[2][5], 2000));	
		
		//No8
		matriz[1][4].setNodeInfo(new NodeInfo(matriz[2][4], 5380));	
		matriz[1][4].setNodeInfo(new NodeInfo(matriz[1][1], 1500));	
		matriz[1][4].setNodeInfo(new NodeInfo(matriz[0][4], 1630));			
		
		//No9
		matriz[1][1].setNodeInfo(new NodeInfo(matriz[2][1], 2760));
		matriz[1][1].setNodeInfo(new NodeInfo(matriz[1][4], 1500));
		matriz[1][1].setNodeInfo(new NodeInfo(matriz[0][1], 4480));
		
		//No10
		matriz[3][1].setNodeInfo(new NodeInfo(matriz[2][1], 790));	
		
		//No11
		matriz[0][1].setNodeInfo(new NodeInfo(matriz[1][1], 4480));	
		
		//No12
		matriz[0][4].setNodeInfo(new NodeInfo(matriz[1][4], 1630));	
		
		//No13
		matriz[3][3].setNodeInfo(new NodeInfo(matriz[2][2], 3200));
		matriz[3][3].setNodeInfo(new NodeInfo(matriz[2][3], 3120));
		matriz[3][3].setNodeInfo(new NodeInfo(matriz[4][3], 1530));
		
		//No14
		matriz[4][3].setNodeInfo(new NodeInfo(matriz[3][3], 1530));			
	}
	
	private void PrintMatriz() {		
		System.out.print("[  ]");
		for (int i = 0; i < matriz[1].length; i++) {
			System.out.print("  C [" + i + "] ");
		}		
		System.out.println();
		
		for (int i = 0; i < matriz.length; i++) {
			
			System.out.print("R[" + i + "]  ");			
			for (int j = 0; j < matriz[i].length; j++) {
				if(matriz[i][j] == null) {
					System.out.print("[XXX]   ");
				}else {
					if(matriz[i][j].getId() < 10) {
						System.out.print("[E" + matriz[i][j].getId() +" ]   ");
					}else {
						System.out.print("[E" + matriz[i][j].getId() +"]   ");
					}
				}
				
			}
			System.out.println();
		}
	}
}
