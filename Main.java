import java.util.Scanner;
class MetodoSimplex{
        public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        byte opcion,n, restricciones, f, columnaPivote = 0, filaPivote=0;
        double menorCociente, cociente, pivote,numMultiplicar,solucion;
        double [][] tablaSimplex;
        double[] coeficiente;
        boolean continuar= true;

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
                        coeficiente[i]=sc.nextDouble();
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

                    for (int columna=0;columna<n;columna ++){
                        tablaSimplex [restricciones][columna]=(-1)*coeficiente [columna];
                    }
                    tablaSimplex [restricciones][n]=0;
                    while (continuar){

                        columnaPivote=0;
                        for (int columna = 0;columna<n;columna ++){
                            if (tablaSimplex[restricciones][columna] < tablaSimplex[restricciones][columnaPivote]) {
                                columnaPivote=(byte)columna;
                            }
                        }
                        if(tablaSimplex[restricciones][columnaPivote] >= 0){
                            continuar = false;
                            break;
                        }
                        menorCociente=Double.MAX_VALUE;
                        for (f=0;f<restricciones;f ++){
                            if (tablaSimplex[f][columnaPivote] > 0) {
                                cociente = tablaSimplex[f][n] / tablaSimplex[f][columnaPivote];
                                if(cociente < menorCociente){
                                    menorCociente = cociente;
                                    filaPivote = f;
                                }    
                            }
                        }
                        pivote=tablaSimplex [filaPivote][columnaPivote];
                        for(int i=0; i<=n; i++){
                            tablaSimplex[filaPivote][i] /= pivote;
                        }
                        for(f=0;f<=restricciones;f++){
                            if(f != filaPivote){
                                numMultiplicar=tablaSimplex[f][columnaPivote];
                                for(int i=0;i<=n;i++){
                                    tablaSimplex[f][i] -= numMultiplicar * tablaSimplex[filaPivote][i];
                                }
                            }
                        }
                    }
                    System.out.println("\nResultados finales: ");
                for(int i=0;i<n;i++){
                    System.out.println("X"+(i+1)+" = "+tablaSimplex[i][n]);
                }
                solucion=tablaSimplex[restricciones][n];
                System.out.println("Z = "+ solucion);
                }    
                case 2->{
                    System.out.println("\nMinimizar");
                    System.out.println("Escribe cuantas variables tiene el problema");
                    n=sc.nextByte();
                    tablaSimplex = new double[6][n+1];
                    coeficiente = new double[n];
                    for(int i=0;i<n;i++){   
                        System.out.println("Ingresa el coeficiente de X"+(i+1)+":");
                        coeficiente[i]=sc.nextDouble();
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
                    for(int columna = 0; columna < n; columna++){
                        tablaSimplex[restricciones][columna] = coeficiente[columna];
                    }
                    tablaSimplex[restricciones][n] = 0;
                    while(continuar){
                        columnaPivote = 0;
                        for(int col = 1; col < n; col++){
                            if(tablaSimplex[restricciones][col] > tablaSimplex[restricciones][columnaPivote]){
                                columnaPivote = (byte)col;
                            }
                        }
                        if(tablaSimplex[restricciones][columnaPivote] <= 0){
                            continuar = false;
                            break;
                        }
                        menorCociente = Double.MAX_VALUE;
                        filaPivote = -1;
                        for(f= 0; f < restricciones; f++){
                            if(tablaSimplex[f][columnaPivote] > 0){
                                cociente = tablaSimplex[f][n] / tablaSimplex[f][columnaPivote];
                                if(cociente < menorCociente){
                                    menorCociente = cociente;
                                    filaPivote = f;
                                }
                            }   
                        }
                        if(filaPivote == -1){
                            System.out.println("El problema no tiene solucion acotada (unbounded).");
                            continuar = false;
                            break;
                        }
                        pivote = tablaSimplex[filaPivote][columnaPivote];

                        for(int i = 0; i <= n; i++){
                            tablaSimplex[filaPivote][i] /= pivote;
                        }
                        for(f = 0; f <= restricciones; f++){
                            if(f != filaPivote){
                                numMultiplicar = tablaSimplex[f][columnaPivote];
                                for(int i = 0; i <= n; i++){
                                    tablaSimplex[f][i] -= numMultiplicar * tablaSimplex[filaPivote][i];
                                }
                            }
                        }
                    }
                    System.out.println("\nResultados finales: ");
                    for(int i = 0; i < n; i++){
                        System.out.println("X" + (i + 1) + " = " + tablaSimplex[i][n]);
                    }
                    solucion= tablaSimplex[restricciones][n];
                    System.out.println("Z mínimo = " + solucion);
                }
                case 3 ->{
                System.out.println("Salir");
                }   
            }
        }while (opcion !=3);
    } 
}