import java.time.Duration;

public class Coordenador extends Funcionario {

    public Coordenador(String nome, int id) {
        super(nome, id);
    }

    @Override
    public boolean podeBaterPonto() {
        return true;
    }

    @Override
    public Duration limiteDeHoraExtra() {
        return Duration.ofHours(5);
    }

    @Override
    public String getCargo() {
        return "Coordenador(a)";
    }


}
