public class Main {
    public static void main(String[] args) {
        char[][] sprout = {
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ',', 'r', '\'', '"', '7'},
                {'r', '`', '-', '_', ' ', ' ', ' ', ',', '\'', ' ', ' ', ',', '/'},
                {' ', '\\', '.', ' ', '"', '.', ' ', 'L', '_', 'r', '\''},
                {' ', ' ', ' ', '`', '~', '\\', '/'},
                {' ', ' ', ' ', ' ', ' ', ' ', '|'},
                {' ', ' ', ' ', ' ', ' ', ' ', '|'}
        };
        for (int i = 0; i < sprout.length; i++) {
            for (int j = 0; j < sprout[i].length; j++) {
                System.out.print(sprout[i][j]);
            }
            System.out.println();
        }
    }
}