package QSixteen;

public class CharacterCounting {

    public static void main(String[] args) {

        int count = 0;

        for(int i = 0; i < args.length; i++){

            for(int j = 0; j < args[i].length(); j++){

                count++;

            }

        }

        System.out.println("The number of characters in this string: " + count);

    }

}
