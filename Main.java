import java.util.Scanner;
class MetodoSimplex{
    /**
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        byte opcion,n, restricciones, f, columnaPivote;
        double [][] tablaSimplex;
        double[] coeficiente;

        do{
            System.out.println("\n \n \t \tMenu");
            System.out.println("1. Maximizar");
            System.out.println("2. Minimizar");
            System.out.println("3. Salir");
            System.out.println("Opcion");
            opcion = sc.nextByte();
            switch (opcion){
                case 1-> {
                    System.out.println("\nMaximizar");
                    System.out.println("Escribe cuantas variables tiene el problema");
                    n=sc.nextByte();
                    tablaSimplex = new double[6][n+1];
                    coeficiente = new double[n];
                    for(int i=0;i<n;i++){   
                    System.out.println("Ingresa el coeficiente de X"+(i+1)+":");
                    coeficiente[i]=sc.nextByte();
                }
                System.out.println("\nEscribe el numero de restricciones que tiene el problema");
                restricciones=sc.nextByte();
                for (f=0;f<restricciones;f ++){
                    System.out.println("\nRestriccion" + (f+1));
                    for (int columna = 0;columna<n;columna ++){
                        System.out.println("Coeficiente X"+(columna+1)+": ");
                        tablaSimplex[f][columna]=sc.nextDouble();
                    }
                    System.out.println("Escribe el valor de b (<=)");
                     tablaSimplex[f][n]=sc.nextDouble();

                }

                }
                case 2->{
                    System.out.println("Minimizar");
                    System.out.println("");
                    System.out.println("");

                }
                case 3 ->{

                }
            }
        }while (opcion !=3);

    }
    
}