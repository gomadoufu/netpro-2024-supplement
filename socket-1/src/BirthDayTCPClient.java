/*
  * キーボードから読み込んだ年齢をサーバに送信し、
  * サーバから受信した飲酒可否の判定結果をディスプレイに表示するクライアント
*/

import java.io.BufferedReader; //　入出力関連パッケージを利用する
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket; //ネットワーク関連のパッケージを利用する
//　ユーティリティパッケージを利用する
import java.util.Scanner;

public class BirthDayTCPClient {

    private static final String SERVER_NAME = "localhost";

    public static void main(String arg[]) {
        try {
            /* 通信の準備をする */
            Scanner scanner = new Scanner(System.in);
            System.out.print("Server IP address? >");
            String serverName = scanner.nextLine();
            System.out.println("Server IP address is " + serverName);
            System.out.println("Server Port number? >");
            int port = scanner.nextInt();
            System.out.print("Your age? >");
            int age = scanner.nextInt();
            System.out.println("Your age is " + age);

            Socket socket = new Socket(serverName, port); // サーバに接続要求を送る
            OutputStream os = socket.getOutputStream();

            os.write("誕生日ケーキをください\nいちご\n21".getBytes());
            os.flush();

            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());

            BirthDayCake cake = (BirthDayCake) ois.readObject();

            System.out.println("お返しのプレゼントについていたメッセージは" + cake.getMessage());

            ois.close();

            socket.close();

        } // エラーが発生したらエラーメッセージを表示してプログラムを終了する
        catch (java.net.UnknownHostException uhe) {
            uhe.printStackTrace();
            System.err.println("送信先のサーバ名が間違っているのでプログラムを終了します");
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("エラーが発生したのでプログラムを終了します");
        }
    }
}
