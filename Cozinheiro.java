
public class Cozinheiro extends Thread {
	private Caldeirao caldeirao;
	private int qtdCaldeiraoComplete = 0;

	public Cozinheiro(Caldeirao caldeirao) {
		this.caldeirao = caldeirao;
	}

	@Override
	public void run() {
		while (true) {
			try {
				preparaJantar();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

	private synchronized void preparaJantar() throws InterruptedException {
		setQtdCaldeiraoComplete(this.getQtdCaldeiraoComplete() + 1);

		while (this.caldeirao.getM() > 0)
			wait();

		System.out.println("Cozinheiro acordado!");
		System.out.println("Cozinheiro preparando o jantar!");

		sleep(5000);

		this.caldeirao.setM(5);
		notify();
	}

	public synchronized void Servir(Canibal canibal) throws InterruptedException {
		if (this.caldeirao.getM() > 0) {
			System.out.println( canibal.getNome() + " está se servindo!");
			sleep(1000);
			this.caldeirao.setM(this.caldeirao.getM() - 1);
			canibal.prato = true;
		} else {
			notify();
		}

	}

	public void Comer(Canibal canibal) throws InterruptedException {
		System.out.println( canibal.getNome() + " está comendo!");
		canibal.setQtdComidas(canibal.getQtdComidas() + 1);
		canibal.prato = false;
		canibal.qtdDormiu++;
		sleep(3000);
	}

	public int getQtdCaldeiraoComplete() {
		return qtdCaldeiraoComplete;
	}

	public void setQtdCaldeiraoComplete(int qtdCaldeiraoComplete) {
		this.qtdCaldeiraoComplete = qtdCaldeiraoComplete;
	}

}
