import java.util.ArrayList;
import java.util.Scanner;

public class Principal {
	
	static Scanner teclado = new Scanner(System.in);
	static ArrayList<Transacao> al;
	
	public static void main(String[] args) {
		Conta conta = new Conta();
		int x = -1;//contador para armazenar a resposta do menu
		do{//menu de selecao
			System.out.println(" ---Menu---");
			System.out.println("0 - sair");
			System.out.println("1 - incluir deposito");
			System.out.println("2 - incluir um saque em dinheiro");
			System.out.println("3 - incluir um pagamento com o cartao de debito");
			System.out.println("4 - incluir um pagamento com cheque");
			System.out.println("5 - imprimir extrato de um mes");
			System.out.println("6 - imprimir extrato de determinado intervalo de tempo");
			System.out.println("7 - imprimir extrato de todas as transacoes");
			System.out.print("Informe a opcao desejada: ");
			x = teclado.nextInt();
			teclado.nextLine();
			System.out.println();
			switch(x){
			case 0:
				System.out.println("\nAte a proxima! \n");
				break;
			case 1:
				conta.AddDeposito();
				break;
			case 2:
				conta.AddSaque();
				break;
			case 3:
				conta.AddPagamentoDebito();
				break;
			case 4:
				conta.AddPagamentoCheque();
				break;
			case 5:
				conta.ImprimirExtratoMes();
				break;
			case 6:
				conta.ImprimeExtratoIntervalo();
				break;
			case 7:
				conta.ImprimeExtratoInteiro();
				break;
			default:
				System.out.println("Numero invalido, por favor insira outro");
				break;
			}
		}while(x != 0);
	}
}