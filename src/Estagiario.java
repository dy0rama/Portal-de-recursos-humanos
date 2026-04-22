import java.time.Duration;

public class Estagiario extends Funcionario{

    public Estagiario(String nome, int id) {
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
        return "Estagiário(a)";
    }
}
