package Fabrica;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        Funcionario f1 = new Funcionario("Ana", 1980, 2500, true);
        Funcionario f2 = new Funcionario("João", 1978, 3200, true);
        Funcionario f3 = new Funcionario("Carlos", 1999, 5000, true);
        Funcionario f4 = new Funcionario("Maria", 2002, 4500, true);

        Empresa e1 = new Empresa("Empresa A", List.of(f1, f2));
        Empresa e2 = new Empresa("Empresa B", List.of(f3, f4));

        List<Empresa> empresas = List.of(e1, e2);

        System.out.println("=== Funcionários filtrados ===");
        FabricaUtil.filtrarFuncionarios(empresas).forEach(System.out::println);

        System.out.println("\n=== Soma números pares ===");
        System.out.println(FabricaUtil.somarNumerosPares(List.of(1,2,3,4,5,6)));

        System.out.println("\n=== Maiores salários CLT < 25 anos ===");
        FabricaUtil.maioresSalariosCltMenos25(empresas).forEach(System.out::println);
    }
}
