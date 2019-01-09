package Ejercicio_Alex;

import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Notacion {
    static Stack<String> pilaSignos = new Stack<>();
    static Stack<String> pilaNums = new Stack<>();

    public static void main(String args[]) {
        String op = "6*7 +5";
        separateOp(op);
        System.out.println(orderOp());
    }


    static public void separateOp (String op){
        Pattern patterns = Pattern.compile("[0-9]");
        Matcher matcher ;

        for (char c : op.toCharArray()) {
            matcher = patterns.matcher("" + c);
            if (matcher.matches()) {
                pilaNums.push("" + c);
            } else {
                pilaSignos.push("" + c);
            }
        }

    }
    static public String orderOp (){
        String res="";
        int size = pilaSignos.size();
        for (int i =0; i<pilaSignos.size();i++){
            if (i==0 && (pilaSignos.peek().equals("*") || pilaSignos.peek().equals("/"))) {
                res += pilaSignos.pop();
                res += pilaNums.pop();
                res += pilaNums.pop();
            }else if (pilaSignos.peek().equals(" ")){
                res += pilaSignos.pop();
                if (pilaSignos.peek().equals("*") || pilaSignos.peek().equals("/")) {
                    res += pilaSignos.pop();
                    res += pilaNums.pop();
                    res += pilaNums.pop();
                }else{
                    res += pilaSignos.pop();
                    res += pilaNums.pop();
                }

             }else if(pilaSignos.peek().equals("*") || pilaSignos.peek().equals("/")){
                res += pilaSignos.pop();
                res += pilaNums.pop();
                res += pilaNums.pop();

            }else{
                res += pilaSignos.pop();
                res += pilaNums.pop();
            }
        }

        return res;
    }
}
