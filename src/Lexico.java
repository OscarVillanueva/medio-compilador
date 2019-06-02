public class Lexico {
    String[] lex = new String[]{"init:", "def", "idn", "def", "idn","mien", "idn", "op", "idn", "must",
            "des", "par", "idn", "op", "const", "par", "must",
            "mov", "idn", ",", "idn","in", "par", "idn", "par", "out", "par", "idn","par",
            "must",
            "must"};

    /*String[] lex = new String[]{"init:", "mien", "idn", "op", "idn", "must",
            "des", "par", "idn", "op", "const", "par", "must",
            "def", "idn", "mov", "idn", ",", "idn","in", "par", "idn", "par", "out", "par", "idn","par",
            "must",
            "must"};*/

    //String[] lex = new String[]{"init:", "def", "idn"};

    int i = 0;

    public String nextToken(){
        if(i < lex.length)
            return lex[i++];
        else
            return " ";
    }
}
