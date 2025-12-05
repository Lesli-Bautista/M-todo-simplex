import java.util.Scanner;
class MetodoSimplex{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        byte opcion,n;
        double [][] tablaSimplex;
        double[] coef;

        do{
            System.out.println("\n \n \t \tMenu");
            System.out.println("1. Maximizar");
            System.out.println("2. Minimizar");
            System.out.println("3. Salir");
            System.out.println("Opcion");
            opcion = sc.nextByte();
            switch (opcion){
                case 1-> {
                    System.out.println("Maximizar");
                    System.out.println("Escribe cuantas variables tiene el problema");
                    n=sc.nextByte();
                    tablaSimplex = new double[6][n+1];
                    coef = new double[n];
                    for(int i=0;i<n;i++){   
                    System.out.println("Ingresa el coeficiente de X"+(i+1)+":");
                    coef[i]=sc.nextByte();
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
        }

    }
    
}