public class Lexico {
    /*String[] lex = new String[]{"mien", "idn", "op", "idn", "must",
            "des", "par", "idn", "op", "const", "par", "must",
            "def", "idn", "mov", "idn", ",", "idn","in", "par", "idn", "par", "out", "par", "idn","par",
            "must",
            "must"};*/

    String[] lex = new String[]{"out", "par", "const","par"};

    int i = 0;

    public String nextToken(){
        if(i < lex.length)
            return lex[i++];
        else
            return " ";
    }
}
