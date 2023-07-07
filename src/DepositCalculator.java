import java.util.Scanner;

public class DepositCalculator
{
    double calculateComplexPercent(double amount, double yearRate, int depositPeriod ) {
       double finalAmount = amount * Math.pow((1 + yearRate / 12), 12 * depositPeriod);
       return roundToPlaces(finalAmount, 2);
    }

    double calculateSimplePercent(double doubleAmount, double yearRate, int depositPeriod) {
         return roundToPlaces(doubleAmount + (doubleAmount * yearRate * depositPeriod), 2);
    }

    double roundToPlaces(double value, int places) { //Округление до заданного числа символов после запятой
        double scale = Math.pow(10, places);
        return Math.round(value * scale) / scale;
    }

    void calculateFinalAmount() {
        int period;
        int action;
        int amount;
        double finalAmount = 0;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите сумму вклада в рублях:");
        amount = scanner.nextInt();

        System.out.println("Введите срок вклада в годах:") ;
        period = scanner.nextInt();

        System.out.println("Выберите тип вклада, "
                + "1 - вклад с обычным процентом, "
                + "2 - вклад с капитализацией:");
        action = scanner.nextInt();

        if (action == 1) {
            finalAmount = calculateSimplePercent(amount, 0.06, period);
        }
        else if (action == 2) {
            finalAmount = calculateComplexPercent(amount, 0.06, period);
        }

        System.out.println("Результат вклада: " + amount + " за "
                + period + " лет превратятся в " + finalAmount);
    }

    public static void main(String[] args) {
        new DepositCalculator().calculateFinalAmount();
    }
}
