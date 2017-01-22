package root;

import org.jfree.data.general.DefaultPieDataset;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

/**
 * Created by ShimaK on 09-Dec-16.
 */
public class SlotMachineController {
    private SlotMachineView view;
    private SlotMachine model;
    private ActionListener addCreditLis, addMaxBetLis, addMinBetLis, resetBetLis, startSpinLis, saveFileLis, statisticsLis, backLis;
    private MouseListener stopSpinLis;
    private Symbol[] symbols;
    private boolean isSpinning;

    //TODO enables bet one & bet max
    public SlotMachineController(SlotMachineView view, SlotMachine model) {
        this.view = view;
        this.model = model;
    }

    /**
     * Calls all Button & Label ActionListeners & MouseListeners
     */
    public void control() {
        setAddCoin();
        setOneBet();
        setMaxBet();
        setResetBet();
        setSpin();
        stopSpin();
        setStatistics();
        setBack();
        try {
            setSave();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Sets Listeners to ADD COIN Button
     * Updates model then it gets the coins amount and updates UI
     */
    public void setAddCoin() {
        addCreditLis = e -> {
            model.addCoin();
            view.setCreditAmount(String.valueOf(model.getCurrentCoins()));
        };
        view.getAddCoinBtn().addActionListener(addCreditLis);
    }

    /**
     * Sets Listeners to BET ONE Button
     * Updates model then it gets the bet amount and updates UI
     */
    public void setOneBet() {
        addMinBetLis = e -> {
            if (!isSpinning) {
                model.betOne();
                view.setText(String.valueOf(model.getCurrentBet()), view.getBetLbl());
                view.setCreditAmount(String.valueOf(model.getCurrentCoins()));
                setSpinEnable(view.getSpinBtn());
            }
        };
        view.getBetOneBtn().addActionListener(addMinBetLis);
    }

    /**
     * Sets Listeners to BET MAX Button
     * Updates model then it gets the bet amount and updates UI
     */
    public void setMaxBet() {
        addMaxBetLis = e -> {
            if (!isSpinning) {
                model.betMax();
                view.setText(String.valueOf(model.getCurrentBet()), view.getBetLbl());
                view.setCreditAmount(String.valueOf(model.getCurrentCoins()));
                setSpinEnable(view.getSpinBtn());
            }
        };
        view.getBetMaxBtn().addActionListener(addMaxBetLis);
    }

    /**
     * Sets Listeners to RESET Button
     * Updates model then it gets the credit and coin amount the updates UI
     */
    public void setResetBet() {
        resetBetLis = e -> {
            if (!isSpinning) {
                model.reset();
                view.setText(String.valueOf(model.getCurrentBet()), view.getBetLbl());
                view.setCreditAmount(String.valueOf(model.getCurrentCoins()));
                setSpinEnable(view.getSpinBtn());
            }
        };
        view.getResetBetBtn().addActionListener(resetBetLis);
    }

    /**
     * Sets Enable value to SPIN Button
     * Checks with current bet amount
     */
    public void setSpinEnable(JButton spin) {
        if (model.getCurrentBet() > 0) {
            spin.setEnabled(true);
        } else {
            spin.setEnabled(false);
        }
    }

    /**
     * Enables SPIN Button
     * Starts Spinning
     * Set Listeners for SPIN button
     */
    public void setSpin() {
        if (model.getCurrentBet() < 1) {
            view.getSpinBtn().setEnabled(false);
        }

        startSpinLis = e -> {
            if (!isSpinning) {
                isSpinning = true;
                new Spin().start();
            }
        };
        view.getSpinBtn().addActionListener(startSpinLis);
    }

    /**
     * Sets Mouse Listeners to ReelPanel
     * If one of reel panel get clicked it stops spinning
     */
    public void stopSpin() {
        stopSpinLis = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                if (isSpinning) {
                    isSpinning = false;
                    setResultState();
                    setSpinEnable(view.getSpinBtn());
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        };
        view.getReel1Lbl().addMouseListener(stopSpinLis);
        view.getReel2Lbl().addMouseListener(stopSpinLis);
        view.getReel3Lbl().addMouseListener(stopSpinLis);
    }

    /**
     * Compares Symbols
     * If All Symbols equals displays won result, changes credit amount
     * Else if Two of Symbols equals displays free spin message
     * Else displays Lost message changes credit & bet amount
     */
    private void setResultState() {
        if (compareSymbols() == 3) {
            view.setText("You've have won", view.getResultLbl());
            model.threeWins(symbols[0]);
            view.setText(String.valueOf(model.getTotalBets()), view.getBetLbl());
            view.setCreditAmount(String.valueOf(model.getCurrentCoins()));
        } else if (compareSymbols() == 2) {
            model.twoWins();
            view.setText("You've got a free spin", view.getResultLbl());
        } else {
            model.lose();
            view.setText(String.valueOf(model.getCurrentBet()), view.getBetLbl());
            view.setText("You lost", view.getResultLbl());
        }
    }

    /**
     * Compares symbols
     * if all 3 are same returns 3
     * Else if 2 of are same returns 2
     * Else returns 0
     */
    public int compareSymbols() {
        if (symbols[0].equals(symbols[1]) && symbols[1].equals(symbols[2])) {
            return 3;
        } else if (symbols[0].equals(symbols[1]) || symbols[1].equals(symbols[2]) || symbols[0].equals(symbols[2])) {
            return 2;
        } else {
            return 0;
        }
    }

    /**
     * Sets Enable value to STATISTICS Button
     */
    public void setStatistics() {
        statisticsLis = e -> {
            if (!isSpinning) {
                loadStatistics();
                view.swapPanel(view.getStatisticsPanel());
                view.getFrame().setMinimumSize(new Dimension(1200, 660));

                DefaultPieDataset dataSet = view.getDataSet();

                double total = model.getWins() + model.getLoses() + model.getTwoWins();

                if (total > 0) {
                    dataSet.setValue("Wins", new Double(model.getWins() / total * 100));
                    dataSet.setValue("Loses", new Double(model.getTwoWins() / total * 100));
                    dataSet.setValue("Two Wins", new Double(model.getLoses() / total * 100));
                }
            }
        };
        view.getStatsBtn().addActionListener(statisticsLis);
    }

    /**
     * Load details of statistics from model
     */
    public void loadStatistics() throws ArithmeticException {
        view.setText(String.valueOf(model.getWins()), view.getWinLbl());
        view.setText(String.valueOf(model.getLoses()), view.getLoseLbl());
        view.setText(String.valueOf(model.getTwoWins()), view.getTwoWinsLbl());
        view.setText(String.valueOf(model.getTotalCoins()), view.getTotCreditsLbl());
        view.setText(String.valueOf(model.getTotalBets()), view.getTotBetLbl());

        try {
            view.setText(String.valueOf(model.getTotalBets() / (model.getWins() + model.getTwoWins()
                    + model.getLoses())), view.getAvgCreditsLbl());
        } catch (ArithmeticException e) {
            view.setText("0", view.getAvgCreditsLbl());
        }
    }

    /**
     * Sets Enable value to BACK Button
     */
    public void setBack() {
        backLis = e -> {
            view.swapPanel(view.getMainPanel());
            view.getFrame().setMinimumSize(new Dimension(700, 630));
            view.getFrame().setSize(new Dimension(700, 630));
        };
        view.getBackBtn().addActionListener(backLis);
    }

    /**
     * Sets Enable value to SAVE Button
     */
    public void setSave() throws IOException {
        saveFileLis = e -> {
            try {
                model.saveStatistics();
            } catch (IOException e1) {
                System.out.println(e1.getMessage());
            }
        };
        view.getSaveBtn().addActionListener(saveFileLis);
    }

    /**
     * Inner class for change images of reel
     * Runs Thread
     * Sleeps 30 milliseconds
     */
    private class Spin extends Thread {
        public void run() {
            do {
                symbols = model.getSymbol();
                view.setImageReel(symbols[0].getImage(), view.getReel1Lbl());
                view.setImageReel(symbols[1].getImage(), view.getReel2Lbl());
                view.setImageReel(symbols[2].getImage(), view.getReel3Lbl());

                try {
                    Thread.sleep(30);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } while (isSpinning);
        }
    }
}
