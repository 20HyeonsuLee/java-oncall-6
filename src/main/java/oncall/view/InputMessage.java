package oncall.view;

public enum InputMessage {

    INPUT_MACHINE_AMOUNT("자판기가 보유하고 있는 금액을 입력해 주세요."),
    INPUT_PRODUCTS("상품명과 가격, 수량을 입력해 주세요."),
    INPUT_BUY_AMOUNT("투입 금액을 입력해 주세요."),
    INPUT_BUY_PRODUCT_NAME("구매할 상품명을 입력해 주세요."),
    ;

    private final String message;

    InputMessage(String message) {
        this.message = message;
    }

    public void print(Object... values) {
        System.out.println(format(values));
    }

    public String format(Object... values) {
        return String.format(message, values);
    }
}
