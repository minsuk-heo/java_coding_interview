package advanced;

import java.util.Stack;

/**
 * Created by minsukheo on 2/12/17.
 */
public class BracketValidator {

    public static void main(String[] args) {
        BracketValidator bv = new BracketValidator();
        System.out.println(bv.solution("{{12(1(2))}[]}"));

    }

    private boolean solution(String str) {
        int myFlag = 0;

        Stack myStack = new Stack();

        for (int i = 0; i < str.length(); i++) {


            if(str.charAt(i) == '(' || str.charAt(i) == '[' || str.charAt(i) == '{')
                myStack.push(str.charAt(i));

            if(str.charAt(i) == ')'){
                if('(' != myStack.pop().toString().charAt(0)){
                    myFlag = -1;
                    break;
                }
            }

            if(str.charAt(i) == ']'){
                if('[' != myStack.pop().toString().charAt(0)){
                    myFlag = -1;
                    break;
                }
            }

            if(str.charAt(i) == '}'){
                if('{' != myStack.pop().toString().charAt(0)){
                    myFlag = -1;
                    break;
                }
            }
        }

        if(myFlag == -1)
            return false;
        else return true;


    }
}
