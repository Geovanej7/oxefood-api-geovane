package br.com.ifpe.oxefood.util.exception;

public class EntregadorException extends RuntimeException {

    public static final String MSG_CPF_NULO ="CPF não pode ser nulo";

    public EntregadorException(String msg){
        super(String.format(msg));
    }

}
