import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Main {

    private static final Map<Integer, Funcionario> funcionarios =  new HashMap<>();
    private static final Map<Integer, List<RegistrarPonto>> registros =  new HashMap<>();
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao;

        do {
            System.out.println("\n=== PORTAL RH ===");
            System.out.println("1 - Cadastrar Funcionário");
            System.out.println("2 - Registrar Ponto");
            System.out.println("3 - Listar Registros");
            System.out.println("4 - Remover Funcionário");
            System.out.println("0 - Sair");
            System.out.print(" ");

            opcao = lerInteiro("Escolha uma opção:");

            switch (opcao) {
                case 1 ->
                    cadastrarFuncionario();
                case 2 ->
                        registarPonto();
                case 3 ->
                    listarRegistros();
                case 4 ->
                    removerFuncionario();
                case 0 -> {
                    System.out.println("=================");
                    System.out.println("Encerrando...");
                }
                default -> {
                    System.out.println("=================");
                    System.out.println("Opção Inválida!");
                }
            }
        }while (opcao != 0);
    }

    private static void removerFuncionario() {
        System.out.println("=================");
        int id = lerInteiro("ID do funcionário: ");

        funcionarios.remove(id);
        registros.remove(id);

        System.out.println("Funcionário removido com sucesso!");
    }

    private static void listarRegistros() {
        System.out.println("=================");
        int id = lerInteiro("ID do funcionário: ");

        Funcionario f = funcionarios.get(id);

        List<RegistrarPonto> listaRegistros = registros.get(id);

        if (listaRegistros == null) {
            System.out.println("Nenhum registro foi encontrado");
            return;
        }

        System.out.println("ID: " + f.getId());
        System.out.println("Nome: " + f.getNome());
        System.out.println("Cargo: " + f.getCargo());

        for (RegistrarPonto rp : listaRegistros) {
            System.out.println(rp);
        }
    }

    private static void registarPonto() {
        System.out.println("=================");
        int id = lerInteiro("ID do funcionário: ");

        Funcionario funcionario = funcionarios.get(id);

        if (funcionario == null) {
            System.out.println("Funcionário não encontrado.");
            return;
        }

        if (!funcionario.podeBaterPonto()){
            System.out.println("Este funcionário não bate ponto.");
            return;
        }

        LocalTime entrada = lerHorario("Hora de entrada (HH:mm): ");

        LocalTime saida = lerHorario("Hora de saída (HH:mm): ");

        if (entrada.isBefore(LocalTime.of(6,0)) || saida.isAfter(LocalTime.of(22,0)) || !saida.isAfter(entrada)) {
            System.out.println("Horários inválidos.");
        }else {
            RegistrarPonto rp = new RegistrarPonto(LocalDate.now(), entrada, saida);

            if (rp.calcularHorasExtra().compareTo(funcionario.limiteDeHoraExtra()) > 0 ) {
                System.out.println("Excedeu o limite de horas extra.");
                return;
            }
            registros.computeIfAbsent(id, k -> new ArrayList<>()).add(rp);
            System.out.println("Registro realizado com sucesso!");
        }
    }

    private static void cadastrarFuncionario() {
        System.out.println("=================");
        int id = lerInteiro("ID do funcionário: ");

        if (funcionarios.containsKey(id)) {
            System.out.println("Já existe funcionário com esse ID!");
            return;
        }
        sc.nextLine();

        String nome =lerTexto();

        int cargo = lerInteiro("Cargo:\n1 - Gerente\n2 - Coordenador\n3 - Analista\n4 - Assistente\n5 - Estagiário\nEscolha o cargo: ");

        Funcionario f = null;

        switch(cargo){
            case 1 -> f = new Gerente(nome, id);
            case 2 -> f = new Coordenador(nome, id);
            case 3 -> f = new Analista(nome, id);
            case 4 -> f = new Assistente(nome, id);
            case 5 -> f = new Estagiario(nome, id);
        }

        funcionarios.put(id, f);
        System.out.println("Funcionário cadastrado com sucesso!");
    }

    private static int lerInteiro(String msg) {
        while (true) {
            try {
                System.out.println(msg);
                int valor;
                valor = Integer.parseInt(sc.next());
                return valor;
            }catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Digite um número inteiro.");
            }
        }
    }

    private static String lerTexto() {
        while (true) {
            System.out.println("Nome: ");
            String texto;
            texto = sc.next();

            if (texto.matches("[\\p{L} ]+")) {
                return texto;
            }else  {
                System.out.println("Entrada inválida. Digite novamente.");
            }
        }
    }

    private static LocalTime lerHorario(String msg) {
        while (true) {
            try {
                System.out.println(msg);
                return LocalTime.parse(sc.next(), DateTimeFormatter.ofPattern("HH:mm"));
            } catch (Exception e) {
                System.out.println("Formato inválido! Use HH:mm (ex.: 08:30)");
            }
        }
    }
}
