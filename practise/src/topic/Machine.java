package topic;

/**
 * @author: Spaeurs
 * @date: 2021/10/31 16:55
 * @description: 自动贩卖机类
 */
public class Machine {

    private int colaNumber;

    public int getColaNumber() {
        return colaNumber;
    }

    public void setColaNumber(int colaNumber) {
        this.colaNumber += colaNumber;
    }

    public void setColaNumber(){
        this.colaNumber+=20;
    }

    public void sale(){
        if (colaNumber > 0){
            colaNumber--;
            System.out.println("Sold a bottle of cola");
        }else {
            System.out.println("Cola sold out");
        }
    }

    public static void main(String[] args) {
        Machine machine = new Machine();
        machine.setColaNumber(1);
        System.out.println("The vending machine has " + machine.getColaNumber() + " bottles of cola");
        machine.sale();
        System.out.println("The vending machine has " + machine.getColaNumber() + " bottles of cola");
        machine.sale();
    }
}