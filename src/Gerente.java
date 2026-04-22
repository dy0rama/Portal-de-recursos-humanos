import java.time.Duration;

public class Gerente extends Funcionario {

    public Gerente(String nome, int id) {
        super(nome, id);
    }

    @Override
    public boolean podeBaterPonto() {
        return false;
    }

    @Override
    public Duration limiteDeHoraExtra() {
        return Duration.ZERO;
    }

    @Override
    public String getCargo() {
        return "Gerente";
    }
}
