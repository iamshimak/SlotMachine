package root;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.data.general.DefaultPieDataset;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Color;

/**
 * Created by ShimaK on 10-Dec-16.
 */
//TODO startup images
//TODO result color
public class SlotMachineView {
    private JFrame frame;
    private JPanel mainPanel, titlePanel, reelPanel, resultPanel, buttonPanel, spinPanel, statisticsPanel;
    private JLabel titleLbl, resultLbl, reel1Lbl, reel2Lbl, reel3Lbl, creditLbl, betLbl,
            winTitleLbl, loseTitleLbl, twoTitleWinsLbl, avgCreditsTitleLbl, totCreditsTitleLbl, totBetTitleLbl,
            winLbl, loseLbl, twoWinsLbl, avgCreditsLbl, totCreditsLbl, totBetLbl, statisticsTitle;
    private JButton spinBtn, statsBtn, addCoinBtn, betOneBtn, betMaxBtn, resetBetBtn, backBtn, saveBtn;
    private ChartPanel chartPanel;
    private DefaultPieDataset dataSet;

    /**
     * Calls the all create panels
     */
    public SlotMachineView() {
        setFrame();
        setTitlePanel();
        setReelPanel();
        setResultPanel();
        setButtonPanel();
        setSpinPanel();
        setStatisticsPanel();
        setAllPanel();
    }

    /**
     * Create the JFrame
     */
    private void setFrame() {
        frame = new JFrame("Slot Machine");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setMinimumSize(new Dimension(700, 630));

        mainPanel = new JPanel();
        mainPanel.setBackground(new Color(31, 58, 147));
    }

