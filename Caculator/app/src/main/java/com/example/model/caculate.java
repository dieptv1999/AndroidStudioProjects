package com.example.model;

import java.util.Stack;

//√
public class caculate {
     public int priority(char x){
        switch (x) {
            case '(':
            case ')':
                return 0;
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
            case '%':
            case '√':
                return 2;
            case '^':
                return 3;
            default:
                return 4;
        }
    }
    public boolean isOperator(char c){
         if (c=='+' || c=='-' || c=='*' || c=='/' || c=='%' || c=='√' || c=='^'){
             return true;
         }else return false;
    }
    public String[] processString(String sMath){ // xu ly bieu thuc nhap vao thanh cac phan tu
        String s1 = "", elementMath[] = null;
        caculate  IFP = new caculate();
        sMath = sMath.trim();
        sMath = sMath.replaceAll("\\s+"," "); //    chuan hoa sMath
        for (int i=0; i<sMath.length(); i++){
            char c = sMath.charAt(i);//sMath.substring(i,1);
            if (!IFP.isOperator(c) && c!='(' && c!=')' && c!='π')
                s1 = s1 + c;
            else {
                if (c=='-'){
                    if (i==0 || (i>0 && (isOperator(sMath.charAt(i-1)) || sMath.charAt(i-1) == '(' )))
                        s1 = s1+" "+c;
                    else s1 = s1 + " " + c + " ";
                }else {
                    if (i > 0) {
                        char x = sMath.charAt(i - 1);
                        if (!IFP.isOperator(x) && x != '(' && x != ')' && (c == '(' || c == '√' || c=='π'))
                            s1 = s1 + " * ";
                    }
                    s1 = s1 + " " + c + " ";
                }
            }
        }
        s1 = s1.trim();
        s1 = s1.replaceAll("\\s+"," "); //  chuan hoa s1
        elementMath = s1.split(" ");
        return elementMath;
    }
    public String[] postfix(String[] elementMath){
        caculate  IFP = new caculate();
        String s1 = "", E[];
        Stack <String> S = new Stack <String>();
        for (int i=0; i<elementMath.length; i++){    // duyet cac phan tu
            char c = elementMath[i].charAt(0);  // c la ky tu dau tien cua moi phan tu
            if (c=='-' && elementMath[i].length()>1) c=elementMath[i].charAt(1);
            if (!IFP.isOperator(c) && c!='(' && c!=')')         // neu c khong la toan tu
                s1 = s1 + " " + elementMath[i];     // xuat elem vao s1
            else{                       // c la toan tu
                if (c == '(') S.push(elementMath[i]);   // c la "(" -> day phan tu vao Stack
                else{
                    if (c == ')'){          // c la ")"
                        char c1;        //duyet lai cac phan tu trong Stack
                        do{
                            c1 = S.peek().charAt(0);    // c1 la ky tu dau tien cua phan tu
                            if (c1 != '(') s1 = s1 + " " + S.peek();    // trong khi c1 != "("
                            S.pop();
                        }while (c1 != '(');
                    }
                    else{
                        while (!S.isEmpty() && IFP.priority(S.peek().charAt(0)) > IFP.priority(c)){
                            s1 = s1 + " " + S.peek();
                            S.pop();
                        }
                        S.push(elementMath[i]); //  dua phan tu hien tai vao Stack
                    }
                }
            }
        }
        while (!S.isEmpty()){   // Neu Stack con phan tu thi day het vao s1
            s1 = s1 + " " + S.peek();
            S.pop();
        }
        E = s1.split(" ");  //  tach s1 thanh cac phan tu
        return E;
    }
    public double CalcValue(double a,char c,double b){
        double result=0;
        if (c=='√'){
            result=Math.sqrt(b);
        }else if (c=='^'){
            result=Math.pow(a,b);
        }else if (c=='%'){
            result=(int)a % (int)b;
        }else if (c=='*'){
            result=a*b;
        }else if (c=='/'){
            result=a/b;
        }else if (c=='+'){
            result=a+b;
        }else if (c=='-'){
            result=a-b;
        }
        return result;
    }
    public double tinh_expression(String s){
         if (s.equals("")) return Double.MAX_VALUE;
        String a[]=postfix(processString(s));
        Stack<Double> stack=new Stack<>();
        for (int i=0;i<a.length;++i){
            if (!a[i].equals(""))
                if (a[i].length()==1 && isOperator(a[i].charAt(0))){
                    double b=0,c=0;
                    if (!stack.empty()) c=stack.pop();
                    if (a[i].charAt(0)=='√'){
                        b=0;
                    }else if (!stack.empty()) b=stack.pop();
                    stack.push(CalcValue(b,a[i].charAt(0),c));
                }else{
                    String s1;
                    if (a[i].equals("π")) s1="3.14159265359"; else s1=a[i];
                    stack.push(Double.parseDouble(s1));
                }
        }
        if (!stack.empty()) return stack.pop();
        else return Double.NaN;
    }
}
