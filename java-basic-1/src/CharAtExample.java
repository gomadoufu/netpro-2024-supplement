public class CharAtExample {
    public static void main(String[] args) {
        // 文字列の定義
        String message = "Hello, Java!";

        // charAtメソッドを使用して特定の位置の文字を取得
        char fifthCharacter = message.charAt(4); // インデックスは0から始まるため、4は5番目の文字を指す

        // 取得した文字を表示
        System.out.println("文字列 '" + message + "' の5番目の文字は '" + fifthCharacter + "' です。");
    }
}
