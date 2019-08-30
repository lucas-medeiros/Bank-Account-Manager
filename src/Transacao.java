import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;


public class Transacao implements Comparable<Transacao> {
	
	static String[] tiposVetor = {"Deposito", "Saque", "Pagamento com cheque",
									"Pagamento com cartao de debito"};
	private int tipo;
	private GregorianCalendar data;
	private int valor;
	
	public Transacao(int tipo, GregorianCalendar data, int valor) {
		super();
		this.tipo = tipo;
		this.data = data;
		this.valor = valor;
	}
	
	public Transacao(int tipo, int dia, int mes, int ano, int valor){
		super();
		this.tipo = tipo;
		data = new GregorianCalendar(ano, mes - 1, dia);
		this.valor = valor;
	}

	public int getTipo() {
		return tipo;
	}
	
	public String getTipoString(){
		return tiposVetor[this.getTipo()];
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public GregorianCalendar getData() {
		return data;
	}

	public void setData(GregorianCalendar data) {
		this.data = data;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	public int compareTo(Transacao t) {
		return this.getData().compareTo(t.getData());
	}
	
	public String toString(){
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        String sData = sdf.format(data.getTime());
		return this.getTipoString() + " feito no dia: " + sData + "\nNo valor de: R$" + this.getValor() + ",00";
	}
}