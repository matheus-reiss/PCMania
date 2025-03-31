public class Computador {
    private String marca;
    private float preco;
    private SistemaOperacional sOperacional;
    private HardwareBasico[] hardwareBasicos;
    private MemoriaUSB memoriaUsb;
    private int quantidadeHardwares;

    public Computador(String marca, float preco) {
        this.marca = marca;
        this.preco = preco;
        this.hardwareBasicos = new HardwareBasico[3]; // processador, memoria e hd
        this.quantidadeHardwares = 0;
    }

    public String getMarca() {
        return marca;
    }

    public float getPreco() {
        return preco;
    }

    public void adicionaHardware(HardwareBasico hardware) {
        if (quantidadeHardwares < 3) {
            this.hardwareBasicos[quantidadeHardwares] = hardware;
            quantidadeHardwares++;
        }
    }

    public void setSOperacional(SistemaOperacional sOperacional) {
        this.sOperacional = sOperacional;
    }

    public void adicionaMemoria(MemoriaUSB memUsb) {
        this.memoriaUsb = memUsb;
    }

    public void exibePCconfig() {
        System.out.println("Marca: " + this.marca);
        System.out.printf("Preço: R$ %.2f\n", this.preco);

        for (int i = 0; i < quantidadeHardwares; i++) {
            HardwareBasico hBasico = hardwareBasicos[i];
            System.out.println(hBasico.getNome() + ": " + hBasico.getCapacidade()
                    + (hBasico.getNome().contains("Processador") ? " MHz"
                            : hBasico.getNome().contains("Memória RAM") ? " GB" : " GB"));
        }

        if (sOperacional != null) {
            System.out.println(
                    "Sistema Operacional: " + sOperacional.getNome() + " (" + sOperacional.getTipo() + " bits)");
        } else {
            System.out.println("Sistema Operacional: Não definido");
        }
        if (memoriaUsb != null) {
            System.out.println("Acompanha: " + memoriaUsb.getNome() + " de " + memoriaUsb.getCapacidade() + "GB");
        }
    }
}
