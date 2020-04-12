import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
  
  
public class BigInteger
{
    public static final String QUIT_COMMAND = "quit";
    public static final String MSG_INVALID_INPUT = "Wrong Input";
  
    // implement this
    public static final Pattern EXPRESSION_PATTERN = Pattern.compile("");
  
    String stringnum;
    char sign;

    public BigInteger(int i)
    {
        // switch int to String
        this.stringnum = Integer.toString(i);
    }

    public BigInteger(int[] numfinal, char sign)
    {
        // assign sign
        this.sign = sign;

        // switch int array to String
        this.stringnum = Arrays.toString(numfinal).replace("[", "").replace("]", "").replace(",", "").replace(" ", "");
    }
  
    public BigInteger(String number, char sign)
    {
        this.stringnum = number;
        this.sign = sign;
    }

    // arbitrary constructor
    public BigInteger(String integer)
    {
        stringnum = integer;
        this.sign = 'W';
    }
    //

    public BigInteger add(BigInteger number2)
    {
        // numbers in string
        String string1;
        String string2;

        // compare length of numbers and assign the longer one to string1
        if(this.stringnum.length() >= number2.stringnum.length()){
            string1 = this.stringnum;
            string2 = number2.stringnum;
        } else{
            string1 = number2.stringnum;
            string2 = this.stringnum;
        }

        // lengths of strings
        int strlen1 = string1.length();
        int strlen2 = string2.length();

        // numbers in int array
        int[] numarray1 = new int[strlen1];
        int[] numarray2 = new int[strlen2];

        // assign strings to int arrays
        for(int i = 0; i < strlen1; i++){
            numarray1[i] = string1.charAt(i) - '0';
        }
        for(int i = 0; i < strlen2; i++){
            numarray2[i] = string2.charAt(i) - '0';
        }

        // int array for the RESULT OBJECT
        int[] numresult = new int[strlen1 + 1]; 

        // add each digits and caluculate the carrys (length of string2)
        int carry = 0;
        int subsum;
        int sum;
        for(int i = strlen2 - 1; i > -1; i--){
            subsum = numarray1[strlen1 - strlen2 + i] + numarray2[i] + carry;
            sum = subsum % 10;
            numresult[strlen1 - strlen2 + i + 1] = sum;
            carry = subsum / 10;
        }

        // remaining digits (length of string1 - string2)
        for(int i = strlen1 - strlen2 - 1; i > -1; i--){
            subsum = numarray1[i] + carry;
            sum = subsum % 10;
            numresult[i + 1] = sum;
            carry = subsum / 10;
        }

        // remaing carry
        if (carry > 0){
            numresult[0] = carry;
        }

        // check whether the first digit is zero or not, if it is then erase it
        int[] numfinal;
        if(numresult[0] == 0){
            numfinal = new int[strlen1];
            for(int i = 0; i < strlen1; i++){
                numfinal[i] = numresult[i+1];
            }
        } else{
            numfinal = new int[strlen1 + 1];
            for(int i = 0; i < strlen1 + 1; i++){
                numfinal[i] = numresult[i];
            }
        }

        // let's consider sign
        char sign = this.sign;

        BigInteger result = new BigInteger(numfinal, sign);
        return result;
    }
  
