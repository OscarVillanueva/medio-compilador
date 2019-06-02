public class Lexico {
    String[] lex = new String[]{"mien", "idn", "op", "idn", "must",
            "des", "par", "idn", "op", "const", "par", "must",
            "def", "idn", "mov", "idn", ",", "idn",
            "must",
            "must"};

    //String[] lex = new String[]{"mov", "idn", ",", "idn", "log", "const", "log", "idn", "log", "def"};

    int i = 0;

    public String nextToken(){
        if(i < lex.length)
            return lex[i++];
        else
            return " ";
    }
}
