public class Sintactico {
    private String id = "idn";
    private String operator = "op";
    private String parenthesis = "par";
    private String constant = "const";
    private String mustache = "must";
    private String log = "log";

    private String currentToken;
    private Errors errors;
    private Lexico lex;

    public Sintactico(){
        this.errors = new Errors();
        this.lex = new Lexico();
    }

    public void whoiam(){
        switch (this.currentToken) {
            case "def": //puede ser cambiado por un numero
                this.definition();
                break;

            case "des":
                this.decision();
                break;

            case "mien":
                this.loop();
                break;

            case "mov":
                this.mov();
                break;

            case "in":
                break;

            case "out":
                break;
            default:
                this.fatalError(this.errors.error(6));
                break;
        }
    }

    public void analize(){

        this.currentToken = this.lex.nextToken();

        while (!this.currentToken.equals(" ")) {
            this.whoiam();
        }

    }

    public void logic(){

        while(!this.currentToken.equals(" ") && !this.currentToken.equals(this.mustache))
            this.whoiam();

        if(this.currentToken.equals(" "))
            fatalError(this.errors.error(7));

    }

    public void definition(){
        this.newToken();

        if(this.currentToken.equals(this.id)){
            this.newToken();
        }
        else {
            this.fatalError(this.errors.error(1));
        }

    }

    public void condition(){
        this.newToken();

        if(this.currentToken.equals(this.id)) {
            this.newToken();

            if(this.currentToken.equals(this.operator)){
                this.newToken();

                if(this.currentToken.equals(this.id) || this.currentToken.equals(this.constant)){
                    this.newToken();
                }
                else
                    fatalError(this.errors.error(4));
            }
            else {
                fatalError(this.errors.error(3));
            }
        }
        else
            fatalError(this.errors.error(1));

    }

    public void decision(){
        this.newToken();

        if(this.currentToken.equals(this.parenthesis)) {
            this.condition();

            if(this.currentToken.equals(this.parenthesis)){
                this.newToken();

                this.contentOfStructure();

            }
            else
                fatalError(this.errors.error(2));
        }
        else
            fatalError(this.errors.error(2));

    }

    public void loop(){
        this.condition();

        this.contentOfStructure();

    }

    public void mov(){
        this.newToken();

        if(this.currentToken.equals(this.id)){
            this.newToken();

            if(this.currentToken.equals(",")){

                if(!this.expression()){

                    if(this.currentToken.equals(this.constant) || this.currentToken.equals(this.id)){
                        this.newToken();
                    }
                    else
                        this.fatalError(this.errors.error(4));
                }
            }
            else
                this.fatalError(this.errors.error(8));

        }
        else
            this.fatalError(this.errors.error(1));
    }

    public boolean expression(){
        this.newToken();
        //String aux = this.currentToken;

        if(this.currentToken.equals(this.constant) || this.currentToken.equals(this.id)){
            this.newToken();

            if(this.currentToken.equals(this.log)){
                this.newToken();

                if(this.currentToken.equals(this.constant) || this.currentToken.equals(this.id)){

                    this.newToken();

                    if(this.currentToken.equals(this.log)) {
                        this.expression();
                    }
                    else{
                        return true;
                    }

                }
                else
                    this.fatalError(this.errors.error(4));

            }
            else {
                //this.currentToken = aux;
                return true;
            }
        }
        else
            return false;

        return true;
    }

    private void contentOfStructure() {
        if(this.currentToken.equals(this.mustache)){
            this.newToken();

            this.logic();

            if(this.currentToken.equals(this.mustache)){
                this.newToken();
            }
            else
                fatalError(this.errors.error(5));
        }
        else
            fatalError(this.errors.error(5));
    }


    private void newToken(){
        this.currentToken = this.lex.nextToken();
    }

    private void fatalError(String error){
        System.err.println(error);
        System.exit(0);
    }
}
