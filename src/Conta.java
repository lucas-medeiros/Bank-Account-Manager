import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Conta {
	
	private static int saldo = 0;
	static Scanner teclado = new Scanner(System.in);
	private static ArrayList<Transacao> al;
	
	public Conta() {
		al = new ArrayList<Transacao>();
	}

	public static int getSaldo() {
		return saldo;
	}

	public static void setSaldo(int saldo) {
		Conta.saldo = saldo;
	}
	
	public int PerguntaDia(){
		int dia = 0;
		while((dia > 31) || (dia < 1)){//evita datas invalidas
			System.out.println("Insira o dia: ");
			dia = teclado.nextInt();
			if((dia > 31) || (dia < 1)){
				System.out.println("Numero invalido, por favor insira outro");
			}
		}
		teclado.nextLine();
		return dia;
	}
	
	public int PerguntaMes(){
		int mes = 0;
		while((mes > 12) || (mes < 1)){
			System.out.println("Insira o mes: ");
			mes = teclado.nextInt();
			if((mes > 12) || (mes < 1)){
				System.out.println("Numero invalido, por favor insira outro");
			}
		}
		teclado.nextLine();
		return mes;
	}
	
	public int PerguntaAno(){
		int ano = 0;
		System.out.println("Insira o ano: ");
		ano = teclado.nextInt();
		teclado.nextLine();
		return ano;
		
	}
	
	public void AddDeposito(){
		int deposito = -1, dia = 0, mes = 0, ano = 0;
		System.out.println("Insira a quantia que deseja depositar: ");
		while(deposito < 0){
			deposito = teclado.nextInt();
			if (deposito < 0){
				System.out.println("Numero invalido, por favor insira outro");
			}
		}
		teclado.nextLine();
		dia = this.PerguntaDia();
		mes = this.PerguntaMes();
		ano = this.PerguntaAno();
		saldo += deposito;
		al.add(new Transacao(0, dia, mes, ano, deposito));
		System.out.println("Quantia depositada com sucesso");
	}

	public void AddSaque(){
		int saque = -1, dia = 0, mes = 0, ano = 0;
		System.out.println("Insira a quantia que deseja sacar: ");
		while((saque < 0) || (saque > saldo)){
			saque = teclado.nextInt();
			if ((saque < 0) || (saque > saldo)){
				System.out.println("Numero invalido, por favor insira outro");
			}
		}
		teclado.nextLine();
		dia = this.PerguntaDia();
		mes = this.PerguntaMes();
		ano = this.PerguntaAno();
		saldo -= saque;
		al.add(new Transacao(1, dia, mes, ano, saque));
		System.out.println("Quantia sacada com sucesso");
	}
	
	public void AddPagamentoDebito(){
		int pagamento = -1, dia = 0, mes = 0, ano = 0;
		System.out.println("Insira o valor do pagamento: ");
		while((pagamento < 0) || (pagamento > saldo)){
			pagamento = teclado.nextInt();
			if ((pagamento < 0) || (pagamento > saldo)){
				System.out.println("Numero invalido, por favor insira outro");
			}
		}
		teclado.nextLine();
		dia = this.PerguntaDia();
		mes = this.PerguntaMes();
		ano = this.PerguntaAno();
		saldo -= pagamento;
		al.add(new Transacao(2, dia, mes, ano, pagamento));
		System.out.println("Pagamento realizado com sucesso");
	}
	
	public void AddPagamentoCheque(){
		int pagamento = -1, dia = 0, mes = 0, ano = 0;
		System.out.println("Insira o valor do pagamento: ");
		while((pagamento < 0) || (pagamento > saldo)){
			pagamento = teclado.nextInt();
			if ((pagamento < 0) || (pagamento > saldo)){
				System.out.println("Numero invalido, por favor insira outro");
			}
		}
		teclado.nextLine();
		dia = this.PerguntaDia();
		mes = this.PerguntaMes();
		ano = this.PerguntaAno();
		saldo -= pagamento;
		al.add(new Transacao(3, dia, mes, ano, pagamento));
		System.out.println("Pagamento realizado com sucesso");
	}
	
	public void ImprimirExtratoMes(){
		int mes = this.PerguntaMes();
		Collections.sort(al);
		for (int i = 0; i < al.size(); i++) {
			if (al.get(i).getData().get(Calendar.MONTH) + 1 == mes){
				System.out.println(al.get(i) + "\n");
			}
		}
	}
	
	public void ImprimeExtratoIntervalo(){
		int dia, mes, ano;
		GregorianCalendar inicio, fim;
		System.out.println("Insira a data de inicio do periodo que deseja verificar");
		dia = this.PerguntaDia();
		mes = this.PerguntaMes();
		ano = this.PerguntaAno();
		inicio = new GregorianCalendar(ano, mes-1, dia);
		System.out.println("Insira a data de termino do periodo que deseja verificar");
		dia = this.PerguntaDia();
		mes = this.PerguntaMes();
		ano = this.PerguntaAno();
		fim = new GregorianCalendar(ano, mes-1, dia);
		Collections.sort(al);
		for (int i = 0; i < al.size(); i++) {
			if((al.get(i).getData().compareTo(inicio) > 0) && (al.get(i).getData().compareTo(fim) < 0)){
				System.out.println(al.get(i) + "\n");
			}
		}
	}
	
	public void ImprimeExtratoInteiro(){
		for (int i = 0; i < al.size(); i++) {
			System.out.println(al.get(i) + "\n");
		}
	}
	
}