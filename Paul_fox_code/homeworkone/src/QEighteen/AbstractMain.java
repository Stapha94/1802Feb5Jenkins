package QEighteen;

public class AbstractMain extends AbstractClass{

    @Override
    public boolean checkUppercase(String s){

        boolean hasUppercase = !s.equals(s.toLowerCase());
        return hasUppercase;
    }

    @Override
    public String lowerToUpper(String s){

        s = s.toUpperCase();
        return s;
    }

    @Override
    public int stringToInt(String s){

        int answer = Integer.parseInt(s);
        answer = answer + 10;
        return answer;
    }

}
