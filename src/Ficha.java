public enum Ficha {
    X('X'), O('O');
    private char simbolo;

    Ficha(char simbolo) {
        this.simbolo = simbolo;
    }

    public char getSimbolo() {
        return simbolo;
    }
}
