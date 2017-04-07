package koalacata.gui;

import sun.plugin.javascript.JSClassLoader;

import javax.swing.*;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Created by zhouludong on 2017/3/23.
 */

public class KoalaCataGUI {
    private JFrame mainFrame;
    private JPanel filePanel;
    private JPanel commandPanel;
    private JPanel content;
    private JButton select;
    private JButton runbtn;
    private JFileChooser jFileChooser;
    private JTextField filePath;
    private JTextArea result;

    public KoalaCataGUI(){
        mainFrame = new JFrame("KoalaCata");
        filePanel = new JPanel();
        commandPanel = new JPanel();
        content = new JPanel();
        jFileChooser = new JFileChooser();
        select = new JButton("open file");
        runbtn = new JButton("执行");
        filePath = new JTextField();
        result = new JTextArea();

        prepareGUI();
    }
    public static void main(String[] args){
        KoalaCataGUI swingControlDemo = new KoalaCataGUI();
        swingControlDemo.showEventDemo();
    }
    private void prepareGUI(){
        // mainframe set
        mainFrame.setSize(400,400);
        mainFrame.setLayout(new GridLayout(3, 1));

        mainFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent){
                System.exit(0);
            }
        });

        // file select set
        filePanel.setLayout(new FlowLayout());
        select.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int returnVal = jFileChooser.showOpenDialog(mainFrame);

                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    java.io.File file = jFileChooser.getSelectedFile();
                    filePath.setText(file.getName());
                } else {
                    filePath.setText("Open command cancelled by user." );
                }
            }
        });
        // filePanel.add(jFileChooser);
        filePath.setText("这里是文件路径");
        filePanel.add(filePath);
        filePanel.add(select);

        // command set
        commandPanel.setLayout(new FlowLayout());
        DefaultComboBoxModel commands = new DefaultComboBoxModel();
        commands.addElement("Extract");
        commands.addElement("Match");
        commands.addElement("Transfer");
        commands.addElement("Save Result");
        commands.addElement("One Click Run");

        JComboBox commandList = new JComboBox(commands);
        commandList.setSelectedIndex(0);

        JScrollPane commandListScroll = new JScrollPane(commandList);
        // runbtn.addActionListener(new ActionListener() {
        //     public void actionPerformed(ActionEvent e) {
        //         String data = "";
        //         if (fruitCombo.getSelectedIndex() != -1) {
        //             data = "Fruits Selected: "
        //                     + fruitCombo.getItemAt
        //                     (fruitCombo.getSelectedIndex());
        //         }
        //         statusLabel.setText(data);
        //     }
        // });

        commandPanel.add(commandListScroll);
        commandPanel.add(runbtn);

        // result set
        result.append("这里是结果内容");
        content.add(result);

        mainFrame.add(filePanel);
        mainFrame.add(commandPanel);
        mainFrame.add(content);
        mainFrame.setVisible(true);
    }
    private void showEventDemo(){

        // JButton okButton = new JButton("OK");
        // JButton submitButton = new JButton("Submit");
        // JButton cancelButton = new JButton("Cancel");
        //
        // okButton.setActionCommand("OK");
        // submitButton.setActionCommand("Submit");
        // cancelButton.setActionCommand("Cancel");
        //
        // okButton.addActionListener(new ButtonClickListener());
        // submitButton.addActionListener(new ButtonClickListener());
        // cancelButton.addActionListener(new ButtonClickListener());

        mainFrame.setVisible(true);
    }
    // private class ButtonClickListener implements ActionListener {
    //     public void actionPerformed(ActionEvent e) {
    //         String command = e.getActionCommand();
    //
    //         if( command.equals( "OK" ))  {
    //             statusLabel.setText("Ok Button clicked.");
    //         } else if( command.equals( "Submit" ) )  {
    //             statusLabel.setText("Submit Button clicked.");
    //         } else {
    //             statusLabel.setText("Cancel Button clicked.");
    //         }
    //     }
    // }
}
