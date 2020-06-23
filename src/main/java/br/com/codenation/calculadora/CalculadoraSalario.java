package br.com.codenation.calculadora;

public class CalculadoraSalario {
    public long calcularSalarioLiquido(double salarioBase) {
        //Use o Math.round apenas no final do método para arredondar o valor final.
        //Documentação do método: https://docs.oracle.com/javase/8/docs/api/java/lang/Math.html#round-double-
        if (salarioBase < 1039.0) {
            return 0;
        }
        salarioBase = this.calcularInss(salarioBase);
        salarioBase = this.calcularIrrf(salarioBase);
        return Math.round(salarioBase);
    }

    //Exemplo de método que pode ser criado para separar melhor as responsabilidades de seu algorítmo
    private double calcularInss(double salario) {

        if (salario <= 1500.0) {
            return salario - (salario * 8)/100;
        }
        else if (salario <= 4000.00) {
            return salario - (salario * 9)/100;
        }
        else {
            return salario - (salario * 11)/100;
        }
    }

    private double calcularIrrf(double salario) {
        if (salario <= 3000.0) {
            return salario;
        }
        else if (salario <= 6000.0 ) {
            return salario - (salario * 7.5)/100;
        }
        else {
            return salario - (salario * 15)/100;
        }
    }
}
