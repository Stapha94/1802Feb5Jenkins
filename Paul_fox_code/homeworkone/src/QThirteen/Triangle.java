package QThirteen;

public class Triangle {

    public static void main(String[] args) {

        for(int i = 0; i < 4; i++){

            for(int j = 0; j <= i; j++){

                if (i == 3){

                    if (j % 2 == 0){

                        System.out.print(0);

                    }

                    else
                        System.out.print(1);

                }

                else {

                    if (j == 0 && i == 0) {

                        System.out.print(0);

                    }

                    else if (j % 2 == 0) {

                        System.out.print(1);

                    }

                    else
                        System.out.print(0);
                }

            }
            System.out.println();

        }

    }

}
