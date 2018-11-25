import java.util.List;

/**
 * 解析指定表达式的语法分析器
 */
public class syntaxParsing {

    /**
     * 分析字段的语法解析器
     *
     * @param curr 当前的字段
     * @param nex  下一个字段
     * @return 是否是产生式
     */
    public static boolean parsing(String curr, String nex) {
        /**
         *  ①明确匹配产生式
         *  ②这里简单的认为：字段定义：字段类型 即为字段定义的产生式
         *  ③字段定义展开的产生式：重音符：字段名：重音符
         *  ④字段类型展开的产生式：内部字段名：参数（可选）
         **/
        if (curr.length() > 3)
            if (curr.substring(0, 1).equals("`")  && curr.substring(curr.length() - 1, curr.length()).equals("`") && internalType(nex))
                return true;
            else return false;
        else return false;
    }

    /**
     * 判断Token是否是内部定义的类型
     *
     * @param nex 需要判断的Token
     * @return
     */
    public static boolean internalType(String nex) {
        /**
         * 这里不再对类型定义做产生式，而是粗略的进行判断
         */

        //转换为小写
        String i_nex = nex.toLowerCase();

        //判断是否是内部定义类型 ：类型定义提取自nacicat for mysql
        switch (i_nex) {
            case "tinyint":
                return true;
            case "smallint":
                return true;
            case "mediumint":
                return true;
            case "int":
                return true;
            case "integer":
                return true;
            case "bigint":
                return true;
            case "float":
                return true;
            case "double":
                return true;
            case "char":
                return true;
            case "varchar":
                return true;
            case "tinyblob":
                return true;
            case "tinytext":
                return true;
            case "blob":
                return true;
            case "text":
                return true;
            case "mediumblob":
                return true;
            case "mediumtext":
                return true;
            case "longblob":
                return true;
            case "longtext":
                return true;
            case "date":
                return true;
            case "time":
                return true;
            case "year":
                return true;
            case "datetime":
                return true;
            case "timestamp":
                return true;
            case "set":
                return true;
        }

        return false;
    }

}
