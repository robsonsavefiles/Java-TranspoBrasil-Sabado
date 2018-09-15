//2)crie um Enum TipoUsuario com os seguintes valores:BASIC, MEDIUM, HARD, ADMIN, em seguida crie um sistema
//de cadastro de usuarios onde podera adicionar listar ou remover usuario. A classe usuario deve possuir os seguintes
//atributos: nome, email, senha, tipo[TipoUsuario];
package br.com.proway.java;

public enum TipoUsuario {

    BASIC(1), MEDIUM(2), HARD(3), ADMIM(4) {
                public int getCodigo() {
                    return 1000;
                }
            };

    private int codigo;

    TipoUsuario(int codigo) {
        this.codigo = codigo;
    }

    public int getCodigo() {
        return codigo;
    }

    public static TipoUsuario of(int codigo) {
        switch (codigo) {
            case 1:
                return BASIC;
            case 2:
                return MEDIUM;
            case 3:
                return HARD;
            case 4:
                return ADMIM;

        }
        return null;

    }

}
