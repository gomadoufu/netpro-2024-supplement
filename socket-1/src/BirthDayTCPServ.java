import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream; // 入出力関連パッケージを利用する
import java.io.ObjectOutputStream;
import java.net.ServerSocket; //ネットワーク関連のパッケージを利用する
import java.net.Socket;
// ユーティリティパッケージを利用する
import java.nio.CharBuffer;

public class BirthDayTCPServ {

    public static void main(String arg[]) {
        try {
            /* 通信の準備をする */
            ServerSocket server = new ServerSocket(5002); // ポート番号を指定し、クライアントとの接続の準備を行う
            System.out.println("接続を待ち受けています");

            Socket socket = server.accept(); // クライアントからの接続要求を待ち、
            System.out.println("接続しました");

            InputStreamReader isr = new InputStreamReader(socket.getInputStream());

            System.out.println("クライアントからのメッセージを受信しました");

            // クライアントのデータを受信する
            // バッファにデータを入れて、String型に変換する
            CharBuffer cb = CharBuffer.allocate(1024);

            /* 判定結果をクライアントに送信する */
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());

            BirthDayCake cake = new BirthDayCake();
            cake.setMessage("おめでとうございます");
            cake.setCandles(20);
            cake.setPrice(5000);

            oos.writeObject(cake);
            oos.flush();

            oos.close();
            // socketの終了。
            socket.close();
            server.close();

        } // エラーが発生したらエラーメッセージを表示してプログラムを終了する
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("エラーが発生したのでプログラムを終了します");
        }
    }
}
