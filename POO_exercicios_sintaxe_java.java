import java.util.*;
import java.lang.Math;

public class POO_exercicios_sintaxe_java {
    
    static void exercicio_1(int a, int b){
        // printa o valor da soma de "a" ate "b"
        int soma = 0;
        for (int i = a; i < b; i++){
            soma += i;
        }
        System.out.println(soma);

    }

    static void exercicio_2(int a, int b){
        // printa os multiplos de 3 entre "a" e "b"
        for (int i = a; i < b; i++){
            if (i % 3 == 0){
                System.out.println(i);
            }
        }
    }

    static void exercicio_3(){
        // pede do usuario um inteiro e printa o fatorial desse numero
        System.out.print("digite um numero: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();

        int resultado = 1;

        while (n > 0){
            resultado *= n--;
        }

        System.out.println("fatorial: " + resultado);
    }

    static void exercicio_4(){
        // imprimir a sequencia de Fibonacci ate passar do 100
        int a = 0, b = 1;
        System.out.printf("%d, %d, ", a, b);
        
        while (b < 100){
            int temp = a;
            a = b;
            b = a + temp;

            if (b < 100){
                System.out.printf("%d ", b);
            }
        }
    }

    static void exercicio_5(int a){
        while (a != 1){
            if (a % 2 == 0){
                a /= 2;
            }
            else{
                a = 3 * a + 1;
            }
            
            if (a == 1){
                System.out.print(a);
            }
            else{
                System.out.print(a + " -> ");
            }
        }
    }
    
    // proximas funcoes serao usadas no exercio 6
    static int gerar_numero_aleatorio(int min, int max){
        int n = (int) (Math.random() * (max - min + 1) + min);
        return n;

    }

    static int[] gerar_array_aleatorio(int tam){
        int arr[] = new int [tam];
        
        for (int i = 0; i < tam; i++){
            arr[i] = gerar_numero_aleatorio(0, 100);
        }

        return arr;
    }

    static void quickSort(int[] arr, int inicio, int fim){

        if (inicio >= fim){
            return;
        }

        int i = inicio;
        int j = fim;

        // escolhendo um pivot no meio do array
        int pivot = arr[(i + j)/2];
        
        while (i <= j){

            // movendo "i" ate achar um elemento maior que o pivot
            while (arr[i] < pivot){
                i++;
            }

            // movendo "j" ate achar um elemento menor que o pivot
            while(arr[j] > pivot){
                j--;
            }

            if (i <= j){
                // trocando as variaveis
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;

                i++;
                j--;
            }
        }
        quickSort(arr, inicio, j);
        quickSort(arr, i, fim);
    }

    static void printArr(int[] arr){

        System.out.print("{");

        for(int i = 0; i < arr.length; i++){
            if (i == arr.length - 1){
                System.out.print(arr[i]);
            }
            else{
                System.out.print(arr[i] + ", ");
            }
        }

        System.out.println("}");

    }

    static int[] unir_arrays_ordenados(int[] arr1, int[] arr2){
        int tam_1 = arr1.length;
        int tam_2 = arr2.length;
        int[] arr_final = new int[tam_1 + tam_2];
        
        int i = 0;
        int j = 0;
        int k = 0;

        // i eh o contador do array 1
        // j eh o contador do array 2
        // k eh o contador do array final
        // iremos passar simultaneamente o i no array 1 e j no array 2
        // comparamos qual dos elementos entre arr1[i] e arr2[j] eh menor
        // inserimos esse menor elemento no array final
        // por fim, aumentamos o contador de onde o elemento veio
        // ex: i++ se menor elemento veio do array 1 e j++ se veio do array 2
        while (i < tam_1 && j < tam_2){
            if (arr1[i] < arr2[j]){
                arr_final[k] = arr1[i];
                k++;
                i++;
            }
            else{
                arr_final[k] = arr2[j];
                k++;
                j++;
            }
        }
        // copiando elementos restantes do array 1, caso necessario
        while (i < tam_1){
            arr_final[k] = arr1[i];
            k++;
            i++;
        }
        
        // copiando elementos restates do array 2, caso necessario
        while (j < tam_2){
            arr_final[k] = arr1[j];
            k++;
            j++;
        }

        return arr_final;
    }

    static void exercicio_6(){
        // gerando dois arrays aleatorios de 50 elementos
        int arr_1[] = gerar_array_aleatorio(50);
        int arr_2[] = gerar_array_aleatorio(50);
        
        // imprimindo os arrays aleatorios
        System.out.println("array 1: ");
        printArr(arr_1);
        System.out.println("----------------------");
        System.out.println("array 2: ");
        printArr(arr_2);
        System.out.println();

        // ordenando os dois arrays usando quicksort
        quickSort(arr_1, 0, arr_1.length - 1);
        quickSort(arr_2, 0, arr_2.length - 1);

        //imprimindo os dois arrays ordenados
        System.out.println("array 1 ordenado: ");
        printArr(arr_1);
        System.out.println("----------------------");
        System.out.println("array 2 ordenado: ");
        printArr(arr_2);
        System.out.println();

        // juntado os dois arrays ordenados
        // criando um array de 100 posicoes e ordenado
        int arr_3[] = unir_arrays_ordenados(arr_1, arr_2);
        System.out.println("array 3: ");
        printArr(arr_3);
    }
    public static void main(String[] args){
        
        // para checar os exercicios, tire as '//' do exercicio que deseje
        // e rode o programa

        // exercicio_1(1, 1000);
        // exercicio_2(1, 100);
        // exercicio_3();
        // exercicio_4();
        // exercicio_5(13);
        // exercicio_6();
    }   
}