    public BigInteger subtract(BigInteger number2)
    {
        // return result OBJECT
        BigInteger result;

        // numbers in string
        String string1;
        String string2;

        // let's consider sign
        char sign;

        // compare value of numbers and assign the bigger one to string1
        // First compare the length, then digit from high bits
        if(this.stringnum.length() > number2.stringnum.length()){
            string1 = this.stringnum;
            string2 = number2.stringnum;
            sign = this.sign;
        } else if(this.stringnum.length() < number2.stringnum.length()){
            string1 = number2.stringnum;
            string2 = this.stringnum;
            sign = number2.sign;
        } else{
            int comparision_index = 0;
            for(int i = 0; i < this.stringnum.length(); i++){
                if(this.stringnum.charAt(i) > number2.stringnum.charAt(i)){
                    comparision_index = 1;
                    break;
                } else if(this.stringnum.charAt(i) < number2.stringnum.charAt(i)){
                    comparision_index = -1;
                    break;
                }
            }
            if (comparision_index == 0){
                string1 = "W";
                string2 = "W";
                sign = 'W';
                result = new BigInteger(0);
                return result;
            } else if (comparision_index == 1){
                string1 = this.stringnum;
                string2 = number2.stringnum;
                sign = this.sign;
            } else if (comparision_index == -1){
                string1 = number2.stringnum;
                string2 = this.stringnum;
                sign = number2.sign;
            } else{
                string1 = "W";
                string2 = "W";
                sign = 'W';
            }
        }

        // lengths of strings
        int strlen1 = string1.length();
        int strlen2 = string2.length();

        // numbers in int array
        int[] numarray1 = new int[strlen1];
        int[] numarray2 = new int[strlen2];

        // assign strings to int arrays
        for(int i = 0; i < strlen1; i++){
            numarray1[i] = string1.charAt(i) - '0';
        }
        for(int i = 0; i < strlen2; i++){
            numarray2[i] = string2.charAt(i) - '0';
        }

        // int array for the RESULT OBJECT
        int[] numresult = new int[strlen1]; 

        // subtract each digits and caluculate the carrys (length of string2)
        int carry = 0;
        int subdifference;
        int difference;
        for(int i = strlen2 - 1; i > -1; i--){
            subdifference = numarray1[strlen1 - strlen2 + i] - numarray2[i] - carry;
            if(subdifference < 0){
                difference = subdifference + 10;
                carry = 1;
            } else{
                difference = subdifference;
                carry = 0;
            }
            numresult[strlen1 - strlen2 + i] = difference;
        }
        
        // remaining digits (length of string1 - string2)
        for(int i = strlen1 - strlen2 - 1; i > -1; i--){
            subdifference = numarray1[i] - carry;
            if(subdifference < 0){
                difference = subdifference + 10;
                carry = 1;
            } else{
                difference = subdifference;
                carry = 0;
            }
            numresult[i] = difference;
        }
        
        // check whether the first digit is zero or not, if it is then erase it
        int[] numfinal;
        int count = 0;
        for(int i = 0; i < strlen1; i++){
            if(numresult[i] == 0){
                count++;
            } else{
                break;
            }
        }
        numfinal = new int[strlen1 - count];
        for(int i = strlen1 - count - 1; i > -1; i--){
            numfinal[i] = numresult[i + count];
        }

        result = new BigInteger(numfinal, sign);
        return result;
    }
  
    public BigInteger multiply(BigInteger number2)
    {
        // return result OBJECT
        BigInteger result;

        // numbers in string
        String string1 = this.stringnum;
        String string2 = number2.stringnum;

        // check if one of strings is zero
        if(string1.length() == 1 && string1.charAt(0) == '0'){
            result = new BigInteger(0);
            return result;
        }
        if(string2.length() == 1 && string2.charAt(0) == '0'){
            result = new BigInteger(0);
            return result;
            
        }

        // lengths of strings
        int strlen1 = string1.length();
        int strlen2 = string2.length();

        // numbers in int array
        int[] numarray1 = new int[strlen1];
        int[] numarray2 = new int[strlen2];

        // assign strings to int arrays
        for(int i = 0; i < strlen1; i++){
            numarray1[i] = string1.charAt(i) - '0';
        }
        for(int i = 0; i < strlen2; i++){
            numarray2[i] = string2.charAt(i) - '0';
        }

        // int array for the RESULT OBJECT
        int[] numresult = new int[strlen1 + strlen2]; 

        // multiply each digits and caluculate the carrys
        int digit1 = 0; // kind of similar to column
        int digit2 = 0; // kind of similar to row

        int carry = 0;
        int sum;
        for(int i = strlen2 - 1; i > -1; i--){
            carry = 0;
            digit1 = 0;

            for(int j = strlen1 - 1; j > -1; j--){
                sum = numarray2[i] * numarray1[j] + numresult[digit1 + digit2] + carry;
                carry = sum / 10;
                numresult[digit1 + digit2] = sum % 10;

                digit1++;
            }
            if (carry > 0){
                numresult[digit1 + digit2] += carry;
            }

            digit2++;
        }

        // check whether the first digit is zero or not, if it is then erase it
        int[] numfinal;
        int count = 0;
        for(int i = strlen1 + strlen2 - 1; i > -1; i--){
            if(numresult[i] == 0){
                count++;
            } else{
                break;
            }
        }
        
        numfinal = new int[strlen1 + strlen2 - count];
        for(int i = strlen1 + strlen2 - count - 1; i > -1; i--){
            numfinal[i] = numresult[- i - 1 + strlen1 + strlen2 - count];
        }

        // let's consider sign
        char sign1 = this.sign;
        char sign2 = number2.sign;
        char sign;

        if(sign1 == '+' && sign2 == '+'){
            sign = '+';
        } else if(sign1 == '+' && sign2 == '-'){
            sign = '-';
        } else if(sign1 == '-' && sign2 == '+'){
            sign = '-';
        } else{
            sign = '+';
        }

        result = new BigInteger(numfinal, sign);
        return result;
    }
  
