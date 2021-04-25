package com.project.GUI;

import com.project.Database.BankDatabase;
import com.validator.card.Validator;

import javax.swing.*;
import java.awt.*;


public class GUIMethods {
    public  void Login() {
        //Creating the Frame
        int HEIGHT = 1080;
        int WIDTH = 1080;
        JFrame frame = new JFrame("Login Screen");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(WIDTH, HEIGHT);
        //Welcome Text
        JLabel label = new JLabel("Welcome to the ATM");
        label.setBounds(WIDTH / 2 - 150, HEIGHT / 2 - 400, 400, 30);
        label.setFont(new Font(label.getFont().getName(), Font.PLAIN, 30));
        //CardNo
        JLabel CardNo = new JLabel("Account no:");
        CardNo.setBounds(WIDTH / 2 - 200, HEIGHT / 2 - 140, 130, 20);
        CardNo.setFont(new Font(label.getFont().getName(), Font.PLAIN, 20));
        JTextField Card = new JTextField(16);
        Card.setBounds(WIDTH / 2 - 80, HEIGHT / 2 - 140, 300, 25);
        Card.setFont(new Font(label.getFont().getName(), Font.PLAIN, 20));
        //PIN
        JLabel PinNo = new JLabel("PIN:");
        PinNo.setBounds(WIDTH / 2 - 200, HEIGHT / 2 - 110, 100, 20);
        PinNo.setFont(new Font(label.getFont().getName(), Font.PLAIN, 20));
        JTextField Pin = new JTextField(16);
        Pin.setBounds(WIDTH / 2 - 80, HEIGHT / 2 - 110, 300, 25);
        Pin.setFont(new Font(label.getFont().getName(), Font.PLAIN, 20));

        //Error Label
        JLabel label1 = new JLabel("");
        label1.setBounds(WIDTH / 2 - 80, HEIGHT / 2 + 50, 400, 25);
        label1.setFont(new Font(label.getFont().getName(), Font.PLAIN, 20));
        //Buttons
        JButton login = new JButton("Send");
        JButton reset = new JButton("Reset");
        JButton signup = new JButton("Sign Up");
        login.setBounds(WIDTH / 2 - 100, HEIGHT / 2 - 50, 100, 30);
        reset.setBounds(WIDTH / 2 + 50, HEIGHT / 2 - 50, 100, 30);
        signup.setBounds(WIDTH / 2 - 25, HEIGHT / 2, 100, 30);
        //KeyListener

        login.addActionListener(e -> {
            System.out.println("Pressed");
            String value = Card.getText();
            String pin = Pin.getText();
            if (value.length() != 0 && pin.length() != 0) {
                long value1 = Long.parseLong(value);
                if (Validator.isValid(value1) && pin.length() == 4) {
                    BankDatabase bankDatabase = new BankDatabase();
                    boolean val = bankDatabase.LogIn(value1, Integer.parseInt(pin));
                    if (val) {
                        label1.setText("You are logged in");
                        frame.setVisible(false);
                        AccountValue(value1);
                    } else {
                        label1.setText("Incorrect Pin");
                    }
                } else {
                    label1.setText("Incorrect");
                }
            }
        });
        reset.addActionListener(e -> {
            label1.setText("");
            Pin.setText("");
            Card.setText("");
        });
        signup.addActionListener(e -> {
            System.out.println("Pressed");
            String value = Card.getText();
            String pin = Pin.getText();
            if (value.length() != 0 && pin.length() != 0) {
                long value1 = Long.parseLong(value);
                if (Validator.isValid(value1) && pin.length() == 4) {
                    BankDatabase bankDatabase = new BankDatabase();
                    boolean val = bankDatabase.SignUp(value1, Integer.parseInt(pin));
                    if (val) {
                        label1.setText("You have signed up");
                        frame.setVisible(false);
                        AccountValue(value1);
                    } else {
                        label1.setText("Account already exists");
                    }
                } else {
                    label1.setText("Incorrect");
                }
            }
        });

        //Adding to the Frame
        frame.add(CardNo);
        frame.add(Card);
        frame.add(PinNo);
        frame.add(Pin);
        frame.add(label);
        frame.add(label1);
        frame.add(login);
        frame.add(reset);
        frame.add(signup);
        frame.setResizable(false);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    private  void AccountValue(Long Cardno) {
        //Creating the Frame
        int HEIGHT = 1080;
        int WIDTH = 1080;
        BankDatabase bankDatabase = new BankDatabase();
        //Frame
        JFrame frame = new JFrame("HomePage");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(WIDTH, HEIGHT);

        //Label
        JLabel display = new JLabel("Choose your option");
        display.setBounds(WIDTH / 2 - 150, HEIGHT / 2 - 400, 400, 30);
        display.setFont(new Font(display.getFont().getName(), Font.PLAIN, 30));
        JLabel label1 = new JLabel("Rs " + bankDatabase.getMoney(Cardno));
        label1.setBounds(WIDTH / 2 - 150, HEIGHT / 2 - 300, 400, 30);
        label1.setFont(new Font(display.getFont().getName(), Font.PLAIN, 30));


        //TextBox
        JLabel money = new JLabel("Amount:");
        money.setBounds(WIDTH / 2 - 200, HEIGHT / 2 - 200, 100, 20);
        money.setFont(new Font(display.getFont().getName(), Font.PLAIN, 20));
        JTextField moneytext = new JTextField(16);
        moneytext.setBounds(WIDTH / 2 - 80, HEIGHT / 2 - 200, 300, 25);
        moneytext.setFont(new Font(display.getFont().getName(), Font.PLAIN, 20));
        JLabel acountnor = new JLabel("Cardno:");
        acountnor.setBounds(WIDTH / 2 - 200, HEIGHT / 2 - 250, 100, 20);
        acountnor.setFont(new Font(display.getFont().getName(), Font.PLAIN, 20));
        JTextField acountnof = new JTextField(16);
        acountnof.setBounds(WIDTH / 2 - 80, HEIGHT / 2 - 250, 300, 25);
        acountnof.setFont(new Font(display.getFont().getName(), Font.PLAIN, 20));
        //Error Label
        JLabel label3 = new JLabel("");
        label3.setBounds(WIDTH / 2 - 80, HEIGHT / 2 + 50, 400, 25);
        label3.setFont(new Font(display.getFont().getName(), Font.PLAIN, 20));
        //Buttons
        JButton back = new JButton("Back");
        JButton withdraw = new JButton("WITHDRAW");
        JButton deposit = new JButton("DEPOSIT");
        JButton transfer = new JButton("TRANSFER");
        withdraw.setBounds(WIDTH / 2 - 300, HEIGHT / 2 - 50, 200, 50);
        deposit.setBounds(WIDTH / 2 + 100, HEIGHT / 2 - 50, 200, 50);
        transfer.setBounds(WIDTH / 2 - 100, HEIGHT / 2 - 120, 200, 50);
        back.setBounds(25, 25, 100, 30);
        //Listener
        back.addActionListener(e -> {
            frame.setVisible(false);
            Login();
        });
        deposit.addActionListener(e -> {
            Long moneyadd = Long.parseLong(moneytext.getText());
            bankDatabase.Withdraw(Cardno, moneyadd);
            AccountValue(Cardno);
            label3.setText(moneyadd + "have been added");
        });
        withdraw.addActionListener(e -> {
            Long moneyremove = Long.parseLong(moneytext.getText());

            Long value = Long.parseLong(label1.getText().replaceAll("[^0-9]", ""));
            if (value - moneyremove > 0) {
                moneyremove = -moneyremove;
                bankDatabase.Withdraw(Cardno, moneyremove);
                AccountValue(Cardno);
                label3.setText(moneyremove + "have been credited");
            } else {
                label3.setText("Not enough money in account");
            }


        });
        transfer.addActionListener(e -> {
            Long moneyof = Long.parseLong(moneytext.getText());
            if (acountnof.getText() != null) {
                long value1 = Long.parseLong(acountnof.getText());
                if (Validator.isValid(value1)) {
                    Long value = Long.parseLong(label1.getText().replaceAll("[^0-9]", ""));
                    if (value - moneyof > 0) {
                        BankDatabase bankDatabases = new BankDatabase();
                        boolean val = bankDatabases.Withdraw(value1, moneyof);
                        moneyof = -moneyof;
                        bankDatabase.Withdraw(Cardno, moneyof);
                        AccountValue(Cardno);
                        if (val) {
                            label3.setText("Transfer Successful");
                        }
                    } else {
                        label3.setText("Not enough money in account");
                    }


                }
            }
            else{
                label3.setText("Please Enter the account number");
            }

        });

        //Adding to frame
        frame.add(display);
        frame.add(label1);
        frame.add(label3);
        frame.add(back);
        frame.add(withdraw);
        frame.add(deposit);
        frame.add(transfer);
        frame.add(money);
        frame.add(moneytext);
        frame.add(acountnof);
        frame.add(acountnor);
        frame.setResizable(false);
        frame.setLayout(null);
        frame.setVisible(true);

    }

}

