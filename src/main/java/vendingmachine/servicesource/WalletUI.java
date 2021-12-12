package vendingmachine.servicesource;

import vendingmachine.constants.StringConstants;

public class WalletUI {
    private final WalletSystem wallet;
    private final String PRINT_TITLE_MESSAGE = "\n자판기가 보유한 동전";
    private final String PRINT_DELIMITER = " - ";

    WalletUI(WalletSystem wallet){
        this.wallet = wallet;
    }

    void printRemainCoins(){
        Coin[] coinTypes =  Coin.values();
        System.out.println(PRINT_TITLE_MESSAGE);

        for(Coin currentCoin : coinTypes){
            int remainCoinsInWallet = wallet.getRemainCoinsByCoinType(currentCoin);
            System.out.println(currentCoin + PRINT_DELIMITER + remainCoinsInWallet + StringConstants.PRODUCT_UNIT);
        }

        System.out.print('\n');
    }
}