    @Override
    public String toString()
    {
        if(this.sign == '-'){
            this.stringnum = this.sign + this.stringnum;
        }
        return this.stringnum;
    }
  
    static BigInteger evaluate(String input) throws IllegalArgumentException
    {
        String strinput = input.replaceAll("\\p{Z}", "");

        // Seperate Operators
        char[] signs = new char[3];
        int[] signs_index = new int[3];
        int count = 0;
        for(int i = 0; i < strinput.length(); i++){
            if(strinput.charAt(i) == '+' || strinput.charAt(i) == '-' || strinput.charAt(i) == '*'){
                signs[count] = strinput.charAt(i);
                signs_index[count] = i;
                count++;
            }
        }

        // Using Operators, Seperate two substrings and find out their sign and operator
        char sign1;
        char operator;
        char sign2;
        String substring1;
        String substring2;
        if(count == 0){
            sign1 = 'W';
            operator = 'W';
            sign2 = 'W';
            substring1= "Warning1";
            substring2= "Warning2";
        } else if(count == 1){
            sign1 = '+';
            operator = signs[0];
            sign2 = '+';
            substring1 = strinput.substring(0, signs_index[0]);
            substring2 = strinput.substring(signs_index[0] + 1);
        } else if(count == 2){
            if(signs_index[0] + 1 == signs_index[1]){
                sign1 = '+';
                operator = signs[0];
                sign2 = signs[1];
                substring1 = strinput.substring(0, signs_index[0]);
                substring2 = strinput.substring(signs_index[0] + 2);
            } else{
                sign1 = signs[0];
                operator = signs[1];
                sign2 = '+';
                substring1 = strinput.substring(1, signs_index[1]);
                substring2 = strinput.substring(signs_index[1] + 1);
            }
        } else if(count == 3){
            sign1 = signs[0];
            operator = signs[1];
            sign2 = signs[2];
            substring1 = strinput.substring(1, signs_index[1]);
            substring2 = strinput.substring(signs_index[1] + 2);
        } else{
            sign1 = 'W';
            operator = 'W';
            sign2 = 'W';
            substring1= "Warning1";
            substring2= "Warning2";
        }

        // make BigInteger Object using substrings
        BigInteger number1 = new BigInteger(substring1, sign1);
        BigInteger number2 = new BigInteger(substring2, sign2);

        // implement add, subtract, multiply method using BigInteger Objects
        BigInteger result;
        if(operator == '+'){
            if(sign1 == '+' && sign2 == '+'){
                result = number1.add(number2);
            } else if(sign1 == '-' && sign2 == '-'){
                result = number1.add(number2);
            } else if(sign1 == '-' && sign2 == '+'){
                result = number1.subtract(number2);
            } else{
                result = number1.subtract(number2);
            }
        } else if(operator == '-'){
            if(sign1 == '+' && sign2 == '+'){
                number2.sign = '-';
                result = number1.subtract(number2);
            } else if(sign1 == '-' && sign2 == '-'){
                number2.sign = '+';
                result = number1.subtract(number2);
            } else if(sign1 == '-' && sign2 == '+'){
                result = number1.add(number2);
            } else{
                result = number1.add(number2);
            }
        } else if(operator == '*'){
            result = number1.multiply(number2);
        } else{
            result = new BigInteger("Hello");
        }

        return result;
    }
  
    public static void main(String[] args) throws Exception
    {
        try (InputStreamReader isr = new InputStreamReader(System.in))
        {
            try (BufferedReader reader = new BufferedReader(isr))
            {
                boolean done = false;
                while (!done)
                {
                    String input = reader.readLine();
  
                    try
                    {
                        done = processInput(input);
                    }
                    catch (IllegalArgumentException e)
                    {
                        System.err.println(MSG_INVALID_INPUT);
                    }
                }
            }
        }
    }
  
    static boolean processInput(String input) throws IllegalArgumentException
    {
        boolean quit = isQuitCmd(input);
  
        if (quit)
        {
            return true;
        }
        else
        {
            BigInteger result = evaluate(input);
            System.out.println(result.toString());
  
            return false;
        }
    }
  
    static boolean isQuitCmd(String input)
    {
        return input.equalsIgnoreCase(QUIT_COMMAND);
    }
}
