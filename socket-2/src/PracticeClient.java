import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class PracticeClient {
    private int enterPort(Scanner s, InputStream input) {
        System.out.print("ポート番号を入力してください: ");
        int port = s.nextInt();
        s.nextLine(); // 改行文字を読み込む
        return port;
    }

    public static void main(String[] args) throws Exception {
        PracticeClient client = new PracticeClient();
        Scanner scanner = new Scanner(System.in);
        int port = client.enterPort(scanner, System.in);
        try (Socket socket = new Socket("localhost", port)) {
            System.out.println("サーバーに接続しました");
            while (true) {
                System.out.println("メッセージを入力してください:");
                String message = scanner.nextLine() + "\n";
                System.out.println("メッセージを送信します: " + message);

                OutputStream outputStream = socket.getOutputStream();

                outputStream.write(message.getBytes());

                System.out.println("メッセージを送信しました");
                outputStream.flush();

                ByteArrayOutputStream data = new ByteArrayOutputStream();
                InputStream inputStream = socket.getInputStream();
                int c;
                while ((c = inputStream.read()) != '\n') {
                    data.write(c);
                }
                System.out.println("サーバーからのメッセージを受信しました: " + data.toString());
            }
        }
    }
}
