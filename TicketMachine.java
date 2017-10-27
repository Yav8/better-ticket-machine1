/**
 * TicketMachine models a ticket machine that issues
 * flat-fare tickets.
 * The price of a ticket is specified via the constructor.
 * Instances will check to ensure that a user only enters
 * sensible amounts of money, and will only print a ticket
 * if enough money has been input.
 * 
 * @author David J. Barnes and Michael KÃ¶lling
 * @version 2011.07.31
 */
public class TicketMachine
{
    // The price of a ticket from this machine.
    private int price;
    // The amount of money entered by a customer so far.
    private int balance;
    // The total amount of money collected by this machine.
    private int total;
    // La máquina es del tipo que vende billetes con premio.
    private boolean premio;
    // Indica el número de billetes que cómo máximo la máquina puede vender.
    private int numeroMaximoDeBilletes;
    // Indica el número actual de billetes que la máquina ha vendido.
    private int numeroActualDeBilletes;

    /**
     * Crea una máquina que imprime billetes con un precio determinado.
     * Indica si es una máquina normal o que venda billetes con premio.
     * Si vende billetes con premio,
     * por cada billete que se compra te dan otro de regalo.
     * Indica el número máximo de billetes.
     */
    public TicketMachine(int cost, boolean billeteConPremio, int NumeroMaximoDeBilletesQuePuedeVender)
    {
        if(billeteConPremio == true)
        {
            price = cost;
            balance = 0;
            total = 0;
            premio = billeteConPremio;
            numeroMaximoDeBilletes = NumeroMaximoDeBilletesQuePuedeVender;
        }
        else
        {
            price = cost;
            balance = 0;
            total = 0;
            numeroMaximoDeBilletes = NumeroMaximoDeBilletesQuePuedeVender;
        }
    }

    /**
     * @Return The price of a ticket.
     */
    public int getPrice()
    {
        return price;
    }

    /**
     * Return The amount of money already inserted for the
     * next ticket.
     */
    public int getBalance()
    {
        return balance;
    }

    /**
     * Recibe la cantidad de dinero de un cliente.
     * Verifica que la cantidad sea razonable.
     * Si no hay billetes en la máquina no se puede meter dinero.
     */
    public void insertMoney(int amount)
    {
        if(numeroActualDeBilletes < numeroMaximoDeBilletes) {
            if(amount > 0) {
                balance = balance + amount;
            }
            else {
                System.out.println("Use a positive amount rather than: " +
                    amount);
            }
        }
        else {
            amount = 0;
            System.out.println("La máquina se ha quedado sin billetes, es inútil meter dinero.");
        }
    }

    /**
     * Imprime un billete si se ha insertado suficiente dinero y
     * reduce el saldo actual según el precio del boleto. 
     * Imprime un mensaje de error si no hay suficiente dinero metido en la máquina.
     * Si la máquina es del tipo que vende billetes con premio, 
     * cada vez que se compre un billete con éxito te dan uno de regalo.
     * Si la máquina no tiene billetes disponibles, al intentar sacar uno sale un mensaje de error.
     */
    public void printTicket()
    {
        if(numeroActualDeBilletes < numeroMaximoDeBilletes) {
            if(premio == true) {
                if(balance >= price) {
                    // Simulate the printing of a ticket.
                    System.out.println("##################");
                    System.out.println("# The BlueJ Line");
                    System.out.println("# Ticket");
                    System.out.println("# " + price + " cents.");
                    System.out.println("##################");
                    System.out.println();
                    System.out.println("¡Llévate un billete de regalo!");

                    // Update the total collected with the price.
                    total = total + price;
                    // Reduce the balance by the prince.
                    balance = balance - price;
                    // Contabiliza el número de billetes que se venden.
                    numeroActualDeBilletes = numeroActualDeBilletes + 1;

                }
                else {
                    System.out.println("You must insert at least: " +
                        (price - balance) + " more cents.");
                }
            }
            else {
                if(balance >= price) {
                    // Simulate the printing of a ticket.
                    System.out.println("##################");
                    System.out.println("# The BlueJ Line");
                    System.out.println("# Ticket");
                    System.out.println("# " + price + " cents.");
                    System.out.println("##################");
                    System.out.println();

                    // Update the total collected with the price.
                    total = total + price;
                    // Reduce the balance by the prince.
                    balance = balance - price;
                    // Contabiliza el número de billetes que se venden.
                    numeroActualDeBilletes = numeroActualDeBilletes + 1;
                }
                else {
                    System.out.println("You must insert at least: " +
                        (price - balance) + " more cents.");
                }
            }
        }
        else {
            System.out.println("ERROR: La máquina se ha quedado sin billetes, no puede comprar más.");
        }
    }

    /**
     * Return the money in the balance.
     * The balance is cleared.
     */
    public int refundBalance()
    {
        int amountToRefund;
        amountToRefund = balance;
        balance = 0;
        return amountToRefund;
    }

    /**
     * Vacía y devuelve el dinero de la máquina, 
     * sólo si no hay una operación en curso.
     */
    public int emptyMachine()
    {
        int devolucionTotalDeDinero;
        if(balance == 0)
        {
            devolucionTotalDeDinero = total;
            total = 0;
        }
        else 
        {
            System.out.println("ERROR: La máquina tiene una operación en curso, imposible vaciar la máquina en este momento.");
            devolucionTotalDeDinero = -1;
        }
        return devolucionTotalDeDinero;
    }
}
