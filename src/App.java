
import StockHolders.*;
import SoyShareholders.*;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Iniciando programa");
        System.out.println("Observadores de dolar: ");
        boolean continuar = true;
        Scanner sc = new Scanner(System.in);

        StockExchange StockPVH = new StockExchange();
        new DollStockHolder(StockPVH);
        new DollStockHolder(StockPVH);
        new GoldStockHolder(StockPVH);
        new GoldStockHolder(StockPVH);

        System.out.println("\nIniciando o dia nas cotações 5.80 e 350");
        StockPVH.setState(5.80, 350, 5);

        System.out.println("\nMeio dia");
        StockPVH.setState(6, 340, 2);

        System.out.println("\nFinalizando o dia nas cotações 4.99 e 240");
        StockPVH.setState(4.99, 240, 3);

        while(continuar){
            String opcao = "";
            System.out.print("Deseja cadastrar um observador de soja? ['sim' - 'não']: ");
            opcao = sc.nextLine();


            if(opcao.toLowerCase().equals("sim")) {
                System.out.print("Insira um valor mínimo para compra de soja [1.00 2.00 ...]: ");
                double minimumPriceForSoybeanSales = sc.nextDouble();

                System.out.println("");

                System.out.print("Insira um valor mínimo para venda de soja [1.00 2.00 ...]: ");
                double minimumPriceForBuyingSoybeans = sc.nextDouble();

                new SoyShareholder(StockPVH, minimumPriceForSoybeanSales, minimumPriceForBuyingSoybeans);

                System.out.println("");
            }
            
            System.out.println("Vamos cadastrar cotações novas?");
            System.out.println("Favor responda o questionário \r\n");
            sc.nextLine();

            String opcaoCotacao = "";
            System.out.print("Deseja alterar o valor das cotações?");
            opcaoCotacao = sc.nextLine();

            if(opcaoCotacao.toLowerCase().trim().equals("sim")) {
                System.out.print("Insira o valor da soja: ");
                double SoyValue = sc.nextDouble();
                System.out.println("");
                System.out.print("Insira o valor do dolar: ");
                double DollValue = sc.nextDouble();
                System.out.println("");
                System.out.print("Insira o valor do ouro: ");
                double GoldValue = sc.nextDouble();

                StockPVH.setState(DollValue, GoldValue, SoyValue);
            }
            
            continuar = opcaoCotacao.toLowerCase().equals("sim") || opcao.toLowerCase().equals("sim");
        };

        sc.close();
    }
}
