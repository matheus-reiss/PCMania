public class Cliente {
    private String nome;
    private long cpf;
    private Computador[] computadores;
    private int quantidadeComputadores;

    public Cliente(String nome, long cpf) {
        this.nome = nome;
        this.cpf = cpf;
        this.computadores = new Computador[10];// limite de 10 computadores por compra
        this.quantidadeComputadores = 0;
    }

    public void compraComputador(Computador comprado) {

        if (quantidadeComputadores < 10) {
            this.computadores[quantidadeComputadores] = comprado;
            quantidadeComputadores++;
        }
    }

    public float calcTotalCompra() {
        float total = 0;
        for (int i = 0; i < quantidadeComputadores; i++) {
            total += computadores[i].getPreco();
        }
        return total;
    }

    public void exibeInfo() {
        System.out.println("Informaçoes do cliente");
        System.out.println("Nome: " + this.nome);
        System.out.println("CPF: " + this.cpf);

        if (quantidadeComputadores > 0) {
            System.out.println("Computadores comprados");
            for (int i = 0; i < quantidadeComputadores; i++) {
                System.out.println("Computador " + (i + 1) + ":");
                computadores[i].exibePCconfig();
            }
            System.out.printf("Total Compra = R$ %.2f\n", calcTotalCompra());
        } else {
            System.out.println("Nenhum computador comprado");
            System.out.printf("Total Compra = R$ %.2f\n", 0.00);
        }
    }
}
