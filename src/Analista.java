import java.time.Duration;

public class Analista extends Funcionario {

    public Analista(String nome, int id) {
        super(nome, id);
    }

    @Override
    public boolean podeBaterPonto() {
        return true;
    }

    @Override
    public Duration limiteDeHoraExtra() {
        return Duration.ofHours(3);
    }

    @Override
    public String getCargo() {
        return "Analista";
    }
}