    /**
     * Setting up and add components to titlePanel
     */
    private void setTitlePanel() {
        titlePanel = new JPanel();
        titlePanel.setMinimumSize(new Dimension(700, 80));

        GroupLayout layout = new GroupLayout(titlePanel);

        titlePanel.setLayout(layout);
        titlePanel.setOpaque(false);

        titleLbl = new JLabel("Winning or losing Game");
        titleLbl.setForeground(Color.WHITE);
        titleLbl.setFont(new Font("Gotham", Font.BOLD, 50));

        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(titleLbl, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap()
                )

        );

        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(titleLbl, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap()
                )
        );
    }

    /**
     * Setting up and add components to reelPanel
     */
    private void setReelPanel() {
        reelPanel = new JPanel();
        reelPanel.setMinimumSize(new Dimension(700, 300));

        GroupLayout layout = new GroupLayout(reelPanel);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        reelPanel.setLayout(layout);
        reelPanel.setOpaque(false);

        reel1Lbl = new JLabel(convertImage(new ImageIcon("src/root/images/redseven.png"), 200, 200));
        reel2Lbl = new JLabel(convertImage(new ImageIcon("src/root/images/redseven.png"), 200, 200));
        reel3Lbl = new JLabel(convertImage(new ImageIcon("src/root/images/redseven.png"), 200, 200));

        reel1Lbl.setMinimumSize(new Dimension(200, 200));
        reel2Lbl.setMinimumSize(new Dimension(200, 200));
        reel3Lbl.setMinimumSize(new Dimension(200, 200));

        reel1Lbl.setBackground(new Color(65, 100, 214));
        reel1Lbl.setOpaque(true);
        reel2Lbl.setBackground(new Color(65, 100, 214));
        reel2Lbl.setOpaque(true);
        reel3Lbl.setBackground(new Color(65, 100, 214));
        reel3Lbl.setOpaque(true);

        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(reel1Lbl, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(reel2Lbl, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(reel3Lbl, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
        );

        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(reel1Lbl)
                                .addComponent(reel2Lbl)
                                .addComponent(reel3Lbl))
                        .addContainerGap()
                )
        );
    }

    /**
     * Setting up and add components to statusPanel
     */
    private void setResultPanel() {
        resultPanel = new JPanel();
        resultPanel.setMinimumSize(new Dimension(700, 50));

        GroupLayout layout = new GroupLayout(resultPanel);

        resultPanel.setLayout(layout);
        resultPanel.setOpaque(false);

        resultLbl = new JLabel();
        resultLbl.setForeground(Color.WHITE);
        resultLbl.setFont(new Font("Gotham", Font.PLAIN, 30));

        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(resultLbl, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap()
                )

        );

        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(resultLbl, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap()
                )
        );
    }

    /**
     * Setting up and add components to buttonPanel
     */
    private void setButtonPanel() {
        buttonPanel = new JPanel();
        buttonPanel.setPreferredSize(new Dimension(700, 100));

        GroupLayout layout = new GroupLayout(buttonPanel);
        buttonPanel.setLayout(layout);
        buttonPanel.setOpaque(false);

        creditLbl = new JLabel("010", SwingConstants.CENTER);
        creditLbl.setFont(new Font("LCD", Font.PLAIN, 50));
        creditLbl.setMinimumSize(new Dimension(100, 80));
        creditLbl.setForeground(Color.RED);
        creditLbl.setBackground(Color.BLACK);
        creditLbl.setOpaque(true);

        betLbl = new JLabel("0", SwingConstants.CENTER);
        betLbl.setFont(new Font("LCD", Font.PLAIN, 50));
        betLbl.setMinimumSize(new Dimension(55, 80));
        betLbl.setForeground(Color.RED);
        betLbl.setBackground(Color.BLACK);
        betLbl.setOpaque(true);

        addCoinBtn = createButton("<html> <center> ADD </center> </br> <center> COIN </center> </html>", new Dimension(80, 80));

        betOneBtn = createButton("<html> <center> BET </center> </br> <center> ONE </center> </html>", new Dimension(80, 80));

        betMaxBtn = createButton("<html> <center> BET </center> </br> <center> MAX </center> </html>", new Dimension(80, 80));

        resetBetBtn = createButton("RESET", new Dimension(80, 80));

        statsBtn = createButton("STATISTICS", new Dimension(120, 80));

        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(creditLbl)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(betLbl)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(addCoinBtn)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(betOneBtn)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(betMaxBtn)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(resetBetBtn)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(statsBtn)
                        .addContainerGap())
        );

        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(creditLbl)
                                .addComponent(betLbl)
                                .addComponent(addCoinBtn)
                                .addComponent(betOneBtn)
                                .addComponent(betMaxBtn)
                                .addComponent(resetBetBtn)
                                .addComponent(statsBtn))
                        .addContainerGap())
        );
    }

    /**
     * Setting up and add components to spinPanel
     */
    private void setSpinPanel() {
        spinPanel = new JPanel();

        GroupLayout layout = new GroupLayout(spinPanel);
        spinPanel.setLayout(layout);
        spinPanel.setOpaque(false);

        spinPanel.setMinimumSize(new Dimension(700, 100));

        spinBtn = createButton("SPIN", new Dimension(200, 80));

        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(spinBtn, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap()
                )

        );

        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(spinBtn, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap()
                )
        );
    }

    /**
     * Setting up and add components to statisticsPanel
     * I used JLabel to display information
     * JButton for button
     */
    private void setStatisticsPanel() {
        statisticsPanel = new JPanel();

        GroupLayout layout = new GroupLayout(statisticsPanel);
        statisticsPanel.setLayout(layout);

        statisticsPanel.setBackground(new Color(31, 58, 147));
        statisticsPanel.setMinimumSize(new Dimension(1000, 630));

        statisticsTitle = createLabel("Statistics", new Dimension(300, 60));
        statisticsTitle.setHorizontalAlignment(JLabel.CENTER);
        statisticsTitle.setFont(new Font("Gotham", Font.BOLD, 40));

        winTitleLbl = createLabel("Total Wins", new Dimension(300, 60));

        winLbl = createLabel("", new Dimension(200, 60));

        loseTitleLbl = createLabel("Loses", new Dimension(300, 60));

        loseLbl = createLabel("", new Dimension(200, 60));

        twoTitleWinsLbl = createLabel("Total Two Wins", new Dimension(300, 60));

        twoWinsLbl = createLabel("", new Dimension(200, 60));

        avgCreditsTitleLbl = createLabel("<html><center>Average no. of credits <br> netted per game</html>", new Dimension(300, 60));

        avgCreditsLbl = createLabel("", new Dimension(200, 60));

        totCreditsTitleLbl = createLabel("Total Netted Credits", new Dimension(300, 60));

        totCreditsLbl = createLabel("", new Dimension(200, 60));

        totBetTitleLbl = createLabel("Total Bet Amount", new Dimension(300, 60));

        totBetLbl = createLabel("", new Dimension(200, 60));

        backBtn = createButton("BACK", new Dimension(200, 60));

        saveBtn = createButton("SAVE", new Dimension(200, 60));

        //TODO - PieChart
        dataSet = new DefaultPieDataset();

        chartPanel = new ChartPanel(ChartFactory.createPieChart("Pie chart",  // chart title
                dataSet,        // data
                true,           // include legend
                true,
                false));

        chartPanel.setMinimumSize(new Dimension(400, 525));

        layout.setHorizontalGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(statisticsTitle, GroupLayout.Alignment.CENTER)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(winTitleLbl, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(winLbl, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(twoTitleWinsLbl, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(twoWinsLbl, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(loseTitleLbl, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(loseLbl, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(avgCreditsTitleLbl, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(avgCreditsLbl, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(totCreditsTitleLbl, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(totCreditsLbl, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(totBetTitleLbl, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(totBetLbl, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(backBtn, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(saveBtn, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addComponent(chartPanel)))
                .addContainerGap()
        );

        layout.setVerticalGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(statisticsTitle)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(winTitleLbl, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(winLbl, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(twoTitleWinsLbl, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(twoWinsLbl, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(loseTitleLbl, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(loseLbl, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(avgCreditsTitleLbl, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(avgCreditsLbl, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(totCreditsTitleLbl, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(totCreditsLbl, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(totBetTitleLbl, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(totBetLbl, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(backBtn, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(saveBtn, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(chartPanel)
                                .addContainerGap())
                )
        );
    }

    /**
     * Lay out the Frame
     */
    private void setAllPanel() {
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        mainPanel.add(titlePanel);
        mainPanel.add(Box.createVerticalGlue());
        mainPanel.add(reelPanel);
        mainPanel.add(Box.createVerticalGlue());
        mainPanel.add(resultPanel);
        mainPanel.add(Box.createVerticalGlue());
        mainPanel.add(buttonPanel);
        mainPanel.add(Box.createVerticalGlue());
        mainPanel.add(spinPanel);

        frame.add(mainPanel);
        //frame.pack();
        frame.setVisible(true);
    }

    /**
     * Converts the given image to given width & height
     */
    private ImageIcon convertImage(ImageIcon image, int width, int height) {
        if (image != null) {
            return new ImageIcon(image.getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT));
        } else {
            return null;
        }
    }

    /**
     * Set Text to given Label
     */
    public void setText(String text, JLabel label) throws NullPointerException {
        if (text != null && label != null) {
            label.setText(text);
        } else {
            throw new NullPointerException(text + " or " + label + " is null");
        }
    }

    /**
     * Checks credit amount length and set to Credit Label
     */
    public void setCreditAmount(String credit) throws NullPointerException {
        if (credit != null) {
            if (credit.length() == 1) {
                creditLbl.setText("00" + credit);
            } else if (credit.length() == 2) {
                creditLbl.setText("0" + credit);
            } else {
                creditLbl.setText(credit);
            }
        } else {
            throw new NullPointerException("credit cannot be null");
        }
    }

    /**
     * Set given ImageIcon to given Label
     * Converts image size
     */
    public void setImageReel(ImageIcon image, JLabel reel) {
        reel.setIcon(convertImage(image, 200, 200));
    }

    /**
     * Swap from current panel to given panel
     */
    public void swapPanel(JPanel panel) {
        frame.setContentPane(panel);
        frame.revalidate();
    }

    /**
     * Gets name & dimension as parameters returns button
     */
    public JButton createButton(String name, Dimension size) {
        JButton button = new JButton(name);

        button.setMinimumSize(size);
        button.setFont(new Font("Gotham", Font.BOLD, 17));
        button.setFocusPainted(false);
        button.setForeground(Color.WHITE);
        button.setBackground(new Color(65, 100, 214));
        button.setBorder(null);
        button.setOpaque(true);
        button.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                e.getComponent().setBackground(new Color(84, 115, 218));
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                e.getComponent().setBackground(new Color(65, 100, 214));
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                e.getComponent().setBackground(new Color(84, 115, 218));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                e.getComponent().setBackground(new Color(65, 100, 214));
            }
        });

        return button;
    }

    /**
     * Gets name & dimension as parameters returns label
     */
    public JLabel createLabel(String name, Dimension size) {
        JLabel label = new JLabel(name);

        label.setMinimumSize(size);
        label.setFont(new Font("Gotham", Font.BOLD, 25));
        label.setForeground(Color.WHITE);
        label.setOpaque(false);

        return label;
    }

    public DefaultPieDataset getDataSet() {
        return dataSet;
    }

    public JFrame getFrame() {
        return frame;
    }

    public JButton getSpinBtn() {
        return spinBtn;
    }

    public JButton getAddCoinBtn() {
        return addCoinBtn;
    }

    public JButton getBetOneBtn() {
        return betOneBtn;
    }

    public JButton getBetMaxBtn() {
        return betMaxBtn;
    }

    public JButton getResetBetBtn() {
        return resetBetBtn;
    }

    public JButton getStatsBtn() {
        return statsBtn;
    }

    public JButton getBackBtn() {
        return backBtn;
    }

    public JButton getSaveBtn() {
        return saveBtn;
    }

    public JPanel getStatisticsPanel() {
        return statisticsPanel;
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public JLabel getReel1Lbl() {
        return reel1Lbl;
    }

    public JLabel getReel2Lbl() {
        return reel2Lbl;
    }

    public JLabel getReel3Lbl() {
        return reel3Lbl;
    }

    public JLabel getBetLbl() {
        return betLbl;
    }

    public JLabel getWinLbl() {
        return winLbl;
    }

    public JLabel getLoseLbl() {
        return loseLbl;
    }

    public JLabel getTwoWinsLbl() {
        return twoWinsLbl;
    }

    public JLabel getAvgCreditsLbl() {
        return avgCreditsLbl;
    }

    public JLabel getTotCreditsLbl() {
        return totCreditsLbl;
    }

    public JLabel getTotBetLbl() {
        return totBetLbl;
    }

    public JLabel getResultLbl() {
        return resultLbl;
    }
}