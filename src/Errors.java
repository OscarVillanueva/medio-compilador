import java.util.HashMap;

public class Errors {

    private HashMap<Integer, String> errors;

    public Errors() {
        this.errors = new HashMap();
        this.errors.put(1, "Error no se esperaba un token se esperaba un identificador");
        this.errors.put(2, "Error no se esperaba un token se esperaba un parentesis");
        this.errors.put(3, "Error no se esperaba un token se esperaba un operador");
        this.errors.put(4, "Error no se esperaba un token se esperaba un identificador o una constante");
        this.errors.put(5, "Error no se esperaba un token se esperaba una llave");
        this.errors.put(6, "Error no se esperaba un token se esperaba una instrucción");
        this.errors.put(7, "No se esperaba la terminación del programa");
        this.errors.put(8, "Error no se esperaba un token se esperaba una ,");
        this.errors.put(9, "Error no se esperaba un token se esperaba un identificador, una constante o una expresion");
    }

    public String error(int index){
        return this.errors.get(index);
    }

}
