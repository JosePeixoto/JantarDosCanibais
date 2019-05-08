public class Canibal extends Thread {

	private String nome;
	private Caldeirao caldeirao;
	private Cozinheiro cozinheiro;
	private int qtdComidas = 0;
	int qtdDormidas = 0;
	private int qtdServidas = 0;
	public boolean prato = false;

	public Canibal(String nome, Caldeirao caldeirao, Cozinheiro cozinheiro) {
		this.nome = nome;
		this.caldeirao = caldeirao;
		this.cozinheiro = cozinheiro;
	}

	@Override
	public void run() {

		while (true) {

			if (this.getQtdComidas() == 18) {
				Thread.currentThread().stop();
			}

			try {
				synchronized (this) {
					this.cozinheiro.Servir(this);
				}
				if (prato) {
					this.cozinheiro.Comer(this);
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

	public int getQtdDormidas() {
		return qtdDormidas;
	}

	public void setQtdDormidas(int qtdDormidas) {
		this.qtdDormidas = qtdDormidas;
	}

	public int getQtdServidas() {
		return qtdServidas;
	}

	public void setQtdServidas(int qtdServidas) {
		this.qtdServidas = qtdServidas;
	}

}
