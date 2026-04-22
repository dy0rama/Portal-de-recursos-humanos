import java.time.Duration;
import java.util.Scanner;

public abstract class Funcionario {
    protected String nome;
    protected int id;

    public Funcionario(String nome, int id) {
        this.nome = nome;
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public int getId() {
        return id;
    }

    public abstract boolean podeBaterPonto();

    public abstract Duration limiteDeHoraExtra();

    public abstract String getCargo();
}
