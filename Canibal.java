
public class Canibal extends Thread {

	private String nome;
	private Caldeirao caldeirao;
	private Cozinheiro cozinheiro;
	private int qtdComidas = 0;
	private int qtdDormiu = 0;
	public boolean prato = false;

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
				if (prato) {
					this.cozinheiro.Comer(this);
					this.qtdDormiu++;
				}

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

	public int getQtdDormiu() {
		return qtdDormiu;
	}

	public void setQtdDormiu(int qtdDormiu) {
		this.qtdDormiu = qtdDormiu;
	}

}
