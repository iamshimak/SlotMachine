package root;

/**
 * Created by ShimaK on 01-Dec-16.
 */
public class Reel {
    private Symbol[] symbols;

    public Reel(Symbol[] symbols) {
        if (symbols == null) {
            throw new NullPointerException("Symbols cannot be null");
        }

        int[] randomNums = new int[symbols.length];
        for (int x = 0; x < randomNums.length; x++) {
            randomNums[x] = -1;
        }

        int random;
        boolean isAvailable = false;
        int count = 0;
        do {
            random = (int) (Math.random() * symbols.length + 0);
            for (int aRandomNum : randomNums) {
                if (random == aRandomNum) {
                    isAvailable = true;
                    break;
                }
            }
            if (!isAvailable) {
                randomNums[count] = random;
                count++;
				if (isAvailable == true) {
				}
            }
            isAvailable = false;
        } while (count < 6);

        Symbol[] temp = new Symbol[symbols.length];
        for (int x = 0; x < symbols.length; x++) {
            temp[x] = symbols[randomNums[x]];
        }

        this.symbols = temp;
    }

    /**
     * Returns random sequence of Symbol[]
     */
    public Symbol[] spin() {
        if (symbols == null) {
            throw new NullPointerException("Symbols cannot be null");
        }

        int[] randomNums = new int[symbols.length];
        for (int x = 0; x < randomNums.length; x++) {
            randomNums[x] = -1;
        }

        int random;
        boolean isAvailable = false;
        int count = 0;
        do {
            random = (int) (Math.random() * symbols.length + 0);
            for (int aRandomNum : randomNums) {
                if (random == aRandomNum) {
                    isAvailable = true;
                    break;
                }
            }
            if (!isAvailable) {
                randomNums[count] = random;
                count++;
            }
            isAvailable = false;
        } while (count < 6);

        Symbol[] temp = new Symbol[symbols.length];
        for (int x = 0; x < symbols.length; x++) {
            temp[x] = symbols[randomNums[x]];
        }

        return temp;
    }
}
