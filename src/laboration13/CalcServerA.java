package laboration13;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class CalcServerA implements Runnable {
	private ServerSocket serverSocket;
	private Thread server = new Thread(this);
	private Calculator calculator;

	public CalcServerA(Calculator calculator, int port) {
		try {
			this.calculator = calculator;
			serverSocket = new ServerSocket(port);
			server.start();
		} catch (IOException e) {
			System.err.println(e);
		}
	}

	public void run() {
		String[] parts;
		String request, response = "";
		double nbr1, nbr2, answer;
		char operation;
		System.out.println("Server startad");

		while (true) {
			try (Socket socket = serverSocket.accept();
					DataInputStream dis = new DataInputStream(socket.getInputStream());
					DataOutputStream dos = new DataOutputStream(socket.getOutputStream())) {

				request = dis.readUTF();
				parts = request.split(",");

				if (parts.length == 3) {
					try {
						nbr1 = Double.parseDouble(parts[0]);
						nbr2 = Double.parseDouble(parts[1]);
						operation = parts[2].charAt(0);
						answer = calculator.calculate(nbr1, nbr2, operation);
						response = answer + "\n" + parts[0] + parts[2] + parts[1] + "=" + answer;
					} catch (Exception e) {
						response = e.toString() + "\n" + parts[0] + parts[2] + parts[1];
					}
				} else {
					response = "Fel antal argument: " + parts.length;
				}
				dos.writeUTF(response);
				dos.flush();

			} catch (IOException e) {
				System.err.println(e);
			}
		}
	}

	public static void main(String[] args) {
		new CalcServerA(new Calculator(), 3450);
	}
}