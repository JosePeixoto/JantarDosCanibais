
public class Canibal extends Thread {

	private String nome;
	private Caldeirao caldeirao;
	private Cozinheiro cozinheiro;
	private int qtdComidas = 0;

	public Canibal(String nome, Caldeirao caldeirao, Cozinheiro cozinheiro) {
		this.nome = nome;
		this.caldeirao = caldeirao;
		this.cozinheiro = cozinheiro;
	}

	@Override
	public void run() {

		while (true) {
			try {
				this.cozinheiro.Servir(this);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}

	}

	public String getNome() {
		return nome;
	}

	public int getQtdComidas() {
		return qtdComidas;
	}

	public void setQtdComidas(int qtdComidas) {
		this.qtdComidas = qtdComidas;
	}

}
