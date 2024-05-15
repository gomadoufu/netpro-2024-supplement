import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PracticeServer {
    private List<String> dataBase;

    PracticeServer() {
        dataBase = new ArrayList<String>();
    }

    private int enterPort(InputStream input) {
        Scanner scanner = new Scanner(input);
        System.out.print("ポート番号を入力してください: ");
        int port = scanner.nextInt();
        scanner.close();
        return port;
    }

    private Socket connect(ServerSocket server) {
        try {
            System.out.println("待機しています...");
            Socket socket = server.accept();
            return socket;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // message := "GET" index | "POST" index message
    // response := message | "OK" message
    private String router(String message) {
        String command = message.split(" ")[0];
        int index = Integer.parseInt(message.split(" ")[1]);
        // TODO: switchにする
        if (command.equals("GET")) {
            return get(index);
        } else if (command.equals("POST")) {
            String messageBody = message.split(" ")[2];
            post(messageBody);
            return "OK " + messageBody;
        } else {
            return "Invalid command";
        }
    }

    private String get(int index) {
        return this.dataBase.get(index);
    }

    private void post(String message) {
        this.dataBase.add(message);
    }

    public static void main(String[] args) throws Exception {
        PracticeServer server = new PracticeServer();
        int port = server.enterPort(System.in);

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("localhostの" + port + "番ポートで待機します");
            Socket socket = server.connect(serverSocket);
            while (true) {
                InputStream inputStream = socket.getInputStream();
                ByteArrayOutputStream data = new ByteArrayOutputStream();
                System.out.println("接続しました。相手の入力を待っています......");

                int c;
                while ((c = inputStream.read()) != '\n') {
                    data.write(c);
                }

                String response = server.router(data.toString()) + "\n";
                System.out.println("クライアントからのメッセージは" + data.toString() + "です");

                OutputStream outputStream = socket.getOutputStream();
                outputStream.write(response.getBytes());
                outputStream.flush();
                System.out.println("クライアントにメッセージを送信しました");
            }
        }
    }
}
