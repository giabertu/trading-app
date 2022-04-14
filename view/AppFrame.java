package view;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.BorderLayout;

import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import control.User;
import model.AssetWrapper;


public class AppFrame extends JFrame {
    
    public JButton buttonDeposit;
    public JButton buttonWithdraw;
    public JButton buttonSearch;
    public JButton buttonCryptoSearch;

    public JButton buttonBuy;
    public JButton buttonSell;

    public JTextField depositField;
    public JTextField withdrawField;
    public JTextField searchField;
    public JTextField searchCryptoField;

    public JTextField buyField;
    public JTextField sellField;

    public JLabel accountInfo;
    public JLabel searchLabel;
    public JLabel searchCryptoLabel;

    public JLabel assetLabel;
    public JLabel portfolioLabel;

    public AssetWrapper currentAsset;


    public JMenuBar menuBar = new JMenuBar();

    public AppFrame() {

        this.setSize(1050,700); //sets initial x and y dimension
        this.setTitle("Stock Trading App"); //gives a title to the frame (shown on top of it)
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //this makes sure that the app is killed
        //when you press on the close button, instead of hiding it.
        //this.setIconImage(new ImageIcon("appIcon.png").getImage());
        this.getContentPane().setBackground(Color.lightGray); //change background color.
    
        //this.setResizable(false); //this prevents the frame from being resized

        this.setLayout(new BorderLayout(10,10));
        addAllPanels();
        addAllMenus();

        //this.pack(); //sets the size of frame to accomodate all components. Make sure to add
        //All components before using pack. 
        this.setVisible(true); //make frame visible
    }

    public void addAllPanels(){

        /************************ CREATING, ADDING PANELS***************/
        JPanel panel1 = new JPanel();
        JPanel westPanel = new JPanel();
        JPanel panel3 = new JPanel();
        JPanel bottomPanel = new JPanel();
        JPanel centerPanel = new JPanel();

        panel1.setBackground(Color.white);
        westPanel.setBackground(Color.WHITE);
        panel3.setBackground(Color.YELLOW);
        bottomPanel.setBackground(Color.white);
        centerPanel.setBackground(Color.white);

        //centerPanel.setLayout(new GridLayout());
        westPanel.setLayout(new GridLayout(7, 1, 10, 0));

        panel1.setPreferredSize(new Dimension(100,100));
        westPanel.setPreferredSize(new Dimension(100,100));
        panel3.setPreferredSize(new Dimension(100,100));
        bottomPanel.setPreferredSize(new Dimension(100,100));
        centerPanel.setPreferredSize(new Dimension(100,100));

        this.add(panel1, BorderLayout.NORTH);
        this.add(westPanel, BorderLayout.WEST);
        this.add(panel3, BorderLayout.EAST);
        this.add(bottomPanel, BorderLayout.SOUTH);
        this.add(centerPanel, BorderLayout.CENTER);

        /*********************** TOP PANEL*************************/
        accountInfo = new JLabel();
        buttonDeposit = new JButton();
        buttonWithdraw = new JButton();

        buttonDeposit.setPreferredSize(new Dimension(100, 30));
        buttonWithdraw.setPreferredSize(new Dimension(100, 30));

        buttonDeposit.setText("Deposit");
        buttonWithdraw.setText("Withdraw");
        accountInfo.setText("<html><body>Account Value: $0"  +
         "<br>Free balance: $0<body><html>");
        accountInfo.setFont(new Font("Arial", Font.BOLD, 35));

        depositField = new JTextField();
        withdrawField = new JTextField();

        depositField.setPreferredSize(new Dimension(75, 20));
        withdrawField.setPreferredSize(new Dimension(75, 20));

        panel1.add(accountInfo);
        panel1.add(buttonDeposit);
        panel1.add(depositField);

        panel1.add(buttonWithdraw);
        panel1.add(withdrawField);

        /**************************CENTER PANEL****************** */

        searchLabel = new JLabel("Search Stock Ticker:");
        searchField = new JTextField();
        buttonSearch = new JButton("Search Stock");

        searchLabel.setLabelFor(searchField);
        searchLabel.setFont(new Font("Arial", Font.BOLD, 15));
        searchLabel.setBounds(0, 50, 30, 30);

        searchField.setPreferredSize(new Dimension(100,30));
        searchField.setBounds(45, 50, 75, 20);

        buttonSearch.setPreferredSize(new Dimension(130, 30));

        searchCryptoLabel = new JLabel("Search Crypto Ticker:");
        searchCryptoField = new JTextField();
        buttonCryptoSearch = new JButton("Search Crypto");

        searchCryptoLabel.setLabelFor(searchCryptoField);
        searchCryptoLabel.setFont(new Font("Arial", Font.BOLD, 15));

        searchCryptoField.setPreferredSize(new Dimension(100,30));

        centerPanel.add(searchLabel);
        centerPanel.add(searchField);
        centerPanel.add(buttonSearch);

        centerPanel.add(searchCryptoLabel);
        centerPanel.add(searchCryptoField);
        centerPanel.add(buttonCryptoSearch);

        //display stock and price
        assetLabel = new JLabel();
        assetLabel.setText("No Asset has been searched yet.");
        assetLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        centerPanel.add(assetLabel);

        //buy and sell buttons
        buttonBuy = new JButton("Buy");
        buttonSell = new JButton("Sell");

        buyField = new JTextField(); 
        sellField = new JTextField();

        buyField.setPreferredSize(new Dimension(100,30));
        sellField.setPreferredSize(new Dimension(100,30));

        buttonBuy.setVisible(false);
        buttonSell.setVisible(false);
        buyField.setVisible(false);
        sellField.setVisible(false);

        centerPanel.add(buttonBuy);
        centerPanel.add(buyField);
        centerPanel.add(buttonSell);
        centerPanel.add(sellField);


        /****************************BOTTOM PANEL********************* */

        portfolioLabel = new JLabel();

        portfolioLabel.setText("No Assets Owned");
        portfolioLabel.setFont(new Font("Arial", Font.PLAIN, 20));

        bottomPanel.add(portfolioLabel);

        /****************************WEST PANEL********************** */
        JLabel suggested = new JLabel("  Search...");
        JLabel suggestedTicker1 = new JLabel();
        JLabel suggestedTicker2 = new JLabel();
        JLabel suggestedTicker3 = new JLabel();
        JLabel suggestedTicker4 = new JLabel();
        JLabel suggestedTicker5 = new JLabel();
        JLabel suggestedTicker6 = new JLabel();


        suggestedTicker1.setText("   MSFT");
        suggestedTicker2.setText("   TWTR");
        suggestedTicker3.setText("   AAPL");
        suggestedTicker4.setText("   TSLA");
        suggestedTicker5.setText("   NVDA");
        suggestedTicker6.setText("   GM");

        suggested.setFont(new Font("Arial", Font.BOLD, 20));
        suggestedTicker1.setFont(new Font("Arial", Font.ITALIC, 20));
        suggestedTicker2.setFont(new Font("Arial", Font.ITALIC, 20));
        suggestedTicker3.setFont(new Font("Arial", Font.ITALIC, 20));
        suggestedTicker4.setFont(new Font("Arial", Font.ITALIC, 20));
        suggestedTicker5.setFont(new Font("Arial", Font.ITALIC, 20));
        suggestedTicker6.setFont(new Font("Arial", Font.ITALIC, 20));

        westPanel.add(suggested);
        westPanel.add(suggestedTicker1);
        westPanel.add(suggestedTicker2);
        westPanel.add(suggestedTicker3);
        westPanel.add(suggestedTicker4);
        westPanel.add(suggestedTicker5);
        westPanel.add(suggestedTicker6);


    }

