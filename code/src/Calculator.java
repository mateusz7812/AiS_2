import java.util.ArrayList;
import java.util.List;

public class Calculator {
    private ArrayList<String> equation;

    public Calculator(ArrayList<String> equation) {

        this.equation = equation;
    }

    private int calcSigns(String sign, ArrayList<String> characters){
        var number = 0;
        for (String character :
                characters) {
            if(character.equals(sign)) number++;
        }
        return number;
    }

    private UnlimitedStack<Object> _getSubEquations(List<String> equation){
        var stack = new UnlimitedStack<>();
        int index = 1;
        int maxIndex = equation.size()-1;
        while(index<maxIndex){
            if(equation.get(index).equals("{")){
                int openBracketIndex = index;
                int openingBrackets = 1;
                int closingBrackets = 0;
                index++;
                while(openingBrackets != closingBrackets){
                    String character = equation.get(index);
                    if(character.equals("{")) openingBrackets++;
                    if(character.equals("}")) closingBrackets++;
                    index++;
                }
                stack.Push(_getSubEquations(equation.subList(openBracketIndex, index)));
            }
            else{
                stack.Push(equation.get(index));
                index++;
            }
        }
        return stack;
    }

    private UnlimitedStack<Object> GetSubEquations(ArrayList<String> equation) throws Exception {
        if(calcSigns("{" , equation) != calcSigns("}", equation)) throw new Exception("bad equation");
        return _getSubEquations(equation);
    }

    private float _calc(UnlimitedStack<Object> subEquations) throws Exception {
        var operationSign = (String)subEquations.Pop();
        var objectFactors = new Object[]{subEquations.Pop(), subEquations.Pop()};
        float[] floatFactors = new float[2];
        for(int i=0; i<2; i++){
            if(objectFactors[i] instanceof UnlimitedStack){
                objectFactors[i] = _calc((UnlimitedStack<Object>)objectFactors[i]);
            }
            floatFactors[i] = Float.parseFloat(objectFactors[i].toString());
        }
        switch(operationSign){
            case "+":
                return floatFactors[0] + floatFactors[1];
            case "*":
                return floatFactors[0] * floatFactors[1];
            case "/":
                return floatFactors[1] / floatFactors[0];
            case "-":
                return floatFactors[1] - floatFactors[0];
            default:
                throw new Exception("bad equation operator");
        }
    }

    public float Calc() throws Exception {
        UnlimitedStack<Object> objectUnlimitedStack = GetSubEquations(equation);
        return _calc(objectUnlimitedStack);
    }
}
