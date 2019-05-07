
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

		while (this.caldeirao.getM() > 0) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		System.out.println("Cozinheiro acordado!");
		System.out.println("Cozinheiro preparando o jantar!");

		sleep(5000);

		this.caldeirao.setM(5);
		notify();
	}

	public synchronized void Servir(Canibal canibal) throws InterruptedException {
		notify();
		if (this.caldeirao.getM() > 0) {

			this.caldeirao.setM(this.caldeirao.getM() - 1);

			// wait(1000);
			System.out.println("O canibal " + canibal.getNome() + " está se servindo!");

			sleep(1000);

			Comer(canibal);

		} else {
			notify();
		}

	}

	public void Comer(Canibal canibal) {
		System.out.println("O canibal " + canibal.getNome() + " está comendo!");
		canibal.setQtdComidas(canibal.getQtdComidas() + 1);
		try {

			sleep(3000);

		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public int getQtdCaldeiraoComplete() {
		return qtdCaldeiraoComplete;
	}

	public void setQtdCaldeiraoComplete(int qtdCaldeiraoComplete) {
		this.qtdCaldeiraoComplete = qtdCaldeiraoComplete;
	}

}
