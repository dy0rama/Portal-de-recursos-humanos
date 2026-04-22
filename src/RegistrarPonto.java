import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class RegistrarPonto {
    private final LocalDate data;
    private final LocalTime entrada;
    private final LocalTime saida;

    public RegistrarPonto(LocalDate data, LocalTime entrada, LocalTime saida) {
        this.data = data;
        this.entrada = entrada;
        this.saida = saida;
    }

    public Duration calcularHorasTrabalhadas() {
        Duration duracao = Duration.between(entrada, saida);

        if (duracao.isNegative() || duracao.isZero()) {
            return Duration.ZERO;
        }

        duracao = duracao.minusHours(1);

        return duracao;
    }

    public Duration calcularHorasExtra() {
        Duration horasTrabalhadas = calcularHorasTrabalhadas();
        Duration jornadaPadrao = Duration.ofHours(8);

        if (horasTrabalhadas.compareTo(jornadaPadrao) <= 0) {
            return Duration.ZERO;
        }

        return horasTrabalhadas.minus(jornadaPadrao);
    }

    private static final DateTimeFormatter formatadorData = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    private static final DateTimeFormatter formatadorHora = DateTimeFormatter.ofPattern("HH:mm");

    @Override
    public String toString() {
        return "====Registro====" + "\nData: " + data.format(formatadorData) +
                "\nEntrada do funcionário: " + entrada.format(formatadorHora) + "Hrs" +
                "\nSaída do funcionário: " + saida.format(formatadorHora) + "Hrs" +
                "\nHoras trabalhadas: " + formatadorHora(calcularHorasTrabalhadas()) + "Hrs" +
                "\nHoras extras: " + formatadorHora(calcularHorasExtra());
    }

    private String formatadorHora(Duration duration) {
        long horas =  duration.toHours();
        long minutos = duration.toMinutesPart();

        return String.format("%02d:%02d", horas, minutos);
    }
}
