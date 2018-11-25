import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class mysql {


    private JPanel llll;
    private JTextField textField1;
    private JTextArea textArea1;
    private JButton button1;

    public mysql() {

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

              String aliasName = textField1.getText().toString();
              String mysqlText = textArea1.getText().toString();
              List<String> lexToken=null;
              boolean isField = false;

              lexToken=lexicalAnalysis.lex(mysqlText);

              //语法分析的一部分 在主类里写了

              for (int i = 0; i < lexToken.size(); i++) {
                  if(i!=lexToken.size()-1) //最后一个就省略不分析了
                  isField=syntaxParsing.parsing(lexToken.get(i),lexToken.get(i+1));
                  if(isField) System.out.print(organizeField(lexToken.get(i))+"----");

                  /**
                   * 扩展：
                   * 如果这个语法分析失败，那么应该回溯。然后去匹配下一个语法分析器
                   * 由于只有一个词法分析器所以这里不必回溯
                   */

              }

            }
        });
    }

    /**
     * 处理字段 替换掉重音符
     * @param sourceToken 需要替换的Token
     * @return
     */
    String organizeField(String sourceToken){return sourceToken.replace("`","");}

    public static void main(String[] args) {
        JFrame frame = new JFrame("mysql");
        frame.setContentPane(new mysql().llll);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        int width = Toolkit.getDefaultToolkit().getScreenSize().width;
        int height = Toolkit.getDefaultToolkit().getScreenSize().height;

        frame.setBounds((width - 400) / 2,
                (height - 800) / 2, 400, 800);

        frame.pack();
        frame.setVisible(true);
    }
}
