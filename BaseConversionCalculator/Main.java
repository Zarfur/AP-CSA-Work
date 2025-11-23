package BaseConversionCalculator;
// Sorry Ms. Qiu! 
// "submited late" due to issues with codeHS (codeHS not saving!)

import java.util.Scanner;
public class Main
{
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args)
    {
        int iBase = 0, iTarget = 0;
        String iNumber = "NA";
        // get inputs
        while(!validateInputs(iBase, iTarget, iNumber)){
            System.out.println("Enter original base(2-16)");
            iBase = sc.nextInt();

            System.out.println("Enter a number: ");
            iNumber = sc.next();

            System.out.println("Enter target base(2-16)");
            iTarget = sc.nextInt();

            iNumber = iNumber.toUpperCase();
        }

        // results
        String result = calculator(iBase, iTarget, iNumber);
        System.out.println("Result: " + iNumber + " ( base " + iBase + " ) = " + result + " ( base " + iTarget + " ) " );
    }

    public static boolean validateInputs(int base, int target, String number){
        char[] indexer = {'A','B', 'C', 'D', 'E', 'F'};
        boolean inRange = false;

        // check valid base and number 2 <= x <= 16
        if( (base > 16 || base < 2) || (target > 16 || target < 2) ){
            return false;
        }
        // validate number

        for(int index = 0; index < number.length();index++){
            inRange = false;
            char charAt = number.charAt(index);
            
            // check range Hexi
            for(int index2 = 0; index2 < indexer.length; index2++){
                if(indexer[index2] == charAt){
                    inRange = true;
                    if(index2+10 >= base){
                        return false;
                    }
                }
            }

            // check range and valid numb
            if(Character.isDigit(charAt)){
                int charToInt = Integer.parseInt(charAt + "");
                inRange = true;
                if(charToInt >= base){
                    return false;
                }
            }
        
            if(!inRange){
                return false;
            }
        }

        return true;
    }
    public static String calculator(int base, int target, String number){
        int temp =0;
        if(base == 10){
            temp = Integer.parseInt(number);
            return decimalToAny(temp, target);
        }
        temp = anyToDecimal(number, base);
        return decimalToAny(temp, target);

    }
       
    public static int anyToDecimal(String b, int base) {
        int result=0;
        // loops through every character in b and
        // converts it to decimal, and then adds it to decimal result
        
        for(int i=0; i<b.length();i++){
            String d = b.substring(i, i+1); 
            // added so anyToDecimal can handle letters
            switch(d){
                case "0": case "1": case "2": case "3": case "8": 
                case "4": case "5": case "6": case "7": case "9":
                    result += Integer.parseInt(d)*Math.pow(base, b.length()-i-1);
                    break;
                
                case "A": case "B": case "C": case "D": case "E": 
                case "F":
                    String[] indexer = {"A", "B", "C", "D", "E", "F"};
                    for(int k=0; k<indexer.length; k++){
                        if(d.equals(indexer[k])){
                            result += (k+10)*Math.pow(base, b.length()-i-1);
                        }
                    }
                    break;
            }
        }
        return result;
    }

    
    public static String decimalToAny(int decimal, int base){
        String result = "";
        if(decimal ==0) return "0";
        while(decimal > 0){
            result = getHexi(decimal % base) + result;
            decimal = decimal / base;
        }
        return result;
    }
    
    public static String getHexi(int numb){
        String[] indexer = {"A", "B", "C", "D", "E", "F"};
        if(numb>=10){
            return indexer[numb-10];
        }
        return ""+numb;
    }
}
