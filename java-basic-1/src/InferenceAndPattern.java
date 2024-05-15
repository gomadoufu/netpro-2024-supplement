public class InferenceAndPattern {
    public static void main(String[] args) throws Exception {
        var integer = 10;
        var doubleValue = 10.0;
        var string = "Hello World";

        if (integer == 10) {
            System.out.println(doubleValue * 2);
            System.out.println(string);
        }

        var app = new InferenceAndPattern();

        System.out.println(formatterPatternSwitch(integer));
        System.out.println(formatterPatternSwitch(doubleValue));
        System.out.println(formatterPatternSwitch(string));
        System.out.println(formatterPatternSwitch(app));

    }

    static String formatterPatternSwitch(Object obj) {
        return switch (obj) {
            case Integer i -> String.format("int %d", i);
            case Double d -> String.format("double %f", d);
            case String s -> String.format("String %s", s);
            default -> obj.toString();
        };
    }

}
