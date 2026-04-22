O objetivo desse programa é permitir:

      1. Cadastros de funcionários      
      2. Registro de entrada e saída
      3. Controle de horas trabalahdas
      4. Validação de regras de negócio

Tipos de funcionários:

      #  Tipo            Bate Ponto       Hora Extra

      1. Gerente         Não              0h
      2. Coordenador     Sim              5h
      3. Analista        Sim              3h
      4. Assistente      Sim              3h
      5. Estagiário      Não              0h

Regras do Negócio:

      1. Horário de entrada >= 06:00
      2. Horário de saída <= 22:00
      3. Saída deve ser após a entrada
      4. 1 hora de almoço é descontada automaticamente
      5. Limite de horas extra por tipo de funcionário
      6. Gerentes e estagiários não podem registrar ponto

Funcionalidades:

      1. Cadstrar Funcionário
      2. Registrar Ponto
      3. Listar Registros
      4. Remover Funcionário
      5. Encerrar Sistema

Tecnologias Utilizadas:

      1. Java
      2. Programação Orientada à Objetos
      3. API de Data/Hora (LocalDate, LocalTime)

Paradigmas utilizados:

      1. Abstração
      2. Polimorfismo
      3. Herança
      4. Encapsulamento

Decisões de projeto:

      1. Uso de Classe abstrata Funcionário para generalização
      2. Uso de Map para armazenamento de memória
      3. Tratamento de erros com try/catch
      4. Validação de entrada de usuário
