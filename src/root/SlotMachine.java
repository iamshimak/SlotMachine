package root;

import javax.swing.*;
import java.io.*;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by ShimaK on 01-Dec-16.
 */
public class SlotMachine {
    private Reel[] reels = new Reel[3];
    private int currentCoins, currentBet, count, wins, twoWins, loses, totalCoins, totalBets;
    private boolean imageNotFound;

    public SlotMachine() {
        initialization();
    }

    /**
     * Create Symbols and set images & values then added to reel
     */
    public void initialization() {
        Symbol[] symbols = new Symbol[6];

        currentCoins = 10;
        totalCoins = 10;

        for (int x = 0; x < symbols.length; x++) {
            symbols[x] = new Symbol();
        }

        setImage(symbols[0], "images/redseven.png", "redSeven");
        setImage(symbols[1], "images/bell.png", "bell");
        setImage(symbols[2], "images/watermelon.png", "watermelon");
        setImage(symbols[3], "images/plum.png", "plum");
        setImage(symbols[4], "images/lemon.png", "lemon");
        setImage(symbols[5], "images/cherry.png", "cherry");

        if (imageNotFound) {
            JOptionPane.showMessageDialog(null, "Images are missing please save images at src/root/images");
        }

        symbols[0].setValue(7);
        symbols[1].setValue(6);
        symbols[2].setValue(5);
        symbols[3].setValue(4);
        symbols[4].setValue(3);
        symbols[5].setValue(2);

        for (int x = 0; x < reels.length; x++) {
            reels[x] = new Reel(symbols);
        }
    }

    /**
     * Pass image to loadImage if error occurs displays warning message
     */
    public void setImage(Symbol symbol, String path, String description) {
        try {
            symbol.setImage(loadImage(path, description));
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            imageNotFound = true;
        }
    }

    /**
     * Increase current credits & total credits
     */
    public void addCoin() {
        currentCoins++;
        totalCoins++;
    }

    /**
     * Decrease current credits , Increase current bet & total bet by one if current credits > 0
     */
    public void betOne() {
        if (currentCoins > 0) {
            currentCoins--;
            currentBet++;
            totalBets++;
        }
    }

    /**
     * Decrease current credits , Increase current bet & total bet by three if current credits > 2
     */
    public void betMax() {
        if (currentCoins > 2) {
            betOne();
            betOne();
            betOne();
            /*currentCoins -= 3;
            currentBet += 3;
            totalBets += 3;*/
        }
    }

    /**
     * Set setBack old values of current credits & totalBets then set current bet to 0
     */
    public void reset() {
        currentCoins += currentBet;
        totalBets += currentBet;
        currentBet = 0;
    }

    /**
     * Get Symbol parameter multiplies it's value by current bet and set that to current credits
     * Set current bet to 0
     * Increase wins
     */
    public void threeWins(Symbol symbol) throws NullPointerException {
        if (symbol != null) {
            wins++;
            currentCoins += symbol.getValue() * currentBet;
            currentBet = 0;
        } else {
            throw new NullPointerException("Symbol is null");
        }
    }

    /**
     * Increase two wins
     */
    public void twoWins() {
        twoWins++;
    }

    /**
     * Increase loses
     * Set current bet to 0
     */
    public void lose() {
        loses++;
        currentBet = 0;
    }

    /**
     * Save text file named current date & time
     * Details of Files Total Wins, Two Wins, Loses, Total Credits, Total Bets
     */
    public void saveStatistics() throws IOException {
        File file = new File(new SimpleDateFormat("yyyy-MM-dd_hh-mm-ss'.txt'").format(new Date()));

        try {
            file.createNewFile();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        BufferedWriter bufferWriter = null;
        try {
            bufferWriter = new BufferedWriter(new FileWriter(file, true));
            bufferWriter.write("Total Wins:\t" + wins + "\nTwo Wins:\t" + twoWins + "\nLoses:\t" + loses
                    + "\nTotal Credits:\t" + totalCoins + "\nTotal Bets:\t" + totalBets);
        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println(e.getMessage());
        } finally {
            if (bufferWriter != null) {
                try {
                    bufferWriter.close();
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }

    /**
     * Gets image's path & description as parameters
     * creates an imageIcon object returns
     */
    public ImageIcon loadImage(String path, String description) throws FileNotFoundException {
        URL imgURL = getClass().getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL, description);
        } else {
            throw new FileNotFoundException(description + " isn't found");
        }
    }

    /**
     * Gets one Symbol in each real and returns Symbol[]
     */
    public Symbol[] getSymbol() {
        Symbol[] symbols = new Symbol[reels.length];

        if (count == reels[0].spin().length) {
            count = 0;
        }

        for (int x = 0; x < reels.length; x++) {
            symbols[x] = reels[x].spin()[count];
        }

        count++;

        return symbols;
    }

    public int getCurrentCoins() {
        return currentCoins;
    }

    public int getCurrentBet() {
        return currentBet;
    }

    public int getWins() {
        return wins;
    }

    public int getTwoWins() {
        return twoWins;
    }

    public int getLoses() {
        return loses;
    }

    public int getTotalCoins() {
        return totalCoins;
    }

    public int getTotalBets() {
        return totalBets;
    }
}