    public void addAllMenus(){
        JMenu refresh = new JMenu("Refresh");
        menuBar.add(refresh);

        this.setJMenuBar(menuBar);
    }

    public void addButtonDepositActionListener(ActionListener listener) {
        buttonDeposit.addActionListener(listener);
    }

    public void addButtonWithdrawActionListener(ActionListener listener) {
        buttonWithdraw.addActionListener(listener);
    }

    public void addButtonSearchActionListener(ActionListener listener){
        buttonSearch.addActionListener(listener);
        buttonCryptoSearch.addActionListener(listener);
    }
    public void addButtonCryptoSearchActionListener(ActionListener listener){
        buttonCryptoSearch.addActionListener(listener);
    }

    public void AddButtonBuyActionListener(ActionListener listener){
        buttonBuy.addActionListener(listener);
    }

    public void AddButtonSellActionListener(ActionListener listener){
        buttonSell.addActionListener(listener);
    }

    public void displayAccount(JLabel label, User user){
        label.setText("<html><body>Account Value: $" + ((control.User) user).getAccount().getTotBalance() +
         "<br>Free balance: $" + ((control.User) user).getAccount().getFreeBalance()+ "<body><html>");
    }

    public void displayAsset(JLabel label, AssetWrapper asset) throws IOException{
        label.setText("You searched for: " + asset.getName() + ", which has price " + asset.getPrice().toString());
        currentAsset = asset;

        buttonBuy.setVisible(true);
        buttonSell.setVisible(true);
        buyField.setVisible(true);
        sellField.setVisible(true);
    }

    public void displayPortfolio(JLabel label, User user){
        label.setText(((control.User) user).getAccount().portfolioToString());
    }

}
