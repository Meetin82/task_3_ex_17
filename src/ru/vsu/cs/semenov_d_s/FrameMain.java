package ru.vsu.cs.semenov_d_s;

import ru.vsu.cs.semenov_d_s.utils.SwingUtils;
import ru.vsu.cs.semenov_d_s.utils.Utils;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class FrameMain extends JFrame {
    private JPanel panelMain;
    private JButton buttonLoadInputFromFile;
    private JButton buttonRun;
    private JButton buttonSaveOutputInFile;
    private JScrollPane JscrollPane;
    private JTextField textFieldInput;
    private JTextField textFieldOutput1;
    private JTextField textFieldOutput2;

    private final JFileChooser fileChooserOpen;
    private final JFileChooser fileChooserSave;
    private final JMenuBar menuBarMain;
    private final JMenu menuLookAndFeel;

    public FrameMain() {
        this.setTitle("Task 3");
        this.setContentPane(panelMain);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(700, 100, 300, 300);
        this.setResizable(false);
        this.pack();

        fileChooserOpen = new JFileChooser();
        fileChooserSave = new JFileChooser();
        fileChooserOpen.setCurrentDirectory(new File("."));
        fileChooserSave.setCurrentDirectory(new File("."));
        FileFilter filter = new FileNameExtensionFilter("Text files", "txt");
        fileChooserOpen.addChoosableFileFilter(filter);
        fileChooserSave.addChoosableFileFilter(filter);

        fileChooserSave.setAcceptAllFileFilterUsed(false);
        fileChooserSave.setDialogType(JFileChooser.SAVE_DIALOG);
        fileChooserSave.setApproveButtonText("Save");

        menuBarMain = new JMenuBar();
        setJMenuBar(menuBarMain);

        menuLookAndFeel = new JMenu();
        menuLookAndFeel.setText("Вид");
        menuBarMain.add(menuLookAndFeel);

        buttonLoadInputFromFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    if (fileChooserOpen.showOpenDialog(panelMain) == JFileChooser.APPROVE_OPTION) {
                        String text = Utils.readTextFromFile(fileChooserOpen.getSelectedFile().getPath());
                        textFieldInput.setText(text);
                    }
                } catch (Exception e) {
                    SwingUtils.showErrorMessageBox(e);
                }
            }
        });

        buttonSaveOutputInFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    if (fileChooserSave.showSaveDialog(panelMain) == JFileChooser.APPROVE_OPTION) {
                        String text = textFieldOutput1.getText();
                        String file = fileChooserSave.getSelectedFile().getPath();
                        if (!file.toLowerCase().endsWith(".txt")) {
                            file += ".txt";
                        }
                        Utils.writeTextToFile(file, text);
                    }
                } catch (Exception e) {
                    SwingUtils.showErrorMessageBox(e);
                }
            }
        });

        buttonRun.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    String text = (textFieldInput).getText();
                    RearrangementOfWords rearrangementOfWords = new RearrangementOfWords();
                    String[] arrWithMyQueue = rearrangementOfWords.rearrangeWordsWithMyQueue(text);
                    String[] arrWithQueue = rearrangementOfWords.rearrangeWordsWithQueue(text);
                    (textFieldOutput1).setText(Utils.arrayToString(arrWithMyQueue));
                    (textFieldOutput2).setText(Utils.arrayToString(arrWithQueue));

                } catch (Exception e) {
                    SwingUtils.showErrorMessageBox(e);
                }
            }
        });
    }
}