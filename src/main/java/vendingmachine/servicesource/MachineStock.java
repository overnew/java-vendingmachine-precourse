package vendingmachine.servicesource;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.utils.moneychecker.BalanceInputChecker;
import vendingmachine.utils.productchecker.InputChecker;

import java.util.HashMap;
import java.util.Set;

public class MachineStock {
    private static final String PRODUCT_NAME_REQUEST = "구매할 상품명을 입력해 주세요.";
    private HashMap<Product, Integer> productStockMap;  // key: Product, value: 재고 수량
    private HashMap<String, Product> productListMap;    // key: Product name, value: Product

    void MachineStock(){
        productStockMap = InputChecker.getProductStockHashMap();
        productListMap = makeProductList( productStockMap.keySet());
    }

    private HashMap<String, Product> makeProductList(Set<Product> productsSet){
        HashMap<String, Product> productListMap = new HashMap<>();

        for(Product currentProduct : productsSet){
            productListMap.put(currentProduct.getName(), currentProduct);
        }

        return productListMap;
    }

    Product getSelectedProduct(){
        String productName;

        do{
            System.out.println(PRODUCT_NAME_REQUEST);
            productName = Console.readLine();
        }while(!InputChecker.isRightNameInput(productName) || !checkHaveProduct(productName));

        return productListMap.get(productName);
    }

    private boolean checkHaveProduct(String productName){
        boolean haveProduct = true;

        try{
            checkInList(productName);
            checkHaveStock(productName);
        }catch(IllegalArgumentException exception){
            haveProduct = false;
            exception.getMessage();
        }

        return haveProduct;
    }

    private void checkInList(String productName){

        if(!productListMap.containsKey(productName)){
            throw new IllegalArgumentException("[ERROR]: 존재하지 않는 상품입니다.");
        }

    }

    private void checkHaveStock(String productName){

        if(productStockMap.get(productListMap.get(productName)) == 0){
            throw new IllegalArgumentException("[ERROR]: 해당 상품의 재고가 없습니다.");
        }

    }
}
