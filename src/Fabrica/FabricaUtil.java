package Fabrica;

import java.util.Comparator;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class FabricaUtil {

    // 1️⃣ Filtrar funcionários
    public static List<Funcionario> filtrarFuncionarios(List<Empresa> empresas) {
        return empresas.stream()
                .flatMap(e -> e.getFuncionarios().stream())
                .filter(f -> f.getAnoNascimento() >= 1975 && f.getAnoNascimento() <= 1985)
                .filter(f -> f.getSalario() <= 3000)
                .collect(toList());
    }

    // 2️⃣ Somar números pares
    public static int somarNumerosPares(List<Integer> numeros) {
        return numeros.stream()
                .filter(n -> n % 2 == 0)
                .mapToInt(Integer::intValue)
                .sum();
    }

    // 3️⃣ 30 maiores salários CLT com menos de 25 anos
    public static List<Double> maioresSalariosCltMenos25(List<Empresa> empresas) {
        return empresas.stream()
                .flatMap(e -> e.getFuncionarios().stream())
                .filter(Funcionario::isClt)
                .filter(f -> (2025 - f.getAnoNascimento()) < 25) // idade
                .sorted(Comparator.comparing(Funcionario::getSalario).reversed())
                .limit(30)
                .map(Funcionario::getSalario)
                .collect(toList());
    }
}
