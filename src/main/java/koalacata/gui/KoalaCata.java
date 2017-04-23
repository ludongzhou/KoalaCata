package koalacata.gui;

import koalacata.core.xsd.preprocessing.Straightor.AbstractStraightor;
import koalacata.core.xsd.utility.FileUtility;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.HashMap;

/**
 * Created by zhouludong on 2017/4/18.
 */
public class KoalaCata {
    private JButton selectFileButton;
    private JButton loadFileButton;
    private JTextField filePath;
    private JTabbedPane tabbedPane1;
    private JComboBox comboBox1;
    private JButton runButton;
    private JPanel Koala;
    private JTextPane sourceContent;
    private JTextArea textArea1;
    private JTextArea textArea2;
    private JList list1;
    private JTextArea textArea3;
    private JList list2;
    private JTextArea textArea4;
    private JFileChooser fileChooser;
    private File sourceFile;
    private String sourceFileContent;
    private HashMap<String, AbstractStraightor> straightors;

    public KoalaCata() {
        DefaultComboBoxModel commands = new DefaultComboBoxModel();
        commands.addElement("消除三元组");
        commands.addElement("消除错别字");
        comboBox1.setModel(commands);
        // loadStraightors();


        selectFileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fileChooser = new JFileChooser();

                int returnVal = fileChooser.showOpenDialog(Koala);
                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    sourceFile= fileChooser.getSelectedFile();
                    // filePath.setText(sourceFile.getName());
                    filePath.setText(sourceFile.getAbsolutePath());
                } else {
                    filePath.setText("Open command cancelled by user." );
                }
            }
        });

        loadFileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String content = FileUtility.read2String(sourceFile);
                sourceFileContent = content;

                sourceContent.setText(content);
            }
        });
        runButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String operation = comboBox1.getSelectedItem().toString();
                // sourceFileContent = readDoc(straightors.get(operation).run(getDoc(sourceFileContent)));

            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("CataExact");
        frame.setContentPane(new KoalaCata().Koala);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
