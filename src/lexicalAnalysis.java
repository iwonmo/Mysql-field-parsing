import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * 词法分析器 注：会分析出非终结符
 */

public class lexicalAnalysis {

    /**
     * 分析出终结符或者非终结符
     * @param codeStr
     * @return
     */

    public static List<String> lex(String codeStr){

        //词法Token
        List<String> lexToken=new ArrayList<String>();;
        if("".equals(codeStr)) return null;
        String orignal = null;
        try {
            String tmpToken="";

            //对中文进行处理
            orignal = new String(codeStr.getBytes(), "UTF-8");
            for (int i = 0; i < orignal.length(); i++) {
                String ch =String.valueOf(orignal.charAt(i));
                if(ch.equals(" ") || ch.equals("(") || ch.equals(")"))
                {
                    if(!tmpToken.equals("")){
                        lexToken.add(tmpToken);
                        tmpToken="";
                    }
                }
                else
                {
                    tmpToken=tmpToken+ch;
                }
            }
            //追加上最后一个临时Token
            if(!tmpToken.equals("")) lexToken.add(tmpToken);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }

        //返回词法Token
        return lexToken;
    }
}
