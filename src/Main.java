import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // cadastro de cliente
        System.out.println("Bem vindo à PC Mania");
        System.out.print("Digite seu nome: ");
        String nome = scanner.nextLine();
        System.out.print("Digite seu CPF: ");
        long cpf = scanner.nextLong();

        Cliente cliente = new Cliente(nome, cpf);

        // matricula para calculo de preço
        float matricula = 284;

        // Promoções de computadores
        Computador promocao1 = new Computador("Apple", matricula);
        promocao1.adicionaHardware(new HardwareBasico("Processador Core i3", 2200));
        promocao1.adicionaHardware(new HardwareBasico("Memória RAM", 8));
        promocao1.adicionaHardware(new HardwareBasico("HD", 500));
        promocao1.setSOperacional(new SistemaOperacional("Linux Ubuntu", 32));
        promocao1.adicionaMemoria(new MemoriaUSB("Pen-drive", 16));

        Computador promocao2 = new Computador("Samsung", matricula + 1234);
        promocao2.adicionaHardware(new HardwareBasico("Processador Core i5", 3370));
        promocao2.adicionaHardware(new HardwareBasico("Memória RAM", 16));
        promocao2.adicionaHardware(new HardwareBasico("HD", 1000));
        promocao2.setSOperacional(new SistemaOperacional("Windows 8", 64));
        promocao2.adicionaMemoria(new MemoriaUSB("Pen-drive", 32));

        Computador promocao3 = new Computador("Dell", matricula + 5678);
        promocao3.adicionaHardware(new HardwareBasico("Processador Core i7", 4500));
        promocao3.adicionaHardware(new HardwareBasico("Memória RAM", 32));
        promocao3.adicionaHardware(new HardwareBasico("HD", 2000));
        promocao3.setSOperacional(new SistemaOperacional("Windows 10", 64));
        promocao3.adicionaMemoria(new MemoriaUSB("HD Externo", 1000));

        // Menu compras
        int Op;
        do {
            System.out.println("\n========== Promoçoes Disponíveis ==========");
            System.out.println("1 - Promoçao 1: Computador Apple - R$ " + promocao1.getPreco());
            System.out.println("2 - Promoçao 2: Computador Samsung - R$ " + promocao2.getPreco());
            System.out.println("3 - Promoçao 3: Computador Dell - R$ " + promocao3.getPreco());
            System.out.println("0 - Finalizar compra");
            System.out.print("Digite o código da promoçao desejada: ");
            Op = scanner.nextInt();

            switch (Op) {
                case 1:
                    cliente.compraComputador(promocao1);
                    System.out.println("Computador da Apple adicionado ao seu carrinho!");
                    break;
                case 2:
                    cliente.compraComputador(promocao2);
                    System.out.println("Computador da Samsung adicionado ao seu carrinho!");
                    break;
                case 3:
                    cliente.compraComputador(promocao3);
                    System.out.println("Computador da Dell adicionado ao seu carrinho!");
                    break;
                case 0:
                    System.out.println("Finalizando sua compra...");
                    break;
                default:
                    System.out.println("Opçao inválida");
            }
        } while (Op != 0);

        cliente.exibeInfo();

        scanner.close();

    }
}
