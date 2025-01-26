import java.util.Scanner;

public class CreditCardValidator
  {
        public static void main(String[] args){
          Scanner sc = new Scanner(System.in);
          // initialise Char array and take in string input
          char [] ccNum = sc.nextLine().toCharArray();

          if(ccNum.length != 16){
            System.out.println("not valid");
          }
          else{
            char [] revCCNum = reverseArray(ccNum);

            // convert chars to ints
            int [] intCCNum = new int[ccNum.length];
            for(int i = 0; i < 16; i++){
              // '0' avoids Ascii value
              intCCNum[i] = revCCNum[i] - '0';
            }

            // 2nd digit *2
            for(int i = 0; i < 16; i++){
              intCCNum[i] *= 2;
            }

            // if > 9? - 9
            for(int i = 0; i < 16; i++){
              if(intCCNum[i] > 9){
                intCCNum[i] -= 9;
              }
            }

            // sum all digits
            int sum = 0;
            for(int i: intCCNum){
              sum += i;
            }

            // final step, modulo 10 = 0
            if(sum % 10 == 0){
              System.out.println("valid");
            }
            else{
              System.out.println("not valid");
            }
          }
          sc.close();
        }
          // reverses char array, thanks StackOverflow
        public static char [] reverseArray(char [] array){
          for(int i = 0; i < array.length/2; i++){
              array[i] ^= array[array.length-i-1];
            array[array.length-i-1] ^= array[i];
              array[i] ^= array[array.length-i-1];
          }
          return array;
        }
    }
