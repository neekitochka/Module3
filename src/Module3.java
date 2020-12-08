import com.sun.source.util.TaskListener;

import java.util.Scanner;

public class Module3 {

    public static void main(String[] args) {
        System.out.println("TASK 1");
        Task1();
        System.out.println("TASK 2");
        Task2();
        System.out.println("TASK 3");
        Task3();
        System.out.println("TASK 4");
        Task4();
        System.out.println("TASK 5");
        Task5();
        System.out.println("TASK 6");
        Task6();
        System.out.println("TASK 7");
        Task7();
        System.out.println("TASK 8");
        Task8();
        System.out.println("TASK 9");
        Task9();
        System.out.println("TASK 10");
        Task10();
    }

    public static void Task1(){
        Scanner scanstr = new Scanner(System.in);
        System.out.println("Enter first variable: ");
        int a = scanstr.nextInt();
        System.out.println("Enter second variable: ");
        int b = scanstr.nextInt();
        System.out.println("Enter third variable: ");
        int c = scanstr.nextInt();
        System.out.println("Count of solutions: " + solution(a, b, c));
    }

    public static int solution(int a, int b, int c){
        int d = b * b - 4 * a * c;
        int s = 0;
        if (d > 0)
            s = 2;
        else if (d == 0)
            s = 1;
        else if (d < 0)
            s= 0;
        return s;
    }

    public static void Task2(){
        Scanner scanstr = new Scanner(System.in);
        System.out.println("Enter string: ");
        String string = scanstr.nextLine();
        System.out.println("Index of zip: " + findZip(string));
    }

    public static int findZip(String str){
        int firstZip = str.indexOf("zip");
        int secondZip = str.indexOf("zip", firstZip + 1);
        return  secondZip;
    }

    public static void Task3(){
        Scanner scanstr = new Scanner(System.in);
        System.out.println("Enter number: ");
        int r = scanstr.nextInt();
        System.out.println("Is this number perfect? - " + checkPerfect(r));
    }

    public static boolean checkPerfect(int r){
        int sum = 0;
        for (int i = 1; i < r; i++ ){
            if (r % i == 0){
                sum += i;
            }
        }
        return sum == r;
    }

    public static void Task4(){
        Scanner scanstr = new Scanner(System.in);
        System.out.println("Enter string: ");
        String str = scanstr.nextLine();
        System.out.println("The result is: " + flipEndChars(str));
    }

    public static String flipEndChars(String str){
        if (str.length() < 2){
            return "String is too small!";
        }
        else if (str.charAt(0) == str.charAt(str.length() - 1)) {
            return  "Two's a pair.";
        }
        else {
            char[] words = str.toCharArray();
            char sym1 = words[0];
            words[0] = words[words.length - 1];
            words[words.length - 1] = sym1;
            return new String(words);
        }
    }

    public static void Task5(){
        Scanner scanstr = new Scanner(System.in);
        System.out.println("Enter string: ");
        String str = scanstr.nextLine();
        System.out.println("The result is: " + isValidHexCode(str));
    }

    public static boolean isValidHexCode(String str){
        if (str.length() > 5){
            return false;
        }
        return str.matches("#[0-9a-fA-F]+");
    }

    public static void Task6(){
        Scanner scanstr = new Scanner(System.in);
        //вводим данные первого массива
        System.out.println("Enter the length of the first array:");
        int length = scanstr.nextInt();
        int [] arr1 = new int[length];
        System.out.println("Enter the elements of the first array:");

        for(int i=0; i<length; i++ ) {
            arr1[i] = scanstr.nextInt();
        }

        // вводим данные второго массива
        System.out.println("Enter the length of the second array:");
        int length1 = scanstr.nextInt();
        int [] arr2 = new int[length1];
        System.out.println("Enter the elements of the second array:");
        for(int j=0; j<length1; j++ ) {
            arr2[j] = scanstr.nextInt();
        }
        System.out.println("The result is: " + same(arr1, arr2));
    }

    public static boolean same(int[] arr1, int[] arr2){
        int k = 0;
        int s = 0;
        for (int i = 0; i < arr1.length; i++){
            for (int j = i + 1;j < arr1.length; j++){
                if (arr1[i] != arr1[j]){
                k = k + 1;
                i = j;
                }
            }
        }

        for (int i = 0; i < arr2.length; i++){
            for (int j = i + 1; j < arr2.length; j++){
                if (arr2[i] != arr2[j]){
                s = s + 1;
                i = j;
                }
            }
        }
        return (k) == (s);
    }

    public static void Task7(){
        Scanner scanstr = new Scanner(System.in);
        System.out.println("Enter number: ");
        int num = scanstr.nextInt();
        System.out.println("The result is: " + isKaprekar(num));
    }

    public static boolean isKaprekar(int num){
        if (num == 1)
            return true;
        int numpow = num*num;
        int len= 0;

        while (numpow != 0)
        {
           len++;
           numpow /= 10;
        }

       numpow = num * num;

        for (int i = 1; i < len; i++)
        {
            int modulo = (int) Math.pow(10, i);

            int sum = numpow / modulo + numpow % modulo;
            if (sum == num)
                return true;
        }

        return false;
    }

    public static void Task8(){
        Scanner scanstr = new Scanner(System.in);
        System.out.println("Enter string: ");
        String str = scanstr.nextLine();
        System.out.println("The result is: " + longestZero(str));
    }

    public static String longestZero(String str){
        int maxstreak = 0;
        int currentstreak = 0;
        for (int i = 0; i < str.length(); i++){
            if (str.charAt(i) == '0') {
                currentstreak++;

                if (currentstreak > maxstreak) {
                    maxstreak = currentstreak;
                }
            }
            else {
                currentstreak = 0;
            }
        }
        StringBuilder resstring = new StringBuilder("");
        for (int i = 0; i < maxstreak; i++){
            resstring.insert(i, '0');
        }
        return resstring.toString();
    }

    public static void Task9(){
        Scanner scanstr = new Scanner(System.in);
        System.out.println("Enter number: ");
        int num = scanstr.nextInt();
        System.out.println("The result is: " + nextPrime(num));
    }

    public static int nextPrime(int x) {

        boolean currentPrime = true;


        for (int i = 2; i < x; i++) {
            if (x % i == 0) {
                currentPrime = false;
                break;
            }
        }

        if (currentPrime) {
            return x;
        }

        while (!currentPrime) {

            x++;
            currentPrime = true;

            for (int i = 2; i < x; i++) {
                if (x % i == 0) {
                    currentPrime = false;
                    break;
                }
            }
        }

        return x;
    }

    public static void Task10(){
        Scanner scanstr = new Scanner(System.in);
        System.out.println("Enter first side: ");
        int a = scanstr.nextInt();
        System.out.println("Enter second side: ");
        int b = scanstr.nextInt();
        System.out.println("Enter third side: ");
        int c = scanstr.nextInt();
        System.out.println("The result is: " + rightTriange(a, b, c));
    }

    public static boolean rightTriange(int a, int b, int c) {
        return a * a + b * b == c * c || a * a + c * c == b * b || b * b + c * c == a * a;
    }
}


