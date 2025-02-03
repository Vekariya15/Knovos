package Session2.BeautySaloon;

/**
 * in this class create a discount method with various membership of Customers
 */
class DiscountRate {
    static double serviceDiscountPremium = 0.2;
    static double serviceDiscountGold = 0.15;
    static double serviceDiscountSilver = 0.1;

    static double productDiscountPremium = 0.1;
    static double productDiscountGold = 0.1;
    static double productDiscountSilver = 0.1;

    public static double getServiceDiscountRate(String type) { // there multiple case so use switch case

        return switch (type) {
            case "Premium" -> serviceDiscountPremium;  // use arrow function in switch case
            case "Gold" -> serviceDiscountGold;
            case "Silver" -> serviceDiscountSilver;
            default -> 1;   // default case and its value is 1
        };
    }

    public static double getProductDiscountRate(String type) {
        return switch (type) {
            case "Premium" -> productDiscountPremium;
            case "Gold" -> productDiscountGold;
            case "Silver" -> productDiscountSilver;
            default -> 1;
        };
    }

}
